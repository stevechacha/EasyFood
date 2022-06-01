package com.steve.easyfood.presentation.component


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import com.steve.easyfood.util.TestTags
import com.steve.easyfood.presentation.ui.theme.IconSizeMedium
import com.steve.easyfood.ui.theme.darkGreen

@Composable
fun StandardTextFieldLocation(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String = "",
    maxLength: Int = 40,
    error: String = "",
    style: TextStyle = TextStyle(
        color = Color.DarkGray
    ),
    singleLine: Boolean = true,
    maxLines: Int = 1,
    leadingIcon: () -> ImageVector,
    onValueChange: (String) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        TextField(
            value = text,
            onValueChange = {
                if (it.length <= maxLength) {
                    onValueChange(it)
                }
            },
            maxLines = maxLines,
            textStyle = style,
            placeholder = {
                Text(
                    text = hint,
                    color = Color.DarkGray
                )
            },
            isError = error != "",
            singleLine = singleLine,
        )
    }

}
