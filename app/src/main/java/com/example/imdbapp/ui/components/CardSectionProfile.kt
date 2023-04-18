package com.example.imdbapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imdbapp.R
import com.example.imdbapp.ui.components.text.Bold
import com.example.imdbapp.ui.components.text.Regular

@Composable
fun CardSectionProfile(
    title: String,
    description: String,
    boolean: Boolean,
    button: String = ""
) {
    Box(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .background(colorResource(id = R.color.white))
    ) {
        Column(
            modifier = Modifier.padding(
                top = 10.dp,
                start = 15.dp,
                end = 35.dp,
                bottom = 15.dp
            )
        ) {
            Row {
                Image(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .size(30.dp),
                    painter = painterResource(id = R.drawable.yellow_line),
                    contentDescription = "Divider"
                )
                Bold(
                    modifier = Modifier.padding(start = 3.dp, top = 2.dp),
                    color = colorResource(id = R.color.black),
                    text = title,
                    textUnit = 25.sp
                )
            }
            Regular(
                modifier = Modifier.padding(top = 5.dp, start = 20.dp),
                color = colorResource(id = R.color.black),
                text = description,
                textUnit = 18.sp
            )
            if (boolean) {
                Button(
                    onClick = { },
                    modifier = Modifier
                        .padding(top = 20.dp, start = 20.dp)
                        .fillMaxWidth()
                        .height(65.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.yellow),
                        contentColor = colorResource(id = R.color.dark_gray),
                        disabledBackgroundColor = colorResource(id = R.color.yellow)
                    ),
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Medium(
                        modifier = Modifier,
                        color = colorResource(id = R.color.dark_gray),
                        text = button,
                        textUnit = 18.sp
                    )
                }
            }
        }
    }
}
