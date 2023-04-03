package com.loogika.ysearch.uikit.row

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.loogika.ysearch.uikit.text.UiTextRegular
import com.loogika.ysearch.core.R

@Composable
fun UiRow(
    modifier: Modifier = Modifier.fillMaxWidth(),
    colorTitle: Color = MaterialTheme.colorScheme.secondary,
    colorSubtitle: Color = MaterialTheme.colorScheme.secondary,
    styleTitle: TextStyle = MaterialTheme.typography.titleMedium,
    styleSubtitle: TextStyle = MaterialTheme.typography.bodySmall,
    title: String,
    subTitle: String,
    @DrawableRes icon: Int = R.drawable.ic_placeholder_image,
    onClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
        .clickable { onClick() })
    {
        Image(
            modifier = Modifier
                .size(80.dp),
            painter = painterResource(id = icon),
            contentDescription = null
        )

        Column(
            modifier = Modifier.padding(start = 10.dp)
        ) {
            UiTextRegular(
                modifier = Modifier
                    .padding(start = 5.dp),
                color = colorTitle,
                style = styleTitle,
                text = title,
                maxLines = 2
            )

            UiTextRegular(
                modifier = Modifier
                    .padding(start = 5.dp),
                color = colorSubtitle,
                style = styleSubtitle,
                text = subTitle
            )
        }
    }
}