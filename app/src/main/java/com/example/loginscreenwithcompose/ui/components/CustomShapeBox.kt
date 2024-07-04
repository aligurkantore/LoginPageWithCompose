package com.example.loginscreenwithcompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomShapeBox(
    onClick: () -> Unit,
    isSelectedColor: Color,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        modifier = modifier
            .background(isSelectedColor, shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            content()
        }
    }
}
