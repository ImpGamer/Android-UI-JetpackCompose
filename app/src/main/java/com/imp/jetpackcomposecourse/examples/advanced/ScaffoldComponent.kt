package com.imp.jetpackcomposecourse.examples.advanced

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.imp.jetpackcomposecourse.ui.theme.BackGroundTopBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldComponent() {
    val snackbarHostState = remember {
        SnackbarHostState()
    }
    //Creacion de una corrutina
    val scope = rememberCoroutineScope()
    var openDialog by remember {
        mutableStateOf(false)
    }

    /*AlertDialogComponent(
        show = openDialog,
        title = "AlertDialog",
        dismissOnClick = {
            openDialog = false
        })*/

    CustomDialogComp(show = openDialog,
        title = "Custom")

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBarComponent(
                onActionClick = {
                    //openDialog = true
                },
                onActionCustomClick = {
                    openDialog = true
                }
            )
        },
        bottomBar = {
            BottomAppBarComponent()
        },
        floatingActionButton = {
            FabComponent(onClickFab = {
                //Invocacion de un hilo secundario para el llamado del snackBar
                scope.launch {
                    val result = snackbarHostState.showSnackbar(
                        message = "Clicked",
                        actionLabel = "Accepted",
                        withDismissAction = true,
                        duration = SnackbarDuration.Short
                    )
                    when(result) {
                        //Funcion cuando se le hace click a la X (cerrar)
                        SnackbarResult.Dismissed -> println("SnackBar cerrado")
                        //Funcion que se ejecuta cuando se presiona el "actionLabel"
                        SnackbarResult.ActionPerformed -> println("SnackBar aceptado")
                    }
                }
            })
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) {paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Text(text = "EDteam")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComponent(
    onActionClick:() -> Unit,
    onActionCustomClick:() -> Unit
) {
    TopAppBar(title = {
        Text(text = "Bienvenidos",
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.Monospace)
    },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = BackGroundTopBar,
            titleContentColor = Color.White
        ),
        navigationIcon = {
            Icon(imageVector = Icons.Filled.ArrowBack,
                tint = Color.White,
                contentDescription = "Arrow Back")
        },
        actions = {
            Row {
                IconButton(onClick = {onActionClick()}) {
                    Icon(imageVector = Icons.Filled.Share,
                        contentDescription = "Share",
                        tint = Color.White)
                }
                IconButton(onClick = {
                    onActionCustomClick()
                }) {
                    Icon(imageVector = Icons.Filled.Lock,
                        contentDescription = "Lock",
                        tint = Color.White)
                }
            }
        })
}

data class Item(
    val title:String,
    val selectedIcon:ImageVector,
    val unselectedIcon:ImageVector,
    val badgetCount:Int? = null,
    val hasNews:Boolean
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomAppBarComponent() {
    val items:List<Item> = listOf(
        Item(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            badgetCount = 2,
            hasNews = false
        ),
        Item(
            title = "Settings",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            hasNews = false
        ),
        Item(
            title = "Share",
            selectedIcon = Icons.Filled.Share,
            unselectedIcon = Icons.Outlined.Share,
            hasNews = true
        )
    )
    var navigationSelectedItem by remember {
        mutableStateOf(0)
    }

    BottomAppBar() {
        NavigationBar {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = navigationSelectedItem == index,
                    onClick = {
                              navigationSelectedItem = index;
                    },
                    icon = {
                        BadgedBox(badge = {
                            if(item.badgetCount != null) {
                                Badge {
                                    Text(text = item.badgetCount.toString())
                                }
                            } else if(item.hasNews) {
                                Badge()
                            }
                        }) {
                            Icon(
                                imageVector = if(navigationSelectedItem == index) {
                                    item.selectedIcon
                                } else {
                                    item.unselectedIcon
                                }, contentDescription = item.title)
                        }
                    },
                    label = {
                        Text(text = item.title,
                            fontSize = 14.sp,
                            color = Color.DarkGray)
                    })
            }
        }
    }
}

@Composable
fun FabComponent(
    onClickFab:()-> Unit
) {
    FloatingActionButton(
        onClick = {
                  onClickFab()
        },
        containerColor = BackGroundTopBar) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add",
            tint = Color.White)
    }
}

@Composable
fun AlertDialogComponent(show:Boolean,title: String,dismissOnClick:()->Unit) {
    if(show) {
        AlertDialog(
            onDismissRequest = { dismissOnClick() },
            confirmButton = {
                            Button(onClick = {
                                println("Aceptado!")
                                dismissOnClick()
                            }) {
                                Text(text = "Accept")
                            }
            },
            title = {
                Column {
                    Text(text = title)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "In middle")
                }
            },
            dismissButton = {
                Button(onClick = {
                    dismissOnClick()
                }) {
                    Text(text = "Dismiss")
                }
            })
    }
}

@Composable
fun CustomDialogComp(
    show:Boolean,
    title:String,
) {
    if(show) {
        Dialog(onDismissRequest = { /*TODO*/ },
        properties = DialogProperties(
            dismissOnBackPress = true, //Cerrar el popUp con el boton inferior "back" del celular
            dismissOnClickOutside = false //Cerrar el popUp si se presiona fuera de este
        )
        ) {
            //Composicion custom
            Column(modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(24.dp)) {
                Text(text = title)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "This is a dialog custom")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Footer from my dialog custom")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ScaffoldComponentPreview() {
    ScaffoldComponent()
}