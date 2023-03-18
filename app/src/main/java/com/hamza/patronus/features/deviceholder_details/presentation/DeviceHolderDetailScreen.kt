package com.hamza.patronus.features.deviceholder_details.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.hamza.patronus.features.deviceholder_details.presentation.components.DeviceHolderDetailView
import com.hamza.patronus.core.utils.common_ui_components.GlobalUiEvent
import com.hamza.patronus.core.utils.common_ui_components.LoadingView
import com.hamza.patronus.core.utils.common_ui_components.RetryLoading
import kotlinx.coroutines.flow.collectLatest

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DeviceHolderDetailScreen(
    navController: NavController,
    viewmodel: DeviceHolderDetailViewModel = hiltViewModel(),
    userId: String
)
{
    val state = viewmodel.dataFlow.value
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {

        viewmodel.loadDeviceHolderDetails(userId)
        viewmodel.eventFlow.collectLatest { event ->
            when (event) {
                is GlobalUiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(message = event.message)
                }
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        contentColor = MaterialTheme.colors.primaryVariant,
        content = {
            if (state.isLoading) {
                LoadingView(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                )
            }
            if (!state.isLoading && state.deviceHolderDetail == null) {
                RetryLoading(message = "stringResource(R.string.no_data_available)", onClickRetry = {
                    viewmodel.loadDeviceHolderDetails(userId)
                })
            }
            state.deviceHolderDetail?.let {
                DeviceHolderDetailView(it)
            }

        }
    )
}