package com.emotionfactry.presentation.view.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.emotionfactry.presentation.R

data class AppTypography(
    val h1: TextStyle = TextStyle(
        fontFamily = monserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 96.sp,
        letterSpacing = (-1.5).sp
    ),
    val h2: TextStyle = TextStyle(
        fontFamily = monserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 60.sp,
        letterSpacing = (-0.5).sp
    ),
    val h3: TextStyle = TextStyle(
        fontFamily = monserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 48.sp,
        letterSpacing = 0.sp
    ),
    val h4: TextStyle = TextStyle(
        fontFamily = monserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 34.sp,
        letterSpacing = 0.25.sp
    ),
    val h5: TextStyle = TextStyle(
        fontFamily = monserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        letterSpacing = 0.sp
    ),
    val h6: TextStyle = TextStyle(
        fontFamily = monserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        letterSpacing = 0.15.sp
    ),
    val subtitle1: TextStyle = TextStyle(
        fontFamily = monserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.15.sp
    ),
    val subtitle2: TextStyle = TextStyle(
        fontFamily = monserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.1.sp
    ),
    val body1: TextStyle = TextStyle(
        fontFamily = monserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.5.sp
    ),
    val body2: TextStyle = TextStyle(
        fontFamily = monserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.25.sp
    ),
    val button: TextStyle = TextStyle(
        fontFamily = monserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 1.25.sp
    ),
    val caption: TextStyle = TextStyle(
        fontFamily = monserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.4.sp
    ),
    val overline: TextStyle = TextStyle(
        fontFamily = monserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        letterSpacing = 1.5.sp
    )
)

private val monserrat = FontFamily(
   Font(R.font.montserrat_thin, FontWeight.Thin),
   Font(R.font.montserrat_thinitalic, FontWeight.Thin, FontStyle.Italic),
   Font(R.font.montserrat_extralight, FontWeight.ExtraLight),
   Font(R.font.montserrat_extralightitalic, FontWeight.ExtraLight, FontStyle.Italic),
   Font(R.font.montserrat_light, FontWeight.Light, FontStyle.Italic),
   Font(R.font.montserrat_regular, FontWeight.Normal),
   Font(R.font.montserrat_italic, FontWeight.Normal, FontStyle.Italic),
   Font(R.font.montserrat_medium, FontWeight.Medium),
   Font(R.font.montserrat_mediumitalic, FontWeight.Medium, FontStyle.Italic),
   Font(R.font.montserrat_semibold, FontWeight.SemiBold),
   Font(R.font.montserrat_semibolditalic, FontWeight.SemiBold, FontStyle.Italic),
   Font(R.font.montserrat_bold, FontWeight.Bold),
   Font(R.font.montserrat_bolditalic, FontWeight.Bold, FontStyle.Italic),
   Font(R.font.montserrat_extrabold, FontWeight.ExtraBold),
   Font(R.font.montserrat_extrabolditalic, FontWeight.ExtraBold, FontStyle.Italic),
   Font(R.font.montserrat_black, FontWeight.Black),
   Font(R.font.montserrat_blackitalic, FontWeight.Black, FontStyle.Italic),
)