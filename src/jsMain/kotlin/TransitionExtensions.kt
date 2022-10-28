import org.jetbrains.compose.web.css.StyleScope

fun StyleScope.transitionDuration(seconds: Float) = property("transition-duration", "${seconds}s")