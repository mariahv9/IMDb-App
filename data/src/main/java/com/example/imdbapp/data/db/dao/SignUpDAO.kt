package com.example.imdbapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.imdbapp.data.db.entities.UserEntity

@Dao
interface SignUpDAO {
    @Transaction
    suspend fun transaction(userEntity: UserEntity) {
        delete()
        insert(userEntity)
    }

    @Query("SELECT * FROM user")
    fun get(): UserEntity

    @Query("SELECT COUNT(email) FROM user WHERE email = :email")
    suspend fun getByEmail(email: String): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: UserEntity)

    @Query("DELETE FROM user")
    fun delete()
}
