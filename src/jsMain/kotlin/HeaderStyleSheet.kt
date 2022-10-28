import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*

@OptIn(ExperimentalComposeWebApi::class)
object HeaderStyleSheet : StyleSheet() {
    val header by style {
        width(100.px)
        height(100.percent)

        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        position(Position.Fixed)

        padding(60.px, 90.px, 0.px, 60.px)
        property("border-right", "1px solid #EFEFEF")

        transitionDuration(0.5f)

        media(mediaMaxWidth(1000.px)) {
            self style {
                transform {
                    translateX((-260).px)
                }
            }
        }
    }

    val profileImg by style {
        width(100.px)
        alignSelf(AlignSelf.Center)
        borderRadius(50.percent)
    }

    val headerName by style {
        color(Color.white)
        fontSize(1.em)
        fontWeight(800)

        margin(10.px)
    }

    val headerList by style {
        padding(0.px)
        listStyle("none")
    }

    val headerItem by style {
        color(Color.white)
        fontSize((0.7).em)
        fontWeight(400)
        padding(10.px)
    }
}