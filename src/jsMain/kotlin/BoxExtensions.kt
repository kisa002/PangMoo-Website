import androidx.compose.runtime.ExperimentalComposeApi
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.CSSNumeric
import org.jetbrains.compose.web.css.StyleScope
import org.jetbrains.compose.web.css.px

fun StyleScope.boxShadow(value: String) = property("box-shadow", "inset 0 0em ${Colors.primary}")
@ExperimentalComposeApi
fun StyleScope.boxShadow(
    offsetX: CSSNumeric = 0.px,
    offsetY: CSSNumeric = 0.px,
    blurRadius: CSSNumeric = 0.px,
    color: CSSColorValue? = null,
    inset: Boolean = false
) =
    property(
        "box-shadow",
        (if (inset) "inset" else "") + "$offsetX $offsetY $blurRadius " + (color ?: "")
    )