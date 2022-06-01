package com.steve.easyfood.presentation.search

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steve.easyfood.ui.theme.darkGreen

@Composable
fun FoodCategory(
    items: String,
    modifier: Modifier = Modifier,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

            val lineLength = animateFloatAsState(
                targetValue = if (selected) 2f else 0f,
                animationSpec = tween(
                    durationMillis = 300
                )
            )

        Text(
            text = items,
            color = if (selected) Color.White else Color.Black,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(8.dp)
                .clickable { onClick() }
                .drawBehind {
                    if (selected) {
                        if (lineLength.value > 0f) {
                            drawLine(
                                color = if (selected) {
                                    Color.White
                                } else {
                                    darkGreen
                                },
                                start = Offset(
                                    size.width / 2f - lineLength.value * 10.dp.toPx(),
                                    size.height
                                ),
                                end = Offset(
                                    size.width / 2f + lineLength.value * 10.dp.toPx(),
                                    size.height
                                ),
                                strokeWidth = 2.dp.toPx(),
                                cap = StrokeCap.Round
                            )
                        }
                    }
                }

        )

    }
}