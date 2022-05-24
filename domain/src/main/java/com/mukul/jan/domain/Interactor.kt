package com.mukul.jan.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

/**
 * Interface vs abstract :
 * Interface and abstract are work at same level. Major difference is abstract class holds
 * the states at top level.
 */

sealed class InteractorStatus(){
    object Started: InteractorStatus()
    object Finished: InteractorStatus()
    data class Error(val error: Throwable): InteractorStatus()
}

abstract class Interactor<in P> {
    operator fun invoke(params: P) : Flow<InteractorStatus> = flow {
        try {
            emit(InteractorStatus.Started)
            doWork(params)
            emit(InteractorStatus.Finished)
        }catch (e: Exception){
            emit(InteractorStatus.Error(e))
        }
    }.catch { t ->
        emit(InteractorStatus.Error(t))
    }

    suspend fun executeSync(params: P) = doWork(params)

    abstract suspend fun doWork(params: P)
}

abstract class ObserverInteractor<P : Any, T>{
    private val sharedFlow = MutableSharedFlow<T>()
    var flow : Flow<T> = sharedFlow

    suspend operator fun invoke(params: P) : Flow<T> {
        flow = createObservable(params)
        return flow
    }

    abstract suspend fun createObservable(params: P): Flow<T>

}