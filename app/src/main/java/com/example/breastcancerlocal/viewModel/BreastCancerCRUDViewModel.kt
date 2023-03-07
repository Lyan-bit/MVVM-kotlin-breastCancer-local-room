package com.example.breastcancerlocal.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.breastcancerlocal.model.BreastCancerEntity
import com.example.breastcancerlocal.database.Repository
import com.example.breastcancerlocal.model.BreastCancer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.ArrayList

class BreastCancerCRUDViewModel constructor(context: Context): ViewModel() {

    private var currentBreastCancer: BreastCancerEntity? = null
    private var currentBreastCancers: List<BreastCancerEntity> = ArrayList()

    companion object {
        private val repository by lazy { Repository() }
        private var instance: BreastCancerCRUDViewModel? = null
        fun getInstance(context: Context): BreastCancerCRUDViewModel {
            return instance ?: BreastCancerCRUDViewModel(context)
        }
    }

    val allBreastCancers: LiveData<List<BreastCancerEntity>> = repository.allBreastCancers.asLiveData()

    val allBreastCancerIds: LiveData<List<String>> = repository.allBreastCancerids.asLiveData()
    val allBreastCancerAges: LiveData<List<Int>> = repository.allBreastCancerages.asLiveData()
    val allBreastCancerBmis: LiveData<List<Float>> = repository.allBreastCancerbmis.asLiveData()
    val allBreastCancerGlucoses: LiveData<List<Float>> = repository.allBreastCancerglucoses.asLiveData()
    val allBreastCancerInsulins: LiveData<List<Float>> = repository.allBreastCancerinsulins.asLiveData()
    val allBreastCancerHomas: LiveData<List<Float>> = repository.allBreastCancerhomas.asLiveData()
    val allBreastCancerLeptins: LiveData<List<Float>> = repository.allBreastCancerleptins.asLiveData()
    val allBreastCancerAdiponectins: LiveData<List<Float>> = repository.allBreastCanceradiponectins.asLiveData()
    val allBreastCancerResistins: LiveData<List<Float>> = repository.allBreastCancerresistins.asLiveData()
    val allBreastCancerMcps: LiveData<List<Float>> = repository.allBreastCancermcps.asLiveData()
    val allBreastCancerOutcomes: LiveData<List<String>> = repository.allBreastCanceroutcomes.asLiveData()

    fun searchByBreastCancerid(searchQuery: String): LiveData<List<BreastCancerEntity>> {
        return repository.searchByBreastCancerid(searchQuery).asLiveData()
    }

    fun searchByBreastCancerage(searchQuery: Int): LiveData<List<BreastCancerEntity>> {
        return repository.searchByBreastCancerage(searchQuery).asLiveData()
    }

    fun searchByBreastCancerbmi(searchQuery: Float): LiveData<List<BreastCancerEntity>> {
        return repository.searchByBreastCancerbmi(searchQuery).asLiveData()
    }

    fun searchByBreastCancerglucose(searchQuery: Float): LiveData<List<BreastCancerEntity>> {
        return repository.searchByBreastCancerglucose(searchQuery).asLiveData()
    }

    fun searchByBreastCancerinsulin(searchQuery: Float): LiveData<List<BreastCancerEntity>> {
        return repository.searchByBreastCancerinsulin(searchQuery).asLiveData()
    }

    fun searchByBreastCancerhoma(searchQuery: Float): LiveData<List<BreastCancerEntity>> {
        return repository.searchByBreastCancerhoma(searchQuery).asLiveData()
    }

    fun searchByBreastCancerleptin(searchQuery: Float): LiveData<List<BreastCancerEntity>> {
        return repository.searchByBreastCancerleptin(searchQuery).asLiveData()
    }

    fun searchByBreastCanceradiponectin(searchQuery: Float): LiveData<List<BreastCancerEntity>> {
        return repository.searchByBreastCanceradiponectin(searchQuery).asLiveData()
    }

    fun searchByBreastCancerresistin(searchQuery: Float): LiveData<List<BreastCancerEntity>> {
        return repository.searchByBreastCancerresistin(searchQuery).asLiveData()
    }

