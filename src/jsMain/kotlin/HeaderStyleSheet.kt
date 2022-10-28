import org.jetbrains.compose.web.css.*

object HeaderStyleSheet : StyleSheet() {
    val header by style {
        width((6.5).vw)
        height(100.percent)

        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        position(Position.Fixed)

        padding(60.px, 90.px, 30.vw, 60.px)
        property("border-right", "1px solid #EFEFEF")

        media(mediaMaxWidth(1000.px)) {
            self style {
                display(DisplayStyle.None)
            }
        }
    }

    val profileImg by style {
        width(5.em + 1.vw)
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