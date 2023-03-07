package com.example.breastcancerlocal.viewModel

import android.content.Context
import android.content.res.AssetManager
import androidx.lifecycle.ViewModel
import com.example.breastcancerlocal.model.BreastCancerEntity
import com.example.breastcancerlocal.model.BreastCancer
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.channels.FileChannel

class ClassificationViewModel (context: Context): ViewModel() {

    private val assetManager: AssetManager = context.assets
    private val crudViewModel = BreastCancerCRUDViewModel.getInstance(context)

    companion object {
        private var instance: ClassificationViewModel? = null
        fun getInstance(context: Context): ClassificationViewModel {
            return instance ?: ClassificationViewModel(context)
        }
    }

    //classification
    private fun loadModelFile(assetManager: AssetManager, modelPath: String): ByteBuffer {
        val fileDescriptor = assetManager.openFd(modelPath)
        val inputStream = FileInputStream(fileDescriptor.fileDescriptor)
        val fileChannel = inputStream.channel
        val startOffset = fileDescriptor.startOffset
        val declaredLength = fileDescriptor.declaredLength
        return fileChannel.map(
            FileChannel.MapMode.READ_ONLY,
            startOffset, declaredLength)
    }

    suspend fun classify(classification: BreastCancer) : String {
        var res = ""
        lateinit var tflite : Interpreter
        lateinit var tflitemodel : ByteBuffer

        try{
            tflitemodel = loadModelFile(assetManager, "cancer.tflite")
            tflite = Interpreter(tflitemodel)
        } catch(ex: Exception){
            ex.printStackTrace()
        }

        val done: Float = (classification.age.toFloat() - 24) / (89 - 24)
        val dtwo = (classification.bmi - 18.37f) / (38.5787585f - 18.37f)
        val dthree = (classification.glucose - 60) / (201 - 60)
        val dfour = (classification.insulin - 2.432f) / (58.46f - 2.432f)
        val dfive = (classification.homa - 4.311f) / (90.28f - 4.311f)
        val dsix = (classification.leptin - 1.6502f) / (38.04f - 1.6502f)
        val dseven = (classification.adiponectin - 3.21f) / (82.1f - 3.21f)
        val deight = (classification.resistin - 45.843f) / (1698.44f - 45.843f)
        val dnine = (classification.mcp - 45.843f) / (1698.44f - 45.843f)

        val inputVal: FloatArray = floatArrayOf(done, dtwo, dthree, dfour, dfive, dsix, dseven,deight, dnine)
        val outputVal: ByteBuffer = ByteBuffer.allocateDirect(8)
        outputVal.order(ByteOrder.nativeOrder())

        tflite.run(inputVal, outputVal)
        outputVal.rewind()

        val result = FloatArray(2)
        for (i in 0..1) {
            result[i] = outputVal.float
        }

        if (result[0]>result[1])
            res = "Result is negative"

        else
            res = "Result is positive"

        classification.outcome = res
        crudViewModel.persistBreastCancer(classification)

        return res

    }
}