package com.mukul.jan.ui_collections_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mukul.jan.data.collection.source.CollectionListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CollectionListViewModel @Inject constructor(
    private val repository: CollectionListRepository
) : ViewModel() {
    init {
        viewModelScope.launch {
            repository.getCollections().collectLatest {

            }
        }
    }
}