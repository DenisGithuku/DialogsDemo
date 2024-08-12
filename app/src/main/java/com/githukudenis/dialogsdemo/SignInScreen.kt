package com.githukudenis.dialogsdemo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun SignInScreen(
    validationCode: String
) {

    val viewModel: SignInViewModel = viewModel()
    val state = viewModel.state

    LaunchedEffect(Unit) {
        if (validationCode.isNotEmpty()) {
            viewModel.toggleDialog(true)
        }
    }

    if (state.value.isDialogVisible) {
        val properties = DialogProperties()
        Dialog(properties = properties, onDismissRequest = { viewModel.toggleDialog(false) }) {
            Surface(
                modifier = Modifier.fillMaxWidth(0.8f)
                .clip(MaterialTheme.shapes.medium),) {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    //mentorlst logo
                    Image(
                        painter = painterResource(R.drawable.sample_logo),
                        contentDescription = "Sample logo",
                        modifier = Modifier.size(40.dp)
                    )

                    //title
                    Text(
                        text = "Account created successfully",
                        style = MaterialTheme.typography.displaySmall,
                        textAlign = TextAlign.Center
                    )

                    //description
                    Text(
                        text = "Your account has been created. You can proceed to login.",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )

                    //green circle
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color.Green)
                    )

                    //login button
                    Button(
                        onClick = { viewModel.toggleDialog(false) },
                        modifier = Modifier.fillMaxWidth(),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Text("LOGIN")
                    }
                }
            }
        }

//        AlertDialog(
//            title = {
//                Text(
//                    text = "Account created successfully",
//                    style = MaterialTheme.typography.titleMedium
//                )
//            },
//            text = {
//                Text(
//                    text = "Your account has been created. You can proceed to login.",
//                    style = MaterialTheme.typography.bodyMedium
//                )
//            },
//            shape = MaterialTheme.shapes.large,
//            onDismissRequest = {
//                // sending an action
//                viewModel.toggleDialog(
//                    false
//                )
//            },
//            confirmButton = {
//                TextButton(
//                    onClick = {}
//                ) {
//                    Text(text = "Okay")
//                }
//            },
//            dismissButton = {
//                TextButton(onClick = {
//                    // sending an action
//                    viewModel.toggleDialog(
//                       false
//                    )
//                }) {
//                    Text(text = "Cancel")
//                }
//            }
//        )
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = if (state.value.isDialogVisible) "Hide Dialog" else "Show Dialog",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                // sending an action
                viewModel.toggleDialog(
                    !state.value.isDialogVisible
                )
            }
        ) {
            Text(
                text = "Toggle dialog",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }

}