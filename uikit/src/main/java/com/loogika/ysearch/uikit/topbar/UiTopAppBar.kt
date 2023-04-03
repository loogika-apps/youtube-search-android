package com.loogika.ysearch.uikit.topbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.loogika.ysearch.uikit.text.UiTextHeadingSemiBoldSubTitle

@Composable
fun UiTopAppBar(
    title: String? = null,
    action: String? = null,
    showBackButton: Boolean = true,
    colorAction: Color = MaterialTheme.colorScheme.onBackground,
    icon: ImageVector = Icons.Filled.ArrowBack,
    actionListener: () -> Unit = {},
    onBackPressed: () -> Unit = {}
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, top = 16.dp, bottom = 16.dp)
    ) {
        val (backButton, actionTopAppBar) = createRefs()

        if (showBackButton) {
            IconButton(
                onClick = onBackPressed,
                modifier = Modifier
                    .constrainAs(backButton) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .size(30.dp)
            ) {
                Icon(
                    icon,
                    contentDescription = "backButton",
                    tint = colorAction
                )
            }
        }

        title?.let { titleText ->
            UiTextHeadingSemiBoldSubTitle(
                modifier = Modifier
                    .constrainAs(actionTopAppBar) {
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                    }
                    .clickable(
                        onClick = actionListener
                    )
                    .padding(end = 30.dp),
                text = titleText,
                color = colorAction
            )
        }

        action?.let { actionText ->
            UiTextHeadingSemiBoldSubTitle(
                modifier = Modifier
                    .constrainAs(actionTopAppBar) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                    }
                    .clickable(
                        onClick = actionListener
                    )
                    .padding(end = 30.dp),
                text = actionText,
                color = colorAction
            )
        }
    }
}