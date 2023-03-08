package com.example.breastcancerlocal.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.breastcancerlocal.R
import com.example.breastcancerlocal.model.BreastCancerBean
import java.lang.Exception

class CreateFragment : Fragment(), View.OnClickListener {
    //Object declaration
    private lateinit var root: View
    private lateinit var myContext: Context
    private lateinit var classificationBean: BreastCancerBean

    lateinit var input1: EditText
    var input1Data: String = ""
    lateinit var input2: EditText
    var input2Data:  String = ""
    lateinit var input3: EditText
    var input3Data:  String = ""
    lateinit var input4: EditText
    var input4Data:  String = ""
    lateinit var input5: EditText
    var input5Data:  String = ""
    lateinit var input6: EditText
    var input6Data:  String = ""
    lateinit var input7: EditText
    var input7Data:  String = ""
    lateinit var input8: EditText
    var input8Data:  String = ""
    lateinit var input9: EditText
    var input9Data:  String = ""
    lateinit var input10: EditText
    var input10Data:  String = ""

    lateinit var resultTextView : TextView
    lateinit var buttonSave: Button
    lateinit var buttonCancel: Button

    companion object {
        fun newInstance(c: Context): CreateFragment {
            val fragment = CreateFragment()
            val args = Bundle()
            fragment.arguments = args
            fragment.myContext = c
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        root = inflater.inflate(R.layout.create_layout, container, false)

        classificationBean = BreastCancerBean(myContext)

        //UI components declaration
        input1 = root.findViewById(R.id.idField)
        input2 = root.findViewById(R.id.ageField)
        input3 = root.findViewById(R.id.bmiField)
        input4 = root.findViewById(R.id.glucoseField)
        input5 = root.findViewById(R.id.insulinField)
        input6 = root.findViewById(R.id.HOMAField)
        input7 = root.findViewById(R.id.leptinField)
        input8 = root.findViewById(R.id.adiponectinField)
        input9 = root.findViewById(R.id.resistinField)
        input10 = root.findViewById(R.id.MCPField)

        resultTextView = root.findViewById(R.id.result)

        buttonSave = root.findViewById(R.id.diagnoseCreate)
        buttonSave.setOnClickListener(this)

        buttonCancel = root.findViewById(R.id.diagnoseCancel)
        buttonCancel.setOnClickListener(this)

        return root

    }

    override fun onClick(v: View) {
        val imm = myContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        try {
            imm.hideSoftInputFromWindow(v.windowToken, 0)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        when (v.id) {
            R.id.diagnoseCreate -> {
                createOK()
            }
            R.id.diagnoseCancel -> {
                createCancel()
            }
        }
    }

    private fun createOK () {
        input1Data = input1.text.toString()
        classificationBean.setId(input1Data)
        input2Data = input2.text.toString()
        classificationBean.setAge(input2Data)
        input3Data = input3.text.toString()
        classificationBean.setBmi(input3Data)
        input4Data = input4.text.toString()
        classificationBean.setGlucose(input4Data)
        input5Data = input5.text.toString()
        classificationBean.setInsulin(input5Data)
        input6Data = input6.text.toString()
        classificationBean.setHoma(input6Data)
        input7Data = input7.text.toString()
        classificationBean.setLeptin(input7Data)
        input8Data = input8.text.toString()
        classificationBean.setAdiponectin(input8Data)
        input9Data = input9.text.toString()
        classificationBean.setResistin(input9Data)
        input10Data = input10.text.toString()
        classificationBean.setMcp(input10Data)
        classificationBean.setOutcome(resultTextView.text.toString())

        if (classificationBean.isCreateBreastCancerError()) {
                Log.w(javaClass.name, classificationBean.errors())
                Toast.makeText(myContext, "Errors: " + classificationBean.errors(), Toast.LENGTH_LONG).show()
        } else {
            viewLifecycleOwner.lifecycleScope.launchWhenStarted  {
            classificationBean.createBreastCancer()
            }
       }

    }

    private fun createCancel () {
        classificationBean.resetData()
        input1.text.clear()
        input2.text.clear()
        input3.text.clear()
        input4.text.clear()
        input5.text.clear()
        input6.text.clear()
        input7.text.clear()
        input8.text.clear()
        input9.text.clear()
        input10.text.clear()
        resultTextView.text = ""
    }
}
