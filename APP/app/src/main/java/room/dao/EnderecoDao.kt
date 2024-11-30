package room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import room.Endereco

@Dao
interface EnderecoDao {
    @Upsert
    suspend fun addEndereco(endereco: Endereco)

    @Delete
    suspend fun deleteEndereco(endereco: Endereco)

    @Query("SELECT * FROM tabela_endereco ORDER BY idEndereco ASC")
    fun getEnderecoOrderByEndereco(): Flow<List<Endereco>>

}

