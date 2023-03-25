package com.example.imdbapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.imdbapp.R

@Composable
fun HeaderProfile(modifier: Modifier) {
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
            text = "Juan Perez",
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