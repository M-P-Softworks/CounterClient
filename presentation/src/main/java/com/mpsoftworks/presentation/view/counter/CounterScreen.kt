package com.mpsoftworks.presentation.view.counter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mpsoftworks.presentation.model.CounterValue
import com.mpsoftworks.presentation.model.counter.CounterActions
import com.mpsoftworks.presentation.view.theme.AppTheme

@Composable
internal fun CounterScreen(
    navController: NavHostController
) {
    val viewModel: CounterScreenViewModel = hiltViewModel<CounterScreenViewModel>()

    val state = viewModel.counterScreenState.collectAsState()
    val onAction: (CounterActions) -> Unit = remember { { viewModel.onAction(it) } }

    if(state.value.canDecrease) {
        CounterScreenContent(
            value = state.value.counterValue,
            increaseAction = { onAction.invoke(CounterActions.IncreaseCounterPressed) }
        )
    } else {
        CounterScreenContent(
            value = state.value.counterValue,
            increaseAction = { onAction.invoke(CounterActions.IncreaseCounterPressed) },
            decreaseAction = { onAction.invoke(CounterActions.DecreaseCounterPressed) }
        )
    }
}

@Composable
private fun CounterScreenContent(
    modifier: Modifier = Modifier,
    value: CounterValue,
    increaseAction: () -> Unit,
    decreaseAction: (() -> Unit)? = null
) {
    ChangeValueButton(
        modifier = Modifier.fillMaxSize(),
        increaseClick = increaseAction,
        decreaseButton = decreaseAction
    )


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Counter(value = value)
        Spacer(modifier = Modifier.weight(3f))
    }
}

@Composable
private fun Counter(
    modifier: Modifier = Modifier,
    value: CounterValue
) {
    Text(
        modifier = modifier
            .padding(horizontal = AppTheme.dimensions.paddingM),
        text = value.value.toString(),
        textAlign = TextAlign.Center,
        style = AppTheme.typography.h2,
        maxLines = 1
    )
}

@Composable
private fun ChangeValueButton(
    modifier: Modifier = Modifier,
    increaseClick: () -> Unit,
    decreaseButton: (() -> Unit)? = null
) {
    Row(modifier = modifier) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .clickable(
                    enabled = true,
                    role = Role.Tab,
                    onClick = increaseClick,
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                )
        )
        if (decreaseButton != null) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable(
                        enabled = true,
                        role = Role.Tab,
                        onClick = decreaseButton,
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    )
            )
        }
    }
}

@Preview(
    device = Devices.AUTOMOTIVE_1024p,
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun HorizontalScreenPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        CounterScreenContent(
            modifier = Modifier.fillMaxSize(),
            value = constIntVal,
            increaseAction = {},
        )
    }
}

@Preview(
    device = Devices.AUTOMOTIVE_1024p,
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun HorizontalDecreaseScreenPreview() {
    Surface {
        CounterScreenContent(
            modifier = Modifier.fillMaxSize(),
            value = constIntVal,
            increaseAction = {},
            decreaseAction = {}
        )
    }
}

@Preview(
    device = Devices.AUTOMOTIVE_1024p,
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun HorizontalFloatScreenPreview() {
    Surface {
        CounterScreenContent(
            modifier = Modifier.fillMaxSize(),
            value = constIntVal,
            increaseAction = {},
        )
    }
}

@Preview(
    device = Devices.NEXUS_7,
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun VerticalScreenPreview() {
    Surface {
        CounterScreenContent(
            modifier = Modifier.fillMaxSize(),
            value = constIntVal,
            increaseAction = {},
        )
    }
}

@Preview(
    device = Devices.NEXUS_7,
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun VerticalDecreaseScreenPreview() {
    Surface {
        CounterScreenContent(
            modifier = Modifier.fillMaxSize(),
            value = constIntVal,
            increaseAction = {},
            decreaseAction = {}
        )
    }
}

@Preview(
    device = Devices.NEXUS_7,
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun VerticalFloatScreenPreview() {
    Surface {
        CounterScreenContent(
            modifier = Modifier.fillMaxSize(),
            value = constIntVal,
            increaseAction = {},
        )
    }
}

private val constIntVal = CounterValue(8762342)
private val constFloatVal = CounterValue(8742.655F)

