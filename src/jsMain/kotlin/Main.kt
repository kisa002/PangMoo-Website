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
                            Text("SKILLS")
                        }

                        SkillItemContainer {
                            SkillItem(name = "Android", percent = 85)
                            SkillItem(name = "Unity", percent = 70)
                            SkillItem(name = "Communication", percent = 75)
                            SkillItem(name = "PHP", percent = 65)
                        }
                    }
                }

                ExperienceSection {
                    ExperienceContainer {
                        Div(attrs = {
                            style {
                                fontSize(30.px)
                                fontWeight(900)
                            }
                        }) {
                            Text("EXPERIENCE")
                        }

                        Div(attrs = {
                            style {
                                height(60.px)
                            }
                        })

                        Div(attrs = {
                            style {
                                display(DisplayStyle.Flex)
                                flexDirection(FlexDirection.Row)
                                justifyContent(JustifyContent.SpaceBetween)

                                marginLeft(20.px)
                                marginRight(20.px)
                            }
                        }) {
                            Div(attrs = {
                                style {
                                    width(48.percent)
                                }
                            }) {
                                ExperienceItem(
                                    date = "2021.09 ~ 2022.12",
                                    title = "아우토크립트 안드로이드 개발 팀장",
                                    description = "안드로이드 개발 팀장으로 대부분의 프로젝트를 개발, 관리 하였습니다."
                                )

                                ExperienceItem(
                                    date = "2019.09 ~ 2021.09",
                                    title = "펜타시큐리티 안드로이드 메인 개발",
                                    description = "안드로이드 개발 팀장으로 대부분의 프로젝트를 개발, 관리 하였습니다."
                                )

                                ExperienceItem(
                                    date = "2019. 03",
                                    title = "한국공학대학교 컴퓨터공학부 소프트웨어 전공",
                                    description = "한국공학대학교 컴퓨터공학부 소프트웨어 전공으로 1학년 2학기까지 재학 후 휴학 하였습니다."
                                )
                            }

                            Div(attrs = {
                                style {
                                    width(48.percent)
                                }
                            }) {
                                ExperienceItem(
                                    date = "2022 ~",
                                    title = "GDG Songdo Organizer",
                                    description = "Google Developer Groups Songdo에서 Organizer로 활동하고 있습니다."
                                )
                                ExperienceItem(
                                    date = "2022 ~",
                                    title = "GDSC TUK Core Member",
                                    description = "Google Developer Student Clubs TUK에서 Core Member로 활동하고 있습니다."
                                )
                                ExperienceItem(
                                    date = "2015 ~",
                                    title = "한국 게임메이커 커뮤니티 운영진",
                                    description = "약 75,000명의 멤버가 있는 한국 게임메이커 커뮤니티 카페의 운영진으로 활동하고 있습니다."
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ExperienceItem(date: String, title: String, description: String) {
    Div(attrs = {
        style {
            height(10.cssRem)
//            marginBottom(50.px)
//            paddingRight(24.px)
        }
    }) {
        Div(attrs = {
            style {
                color(Color.darkgray)
                fontSize(14.px)
                fontWeight(400)
            }
        }) {
            Text(date)
        }

        Div(attrs = {
            style {
                marginTop(16.px)
            }
        }) {
            Div(attrs = {
                style {
                    fontSize(18.px)
                    fontWeight(700)
                }
            }) {
                Text(title)
            }

            Div(attrs = {
                style {
                    color(Color.gray)
                    fontSize(16.px)
                    marginTop(12.px)
                    fontWeight(300)
                }
            }) {
                Text(description)
            }
        }
    }
}

@Composable
private fun SkillItemContainer(content: ContentBuilder<HTMLDivElement>) =
    Div(attrs = { classes(PangMooStyleSheet.skillItemContainer) }, content = content)

@Composable
private fun SkillItem(name: String, percent: Int) {
    Div(attrs = { classes(PangMooStyleSheet.skillItem) }) {
        Div {
            Span {
                Text(name)
            }

            Span {
                Text("${percent}%")
            }
        }
        Div {
            Div(attrs = {
                style {
                    width(100.percent)
                    backgroundColor(Color.gray)

                    marginTop(15.px)
                }
            }) {
                Div(attrs = {
                    style {
                        width(percent.percent)
                        height(5.px)
                        backgroundColor(Colors.primary)
                    }
                })
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

@Composable
private fun ExperienceSection(content: ContentBuilder<HTMLDivElement>) =
    Div({ classes(PangMooStyleSheet.experienceSection) }, content = content)

@Composable
private fun ExperienceContainer(content: ContentBuilder<HTMLDivElement>) =
    Div({ classes(PangMooStyleSheet.experienceContainer) }, content = content)