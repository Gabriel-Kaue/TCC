package room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import room.Faq

@Dao
interface FaqDao {
    @Upsert
    suspend fun addFaq(faq: Faq)

    @Delete
    suspend fun deleteFaq(faq: Faq)

    @Query("SELECT * FROM faq ORDER BY idPergunta ASC")
    fun getFaqOrderByFaq(): Flow<List<Faq>>
}