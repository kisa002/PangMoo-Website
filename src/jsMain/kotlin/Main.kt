import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import org.w3c.dom.HTMLDivElement

fun main() {
    renderComposable(rootElementId = "root") {
        Style(PangMooStyleSheet)
        Style(HeaderStyleSheet)

        Div({ classes(PangMooStyleSheet.screen) }) {
            Header({ classes(HeaderStyleSheet.header) }) {
                Img(src = "./profile.jpeg", alt = "profile", attrs = { classes(HeaderStyleSheet.profileImg) })

                Div({ classes(HeaderStyleSheet.headerName) }) {
                    Text("PangMoo")
                }

                Ul({ classes(HeaderStyleSheet.headerList) }) {
                    HeaderItem("HOME") {}
                    HeaderItem("INTRODUCE") {}
                    HeaderItem("SKILL") {}
                    HeaderItem("EXPERIENCE") {}
                    HeaderItem("PROJECT") {}
                    HeaderItem("AWARD") {}
                    HeaderItem("ACTIVITY") {}
                    HeaderItem("CONTACT") {}
                }
            }

            Main({ classes(PangMooStyleSheet.main) }) {
                HomeSection {
                    HomeContainer {
                        HomeInfo()
                        HomeActions()
                    }
                }

                AboutMeSection {
                    AboutMeContainer {
                        Div(attrs = {
                            style {
                                fontSize((0.8).em)
                                fontWeight(900)
                            }
                        }) {
                            Text("ABOUT ME")
                        }

                        Div(attrs = {
                            classes(PangMooStyleSheet.aboutMeInfo)
                        }) {
                            AboutMeInfoItem(title = "유광무", description = "이름")
                            AboutMeInfoItem(title = "스물두살", description = "나이")
                            AboutMeInfoItem(title = "ENFJ", description = "MBTI")
                            AboutMeInfoItem(title = "한국공학대학교", description = "학교")
                            AboutMeInfoItem(title = "아우토크립트", description = "회사")
                            AboutMeInfoItem(title = "코틀린 멀티플랫폼", description = "흥미")
                        }
                    }
                }

                SkillSection {
                    SkillContainer {
                        Div(attrs = {
                            style {
                                fontSize((0.8).em)
                                fontWeight(900)
                            }
                        }) {
                            Text("SKILL")
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun AboutMeInfoItem(title: String, description: String) {
    Div(attrs = {
        classes(PangMooStyleSheet.aboutMeInfoItem)
    }) {
        Div(attrs = {
            style {
                fontSize((0.6).em)
                fontWeight(500)
            }
        }) {
            Text(title)
        }
        Div(attrs = {
            style {
                fontSize((0.45.em))
                fontWeight(400)
                marginTop(5.px)
            }
        }) {
            Text(description)
        }
    }
}

@Composable
private fun HeaderItem(text: String, onClick: () -> Unit) {
    Li({
        classes(HeaderStyleSheet.headerItem)

        onClick { onClick() }
    }) {
        Text(text)
    }
}

@Composable
private fun HomeSection(content: ContentBuilder<HTMLDivElement>) =
    Div({ classes(PangMooStyleSheet.sectionMain) }, content = content)

@Composable
private fun HomeContainer(content: ContentBuilder<HTMLDivElement>) =
    Div({ classes(PangMooStyleSheet.containerMain) }, content = content)

@Composable
private fun HomeInfo() {
    Div({ classes(PangMooStyleSheet.mainTitle) }) {
        Text("반갑습니다.")
    }
    Div({ classes(PangMooStyleSheet.mainDescription) }) {
        Text("상상하는 것을 소프트웨어로 만들어내는 것을 좋아하는 팡무입니다. 세상에 선한 영향력으로 이롭게 발전시키기 위해 노력하고 있습니다.")
    }
}

@Composable
private fun HomeActions() {
    Div({ classes(PangMooStyleSheet.mainActions) }) {
        Button({ classes(PangMooStyleSheet.button) }) {
            Text("ABOUT ME")
        }

        Button({
            classes(PangMooStyleSheet.outlineButton)
            style {
                marginLeft(20.px)
            }
        }) {
            Text("PROJECT")
        }
    }
}

@Composable
private fun AboutMeSection(content: ContentBuilder<HTMLDivElement>) =
    Div({ classes(PangMooStyleSheet.aboutMeSection) }, content = content)

@Composable
private fun AboutMeContainer(content: ContentBuilder<HTMLDivElement>) =
    Div({ classes(PangMooStyleSheet.aboutMeContainer) }, content = content)

@Composable
private fun SkillSection(content: ContentBuilder<HTMLDivElement>) =
    Div({ classes(PangMooStyleSheet.skillSection) }, content = content)

@Composable
private fun SkillContainer(content: ContentBuilder<HTMLDivElement>) =
    Div({ classes(PangMooStyleSheet.skillContainer) }, content = content)