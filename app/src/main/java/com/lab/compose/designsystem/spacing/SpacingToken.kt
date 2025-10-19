import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.intuit.sdp.R

object SpacingToken {
    val none: Dp @Composable get() = 0.dp  // no space
    val micro: Dp @Composable get() = dimensionResource(id = R.dimen._4sdp)    // 4  // very tight space
    val tiny: Dp @Composable get() = dimensionResource(id = R.dimen._8sdp)     // 8  // small space, text-to-text
    val extraSmall: Dp @Composable get() = dimensionResource(id = R.dimen._10sdp) // 10  // uncommon but slightly bigger than tiny
    val small: Dp @Composable get() = dimensionResource(id = R.dimen._12sdp)   // 12  // common compact spacing
    val medium: Dp @Composable get() = dimensionResource(id = R.dimen._16sdp)  // 16  // default body padding
    val large: Dp @Composable get() = dimensionResource(id = R.dimen._24sdp)   // 24  // section spacing
    val extraLarge: Dp @Composable get() = dimensionResource(id = R.dimen._32sdp) // 32  // screen-level spacing
    val huge: Dp @Composable get() = dimensionResource(id = R.dimen._48sdp)    // 48  // banners, dialogs, big gaps
}


// Apply same padding on all sides
fun Modifier.appPadding(all: Dp): Modifier =
    this.then(Modifier.padding(all))

// Apply symmetric horizontal + vertical padding
fun Modifier.appPaddingSymmetric(horizontal: Dp = 0.dp, vertical: Dp = 0.dp): Modifier =
    this.then(Modifier.padding(horizontal = horizontal, vertical = vertical))

// Apply only horizontal padding
fun Modifier.appPaddingHorizontal(horizontal: Dp): Modifier =
    this.then(Modifier.padding(horizontal = horizontal))

// Apply only vertical padding
fun Modifier.appPaddingVertical(vertical: Dp): Modifier =
    this.then(Modifier.padding(vertical = vertical))

// Apply padding individually (like "only" in Flutter)
fun Modifier.appPaddingOnly(
    start: Dp = 0.dp,
    top: Dp = 0.dp,
    end: Dp = 0.dp,
    bottom: Dp = 0.dp,
): Modifier = this.then(
    Modifier.padding(start = start, top = top, end = end, bottom = bottom)
)

@Composable
fun appHorizontalArrangement(space: Dp = SpacingToken.none) = Arrangement.spacedBy(space)

@Composable
fun appVerticalArrangement(space: Dp = SpacingToken.none) = Arrangement.spacedBy(space)
