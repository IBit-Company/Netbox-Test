package ir.net_box.test.utils

import androidx.compose.ui.Modifier

fun Modifier.ifElse(
    condition: Boolean,
    ifTrueModifier: Modifier,
    elseModifier: Modifier = Modifier,
): Modifier = then(if (condition) ifTrueModifier else elseModifier)
