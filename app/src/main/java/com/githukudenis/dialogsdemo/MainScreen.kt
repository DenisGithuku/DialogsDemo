package com.githukudenis.dialogsdemo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun MainScreen() {

    val viewModel: MainViewModel = viewModel()
    val state = viewModel.state

    if (state.value.isDialogVisible) {


        val properties = DialogProperties()
        Dialog(properties = properties, onDismissRequest = {}) {
            Column() {
                //mentorlst logo

                //title
                
                //description
                
                //green circle

                //login button
            }
        }

        AlertDialog(
            title = {
                Text(
                    text = "Account created successfully",
                    style = MaterialTheme.typography.titleMedium
                )
            },
            text = {
                Text(
                    text = "Your account has been created. You can proceed to login.",
                    style = MaterialTheme.typography.bodyMedium
                )
            },
            shape = MaterialTheme.shapes.large,
            onDismissRequest = {
                // sending an action
                viewModel.toggleDialog(
                    false
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {}
                ) {
                    Text(text = "Okay")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    // sending an action
                    viewModel.toggleDialog(
                       false
                    )
                }) {
                    Text(text = "Cancel")
                }
            }
        )
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