    fun searchByBreastCancermcp(searchQuery: Float): LiveData<List<BreastCancerEntity>> {
        return repository.searchByBreastCancermcp(searchQuery).asLiveData()
    }

    fun searchByBreastCanceroutcome(searchQuery: String): LiveData<List<BreastCancerEntity>> {
        return repository.searchByBreastCanceroutcome(searchQuery).asLiveData()
    }


    fun getBreastCancerByPK(value: String): Flow<BreastCancer> {
        val res: Flow<List<BreastCancerEntity>> = repository.searchByBreastCancerid(value)
        return res.map { breastCancer ->
            val itemx = BreastCancer.createByPKBreastCancer(value)
            if (breastCancer.isNotEmpty()) {
                itemx.id = breastCancer[0].id
            }
            if (breastCancer.isNotEmpty()) {
                itemx.age = breastCancer[0].age
            }
            if (breastCancer.isNotEmpty()) {
                itemx.bmi = breastCancer[0].bmi
            }
            if (breastCancer.isNotEmpty()) {
                itemx.glucose = breastCancer[0].glucose
            }
            if (breastCancer.isNotEmpty()) {
                itemx.insulin = breastCancer[0].insulin
            }
            if (breastCancer.isNotEmpty()) {
                itemx.homa = breastCancer[0].homa
            }
            if (breastCancer.isNotEmpty()) {
                itemx.leptin = breastCancer[0].leptin
            }
            if (breastCancer.isNotEmpty()) {
                itemx.adiponectin = breastCancer[0].adiponectin
            }
            if (breastCancer.isNotEmpty()) {
                itemx.resistin = breastCancer[0].resistin
            }
            if (breastCancer.isNotEmpty()) {
                itemx.mcp = breastCancer[0].mcp
            }
            if (breastCancer.isNotEmpty()) {
                itemx.outcome = breastCancer[0].outcome
            }
            itemx
        }
    }

    suspend fun createBreastCancer(x: BreastCancerEntity) {
        repository.createBreastCancer(x)
        currentBreastCancer = x
    }

    fun setSelectedBreastCancer(x: BreastCancerEntity) {
        currentBreastCancer = x
    }

    suspend fun editBreastCancer(x: BreastCancerEntity) {
        repository.updateBreastCancer(x)
        currentBreastCancer = x
    }

    suspend fun listBreastCancer(): List<BreastCancerEntity> {
        currentBreastCancers = repository.listBreastCancer()
        return currentBreastCancers
    }

    suspend fun listAllBreastCancer(): ArrayList<BreastCancer> {
        currentBreastCancers = repository.listBreastCancer()
        var res = ArrayList<BreastCancer>()
        for (x in currentBreastCancers.indices) {
            val vo: BreastCancerEntity = currentBreastCancers[x]
            val itemx = BreastCancer.createByPKBreastCancer(vo.id)
            itemx.id = vo.id
            itemx.age = vo.age
            itemx.bmi = vo.bmi
            itemx.glucose = vo.glucose
            itemx.insulin = vo.insulin
            itemx.homa = vo.homa
            itemx.leptin = vo.leptin
            itemx.adiponectin = vo.adiponectin
            itemx.resistin = vo.resistin
            itemx.mcp = vo.mcp
            itemx.outcome = vo.outcome
            res.add(itemx)
        }
        return res
    }

    suspend fun stringListBreastCancer(): List<String> {
        currentBreastCancers = repository.listBreastCancer()
        val res: ArrayList<String> = ArrayList()
        for (x in currentBreastCancers.indices) {
            res.add(currentBreastCancers[x].toString())
        }
        return res
    }

