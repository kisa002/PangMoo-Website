import org.jetbrains.compose.web.css.*

object PangMooStyleSheet : StyleSheet() {
    val screen by style {
        width(100.vw)
        height(100.percent)

        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)

        fontFamily("Noto Sans KR", "sans-serif")
//                fontFamily("Happiness-Sans-Title")

        fontSize(1.vw)


        media(mediaMaxWidth(1500.px)) {
            self style {
                fontSize((1.5).vw)
            }
        }

        media(mediaMaxWidth(1000.px)) {
            self style {
                fontSize((1.75.vw))
            }
        }

        media(mediaMaxWidth(700.px)) {
            self style {
                fontSize((2.vw))
            }
        }
    }

    val sectionMain by style {
        width(100.percent)
        height(100.vh)

        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        alignContent(AlignContent.Center)
    }

    val containerMain by style {
//        padding(30.vh, 40.percent)

//        width(60.percent)
        padding(30.vh, 30.percent)
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        justifyContent(JustifyContent.Center)

        media(mediaMaxWidth(1000.px)) {
            self style {
                padding(30.vh, 0.px)
            }
        }
    }

    val mainTitle by style {
        fontSize(4.em)
        fontWeight(700)
        color(Color.white)
    }

    val mainDescription by style {
        fontSize((1.1).em)
        marginTop(20.px)
        color(Color.darkgray)
        fontWeight(200)
    }

    val mainActions by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        marginTop(40.px)
    }

    val main by style {
        width(100.percent)
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        marginLeft((6.5).vw + 150.px)
//        marginRight((6.5).vw + 150.px)

        media(mediaMaxWidth(1000.px)) {
            self style {
                marginLeft(0.px)
                padding(20.vw)
            }
        }
    }

    val aboutMeSection by style {
        padding(10.vh, 0.vh)
    }

    val aboutMeContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)

        padding(0.vh, 20.percent)

        color(Color.white)
        fontSize(2.em)
    }

    val skillSection by style {
        padding(10.vh, 0.vh)
    }

    val skillContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)

        padding(0.vh, 20.percent)

        color(Color.white)
        fontSize(2.em)
    }

    val aboutMeInfo by style {
        display(DisplayStyle.Flex)
        flexWrap(FlexWrap.Wrap)

        marginTop(40.px)
    }

    val aboutMeInfoItem by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)

        flex(0, 0, (33).percent)

        padding(1.vw + 1.vh)
        boxSizing("border-box")
//        border(width = 1.px, style = LineStyle.Solid, color = Colors.primary)
    }

    val button by style {
        backgroundColor(Color.black)
        padding(15.px)

        color(Color.white)
        fontSize((0.8).em)
        fontWeight(700)

        border(width = 3.px, style = LineStyle.Solid, color = Colors.primary)

        transitionDuration(0.7f)
        property("box-shadow", "inset 0 5em ${Colors.primary}")

        hover(self) style {
            color(Colors.primary)
            boxShadow("inset 0 0em ${Colors.primary}")
        }
    }

    val outlineButton by style {
        padding(15.px)

        color(Color.white)
        fontSize((0.8).em)
        fontWeight(700)

        border(width = 3.px, style = LineStyle.Solid, color = Color.white)

        transitionDuration(0.7f)
        property("box-shadow", "inset 0 5em black")

        hover(self) style {
            color(Colors.primary)
            border(width = 3.px, style = LineStyle.Solid, color = Color.white)

            property("box-shadow", "inset 0 0 white")
        }
    }
}