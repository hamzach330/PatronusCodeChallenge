package com.hamza.doctorboxtest.features.users_listing.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.hamza.patronus.features.deviceholder_listing.domain.model.DeviceHolderItem


@Composable
fun DeviceHolderItem(
    deviceHolder: DeviceHolderItem, onItemClick: (DeviceHolderItem) -> Unit
) {

    Box(
        modifier = Modifier.clickable { onItemClick(deviceHolder) }/*.testTag(TestTags.USER_ITEM)*/

    ) {
        Row(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            //horizontalArrangement = Arrangement.spacedBy(12.dp)

        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(deviceHolder.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .border(2.dp, color = Color.White, shape = CircleShape)
                    .clip(CircleShape)
                    .size(60.dp)
            )

            Spacer(modifier = Modifier.padding(4.dp))

            Column {
                Row() {
                    Text(
                        text = "${deviceHolder.firstName}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp,
                        color = Color.Black
                    )

                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = "${deviceHolder.gender.toLowerCase().capitalize()}",
                        fontSize = 17.sp,
                        color = Color.DarkGray
                    )
                }
                Row() {
                    Text(
                        text = "${deviceHolder.phoneNumber}",
                        fontSize = 17.sp,
                        color = Color.Black
                    )

                    deviceHolder.stickers.forEachIndexed { index, sticker ->

                        if (index % 2 != 0) {
                            Text(
                                modifier = Modifier
                                    .padding(start = 8.dp)
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
                                    .padding(start = 8.dp)
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

            }


//            Text(
//                text = "${deviceHolder.firstName}".uppercase(),
//                color = Color.Black,
//                fontSize = 24.sp,
//                fontWeight = FontWeight.W600
//            )
        }

    }

}



