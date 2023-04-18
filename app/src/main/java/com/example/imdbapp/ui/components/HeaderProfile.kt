package com.example.imdbapp.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.imdbapp.R
import com.example.imdbapp.viewmodel.LoginViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun HeaderProfile(modifier: Modifier, loginViewModel: LoginViewModel) {

    ConstraintLayout(
        modifier = modifier
            .padding(top = 15.dp, start = 35.dp, end = 35.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .height(50.dp)
    ) {
        val (profile, name, settings) = createRefs()

        Box(modifier
            .constrainAs(profile) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }
        ) {
            Image(
                modifier = modifier
                    .clip(CircleShape)
                    .size(40.dp),
                painter = painterResource(id = R.drawable.profile_pic),
                contentDescription = "Perfil",
            )
        }

        Medium(
            modifier = modifier
                .padding(start = 50.dp, top = 8.dp)
                .constrainAs(name) {
                    start.linkTo(profile.end)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                },
            color = colorResource(id = R.color.dark_text),
            text = loginViewModel.userState.value.name,
            textUnit = 20.sp
        )

        Image(
            modifier = Modifier
                .padding(top = 5.dp)
                .size(30.dp)
                .constrainAs(settings) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                },
            painter = painterResource(id = R.drawable.icon_settings),
            contentDescription = "Configuracion"
        )
    }
}
