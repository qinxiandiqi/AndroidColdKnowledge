package cn.qinxiandiqi.android.cold.knowledge.feature.sqlite

import android.app.Application
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 *
 * created by Jianan on 2022/12/8.
 */
class InsertOrUpdateViewModel(
    application: Application,
    private val savedStateHandle: SavedStateHandle,
) : AndroidViewModel(application) {

    private var logFlow = MutableStateFlow("")
    val logStateFlow: StateFlow<String> = logFlow

    private val sqLiteOpenHelper =
        object : SQLiteOpenHelper(application, "InsertOrUpdate", null, 1) {
            override fun onCreate(db: SQLiteDatabase) {

            }

            override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            }
        }

    override fun onCleared() {
        super.onCleared()
        sqLiteOpenHelper.close()
    }

    fun createDB() {
        viewModelScope.launch {
            sqLiteOpenHelper.writableDatabase.execSQL(CREATE_DB)
        }
    }

    fun dropDB() {
        viewModelScope.launch {
            sqLiteOpenHelper.writableDatabase.execSQL(DROP_DB)
        }
    }

    fun insertOrUpdate() {
        viewModelScope.launch {

        }
    }

    companion object {
        private const val TABLE_NAME = "tb_books"
        private const val COL_NAME = "name"
        private const val COL_AUTHOR = "author"
        private const val COL_COUNT = "count"
        private const val CREATE_DB =
            """
                CREATE TABLE IF NOT EXISTS $TABLE_NAME (${BaseColumns._ID} INTEGER PRIMARY KEY, 
                $COL_NAME TEXT NOT NULL, $COL_AUTHOR TEXT, $COL_COUNT INTEGER DEFAULT 0)
            """
        private const val DROP_DB =
            """
                DROP TABLE IF EXISTS $TABLE_NAME
            """

    }
}

class Book(
    var name: String,
    var author: String?,
    var count: Int?
) : BaseColumns