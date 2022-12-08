package cn.qinxiandiqi.android.cold.knowledge.feature.sqlite

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
class InsertOrUpdateViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private var logFlow = MutableStateFlow("")
    val logStateFlow: StateFlow<String> = logFlow

    fun createDB() {
        viewModelScope.launch {

        }
    }

    fun dropDB() {
        viewModelScope.launch {

        }
    }

    fun insertOrUpdate() {
        viewModelScope.launch {

        }
    }
}