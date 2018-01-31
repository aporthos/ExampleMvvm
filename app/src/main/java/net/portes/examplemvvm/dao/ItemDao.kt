package net.portes.examplemvvm.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import net.portes.examplemvvm.pojos.Item

/**
 * Created by portes on 28/01/18.
 */

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveItem(mItem: List<Item>)

    @Query("select * from Item")
    fun getItemAll(): Flowable<List<Item>>
}