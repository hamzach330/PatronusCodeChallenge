package com.hamza.patronus.features.deviceholder_listing.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.hamza.patronus.features.deviceholder_listing.presentation.components.DeviceHolderItem
import com.hamza.patronus.core.utils.common_ui_components.GlobalUiEvent
import com.hamza.patronus.core.utils.common_ui_components.LoadingView
import com.hamza.patronus.core.utils.common_ui_components.RetryLoading
import com.hamza.patronus.features.deviceholder_listing.domain.model.DeviceHolder
import com.hamza.patronus.navigation.Screens
import com.hamza.patronus.ui.theme.ListDividerBg
import kotlinx.coroutines.flow.collectLatest


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DeviceHolderListingScreen(
    navController: NavController,
    viewModel: DeviceHolderListingViewModel = hiltViewModel()
) {
    val state = viewModel.dataFlow.value
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is GlobalUiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(message = event.message)
                }
            }
        }
    }

    val onListItemClick = { deviceHolder: DeviceHolder ->
         navController.navigate(Screens.DeviceHolderDetail.route.replace(oldValue = "{userId}", newValue = "${deviceHolder.id}" ))
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

            if (!state.isLoading && state.deviceHolderListItems.isEmpty()) {
                RetryLoading(message = "No data available", onClickRetry = {
                    viewModel.loadData()
                })
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),

                )
            {

                Text(
                    modifier = Modifier.padding(start = 24.dp, top = 30.dp, bottom = 17.dp),
                    text = "Device holders",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black

                )

                LazyColumn(
                    contentPadding = PaddingValues(start = 24.dp, end = 24.dp),
                ) {
                    items(items = state.deviceHolderListItems) { deviceHolder ->
                        DeviceHolderItem(deviceHolder = deviceHolder, onItemClick = onListItemClick)
                        Divider(Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(ListDividerBg))

                    }

                }

            }


        }
    )
}