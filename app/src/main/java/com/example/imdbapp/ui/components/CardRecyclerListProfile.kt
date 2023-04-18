package com.example.imdbapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imdbapp.R
import com.example.imdbapp.ui.components.text.Regular

@Composable
fun CardRecyclerListProfile(title: String, subtitle: String) {
    Card(
        backgroundColor = colorResource(id = R.color.white),
        elevation = 3.dp,
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .size(width = 170.dp, height = 160.dp)
            .padding(start = 20.dp)
    ) {
        Column {
            Card(
                shape = RoundedCornerShape(5.dp),
                backgroundColor = colorResource(id = R.color.light_gray),
                modifier = Modifier
                    .width(150.dp)
                    .height(105.dp)
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(5.dp)
                ) {
                    Regular(
                        modifier = Modifier,
                        color = colorResource(id = R.color.black),
                        text = title,
                        textUnit = 16.sp
                    )
                }
            }
            Regular(
                modifier = Modifier.padding(start = 8.dp, bottom = 5.dp),
                color = colorResource(id = R.color.black),
                text = subtitle,
                textUnit = 16.sp
            )

            Regular(
                modifier = Modifier.padding(start = 8.dp),
                color = colorResource(id = R.color.gray),
                text = "0",
                textUnit = 16.sp
            )
        }
    }
}
