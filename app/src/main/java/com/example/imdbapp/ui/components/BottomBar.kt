package com.example.imdbapp.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imdbapp.R
import com.example.imdbapp.ui.components.text.Regular

@Composable
fun BottomBar(modifier: Modifier) {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(
        elevation = 10.dp,
        backgroundColor = colorResource(id = R.color.main_color)
    ) {
        BottomNavigationItem(
            icon = {
                if (selectedIndex.value == 0) {
                    Icon(painter = painterResource(id = R.drawable.icon_home), "")
                } else {
                    Icon(painter = painterResource(id = R.drawable.icon_home_light), "")
                }
            },
            label = {
                if (selectedIndex.value == 0) {
                    Regular(
                        modifier = modifier,
                        color = colorResource(id = R.color.black),
                        text = stringResource(id = R.string.inicio),
                        textUnit = 14.sp
                    )
                } else {
                    Regular(
                        modifier = modifier,
                        color = colorResource(id = R.color.black_op),
                        text = stringResource(id = R.string.inicio),
                        textUnit = 14.sp
                    )
                }
            },
            selected = (selectedIndex.value == 0),
            onClick = {
                selectedIndex.value = 0
            })

        BottomNavigationItem(
            icon = {
                if (selectedIndex.value == 1) {
                    Icon(painter = painterResource(id = R.drawable.icon_search), "")
                } else {
                    Icon(painter = painterResource(id = R.drawable.icon_search_light), "")
                }
            },
            label = {
                if (selectedIndex.value == 1) {
                    Regular(
                        modifier = modifier,
                        color = colorResource(id = R.color.black),
                        text = stringResource(id = R.string.buscar),
                        textUnit = 14.sp
                    )
                } else {
                    Regular(
                        modifier = modifier,
                        color = colorResource(id = R.color.black_op),
                        text = stringResource(id = R.string.buscar),
                        textUnit = 14.sp
                    )
                }
            },
            selected = (selectedIndex.value == 1),
            onClick = {
                selectedIndex.value = 1
            })

        BottomNavigationItem(
            icon = {
                if (selectedIndex.value == 2) {
                    Icon(painter = painterResource(id = R.drawable.icon_play_light), "")
                } else {
                    Icon(painter = painterResource(id = R.drawable.icon_play_light), "")
                }
            },
            label = {
                if (selectedIndex.value == 2) {
                    Regular(
                        modifier = modifier,
                        color = colorResource(id = R.color.black),
                        text = stringResource(id = R.string.play),
                        textUnit = 14.sp
                    )
                } else {
                    Regular(
                        modifier = modifier,
                        color = colorResource(id = R.color.black_op),
                        text = stringResource(id = R.string.play),
                        textUnit = 14.sp
                    )
                }
            },
            selected = (selectedIndex.value == 2),
            onClick = {
                selectedIndex.value = 2
            })

        BottomNavigationItem(
            icon = {
                if (selectedIndex.value == 3) {
                    Icon(painter = painterResource(id = R.drawable.icon_user), "")
                } else {
                    Icon(painter = painterResource(id = R.drawable.icon_user_light), "")
                }
            },
            label = {
                if (selectedIndex.value == 3) {
                    Regular(
                        modifier = modifier,
                        color = colorResource(id = R.color.black),
                        text = stringResource(id = R.string.usuario),
                        textUnit = 14.sp
                    )
                } else {
                    Regular(
                        modifier = modifier,
                        color = colorResource(id = R.color.black_op),
                        text = stringResource(id = R.string.usuario),
                        textUnit = 14.sp
                    )
                }
            },
            selected = (selectedIndex.value == 3),
            onClick = {
                selectedIndex.value = 3
            })
    }
}
