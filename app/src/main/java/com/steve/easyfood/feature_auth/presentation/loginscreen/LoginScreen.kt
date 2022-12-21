package com.steve.easyfood.feature_auth.presentation.loginscreen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.steve.easyfood.destinations.RegisterScreenDestination

@Composable
@Destination
fun LoginScreen(
    navigator: DestinationsNavigator,
    viewModel: LoginViewModel = hiltViewModel()
) {

    Column (
        horizontalAlignment = Alignment.CenterHorizontally ,
        modifier= Modifier
            .fillMaxSize()
            .background(Color.White)
            ){

        Spacer(modifier = Modifier.height(10.dp))
        
        Image(
            modifier= Modifier
                .size(100.dp),
            painter = painterResource(id = R.drawable.app_logo),
            contentDescription = " App Logo"
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Login",
            fontSize = 28.sp,
            color= darkGreen,
            fontWeight = FontWeight.Bold,
        )
        Text(text = "Please sign in to continue",
            color = darkGreen,
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.height(SpaceMedium))
                StandardTextField(
                    text = viewModel.usernameText.value,
                    onValueChange = {
                        viewModel.setUsernameText(it)
                    },
                    keyboardType = KeyboardType.Email,
                    error = viewModel.usernameError.value,
                    hint = stringResource(id = R.string.login_hint),

                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                StandardTextField(
                    text = viewModel.passwordText.value,
                    onValueChange = {
                        viewModel.setPasswordText(it)
                    },
                    hint = stringResource(id = R.string.password_hint),
                    keyboardType = KeyboardType.Password,
                 error = viewModel.passwordError.value,
                 isPasswordVisible = viewModel.showPassword.value,
                    onPasswordToggleClick = {
                       viewModel.setShowPassword(it)
                    }
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(end = SpaceLarge),
                    text=stringResource(id = R.string.forgot_password),
                    color = Color.DarkGray,
                )
        Spacer(modifier = Modifier.height(SpaceMedium))

        Button(
            modifier= Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(SpaceLarge)
                .clip(CircleShape),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Red,
                containerColor = darkGreen
            ),
            onClick = {
                navigator.navigate(HomeScreenDestination)
            }
        ) {
            Text(
                text = "Login",
                color = Color.White,
                fontSize = 18.sp,
            )
        }

        Spacer(modifier = Modifier.height(SpaceMedium))

        Text(
            text = buildAnnotatedString {
                append(stringResource(id = R.string.dont_have_an_account_yet))
                append(" ")
                val signUpText = stringResource(id = R.string.sign_up)
                withStyle(
                    style = SpanStyle(
                        color = darkGreen
                    )
                ) {
                    append(signUpText)
                }
            },
            modifier = Modifier
                .clickable {
                           navigator.navigate(RegisterScreenDestination)
                },
            color = Color.DarkGray,
        )

    }

}


