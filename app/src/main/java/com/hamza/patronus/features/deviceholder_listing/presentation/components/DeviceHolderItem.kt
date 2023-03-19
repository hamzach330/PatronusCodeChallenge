package com.hamza.patronus.features.deviceholder_listing.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.hamza.patronus.features.deviceholder_listing.domain.model.DeviceHolder
import com.hamza.patronus.ui.theme.*
import java.util.*


@Composable
fun DeviceHolderItem(
    deviceHolder: DeviceHolder, onItemClick: (DeviceHolder) -> Unit
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

        ) {

            if (deviceHolder.imageUrl != null)
            {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(deviceHolder.imageUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = "Profile Picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .border(2.dp, color = Color.Transparent, shape = CircleShape)
                        .clip(CircleShape)
                        .size(64.dp)
                )
            }

            else{
                Text(
                    modifier = Modifier
                        .border(2.dp, color = ProfilePicBgGray, shape = CircleShape)
                        .clip(CircleShape)
                        .size(64.dp)
                        .background(ProfilePicBgGray)
                        .wrapContentHeight(),
                    text = deviceHolder.firstName.take(1)+deviceHolder.lastName.take(1),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center,
                    color = ProfilePicTextGray
                )
            }



            Spacer(modifier = Modifier.padding(4.dp))

            Column {
                Row() {
                    Text(
                        text = deviceHolder.firstName +" "+deviceHolder.lastName,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 23.sp,
                        color = TextBlack
                    )

                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = deviceHolder.gender.lowercase(Locale.ROOT)
                            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() },
                        fontSize = 23.sp,
                        color = TextLightGray
                    )
                }
                Row(
                    modifier = Modifier.padding(top = 0.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${deviceHolder.phoneNumber}",
                        fontSize = 23.sp,
                        color = TextGray
                    )

                    deviceHolder.stickers.forEachIndexed { index, sticker ->

                        if (index % 2 != 0) {
                            Text(
                                modifier = Modifier
                                    .padding(start = 8.dp)
                                    .border(
                                        width = 50.dp,
                                        color = StickerBgRed.copy(alpha = 0.3f),
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
                                    .padding(start = 8.dp)
                                    .border(
                                        width = 50.dp,
                                        color = StickerBgGray.copy(alpha = 0.3f),
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

            }

        }

    }

}



