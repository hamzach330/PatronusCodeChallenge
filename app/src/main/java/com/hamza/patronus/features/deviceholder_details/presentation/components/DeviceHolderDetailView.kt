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
import com.hamza.patronus.ui.theme.*


@Composable
fun DeviceHolderDetailView(deviceHolderDetail: DeviceHolderDetail, onBackClick: () -> Unit) {

    Box(
        modifier = Modifier
            .padding(start = 32.dp, top = 30.dp, end = 32.dp)
    ) {


        Column(modifier = Modifier.fillMaxSize()) {
            IconButton(
                modifier = Modifier.size(53.dp),/*.clickable { onBackClick() }*/
                onClick = { onBackClick() },
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
                        .border(2.dp, color = Color.Transparent, shape = CircleShape)
                        .clip(CircleShape)
                        .size(64.dp)
                )
            } else {
                Text(
                    modifier = Modifier
                        .border(2.dp, color = ProfilePicBgGray, shape = CircleShape)
                        .clip(CircleShape)
                        .size(64.dp)
                        .background(ProfilePicBgGray)
                        .wrapContentHeight(),
                    text = deviceHolderDetail.firstName.take(1) + deviceHolderDetail.lastName.take(1),
                    fontSize = 35.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center,
                    color = ProfilePicTextGray

                )
            }

            Spacer(modifier = Modifier.size(24.dp))

            Text(
                text = deviceHolderDetail.firstName + " " + deviceHolderDetail.lastName,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 36.sp,
                color = TextBlack
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
                                    color = StickerBgRed.copy(alpha = 0.5f),
                                    shape = RoundedCornerShape(5.dp)
                                )
                                .padding(vertical = 2.dp, horizontal = 4.dp),
                            text = sticker,
                            color = StickerTextRed,
                            fontSize = 17.sp
                        )
                    } else {
                        Text(
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .border(
                                    width = 50.dp,
                                    color = StickerBgGray.copy(alpha = 0.5f),
                                    shape = RoundedCornerShape(5.dp)
                                )
                                .padding(vertical = 2.dp, horizontal = 4.dp),
                            text = sticker,
                            color = StickerTextGray,
                            fontSize = 17.sp
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
                    fontSize = 23.sp,
                    color = TextGray
                )

                Spacer(modifier = Modifier.size(10.dp))
                Divider(
                    modifier = Modifier
                        .width(2.dp)
                        .fillMaxHeight()
                        .padding(vertical = 2.dp),
                    color = ListDividerBg
                )
                Spacer(modifier = Modifier.size(10.dp))

                Text(
                    text = deviceHolderDetail.phoneNumber,
                    fontWeight = FontWeight.Light,
                    fontSize = 23.sp,
                    color = TextGray
                )


            }

            Spacer(modifier = Modifier.size(24.dp))

            Text(
                text = "ADDRESS",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                color = TextGray
            )

            Spacer(modifier = Modifier.size(8.dp))

            Text(
                text = deviceHolderDetail.address.street
                        + ", " + deviceHolderDetail.address.zip
                        + "\n" + deviceHolderDetail.address.country,
                fontWeight = FontWeight.Light,
                fontSize = 23.sp,
                color = TextGray
            )
        }
    }


}