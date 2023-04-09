package com.example.imdbapp.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.imdbapp.R
import com.example.imdbapp.bottomNavItems
import com.example.imdbapp.ui.components.text.Regular

@Composable
fun CustomBottomBar(navController: NavController) {
    var selectedItem by remember { mutableStateOf(0) }

    BottomNavigation(
        backgroundColor = colorResource(id = R.color.main_color)
    ) {
        bottomNavItems.forEachIndexed { index, item ->

            BottomNavigationItem(
                icon = {
                    if (selectedItem == item.index) {
                        Icon(painter = painterResource(id = item.icon_press), "")
                    } else {
                        Icon(painter = painterResource(id = item.icon_light), "")
                    }
                },
                label = {
                    if (selectedItem == item.index) {
                        Regular(
                            modifier = Modifier,
                            color = colorResource(id = R.color.black),
                            text = item.name,
                            textUnit = 14.sp
                        )
                    } else {
                        Regular(
                            modifier = Modifier,
                            color = colorResource(id = R.color.black_op),
                            text = item.name,
                            textUnit = 14.sp
                        )
                    }
                },
                selected = (selectedItem == index),
                onClick = {
                    selectedItem = index
                    navController.navigate(item.route)
                })
        }
    }
}
