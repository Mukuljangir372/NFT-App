package com.mukul.jan.core.extensions

import com.mukul.jan.core.data.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.io.IOException
import kotlin.coroutines.CoroutineContext

private const val NETWORK_ERROR = "Please check your internet connection"
private const val GENERAL_ERROR = "Something went wrong! Please try again"

suspend fun <T: Any> safeApiCall(
    coroutineContext: CoroutineContext,
    dispatcher: CoroutineDispatcher,
    execute: suspend () -> Response<T>
): NetworkResult<T>{
    return withContext(coroutineContext + dispatcher){
        try {
            val response = execute()
            val body = response.body()
            if(response.isSuccessful && body!=null && response.code() == 200){
                NetworkResult.Success(body)
            }else{
                NetworkResult.Error(error = GENERAL_ERROR)
            }
        }catch (throwable: Exception) {
            when(throwable){
                is IOException -> {
                    NetworkResult.Error(error = NETWORK_ERROR)
                }
                else -> {
                    NetworkResult.Error(error = GENERAL_ERROR)
                }
            }
        }
    }
}