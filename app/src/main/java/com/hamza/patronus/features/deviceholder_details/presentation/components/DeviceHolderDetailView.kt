package com.hamza.patronus.features.deviceholder_details.presentation.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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

    Box(
        modifier = Modifier
            .padding(start = 24.dp, top = 34.dp, end = 24.dp)
    ) {


        Column(modifier = Modifier.fillMaxSize()) {
            IconButton(
                modifier = Modifier.size(40.dp),
                onClick = { },
            ) {
                Image(
                    painter = painterResource(R.drawable.back_arrow),
                    contentDescription = null
                )
            }

            Spacer(modifier = Modifier.size(20.dp))


            Image(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .fillMaxHeight(0.4f),
                contentScale = ContentScale.FillBounds,
                painter = painterResource(R.drawable.map),
                contentDescription = null
            )

            Spacer(modifier = Modifier.size(20.dp))

            if (deviceHolderDetail.imageUrl != null) {
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
            } else {
                Text(
                    modifier = Modifier
                        .border(2.dp, color = Color.LightGray, shape = CircleShape)
                        .clip(CircleShape)
                        .size(80.dp)
                        .background(Color.LightGray)
                        .wrapContentHeight(),
                    text = deviceHolderDetail.firstName.take(1) + deviceHolderDetail.lastName.take(1),
                    fontSize = 35.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center,
                    color = Color.Gray

                )
            }

            Spacer(modifier = Modifier.size(24.dp))

            Text(
                text = deviceHolderDetail.firstName + " " + deviceHolderDetail.lastName,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 27.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.size(10.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                deviceHolderDetail.stickers.forEachIndexed { index, sticker ->

                    if (index % 2 != 0) {
                        Text(
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .border(
                                    width = 50.dp,
                                    color = Color.Red.copy(alpha = 0.5f),
                                    shape = RoundedCornerShape(5.dp)
                                )
                                .padding(vertical = 2.dp, horizontal = 4.dp),
                            text = sticker,
                            color = Color.Red
                        )
                    } else {
                        Text(
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .border(
                                    width = 50.dp,
                                    color = Color.Gray.copy(alpha = 0.5f),
                                    shape = RoundedCornerShape(5.dp)
                                )
                                .padding(vertical = 2.dp, horizontal = 4.dp),
                            text = sticker,
                            color = Color.Gray
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.size(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {

                Text(
                    text = deviceHolderDetail.gender,
                    fontWeight = FontWeight.Light,
                    fontSize = 17.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.size(10.dp))
                Divider(
                    modifier = Modifier
                        .width(2.dp)
                        .fillMaxHeight()
                        .padding(vertical = 2.dp),
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.size(10.dp))

                Text(
                    text = deviceHolderDetail.phoneNumber,
                    fontWeight = FontWeight.Light,
                    fontSize = 17.sp,
                    color = Color.Gray
                )


            }

            Spacer(modifier = Modifier.size(24.dp))

            Text(
                text = "ADDRESS",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 15.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.size(8.dp))

            Text(
                text = deviceHolderDetail.address.street
                        + ", " + deviceHolderDetail.address.zip
                        + "\n" + deviceHolderDetail.address.country,
                fontWeight = FontWeight.Light,
                fontSize = 17.sp,
                color = Color.Black
            )


        }

//
//        Card(
//            elevation = 4.dp,
//            shape = RoundedCornerShape(20.dp),
//            modifier = Modifier
//                .background(Color.White)
//                .fillMaxWidth()
//                .padding(10.dp)
//        ) {
//            Column(
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier
//                    .background(Color.White)
//                    .padding(0.dp, 15.dp, 0.dp, 15.dp)
//
//
//            ) {
//                AsyncImage(
//                    model = ImageRequest.Builder(LocalContext.current)
//                        .data(deviceHolderDetail.imageUrl)
//                        .crossfade(true)
//                        .build(),
//                    contentDescription = "Profile Picture",
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                        .border(2.dp, color = Color.White, shape = CircleShape)
//                        .clip(CircleShape)
//                        .size(80.dp)
//                )
//                Text(
//                    text = deviceHolderDetail.firstName ?: "N/A",
//                    color = Color.Black,
//                    fontSize = 20.sp,
//                    //fontFamily = Typography.h3.fontFamily,
//                    fontWeight = FontWeight.W600,
//                    textAlign = TextAlign.Center,
//                    modifier = Modifier.padding(5.dp)
//
//                )
//
//                Row(
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.error),
//                        contentDescription = "Location",
//                        modifier = Modifier.size(17.dp)
//                    )
//
//                    Text(
//                        text = deviceHolderDetail.lastName ?: "N/A",
//                        color = Color.Black,
//                        //fontSize = Typography.body1.fontSize,
//                        textAlign = TextAlign.Center,
//                        modifier = Modifier.padding(2.dp)
//                    )
//
//                }
//
//
//            }
//        }
//
//
//        Column(
//            modifier = Modifier
//                .verticalScroll(rememberScrollState())
//                .padding(20.dp)
//        ) {
//            Text(
//                text = deviceHolderDetail.toString(),
//                color = Color.Black,
//                //fontSize = Typography.h6.fontSize,
//                //fontFamily = Typography.h6.fontFamily,
//            )
//        }


    }


}