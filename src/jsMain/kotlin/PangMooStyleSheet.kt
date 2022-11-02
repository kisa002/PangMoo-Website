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

    val sectionHome by style {
        height(100.vh)

        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        alignContent(AlignContent.Center)

        property("margin-left", "auto")
        property("margin-right", "auto")
    }

    val containerHome by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        justifyContent(JustifyContent.Center)

        maxWidth(600.px)
        padding(30.vh, 0.percent)

        media(mediaMaxWidth(1000.px)) {
            self style {
                padding(30.vh, 0.px)
            }
        }

        media(mediaMaxWidth(768.px)) {
            self style {
                padding(25.vh, 5.vw)
            }
        }
    }

    val homeTitle by style {
        fontSize(60.px)
        fontWeight(700)
        color(Color.white)
    }

    val homeDescription by style {
        fontSize(25.px)
        marginTop(20.px)
        color(Color.darkgray)
        fontWeight(200)
    }

    val homeActions by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        marginTop(40.px)
    }

    val home by style {
        width(100.percent)
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        marginLeft(250.px)

        media(mediaMaxWidth(768.px)) {
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

        transitionDuration(0.4f)

        color(Color.white)
//        padding(0.px, 15.vw)
//        maxWidth(1024.px)

        // 1366 1200 992 768 576

//        media(mediaMaxWidth(1700.px)) {
//            self style {
//                padding(0.px, 10.vw)
//            }
//        }
//        media(mediaMaxWidth(1500.px)) {
//            self style {
//                padding(0.px, 7.vw)
//            }
//        }

        media(mediaMinWidth(576.px)) {
            self style {
                maxWidth(540.px)
            }
        }
        media(mediaMinWidth(768.px)) {
            self style {
                maxWidth(720.px)
            }
        }
        media(mediaMinWidth(1000.px)) {
            self style {
                maxWidth(920.px)
            }
        }
        media(mediaMinWidth(1200.px)) {
            self style {
                maxWidth(960.px)
            }
        }
        media(mediaMinWidth(1366.px)) {
            self style {
                maxWidth(1080.px)
            }
        }
    }

    val aboutMeInfo by style {
        display(DisplayStyle.Flex)
        flexWrap(FlexWrap.Wrap)

        marginTop(40.px)
        alignSelf(AlignSelf.Center)
    }

    val aboutMeInfoItem by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)

        flex(0, 0, 33.percent)

        marginTop(20.px)

        padding(0.px, 25.px)
        boxSizing("border-box")

        transitionDuration(0.4f)

        media(mediaMaxWidth(1500.px)) {
            self style {
                flex(0, 0, 33.percent)
            }
        }

        media(mediaMaxWidth(1000.px)) {
            self style {
                flex(0, 0, 50.percent)
            }
        }

        media(mediaMaxWidth(764.px)) {
            self style {
                flex(0, 0, 100.percent)
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
        color(Color.gray)
        fontSize(16.px)
        fontWeight(300)
        marginTop(5.px)
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

        media(mediaMaxWidth(768.px)) {
            self style {
                padding(25.vh, 5.vw)
            }
        }
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