package com.example.breastcancerlocal.usecase

import android.content.Context
import com.example.breastcancerlocal.model.BreastCancer
import com.example.breastcancerlocal.viewModel.BreastCancerCRUDViewModel
import com.example.breastcancerlocal.viewModel.ClassificationViewModel

class DiagnoseBean(c: Context) {
    private var classificationViewModel: ClassificationViewModel = ClassificationViewModel.getInstance(c)
    private var crudViewModel: BreastCancerCRUDViewModel = BreastCancerCRUDViewModel.getInstance(c)

    private var classification = ""
    private var instanceClassification: BreastCancer? = null

    private var errors = ArrayList<String>()

    fun setclassification(classificationx: String) {
        classification = classificationx
    }

    fun resetData() {
        classification = ""
    }

     suspend fun isdiagnoseerror(): Boolean {
        errors.clear()
        instanceClassification = crudViewModel.getBreastCancerByPK2(classification)
        if (instanceClassification == null) {
            errors.add("classification must be a valid Classification id")
        }
        return errors.size > 0
    }

    fun errors(): String {
        return errors.toString()
    }

    suspend fun diagnose (): String {
        return classificationViewModel.classify(instanceClassification!!)
    }
}