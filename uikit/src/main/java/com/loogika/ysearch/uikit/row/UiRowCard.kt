package com.loogika.ysearch.uikit.row

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.loogika.ysearch.core.R
import com.loogika.ysearch.uikit.text.UiTextRegular

@Composable
fun UiRowCard(
    modifier: Modifier = Modifier.fillMaxWidth(),
    colorTitle: Color = MaterialTheme.colorScheme.secondary,
    colorSubtitle: Color = MaterialTheme.colorScheme.secondary,
    styleTitle: TextStyle = MaterialTheme.typography.titleLarge,
    styleSubtitle: TextStyle = MaterialTheme.typography.bodySmall,
    title: String,
    description: String,
    @DrawableRes image: Int = R.drawable.ic_placeholder_image,
    onClick: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        UiTextRegular(
            modifier = Modifier
                .padding(start = 5.dp),
            color = colorTitle,
            style = styleTitle,
            text = title,
            maxLines = 2
        )

        Image(
            modifier = Modifier
                .padding(top = 10.dp)
                .width(160.dp),
            painter = painterResource(id = image),
            contentDescription = null
        )

        UiTextRegular(
            modifier = Modifier
                .padding(start = 5.dp, top =20.dp),
            color = colorSubtitle,
            style = styleSubtitle,
            text = description
        )
    }
}