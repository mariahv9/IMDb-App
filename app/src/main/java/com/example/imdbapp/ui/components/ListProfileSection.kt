package com.example.imdbapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.imdbapp.R
import com.example.imdbapp.ui.components.text.Bold

@Composable
fun CardListProfile(
    title: String
) {
    Box(
        modifier = Modifier
            .padding(start = 10.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .background(colorResource(id = R.color.white))
    ) {
        ListProfileSection(
            modifier = Modifier,
            text = title
        )
    }
}

@Composable
fun ListProfileSection(modifier: Modifier, text: String) {
    ConstraintLayout(
        modifier = modifier
            .padding(top = 15.dp, start = 35.dp, end = 35.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .height(50.dp)
    ) {
        val (title, arrow) = createRefs()

        Box(modifier
            .constrainAs(title) {}
        ) {
            Bold(
                modifier = modifier,
                color = colorResource(id = R.color.black),
                text = text,
                textUnit = 20.sp
            )
        }

        Image(
            modifier = Modifier
                .padding(top = 5.dp)
                .size(20.dp)
                .constrainAs(arrow) {
                    end.linkTo(parent.end)
                },
            painter = painterResource(id = R.drawable.icon_arrow_forward),
            contentDescription = "arrow"
        )
    }
    LineDivider(modifier = modifier.fillMaxWidth(), colorResource(id = R.color.light_gray))
}
