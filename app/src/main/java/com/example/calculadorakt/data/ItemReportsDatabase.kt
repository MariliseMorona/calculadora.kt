package com.example.calculadorakt.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.calculadorakt.model.ItemReports
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Database(entities = [ItemReports::class], version = 1, exportSchema = false)
abstract class ItemReportsDatabase: RoomDatabase() {

    abstract fun addReportsDao(): AddReportsDao

    companion object{

// Evita que multiplas instancias do banco de dados sejam abertas ao mesmo tempo
        @Volatile
        private var INSTANCE: ItemReportsDatabase? = null

        private class ItemReportsDatabaseCallback(private val scope: CoroutineScope): RoomDatabase.Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let {
                    database ->
                    scope.launch {
                        populateDatabase(database.addReportsDao())
                    }
                }
            }
            suspend fun populateDatabase(dao: AddReportsDao){
                val itemReport1 = ItemReports(
                 1000,
                 10,
                 "Ltda",
                 "Ltda",
                 "30/02/2021",
                 3,
                 30,
                 40,
                 500,
                 1
                )
                dao.insert(itemReport1)
            }
        }
        fun getDatabase(context: Context, scope: CoroutineScope): ItemReportsDatabase{

            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemReportsDatabase::class.java,
                    "item_reports_database"
                )
                    .addCallback(ItemReportsDatabaseCallback(scope))
                    .build()
                    INSTANCE = instance
                    instance
            }
        }
        fun getAll(): List<ItemReports>{
            val itemReport1 = ItemReports(
                1000,
                10,
                "Ltda",
                "Ltda",
                "30/02/2021",
                3,
                30,
                40,
                500,
                1
            )
            return listOf(itemReport1)
        }
    }
}