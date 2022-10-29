import org.jetbrains.compose.web.css.*

object PangMooStyleSheet : StyleSheet() {
    val screen by style {
        width(100.vw)
        height(100.percent)

        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)

        fontFamily("Noto Sans KR", "sans-serif")
//                fontFamily("Happiness-Sans-Title")
    }

    val sectionMain by style {
        width(100.percent)
        height(100.vh)

        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        alignContent(AlignContent.Center)
    }

    val containerMain by style {
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
        fontSize(60.px)
        fontWeight(700)
        color(Color.white)
    }

    val mainDescription by style {
        fontSize(25.px)
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
        marginLeft(250.px)

        media(mediaMaxWidth(1000.px)) {
            self style {
                marginLeft(0.px)
            }
        }
    }

    val aboutMeSection by style {
        padding(10.vh, 0.vh)
        property("margin-left", "auto")
        property("margin-right", "auto")
    }

    val aboutMeContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)

        color(Color.white)
//        padding(0.px, 20.percent)

        maxWidth(1024.px)

        media(mediaMaxWidth(1000.px)) {
            self style {
                padding(0.px, 0.px)
            }
        }
    }

    val skillSection by style {
        padding(10.vh, 0.vh)
    }

    val skillContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)

        color(Color.white)
        padding(0.vh, 20.percent)

        media(mediaMaxWidth(1000.px)) {
            self style {
                padding(0.px, 0.px)
            }
        }
    }

    val aboutMeInfo by style {
        display(DisplayStyle.Flex)
        flexWrap(FlexWrap.Wrap)

        marginTop(40.px)

        maxWidth(1024.px)
        alignSelf(AlignSelf.Center)
    }

    val aboutMeInfoItem by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)

        flex(0, 0, 33.percent)

        marginTop(20.px)

        padding(0.px, 25.px)
        boxSizing("border-box")

        media(mediaMaxWidth(1500.px)) {
            self style {
                flex(0, 0, 33.percent)
            }
        }
    }

    val aboutMeInfoItemContainer by style {
        textAlign("center")
        border(width = (0.7).px, style = LineStyle.Solid, color = Color.gray)
        padding(40.px, 20.px)
    }

    val aboutMeInfoItemValue by style {
        fontSize(25.px)
        fontWeight(500)
    }

    val aboutMeInfoItemKey by style {
        fontSize(15.px)
        fontWeight(400)
        marginTop(5.px)
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