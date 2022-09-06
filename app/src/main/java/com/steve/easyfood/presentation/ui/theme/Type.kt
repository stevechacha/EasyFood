package com.steve.easyfood.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.steve.easyfood.R

// Set of Material typography styles to start with

val poppin = FontFamily(
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppin_bold, FontWeight.Bold),
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = poppin,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = TextWhite
    ),
    h1 = TextStyle(
        fontFamily = poppin,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        color = TextWhite
    ),
    h2 = TextStyle(
        fontFamily = poppin,
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
        color = TextWhite
    ),
    body2 = TextStyle(
        fontFamily = poppin,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        color = TextWhite
    ),

    caption = TextStyle(
        fontFamily = poppin,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )

)