package com.mukul.jan.common_ui_components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.StateFlow


@Composable
fun <T> rememberStateWithLifecycle(
    stateFlow: StateFlow<T>,
    lifecycle : LifecycleOwner = LocalLifecycleOwner.current
) : State<T> {
    val minActiveState : Lifecycle.State = Lifecycle.State.STARTED
    val initialValue = remember(stateFlow){ stateFlow.value }
    return produceState(
        key1 = stateFlow, key2 = lifecycle, key3 = minActiveState,
        initialValue = initialValue
    ){
        lifecycle.lifecycleScope.launchWhenStarted {
            stateFlow.collect{
                this@produceState.value = it
            }
        }

    }
}