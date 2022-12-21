package com.steve.easyfood.feature_auth.presentation.registerscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.steve.easyfood.R
import com.steve.easyfood.feature_auth.presentation.component.StandardTextField
import com.steve.easyfood.core.presentation.common.theme.SpaceLarge
import com.steve.easyfood.core.presentation.common.theme.SpaceMedium
import com.steve.easyfood.core.presentation.common.theme.darkGreen
import com.steve.easyfood.destinations.HomeScreenDestination
import com.steve.easyfood.destinations.LoginScreenDestination

@Composable
@Destination
fun RegisterScreen(
    navigator: DestinationsNavigator,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Spacer(modifier = Modifier.height(5.dp))
        Image(
            modifier = Modifier
                .size(100.dp),
            painter = painterResource(id = R.drawable.app_logo),
            contentDescription = " App Logo"
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Sign Up",
            fontSize = 25.sp,
            color = Color.Green,
            fontWeight = FontWeight.Bold
        )
        Text(text = "Create an account to continue",
            color = Color.DarkGray,
            fontSize = 18.sp,

        )

        Spacer(modifier = Modifier.height(SpaceMedium))
        StandardTextField(
            text = viewModel.emailText.value,
            onValueChange = {
                viewModel.setEmailText(it)
            },
            error = viewModel.emailError.value,
            keyboardType = KeyboardType.Email,
            hint = stringResource(id = R.string.email)
        )
        Spacer(modifier = Modifier.height(SpaceMedium))
        StandardTextField(
            text = viewModel.usernameText.value,
            onValueChange = {
                viewModel.setUsernameText(it)
            },
            hint = stringResource(id = R.string.password_hint),
            error = viewModel.usernameError.value,
            keyboardType = KeyboardType.Password,
            isPasswordVisible = viewModel.showPassword.value,
            onPasswordToggleClick = {
                viewModel.setShowPassword(it)
            }

        )
        Spacer(modifier = Modifier.height(SpaceMedium))
        StandardTextField(
            text = viewModel.passwordText.value,
            onValueChange = {
                viewModel.setPasswordText(it)
            },
            hint = stringResource(id = R.string.confirm_password),
            keyboardType = KeyboardType.Password,
            error = viewModel.passwordError.value,
            isPasswordVisible = viewModel.showPassword.value,
            onPasswordToggleClick = {
                viewModel.setShowPassword(it)
            }
        )
        Spacer(modifier = Modifier.height(SpaceMedium))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(SpaceLarge),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Red,
                containerColor = darkGreen
            ),
            shape = RoundedCornerShape(30.dp),
            onClick = {
                navigator.navigate(HomeScreenDestination)
            }
        ) {
            Text(
                text = "Sign Up",
                color = Color.White,
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.height(SpaceMedium))

        Text(
            text = buildAnnotatedString {
                append(stringResource(id = R.string.already_have_an_account))
                append(" ")
                val signUpText = stringResource(id = R.string.sign_in)
                withStyle(
                    style = SpanStyle(
                        color = darkGreen,

                    )
                ) {
                    append(signUpText)
                }
            },
            modifier = Modifier
                .clickable {
                           navigator.navigate(LoginScreenDestination)

                },
            color = Color.DarkGray,

        )


    }
}