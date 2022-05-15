package com.mukul.jan.core.data

sealed class NetworkResult<T : Any> {
    data class Success<T: Any>(val data: T): NetworkResult<T>()
    data class Error<T: Any>(val code: Int? = 0, val error: String?): NetworkResult<T>()
    data class Loading<T: Any>(val msg: String? = null) : NetworkResult<T>()
}