    suspend fun getBreastCancerByPK2(_val: String): BreastCancer? {
        val res: List<BreastCancerEntity> = repository.searchByBreastCancerid2(_val)
        return if (res.isEmpty()) {
            null
        } else {
            val vo: BreastCancerEntity = res[0]
            val itemx = BreastCancer.createByPKBreastCancer(_val)
            itemx.id = vo.id
            itemx.age = vo.age
            itemx.bmi = vo.bmi
            itemx.glucose = vo.glucose
            itemx.insulin = vo.insulin
            itemx.homa = vo.homa
            itemx.leptin = vo.leptin
            itemx.adiponectin = vo.adiponectin
            itemx.resistin = vo.resistin
            itemx.mcp = vo.mcp
            itemx.outcome = vo.outcome
            itemx
        }
    }

    suspend fun retrieveBreastCancer(_val: String): BreastCancer? {
        return getBreastCancerByPK2(_val)
    }

    suspend fun allBreastCancerIds(): ArrayList<String> {
        currentBreastCancers = repository.listBreastCancer()
        val res: ArrayList<String> = ArrayList()
        for (breastcancer in currentBreastCancers.indices) {
            res.add(currentBreastCancers[breastcancer].id)
        }
        return res
    }

    fun setSelectedBreastCancer(i: Int) {
        if (i < currentBreastCancers.size) {
            currentBreastCancer = currentBreastCancers[i]
        }
    }

    fun getSelectedBreastCancer(): BreastCancerEntity? {
        return currentBreastCancer
    }

    suspend fun persistBreastCancer(_x: BreastCancer) {
        val vo = BreastCancerEntity(_x.id, _x.age, _x.bmi, _x.glucose, _x.insulin, _x.homa, _x.leptin, _x.adiponectin, _x.resistin, _x.mcp, _x.outcome)
        repository.updateBreastCancer(vo)
        currentBreastCancer = vo
    }

    suspend fun searchByBreastCancerid2(idx: String): List<BreastCancerEntity> {
        currentBreastCancers = repository.searchByBreastCancerid2(idx)
        return currentBreastCancers
    }
    suspend fun searchByBreastCancerage2(agex: Int): List<BreastCancerEntity> {
        currentBreastCancers = repository.searchByBreastCancerage2(agex)
        return currentBreastCancers
    }
    suspend fun searchByBreastCancerbmi2(bmix: Float): List<BreastCancerEntity> {
        currentBreastCancers = repository.searchByBreastCancerbmi2(bmix)
        return currentBreastCancers
    }
    suspend fun searchByBreastCancerglucose2(glucosex: Float): List<BreastCancerEntity> {
        currentBreastCancers = repository.searchByBreastCancerglucose2(glucosex)
        return currentBreastCancers
    }
    suspend fun searchByBreastCancerinsulin2(insulinx: Float): List<BreastCancerEntity> {
        currentBreastCancers = repository.searchByBreastCancerinsulin2(insulinx)
        return currentBreastCancers
    }
    suspend fun searchByBreastCancerhoma2(homax: Float): List<BreastCancerEntity> {
        currentBreastCancers = repository.searchByBreastCancerhoma2(homax)
        return currentBreastCancers
    }
    suspend fun searchByBreastCancerleptin2(leptinx: Float): List<BreastCancerEntity> {
        currentBreastCancers = repository.searchByBreastCancerleptin2(leptinx)
        return currentBreastCancers
    }
    suspend fun searchByBreastCanceradiponectin2(adiponectinx: Float): List<BreastCancerEntity> {
        currentBreastCancers = repository.searchByBreastCanceradiponectin2(adiponectinx)
        return currentBreastCancers
    }
    suspend fun searchByBreastCancerresistin2(resistinx: Float): List<BreastCancerEntity> {
        currentBreastCancers = repository.searchByBreastCancerresistin2(resistinx)
        return currentBreastCancers
    }
    suspend fun searchByBreastCancermcp2(mcpx: Float): List<BreastCancerEntity> {
        currentBreastCancers = repository.searchByBreastCancermcp2(mcpx)
        return currentBreastCancers
    }
    suspend fun searchByBreastCanceroutcome2(outcomex: String): List<BreastCancerEntity> {
        currentBreastCancers = repository.searchByBreastCanceroutcome2(outcomex)
        return currentBreastCancers
    }
}