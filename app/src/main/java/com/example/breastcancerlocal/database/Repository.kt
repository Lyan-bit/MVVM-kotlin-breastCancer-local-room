package com.example.breastcancerlocal.database

import com.example.breastcancerlocal.BreastCancerApplication
import com.example.breastcancerlocal.model.BreastCancerEntity
import kotlinx.coroutines.flow.Flow

class Repository : BreastCancerRepository {

    private val breastCancerDAO: BreastCancerEntityDAO by lazy { BreastCancerApplication.database.breastCancerDao() }

    val allBreastCancers: Flow<List<BreastCancerEntity>> = breastCancerDAO.listBreastCancers()

    val allBreastCancerids: Flow<List<String>> = breastCancerDAO.listBreastCancerids()
    val allBreastCancerages: Flow<List<Int>> = breastCancerDAO.listBreastCancerages()
    val allBreastCancerbmis: Flow<List<Float>> = breastCancerDAO.listBreastCancerbmis()
    val allBreastCancerglucoses: Flow<List<Float>> = breastCancerDAO.listBreastCancerglucoses()
    val allBreastCancerinsulins: Flow<List<Float>> = breastCancerDAO.listBreastCancerinsulins()
    val allBreastCancerhomas: Flow<List<Float>> = breastCancerDAO.listBreastCancerhomas()
    val allBreastCancerleptins: Flow<List<Float>> = breastCancerDAO.listBreastCancerleptins()
    val allBreastCanceradiponectins: Flow<List<Float>> = breastCancerDAO.listBreastCanceradiponectins()
    val allBreastCancerresistins: Flow<List<Float>> = breastCancerDAO.listBreastCancerresistins()
    val allBreastCancermcps: Flow<List<Float>> = breastCancerDAO.listBreastCancermcps()
    val allBreastCanceroutcomes: Flow<List<String>> = breastCancerDAO.listBreastCanceroutcomes()

    //Create
    override suspend fun createBreastCancer(breastCancer: BreastCancerEntity) {
        breastCancerDAO.createBreastCancer(breastCancer)
    }

    //Read
    override suspend fun listBreastCancer(): List<BreastCancerEntity> {
        return breastCancerDAO.listBreastCancer()
    }

    //Update
    override suspend fun updateBreastCancer(breastCancer: BreastCancerEntity) {
        breastCancerDAO.updateBreastCancer(breastCancer)
    }

    //Delete all BreastCancers
    override suspend fun deleteBreastCancers() {
       breastCancerDAO.deleteBreastCancers()
    }

    //Delete a BreastCancer
	override suspend fun deleteBreastCancer(id: String) {
	   breastCancerDAO.deleteBreastCancer(id)
    }
    
     //Search with live data
     override fun searchByBreastCancerid (searchQuery: String): Flow<List<BreastCancerEntity>>  {
         return breastCancerDAO.searchByBreastCancerid(searchQuery)
     }
     
     //Search with live data
     override fun searchByBreastCancerage (searchQuery: Int): Flow<List<BreastCancerEntity>>  {
         return breastCancerDAO.searchByBreastCancerage(searchQuery)
     }
     
     //Search with live data
     override fun searchByBreastCancerbmi (searchQuery: Float): Flow<List<BreastCancerEntity>>  {
         return breastCancerDAO.searchByBreastCancerbmi(searchQuery)
     }
     
     //Search with live data
     override fun searchByBreastCancerglucose (searchQuery: Float): Flow<List<BreastCancerEntity>>  {
         return breastCancerDAO.searchByBreastCancerglucose(searchQuery)
     }
     
     //Search with live data
     override fun searchByBreastCancerinsulin (searchQuery: Float): Flow<List<BreastCancerEntity>>  {
         return breastCancerDAO.searchByBreastCancerinsulin(searchQuery)
     }
     
     //Search with live data
     override fun searchByBreastCancerhoma (searchQuery: Float): Flow<List<BreastCancerEntity>>  {
         return breastCancerDAO.searchByBreastCancerhoma(searchQuery)
     }
     
     //Search with live data
     override fun searchByBreastCancerleptin (searchQuery: Float): Flow<List<BreastCancerEntity>>  {
         return breastCancerDAO.searchByBreastCancerleptin(searchQuery)
     }
     
     //Search with live data
     override fun searchByBreastCanceradiponectin (searchQuery: Float): Flow<List<BreastCancerEntity>>  {
         return breastCancerDAO.searchByBreastCanceradiponectin(searchQuery)
     }
     
     //Search with live data
     override fun searchByBreastCancerresistin (searchQuery: Float): Flow<List<BreastCancerEntity>>  {
         return breastCancerDAO.searchByBreastCancerresistin(searchQuery)
     }
     
     //Search with live data
     override fun searchByBreastCancermcp (searchQuery: Float): Flow<List<BreastCancerEntity>>  {
         return breastCancerDAO.searchByBreastCancermcp(searchQuery)
     }
     
     //Search with live data
     override fun searchByBreastCanceroutcome (searchQuery: String): Flow<List<BreastCancerEntity>>  {
         return breastCancerDAO.searchByBreastCanceroutcome(searchQuery)
     }
     

    //Search with suspend
     override suspend fun searchByBreastCancerid2 (id: String): List<BreastCancerEntity> {
          return breastCancerDAO.searchByBreastCancerid2(id)
     }
	     
    //Search with suspend
     override suspend fun searchByBreastCancerage2 (age: Int): List<BreastCancerEntity> {
          return breastCancerDAO.searchByBreastCancerage2(age)
     }
	     
    //Search with suspend
     override suspend fun searchByBreastCancerbmi2 (bmi: Float): List<BreastCancerEntity> {
          return breastCancerDAO.searchByBreastCancerbmi2(bmi)
     }
	     
    //Search with suspend
     override suspend fun searchByBreastCancerglucose2 (glucose: Float): List<BreastCancerEntity> {
          return breastCancerDAO.searchByBreastCancerglucose2(glucose)
     }
	     
    //Search with suspend
     override suspend fun searchByBreastCancerinsulin2 (insulin: Float): List<BreastCancerEntity> {
          return breastCancerDAO.searchByBreastCancerinsulin2(insulin)
     }
	     
    //Search with suspend
     override suspend fun searchByBreastCancerhoma2 (homa: Float): List<BreastCancerEntity> {
          return breastCancerDAO.searchByBreastCancerhoma2(homa)
     }
	     
    //Search with suspend
     override suspend fun searchByBreastCancerleptin2 (leptin: Float): List<BreastCancerEntity> {
          return breastCancerDAO.searchByBreastCancerleptin2(leptin)
     }
	     
    //Search with suspend
     override suspend fun searchByBreastCanceradiponectin2 (adiponectin: Float): List<BreastCancerEntity> {
          return breastCancerDAO.searchByBreastCanceradiponectin2(adiponectin)
     }
	     
    //Search with suspend
     override suspend fun searchByBreastCancerresistin2 (resistin: Float): List<BreastCancerEntity> {
          return breastCancerDAO.searchByBreastCancerresistin2(resistin)
     }
	     
    //Search with suspend
     override suspend fun searchByBreastCancermcp2 (mcp: Float): List<BreastCancerEntity> {
          return breastCancerDAO.searchByBreastCancermcp2(mcp)
     }
	     
    //Search with suspend
     override suspend fun searchByBreastCanceroutcome2 (outcome: String): List<BreastCancerEntity> {
          return breastCancerDAO.searchByBreastCanceroutcome2(outcome)
     }
	     


}
