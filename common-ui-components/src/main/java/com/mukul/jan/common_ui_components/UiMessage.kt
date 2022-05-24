package com.mukul.jan.common_ui_components

data class UiMessage(
    var message: String? = null,
){
    companion object{
        val Empty = UiMessage(message = null)
    }
}
