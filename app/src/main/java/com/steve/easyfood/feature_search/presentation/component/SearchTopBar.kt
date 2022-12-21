package com.steve.easyfood.feature_search.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steve.easyfood.R

@Composable
fun SearchTopBar(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit,
) {
    Box(modifier = modifier) {
        Icon(
            painter = painterResource(id = R.drawable.topbar_speaker_bg),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .align(Alignment.CenterStart)
                .padding(start = 10.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = onBackPressed,
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back_arrow),
                    contentDescription = stringResource(R.string.back_arrow_icon_description),
                    tint = colorResource(id = R.color.smoke_white)
                )
            }

            Text(
                text = stringResource(id = R.string.search),
                fontSize = 18.sp,
                lineHeight = 22.sp,
                color = colorResource(id = R.color.smoke_white),
                modifier = Modifier.padding(start = 10.dp)
            )

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = stringResource(R.string.search),
                    tint = colorResource(id = R.color.smoke_white)
                )
            }
        }

    }


}