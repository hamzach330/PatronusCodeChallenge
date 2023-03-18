package com.hamza.doctorboxtest.features.user_details.presentation.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.hamza.patronus.R
import com.hamza.patronus.features.deviceholder_details.domain.model.DeviceHolderDetail


@Composable
fun DeviceHolderDetailView(deviceHolderDetail: DeviceHolderDetail) {

    Column() {
        Card(
            elevation = 4.dp,
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(Color.White)
                    .padding(0.dp, 15.dp, 0.dp, 15.dp)


            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(deviceHolderDetail.imageUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = "Profile Picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .border(2.dp, color = Color.White, shape = CircleShape)
                        .clip(CircleShape)
                        .size(80.dp)
                )
                Text(
                    text = deviceHolderDetail.firstName ?: "N/A",
                    color = Color.Black,
                    fontSize = 20.sp,
                    //fontFamily = Typography.h3.fontFamily,
                    fontWeight = FontWeight.W600,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(5.dp)

                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.error),
                        contentDescription = "Location",
                        modifier = Modifier.size(17.dp)
                    )

                        Text(
                            text = deviceHolderDetail.lastName?:"N/A",
                            color = Color.Black,
                            //fontSize = Typography.body1.fontSize,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(2.dp)
                        )

                }


            }
        }


        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {
            Text(
                text = deviceHolderDetail.toString(),
                color = Color.Black,
                //fontSize = Typography.h6.fontSize,
                //fontFamily = Typography.h6.fontFamily,
            )
        }


    }


}