package com.example.breastcancerlocal.database

import androidx.room.*
import com.example.breastcancerlocal.model.BreastCancerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BreastCancerEntityDAO {
    //LiveData
    //Read (list entity)
    @Query("SELECT * FROM breastCancer_table")
    fun listBreastCancers(): Flow<List<BreastCancerEntity>>

    //Read (list id)
	@Query("SELECT id FROM breastCancer_table")
	fun listBreastCancerids (): Flow<List<String>>
    //Read (list age)
	@Query("SELECT age FROM breastCancer_table")
	fun listBreastCancerages (): Flow<List<Int>>
    //Read (list bmi)
	@Query("SELECT bmi FROM breastCancer_table")
	fun listBreastCancerbmis (): Flow<List<Float>>
    //Read (list glucose)
	@Query("SELECT glucose FROM breastCancer_table")
	fun listBreastCancerglucoses (): Flow<List<Float>>
    //Read (list insulin)
	@Query("SELECT insulin FROM breastCancer_table")
	fun listBreastCancerinsulins (): Flow<List<Float>>
    //Read (list homa)
	@Query("SELECT homa FROM breastCancer_table")
	fun listBreastCancerhomas (): Flow<List<Float>>
    //Read (list leptin)
	@Query("SELECT leptin FROM breastCancer_table")
	fun listBreastCancerleptins (): Flow<List<Float>>
    //Read (list adiponectin)
	@Query("SELECT adiponectin FROM breastCancer_table")
	fun listBreastCanceradiponectins (): Flow<List<Float>>
    //Read (list resistin)
	@Query("SELECT resistin FROM breastCancer_table")
	fun listBreastCancerresistins (): Flow<List<Float>>
    //Read (list mcp)
	@Query("SELECT mcp FROM breastCancer_table")
	fun listBreastCancermcps (): Flow<List<Float>>
    //Read (list outcome)
	@Query("SELECT outcome FROM breastCancer_table")
	fun listBreastCanceroutcomes (): Flow<List<String>>

	//Suspend
    //Create
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun createBreastCancer (breastCancer: BreastCancerEntity)

    //Read (list entity with suspend)
    @Query("SELECT * FROM breastCancer_table")
    suspend fun listBreastCancer(): List<BreastCancerEntity>

    //Update
    @Update
    suspend fun updateBreastCancer (breastCancer: BreastCancerEntity)

    //Delete all records
    @Query("DELETE FROM breastCancer_table")
    suspend fun deleteBreastCancers ()

    //Delete a single record by PK
    @Query("DELETE FROM breastCancer_table WHERE id = :id")
    suspend fun deleteBreastCancer (id: String)
    
    //Search with live data
	@Query("SELECT * FROM  breastCancer_table WHERE id LIKE :searchQuery ")
	fun searchByBreastCancerid(searchQuery: String): Flow<List<BreastCancerEntity>>
	@Query("SELECT * FROM  breastCancer_table WHERE age LIKE :searchQuery ")
	fun searchByBreastCancerage(searchQuery: Int): Flow<List<BreastCancerEntity>>
	@Query("SELECT * FROM  breastCancer_table WHERE bmi LIKE :searchQuery ")
	fun searchByBreastCancerbmi(searchQuery: Float): Flow<List<BreastCancerEntity>>
	@Query("SELECT * FROM  breastCancer_table WHERE glucose LIKE :searchQuery ")
	fun searchByBreastCancerglucose(searchQuery: Float): Flow<List<BreastCancerEntity>>
	@Query("SELECT * FROM  breastCancer_table WHERE insulin LIKE :searchQuery ")
	fun searchByBreastCancerinsulin(searchQuery: Float): Flow<List<BreastCancerEntity>>
	@Query("SELECT * FROM  breastCancer_table WHERE homa LIKE :searchQuery ")
	fun searchByBreastCancerhoma(searchQuery: Float): Flow<List<BreastCancerEntity>>
	@Query("SELECT * FROM  breastCancer_table WHERE leptin LIKE :searchQuery ")
	fun searchByBreastCancerleptin(searchQuery: Float): Flow<List<BreastCancerEntity>>
	@Query("SELECT * FROM  breastCancer_table WHERE adiponectin LIKE :searchQuery ")
	fun searchByBreastCanceradiponectin(searchQuery: Float): Flow<List<BreastCancerEntity>>
	@Query("SELECT * FROM  breastCancer_table WHERE resistin LIKE :searchQuery ")
	fun searchByBreastCancerresistin(searchQuery: Float): Flow<List<BreastCancerEntity>>
	@Query("SELECT * FROM  breastCancer_table WHERE mcp LIKE :searchQuery ")
	fun searchByBreastCancermcp(searchQuery: Float): Flow<List<BreastCancerEntity>>
	@Query("SELECT * FROM  breastCancer_table WHERE outcome LIKE :searchQuery ")
	fun searchByBreastCanceroutcome(searchQuery: String): Flow<List<BreastCancerEntity>>

    //Search with suspend
    @Query("SELECT * FROM  breastCancer_table WHERE id LIKE :searchQuery")
	suspend fun searchByBreastCancerid2(searchQuery: String): List<BreastCancerEntity>
    @Query("SELECT * FROM  breastCancer_table WHERE age LIKE :searchQuery")
	suspend fun searchByBreastCancerage2(searchQuery: Int): List<BreastCancerEntity>
    @Query("SELECT * FROM  breastCancer_table WHERE bmi LIKE :searchQuery")
	suspend fun searchByBreastCancerbmi2(searchQuery: Float): List<BreastCancerEntity>
    @Query("SELECT * FROM  breastCancer_table WHERE glucose LIKE :searchQuery")
	suspend fun searchByBreastCancerglucose2(searchQuery: Float): List<BreastCancerEntity>
    @Query("SELECT * FROM  breastCancer_table WHERE insulin LIKE :searchQuery")
	suspend fun searchByBreastCancerinsulin2(searchQuery: Float): List<BreastCancerEntity>
    @Query("SELECT * FROM  breastCancer_table WHERE homa LIKE :searchQuery")
	suspend fun searchByBreastCancerhoma2(searchQuery: Float): List<BreastCancerEntity>
    @Query("SELECT * FROM  breastCancer_table WHERE leptin LIKE :searchQuery")
	suspend fun searchByBreastCancerleptin2(searchQuery: Float): List<BreastCancerEntity>
    @Query("SELECT * FROM  breastCancer_table WHERE adiponectin LIKE :searchQuery")
	suspend fun searchByBreastCanceradiponectin2(searchQuery: Float): List<BreastCancerEntity>
    @Query("SELECT * FROM  breastCancer_table WHERE resistin LIKE :searchQuery")
	suspend fun searchByBreastCancerresistin2(searchQuery: Float): List<BreastCancerEntity>
    @Query("SELECT * FROM  breastCancer_table WHERE mcp LIKE :searchQuery")
	suspend fun searchByBreastCancermcp2(searchQuery: Float): List<BreastCancerEntity>
    @Query("SELECT * FROM  breastCancer_table WHERE outcome LIKE :searchQuery")
	suspend fun searchByBreastCanceroutcome2(searchQuery: String): List<BreastCancerEntity>

}
