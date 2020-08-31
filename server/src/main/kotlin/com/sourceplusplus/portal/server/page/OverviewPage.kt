package com.sourceplusplus.portal.server.page

import kotlinx.html.*
import kotlinx.html.stream.appendHTML

@Suppress("unused")
class OverviewPage {
    fun renderPage(): String {
        return buildString {
            appendLine("<!DOCTYPE html>")
            appendHTML().html {
                head {
                    meta {
                        charset = "UTF-8"
                    }
                    title { + """Overview - Source++"""}
                    link {
                        rel = "stylesheet"
                        href = "semantic.min.css"
                    }
                    script {
                        src = "echarts.min.js"
                    }
                    script {
                        src = "jquery-3.5.1.min.js"
                    }
                    script {
                        src = "portal_theme.js"
                    }
                }
                body("overflow_y_hidden") {
                    div("ui sidebar vertical left menu overlay visible very thin icon spp_blue webkit_transition") {
                        style = "overflow: visible !important;"
                        div("ui accordion displaynone") {
                            div("openbtn_background_white") {
                                a(classes = "item openbtn") {
                                    + """Close menu"""
                                }
                            }
                            a(classes = "item active_tab") { + """Dashboard"""}
                            div("title item inactive_tab") {
                                i("dropdown icon") {
                                }
                                + """Traces"""
                            }
                            div("content") {
                                a(classes = "item sidebar_sub_text_color") {
                                    id = "sidebar_traces_link_latest"
                                    href = "traces"
                                    + """Latest"""
                                }
                                a(classes = "item sidebar_sub_text_color") {
                                    id = "sidebar_traces_link_slowest"
                                    href = "traces"
                                    + """Slowest"""
                                }
                                a(classes = "item sidebar_sub_text_color") {
                                    id = "sidebar_traces_link_failed"
                                    href = "traces"
                                    + """Failed"""
                                }
                            }
                            a(classes = "item inactive_tab") {
                                id = "sidebar_configuration_link"
                                href = "configuration"
                                + """Configuration"""
                            }
                        }
                        div("ui dropdown item openbtn") {
                            div("white_color") {
                                i("icon demo-icon content") {
                                }
                            }
                        }
                        a(classes = "ui dropdown item active_tab") {
                            i("icon demo-icon dashboard") {
                            }
                        }
                        div("ui dropdown item inactive_tab") {
                            unsafe {
                                +"""<z class="displaynone">Traces</z>"""
                            }
                            i("icon demo-icon code") {
                            }
                            div("menu secondary_background_color") {
                                a(classes = "item") {
                                    id = "traces_link_latest"
                                    href = "traces"
                                    span("menu_tooltip_text") { + """Latest"""}
                                }
                                a(classes = "item") {
                                    id = "traces_link_slowest"
                                    href = "traces"
                                    span("menu_tooltip_text") { + """Slowest"""}
                                }
                                a(classes = "item") {
                                    id = "traces_link_failed"
                                    href = "traces"
                                    span("menu_tooltip_text") { + """Failed"""}
                                }
                            }
                        }
                        a(classes = "ui item hide_on_toggle") {
                            id = "configuration_link"
                            href = "configuration"
                            i("icon configure inactive_tab") {
                            }
                        }
                    }
                    div("pusher") {
                        div("ui menu fixed asd marginlefting middle aligned content menu_style") {
                            div("ui sidebar horizontal top menu fixed overlay visible very thin icon background_color webkit_transition") {
                                style = "overflow: visible !important;"
                                div("marginlefting align_content_center") {
                                    div("ui icon top left pointing dropdown") {
                                        i("clock outline icon spp_red_color spp_font_margin") {
                                        }
                                        div("menu secondary_background_color no_top_margin") {
                                            div("item") {
                                                id = "last_5_minutes_time"
                                                onClick = "updateTime('last_5_minutes')"
                                                span("menu_tooltip_text") { + """LAST 5 MINUTES"""}
                                            }
                                            div("item") {
                                                id = "last_15_minutes_time"
                                                onClick = "updateTime('last_15_minutes')"
                                                span("menu_tooltip_active_text") { + """LAST 15 MINUTES"""}
                                            }
                                            div("item") {
                                                id = "last_30_minutes_time"
                                                onClick = "updateTime('last_30_minutes')"
                                                span("menu_tooltip_text") { + """LAST 30 MINUTES"""}
                                            }
                                            div("item") {
                                                id = "last_hour_time"
                                                onClick = "updateTime('last_hour')"
                                                span("menu_tooltip_text") { + """LAST HOUR"""}
                                            }
                                            div("item") {
                                                id = "last_3_hours_time"
                                                onClick = "updateTime('last_3_hours')"
                                                span("menu_tooltip_text") { + """LAST 3 HOURS"""}
                                            }
                                        }
                                    }
                                }
                                div("right menu align_content_center") {
                                    a {
                                        id = "current_page_external"
                                        href = "#"
                                        onClick = "clickedViewAsExternalPortal()"
                                        i("external link icon spp_red_color spp_font_margin") {
                                        }
                                    }
                                }
                            }
                        }
                        div("ui padded equal height grid background_color") {
                            style = "min-height: 100vh; margin-left: 60px !important"
                            div("twelve wide stretched column") {
                                div("ui equal height grid") {
                                    div("one column row padding_top_bottom") {
                                        div("column padding_left_right") {
                                            div {
                                                id = "overview_chart"
                                                style = "height: 100%;"
                                            }
                                        }
                                    }
                                }
                            }
                            div("four wide stretched column middle aligned") {
                                div("ui divided link items items_font") {
                                    div("item") {
                                        div("ui mini statistic") {
                                            onClick = "clickedViewAverageThroughputChart()"
                                            div("value align_left") {
                                                id = "card_throughput_average_header"
                                                + """n/a"""
                                            }
                                            div("label") {
                                                id = "card_throughput_average_header_label"
                                                + """AVG THROUGHPUT"""
                                            }
                                        }
                                    }
                                    div("item") {
                                        div("ui mini statistic") {
                                            onClick = "clickedViewAverageResponseTimeChart()"
                                            div("value spp_red_color align_left") {
                                                id = "card_responsetime_average_header"
                                                + """n/a"""
                                            }
                                            div("label spp_red_color") {
                                                id = "card_responsetime_average_header_label"
                                                + """AVG RESP TIME"""
                                            }
                                        }
                                    }
                                    div("item") {
                                        div("ui mini statistic") {
                                            onClick = "clickedViewAverageSLAChart()"
                                            div("value align_left") {
                                                id = "card_servicelevelagreement_average_header"
                                                + """n/a"""
                                            }
                                            div("label") {
                                                id = "card_servicelevelagreement_average_header_label"
                                                + """AVG SLA"""
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    script {
                        src = "semantic.min.js"
                    }
                    script {
                        src = "moment.min.js"
                    }
                    script {
                        src = "sockjs.min.js"
                    }
                    script {
                        src = "vertx-eventbus.min.js"
                    }
                    script {
                        src = "source_eventbus_bridge.js"
                    }
                    script {
                        src = "js/overview.js"
                    }
                    script {
                        src = "js/views/overview_view.js"
                    }
                }
            }
        }
    }

    // Temporary - for reference
    private val overviewHtml = """
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Overview - Source++</title>
            <link rel='stylesheet' href='semantic.min.css'>
            <script src="echarts.min.js"></script>
            <script src='jquery-3.5.1.min.js'></script>
            <script src='portal_theme.js'></script>
        </head>
        <body style="overflow-y: hidden">
        <div class="ui sidebar vertical left menu overlay visible very thin icon spp_blue"
             style="-webkit-transition-duration: 0.1s; overflow: visible !important;">
            <div class="ui accordion displaynone">
                <a class="item openbtn" style="background-color: white; height: 45px !important;">Close menu</a>
                <a class="item active_tab">Dashboard</a>

                <div class="title item inactive_tab">
                    <i class="dropdown icon"></i> Traces
                </div>
                <div class="content">
                    <a id="sidebar_traces_link_latest" class="item sidebar_sub_text_color" href="traces">Latest</a>
                    <a id="sidebar_traces_link_slowest" class="item sidebar_sub_text_color" href="traces">Slowest</a>
                    <a id="sidebar_traces_link_failed" class="item sidebar_sub_text_color" href="traces">Failed</a>
                </div>
                <a id="sidebar_configuration_link" class="item inactive_tab" href="configuration">Configuration</a>
            </div>
            <div class="ui dropdown item openbtn" style="color: white">
                <i class="icon demo-icon content"></i>
            </div>
            <a class="ui dropdown item active_tab"><i class="icon demo-icon dashboard"></i></a>
            <div class="ui dropdown item inactive_tab">
                <z class="displaynone">Traces</z>
                <i class="icon demo-icon code"></i>

                <div class="menu secondary_background_color">
                    <a id="traces_link_latest" class="item" href="traces">
                        <span class="menu_tooltip_text">Latest</span>
                    </a>
                    <a id="traces_link_slowest" class="item" href="traces">
                        <span class="menu_tooltip_text">Slowest</span>
                    </a>
                    <a id="traces_link_failed" class="item" href="traces">
                        <span class="menu_tooltip_text">Failed</span>
                    </a>
                </div>
            </div>
            <a id="configuration_link" class="ui item hide_on_toggle" href="configuration">
                <i class="icon configure inactive_tab"></i>
            </a>
        </div>
        <div class="pusher">
            <div class="ui menu fixed asd marginlefting middle aligned content"
                 style="border-radius: 0!important; border: 0; margin-left: 260px; -webkit-transition-duration: 0.1s; align-content: center;">
                <div class="ui sidebar horizontal top menu fixed overlay visible very thin icon background_color"
                     style="-webkit-transition-duration: 0.1s; overflow: visible !important;">
                    <div class="marginlefting" style="height: 45px; line-height: 45px; align-content:center;">
                        <div class="ui icon top left pointing dropdown">
                            <i class="clock outline icon spp_red_color" style="font-size: 20px; margin-top: -2px"></i>
                            <div class="menu secondary_background_color" style="margin-top: 0 !important;">
                                <div id="last_5_minutes_time" onClick="updateTime('last_5_minutes')" class="item">
                                    <span class="menu_tooltip_text">LAST 5 MINUTES</span>
                                </div>
                                <div id="last_15_minutes_time" onClick="updateTime('last_15_minutes')" class="item">
                                    <span class="menu_tooltip_active_text">LAST 15 MINUTES</span>
                                </div>
                                <div id="last_30_minutes_time" onClick="updateTime('last_30_minutes')" class="item">
                                    <span class="menu_tooltip_text">LAST 30 MINUTES</span>
                                </div>
                                <div id="last_hour_time" onClick="updateTime('last_hour')" class="item">
                                    <span class="menu_tooltip_text">LAST HOUR</span>
                                </div>
                                <div id="last_3_hours_time" onClick="updateTime('last_3_hours')" class="item">
                                    <span class="menu_tooltip_text">LAST 3 HOURS</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="right menu" style="height: 45px; line-height: 45px; align-content:center;">
                        <a id="current_page_external" href="#" onClick="clickedViewAsExternalPortal()">
                            <i class="external link icon spp_red_color" style="font-size: 20px; margin-top: -2px"></i>
                        </a>
                    </div>
                </div>
            </div>
            <div class="ui padded equal height grid background_color" style="min-height: 100vh; margin-left: 60px !important">
                <div class="twelve wide stretched column">
                    <div class="ui equal height grid">
                        <div class="one column row" style="padding-top: 7px; padding-bottom: 0">
                            <div class="column" style="padding-left: 0; padding-right: 0">
                                <div id="overview_chart" style="height: 100%;"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="four wide stretched column middle aligned">
                    <div class="ui divided link items" style="font-size: 10px">
                        <div class="item">
                            <div class="ui mini statistic" onClick="clickedViewAverageThroughputChart()">
                                <div id="card_throughput_average_header" class="value" style="text-align: left">
                                    n/a
                                </div>
                                <div id="card_throughput_average_header_label" class="label">
                                    AVG THROUGHPUT
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="ui mini statistic" onClick="clickedViewAverageResponseTimeChart()">
                                <div id="card_responsetime_average_header" class="value spp_red_color" style="text-align: left">
                                    n/a
                                </div>
                                <div id="card_responsetime_average_header_label" class="label spp_red_color">
                                    AVG RESP TIME
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="ui mini statistic" onClick="clickedViewAverageSLAChart()">
                                <div id="card_servicelevelagreement_average_header" class="value" style="text-align: left">
                                    n/a
                                </div>
                                <div id="card_servicelevelagreement_average_header_label" class="label">
                                    AVG SLA
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src='semantic.min.js'></script>
        <script src="moment.min.js"></script>
        <script src="sockjs.min.js"></script>
        <script src='vertx-eventbus.min.js'></script>
        <script src='source_eventbus_bridge.js'></script>
        <script src='js/overview.js'></script>
        <script src='js/views/overview_view.js'></script>
        </body>
        </html>
    """.trimIndent()
}