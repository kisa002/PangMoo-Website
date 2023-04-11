import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import kotlinx.browser.window
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
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
                            // TODO Filter

                            ProjectItem(
                                type = "Compose Web",
                                name = "PangMoo",
                                role = "1인 개발",
                                date = "2023~",
                                description = "이 사이트를 Compose Web을 활용하여 개발하였습니다. 완성 후 skiko로 리메이크 할 예정입니다.",
                                href = "/"
                            )

                            ProjectItem(
                                type = "Plugin",
                                name = "Naming Fox",
                                role = "1인 개발",
                                date = "2023",
                                description = "GPT-3를 활용하여 IntelliJ 계열 IDE에서 개발자의 최대 난제. 변수와 함수 이름을 지어주는 플러그인을 개발하였습니다. (Client/Server with Ktor)",
                                href = "https://github.com/kisa002/NamingFox"
                            )

                            ProjectItem(
                                type = "Kotlin Multiplatform",
                                name = "TRANSER",
                                role = "1인 개발",
                                date = "2023",
                                description = "AOS/Desktop을 지원하는 번역 유틸리티로 KMP의 이점을 살리기 위해 단순히 로직 공유만이 아닌 각 네이티브 기능을 활용에 초점을 두었습니다.",
                                href = "https://github.com/kisa002/Transer"
                            )

                            ProjectItem(
                                type = "AR",
                                name = "AURES",
                                role = "1인 개발",
                                date = "2022",
                                description = "한국공학대학교 캡스톤 디자인 1위 작품으로 AR 쇼핑몰입니다. AR Unity, WebSite Compose Web, Server PHP를 활용하였습니다.",
                                href = "https://www.youtube.com/watch?v=xfw-bDkxfCU"
                            )

                            ProjectItem(
                                type = "AOS",
                                name = "충전국밥",
                                role = "메인 개발",
                                date = "2021-2022",
                                description = "주변 전기차 충전기 위치와 요금, 충전기 종류 등 상세 정보를 제공합니다.\n또한 충전카드를 앱에 태깅하여 등록하면 충전국밥 앱을 통해 결제가 가능합니다.",
                                href = "https://charging.autocrypt.co.kr/"
                            )

                            ProjectItem(
                                type = "AOS",
                                name = "GreeGo",
                                role = "메인 개발",
                                date = "2021-2022",
                                description = "제주도에서 진행하는 사업으로, 퍼스널 모빌리티를 대여할 수 있으며 주변 관광지 및 실시간 버스 위치, 맞춤형 길 안내 등 확인할 수 있습니다.",
                                href = "https://play.google.com/store/apps/details?id=com.autocrypt.mi.scjeju&hl=ko&gl=US"
                            )

                            ProjectItem(
                                type = "AOS",
                                name = "아이맘택시",
                                role = "유지보수",
                                date = "2022",
                                description = "은평구청 정부사 업으로 운영되는 택시 서비스로, 택시 예약 및 기사의 운행 상태와 위치를 실시간으로 확인할 수 있습니다.",
                                href = "https://play.google.com/store/apps/details?id=com.autocrypt.mi.namu.pax&hl=ko&gl=US"
                            )

                            ProjectItem(
                                type = "AOS",
                                name = "아이맘택시(기사용)",
                                role = "메인 개발",
                                date = "2021-2022",
                                description = "은평구청 정부사 업으로 운영되는 택시 서비스로, 콜 수락/거부 및 기사의 위치/상태를 실시간으로 동기화합니다.",
                                href = "https://play.google.com/store/apps/details?id=com.autocrypt.mi.namu.dvr&hl=ko&gl=US"
                            )

                            ProjectItem(
                                type = "AOS",
                                name = "케이콜(기사님용)",
                                role = "서브 개발",
                                date = "2021-2022",
                                description = "케이콜 기사앱으로 실시간 콜 카드 수신할 수 있으며, 출발지와 목적지 경로를 안내합니다.",
                                href = "https://play.google.com/store/apps/details?id=com.autocrypt.mi.kcalldvr&hl=ko&gl=US"
                            )

                            ProjectItem(
                                type = "AOS",
                                name = "버스닷",
                                role = "메인 개발",
                                date = "2021-2022",
                                description = "여의도에서 운행되고 있는 아우토크립트 직원을 위한 출퇴근 버스 승객용 앱 입니다.",
                                href = "https://play.google.com/store/apps/details?id=com.autocrypt.mi.busdot.pax&hl=ko&gl=US"
                            )

                            ProjectItem(
                                type = "AOS",
                                name = "버스닷(기사용)",
                                role = "서브 개발",
                                date = "2021-2022",
                                description = "여의도에서 운행되고 있는 아우토크립트 직원을 위한 출퇴근 버스 기사용 앱 입니다.",
                                href = "https://play.google.com/store/apps/details?id=com.autocrypt.mi.busdot.dvr&hl=ko&gl=US"
                            )

                            ProjectItem(
                                type = "AOS",
                                name = "세이브 마스크",
                                role = "디자인 제외 1인 개발",
                                date = "2021",
                                description = "의료 분야 급상승 인기 앱 3위 달성한 공적마스크 모아보기 앱으로 구매 가능 요일에 알람 제공 및 주변 마스크 보유한 약국을 편하게 확인 할 수 있습니다.",
                                href = "https://play.google.com/store/apps/details?id=com.haeyum.savemask"
                            )

                            ProjectItem(
                                type = "GAME",
                                name = "Slash Hunter",
                                role = "디자인 제외 1인 개발",
                                date = "2020",
                                description = "스마일게이트 멤버십 11기에 참여하여 만든 2D 플랫포머 게임으로 캐릭터를 조작하여 몬스터를 잡으며 성장하는 게임입니다.",
                                href = "https://www.youtube.com/watch?v=d2vKvDNbdrE"
                            )

                            ProjectItem(
                                type = "VR",
                                name = "DRUNT",
                                role = "디자인 제외 1인 개발",
                                date = "2019",
                                description = "[ Drunt, Draw your own story ] 당신의 이야기를 그리는 VR 드로잉툴로 HTC VIVE사의 신기술인 SRWorks를 이용하여 혼합현실에서 드로잉을 할 수 있도록 구현하였습니다. 또한 드로잉한 작품을 obj로 추출 기능을 제공함으로써 3D 프린터 장벽을 낮추었습니다.",
                                href = "https://www.youtube.com/watch?v=1PbxeVkxfkk"
                            )

                            ProjectItem(
                                type = "AR/VR",
                                name = "VITEDS",
                                role = "디자인 제외 1인 개발",
                                date = "2019",
                                description = "VR/AR 쇼핑몰로 소비자는 VR/AR에서 가구를 배치하여 직접 인테리어 및 클라우드로 동기화되어 VR에서 만든 방을 실시간으로 AR에서 확인할 수 있습니다. 또한 EYE TRACKING 기술을 통해 기업은 자사 제품이 얼마나 사용자들의 시선을 받았는지 통계를 제공합니다. 대회 우승으로 HTC VIVE 본사 초청 및 대만 United XR 행사장에서 부스를 전시하였습니다.",
                                href = "https://www.youtube.com/watch?v=NEQlkGCJH44"
                            )

                            ProjectItem(
                                type = "AR",
                                name = "트레리티 - AR 길안내",
                                role = "디자인 제외 1인 개발",
                                date = "2018",
                                description = "SK Planet에서 주최하는 STA+C 2018 대회 최우수 수상 작품으로 AR 지도 길안내 서비스 입니다.",
                                href = "https://www.youtube.com/watch?v=Ljaa8M-oIaU"
                            )

                            ProjectItem(
                                type = "Chatbot",
                                name = "경영시민",
                                role = "1인 개발",
                                date = "2017",
                                description = "2018년 기준 전교생 90%(+900명) 이상이 사용하는 평촌경영고등학교 챗봇으로, 오늘/내일/이달 날씨 및 급식과 학사 일정, 학사 공지 등을 제공합니다.",
                                href = "https://www.youtube.com/watch?v=N7IlIhR3KCI"
                            )

                            ProjectItem(
                                type = "GAME",
                                name = "음료수회사 경영하기",
                                role = "1인 개발",
                                date = "2015",
                                description = "한국전쟁2030 개발 이후 해당 기획자님과 합작으로 기획 및 디자인을 제외 모든 부분을 혼자 개발하였습니다. 누적 다운로드 수 100,000회 이상 달성하였습니다.",
                                href = "https://m.apkpure.com/kr/%EC%9D%8C%EB%A3%8C%EC%88%98%ED%9A%8C%EC%82%AC-%EA%B2%BD%EC%98%81%ED%95%98%EA%B8%B0-%ED%83%80%EC%9D%B4%EC%BF%A4%EC%8B%9D-%EB%85%B8%EA%B0%80%EB%8B%A4-%EB%8F%88%EB%B2%8C%EA%B8%B0%EA%B2%8C%EC%9E%84/com.haeyum.Drinks_Company_Management"
                            )

                            ProjectItem(
                                type = "GAME",
                                name = "한국전쟁2030",
                                role = "1인 개발",
                                date = "2015",
                                description = "초등학교 시절 좋아하던 Flash 게임을 모바일로 만들고 싶어 직접 원 제작자와 미팅 및 계약하여 합작으로 기획 및 디자인을 제외 모든 부분을 혼자 개발하였습니다. 누적 다운로드 수 500,000회 이상 달성하였습니다.",
                                href = "https://play.google.com/store/apps/details?id=com.HAEYUM.Korea_War_2030"
                            )

                            ProjectItem(
                                type = "GAME",
                                name = "직업키우기2",
                                role = "1인 개발",
                                date = "2014",
                                description = "직업키우기의 후속작으로 기존 방치형 게임 스타일과 다르게 클릭커 스타일로 구현된 게임 입니다. 마찬가지로 Flash 게임의 모티브를 얻어 개발하였습니다. 누적 다운로드 수 100,000회 이상 달성하였습니다.",
                                href = "https://play.google.com/store/apps/details?id=com.Heyum.RaiseJob2"
                            )

                            ProjectItem(
                                type = "GAME",
                                name = "직업키우기",
                                role = "1인 개발",
                                date = "2013",
                                description = "모바일 방치형 게임 장르가 알려지지 않은 시절, Flash 게임의 모티브를 얻어 중학교 1학년 때 플레이스토어에 업로드한 게임 입니다. 이때 최초로 '키우기' 라는 타이틀을 사용하였으며 누적 다운로드 수 100,000회 이상 달성하였습니다.",
                                href = "https://m.apkpure.com/kr/%EC%83%88%EB%A1%9C%EC%9A%B4%EC%9E%A5%EB%A5%B4-%EC%A7%81%EC%97%85%ED%82%A4%EC%9A%B0%EA%B8%B01/com.ideasoft.RaiseJob_1"
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ProjectItem(type: String, name: String, role: String, date: String, description: String, href: String) {
    A(attrs = {
        classes(PangMooStyleSheet.projectItem)
        target(ATarget.Blank)
    }, href = href) {
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
                    width(100.percent)
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

                    I(attrs = {
                        classes("fa-solid", "fa-arrow-up-right-from-square")
                        style {
                            color(Color.lightslategray)
                            marginLeft(10.px)
                            paddingBottom(3.px)
                        }
                    })
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