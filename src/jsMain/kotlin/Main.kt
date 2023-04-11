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
                    HeaderItem("ABOUT ME") {}
                    HeaderItem("SKILL") {}
                    HeaderItem("EXPERIENCE") {}
                    HeaderItem("PROJECTS") {}
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
                        ContainerHeader(title = "ABOUT ME")

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
                        ContainerHeader(title = "SKILLS")

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
                        ContainerHeader(title = "EXPERIENCE")
                        Spacer()

                        Div(attrs = { classes(PangMooStyleSheet.experienceTable) }) {
                            Div(attrs = { classes(PangMooStyleSheet.experienceColumn) }) {
                                ExperienceItem(
                                    date = "2021.09 ~ 2022.12",
                                    title = "아우토크립트 안드로이드 개발 팀장",
                                    description = "모빌리티 대여 서비스, 택시 승객/기사 서비스 등 다양한 애플리케이션을 개발하였습니다."
                                )

                                ExperienceItem(
                                    date = "2019.09 ~ 2021.09",
                                    title = "펜타시큐리티 안드로이드 개발",
                                    description = "AMO WALLET 및 사내 애플리케이션 개발을 담당하였습니다."
                                )

                                ExperienceItem(
                                    date = "2019. 03",
                                    title = "한국공학대학교 컴퓨터공학부 소프트웨어 전공",
                                    description = "한국공학대학교 컴퓨터공학부 소프트웨어 전공으로 1학년 2학기까지 재학 후 휴학 하였습니다."
                                )
                            }

                            Div(attrs = { classes(PangMooStyleSheet.experienceColumn) }) {
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

                ProjectSection {
                    ProjectContainer {
                        ContainerHeader(title = "PROJECTS")
                        Spacer()

                        Div(attrs = {
                            style {
                                display(DisplayStyle.Flex)
                                flexDirection(FlexDirection.Column)
                                marginLeft(20.px)
                                marginRight(20.px)
                            }
                        }) {
                            ProjectItem(
                                type = "AOS",
                                name = "충전국밥",
                                role = "메인 개발",
                                date = "2021-2022",
                                description = "주변 전기차 충전기 위치와 요금, 충전기 종류 등 상세 정보를 제공합니다.\n또한 충전카드를 앱에 태깅하여 등록하면 충전국밥 앱을 통해 결제가 가능합니다."
                            )

                            ProjectItem(
                                type = "AOS",
                                name = "GreeGo",
                                role = "메인 개발",
                                date = "2021-2022",
                                description = "제주도에서 진행하는 사업으로, 퍼스널 모빌리티(전기 자전거, 전동 킥보드, 전기 오토바이, 공공자전거)를 대여할 수 있으며 주변 관광지 및 실시간 버스 위치, 맞춤형 길 안내 등 확인할 수 있습니다."
                            )

                            ProjectItem(
                                type = "AOS",
                                name = "아이맘택시 - 은평구 바우처택시",
                                role = "유지보수",
                                date = "2022",
                                description = "임산부와 영유아 가정을 위해 은평구청에서 진행되는 택시 서비스로, 승객은 배차를 요청할 수 있으며 기사의 운행 상태 및 위치를 실시간으로 확인할 수 있습니다."
                            )

                            ProjectItem(
                                type = "AOS",
                                name = "아이맘택시(기사용)",
                                role = "메인 개발",
                                date = "2021-2022",
                                description = "임산부와 영유아 가정을 위해 은평구청에서 진행되는 택시 서비스로, 기사의 출퇴근 및 탑승/하차 등의 운행 상태를 기록합니다. 모든 상태는 지속적으로 공유되기에 승객앱에서 기사의 위치를 실시간으로 확인할 수 있습니다."
                            )

                            ProjectItem(
                                type = "AOS",
                                name = "케이콜(기사님용)",
                                role = "서브 개발",
                                date = "2021-2022",
                                description = "케이콜 기사님을 위한 앱으로, 배차 요청 시 콜을 표시하며 기사는 수락/거절할 수 있습니다. 또한 출발지와 목적지 및 기사의 위치를 앱 내 지도를 통해 실시간으로 확인할 수 있습니다."
                            )

                            ProjectItem(
                                type = "AOS",
                                name = "버스닷",
                                role = "메인 개발",
                                date = "2021-2022",
                                description = "여의도에서 운행되고 있는 아우토크립트 직원을 위한 출퇴근 버스 승객용 앱 입니다."
                            )

                            ProjectItem(
                                type = "AOS",
                                name = "버스닷(기사용)",
                                role = "서브 개발",
                                date = "2021-2022",
                                description = "여의도에서 운행되고 있는 아우토크립트 직원을 위한 출퇴근 버스 기사용 앱 입니다."
                            )

                            ProjectItem(
                                type = "AOS",
                                name = "세이브 마스크",
                                role = "디자인 제외 1인 개발",
                                date = "2021",
                                description = "의료 분야 급상승 인기 앱 3위 달성한 공적마스크 모아보기 앱 입니다. 사용자가 구매할 수 있는 요일이 오면 알람으로 알려주며, 내 주변에 마스크를 보유한 약국을 편하게 확인 할 수 있습니다. 또한 주변에 물량 있는 마스크를 따로 모아보는 것을 제공합니다."
                            )

                            ProjectItem(
                                type = "VR",
                                name = "DRUNT",
                                role = "디자인 제외 1인 개발",
                                date = "2019",
                                description = "[ Drunt, Draw your own story ] 재미있게 그리고 느끼고 소통하는 VR 드로잉툴로 HTC VIVE사의 신기술인 SRWorks를 이용하여 혼합현실에서 드로잉을 할 수 있도록 구현하였습니다. 또한 드로잉한 작품을 obj로 추출 기능을 제공함으로써 3D 프린터 장벽을 낮추었습니다."
                            )

                            ProjectItem(
                                type = "AR/VR",
                                name = "VITEDS",
                                role = "디자인 제외 1인 개발",
                                date = "2019",
                                description = "VR/AR 쇼핑몰로 소비자는 VR/AR에서 가구를 배치하여 직접 인테리어를 할 수 있으며, 인테리어된 방은 클라우드로 동기화되어 실시간으로 VR에서 만든 방을 AR에서 확인할 수 있습니다. 또한 EYE TRACKING 기술을 통해 기업은 자사 제품이 얼마나 사용자들의 시선을 받았는지 통계를 제공합니다. 대회 우승으로 HTC VIVE 본사 초청 및 대만 United XR 행사장에서 부스를 전시하였습니다."
                            )

                            ProjectItem(
                                type = "AR",
                                name = "트레리티 - AR 길안내",
                                role = "디자인 제외 1인 개발",
                                date = "2018",
                                description = "SK Planet에서 주최하는 STA+C 2018 대회 최우수 수상 작품으로 AR 지도 길안내 서비스 입니다."
                            )

                            ProjectItem(
                                type = "Chatbot",
                                name = "경영시민",
                                role = "1인 개발",
                                date = "2017",
                                description = "2018년 기준, 전교생 90% 이상이 사용하는 평촌경영고등학교 챗봇으로, 오늘/내일/이달 날씨 및 급식과 학사 일정, 학사 공지 등을 제공합니다."
                            )

                            ProjectItem(
                                type = "GAME",
                                name = "음료수회사 경영하기 [타이쿤식 노가다 돈벌기게임]",
                                role = "1인 개발",
                                date = "2015",
                                description = "한국전쟁2030 개발 이후 해당 기획자님과 합작으로 기획 및 디자인을 제외 모든 부분을 혼자 개발하였습니다. 누적 다운로드 수 100,000회 이상 달성하였습니다."
                            )

                            ProjectItem(
                                type = "GAME",
                                name = "한국전쟁2030",
                                role = "1인 개발",
                                date = "2015",
                                description = "초등학교 시절 좋아하던 Flash 게임을 모바일로 만들고 싶어 직접 원 제작자와 미팅 및 계약하여 합작으로 기획 및 디자인을 제외 모든 부분을 혼자 개발하였습니다. 누적 다운로드 수 500,000회 이상 달성하였습니다."
                            )

                            ProjectItem(
                                type = "GAME",
                                name = "직업키우기2",
                                role = "1인 개발",
                                date = "2014",
                                description = "직업키우기의 후속작으로 기존 방치형 게임 스타일과 다르게 클릭커 스타일로 구현된 게임 입니다. 마찬가지로 Flash 게임의 모티브를 얻어 개발하였습니다. 누적 다운로드 수 100,000회 이상 달성하였습니다."
                            )

                            ProjectItem(
                                type = "GAME",
                                name = "직업키우기",
                                role = "1인 개발",
                                date = "2013",
                                description = "모바일 방치형 게임 장르가 알려지지 않은 시절, Flash 게임의 모티브를 얻어 중학교 1학년 때 플레이스토어에 업로드한 게임 입니다. 이때 최초로 '키우기' 라는 타이틀을 사용하였으며, 누적 다운로드 수 100,000회 이상 달성하였습니다."
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ProjectItem(type: String, name: String, role: String, date: String, description: String) {
    Div(attrs = {
        style {
            flex(1)
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
        }
    }) {
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Row)

                paddingTop(16.px)
                paddingBottom(16.px)
            }
        }) {
            Div(attrs = {
                style {
                    display(DisplayStyle.Flex)
                    flexDirection(FlexDirection.Column)
                }
            }) {
                Div(attrs = {
                    style {
                        display(DisplayStyle.Flex)
                        flexDirection(FlexDirection.Row)
                        alignItems(AlignItems.End)
                    }
                }) {
                    Span(attrs = {
                        style {
                            fontSize(20.px)
                            fontWeight(700)
                        }
                    }) {
                        Text("${type}. ${name}")
                    }

                    Span(attrs = {
                        style {
                            marginLeft(10.px)
                            fontSize(15.px)
                            color(Color.gray)
                        }
                    }) {
                        Text("${role}_${date}")
                    }
                }

                Span(attrs = {
                    style {
                        color(Color.darkgray)
                        marginTop(10.px)
                    }
                }) {
                    Text(description)
                }
            }
        }
        Div(attrs = {
            style {
                width(100.percent)
                height(1.px)
                backgroundColor(Color.darkgray)
            }
        })
    }
}

@Composable
private fun Spacer(height: CSSNumeric = 60.px) {
    Div(attrs = {
        style {
            height(height)
        }
    })
}

@Composable
private fun ContainerHeader(title: String) {
    Div(attrs = {
        style {
            fontSize(30.px)
            fontWeight(900)
        }
    }) {
        Text(title)
    }
}

@Composable
private fun ExperienceItem(date: String, title: String, description: String) {
    Div(attrs = {
        style {
            height(10.cssRem)
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
            Text("PROJECTS")
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

@Composable
private fun ProjectSection(content: ContentBuilder<HTMLDivElement>) =
    Div({ classes(PangMooStyleSheet.projectSection) }, content = content)

@Composable
private fun ProjectContainer(content: ContentBuilder<HTMLDivElement>) =
    Div({ classes(PangMooStyleSheet.projectContainer) }, content = content)