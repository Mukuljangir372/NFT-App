package com.mukul.jan.ui_collections_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mukul.jan.common_ui_components.UiMessage
import com.mukul.jan.domain.observers.ObserveCollections
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class CollectionListViewModel @Inject constructor(
    private val observeCollections: ObserveCollections
) : ViewModel() {

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing : StateFlow<Boolean> get() = _isRefreshing

    private val _uiMessage = MutableStateFlow(UiMessage.Empty)
    val uiMessage : StateFlow<UiMessage> get() = _uiMessage

    val state : StateFlow<CollectionStateHolder> = combine(
        isRefreshing,
        uiMessage,
    ){ isRefreshing, uiMessage ->
        CollectionStateHolder(
            isRefreshing = isRefreshing,
            uiMessage = uiMessage
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = CollectionStateHolder.Empty
    )

    init {
        viewModelScope.launch {
            observeCollections(ObserveCollections.Params())
        }
    }

    fun getLiveCollectionList() = observeCollections.flow

    fun refreshing(value: Boolean){
        _isRefreshing.value = value
    }
    fun pushUiMsg(msg: String) {
        _uiMessage.value = UiMessage(message = msg)
    }
    fun clearUiMsg() {
        _uiMessage.value = UiMessage(message = null)
    }

}