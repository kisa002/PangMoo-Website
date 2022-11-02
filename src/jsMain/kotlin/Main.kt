import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.Window
import org.w3c.dom.events.Event
import org.w3c.dom.events.EventListener

fun main() {
//    val innerWidth = callbackFlow<Int> {
//        val callback = object : EventListener {
//            override fun handleEvent(event: Event) {
//                trySend((event.target as? Window)?.innerWidth ?: 0)
//            }
//        }
//        window.addEventListener(type = "resize", callback = callback)
//
//        awaitClose {
//            window.removeEventListener(type = "resize", callback = callback)
//        }
//    }

    renderComposable(rootElementId = "root") {
        val innerWidth = produceState(window.innerWidth) {
            val callback = object : EventListener {
                override fun handleEvent(event: Event) {
                    value = (event.target as? Window)?.innerWidth ?: 0
                }
            }
            window.addEventListener(type = "resize", callback = callback)

            awaitDispose {
                window.removeEventListener(type = "resize", callback = callback)
            }
        }

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

            Main({ classes(PangMooStyleSheet.home) }) {
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
                                fontSize(30.px)
                                fontWeight(900)
                            }
                        }) {
                            Text("ABOUT ME - ${innerWidth.value}")
                        }

                        Div(attrs = {
                            classes(PangMooStyleSheet.aboutMeInfo)
                        }) {
                            // TODO 모바일인 경우 내용이 많으니 필터링 버튼 넣기
                            AboutMeInfoItem(title = "유광무", description = "이름")
                            AboutMeInfoItem(title = "00년생", description = "나이")
                            AboutMeInfoItem(title = "ENFJ", description = "MBTI")
                            AboutMeInfoItem(title = "아우토크립트", description = "회사")
                            AboutMeInfoItem(title = "한국공학대학교", description = "학교")
                            AboutMeInfoItem(title = "NULL", description = "여자친구")
                            AboutMeInfoItem(title = "Android", description = "주력 플랫폼")
                            AboutMeInfoItem(title = "KMM & KMP", description = "최근 관심 기술")
                            AboutMeInfoItem(title = "20+회", description = "해커톤 참여 횟수")
                        }
                    }
                }

                SkillSection {
                    SkillContainer {
                        Div(attrs = {
                            style {
                                fontSize(30.px)
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
            classes(PangMooStyleSheet.aboutMeInfoItemContainer)
        }) {
            I(attrs = {
                classes("fa-solid", "fa-cake-candles")
            })
            Div(attrs = {
                style {
                    classes(PangMooStyleSheet.aboutMeInfoItemValue)
                }
            }) {
                Text(title)
            }
            Div(attrs = {
                classes(PangMooStyleSheet.aboutMeInfoItemKey)
            }) {
                Text(description)
            }
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
    Div({ classes(PangMooStyleSheet.sectionHome) }, content = content)

@Composable
private fun HomeContainer(content: ContentBuilder<HTMLDivElement>) =
    Div({ classes(PangMooStyleSheet.containerHome) }, content = content)

@Composable
private fun HomeInfo() {
    Div({ classes(PangMooStyleSheet.homeTitle) }) {
        Text("반갑습니다.")
    }
    Div({ classes(PangMooStyleSheet.homeDescription) }) {
        Text("상상하는 것을 소프트웨어로 만들어내는 것을 좋아하는 팡무입니다. 세상에 선한 영향력으로 이롭게 발전시키기 위해 노력하고 있습니다.")
    }
}

@Composable
private fun HomeActions() {
    Div({ classes(PangMooStyleSheet.homeActions) }) {
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