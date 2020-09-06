package com.sourceplusplus.portal.server.template

import kotlinx.html.*

fun FlowContent.mainContent(classes: String = "pusher", block: DIV.() -> Unit) {
    div(classes) {
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
                                span("menu_tooltip_text") { +"""LAST 5 MINUTES""" }
                            }
                            div("item") {
                                id = "last_15_minutes_time"
                                onClick = "updateTime('last_15_minutes')"
                                span("menu_tooltip_active_text") { +"""LAST 15 MINUTES""" }
                            }
                            div("item") {
                                id = "last_30_minutes_time"
                                onClick = "updateTime('last_30_minutes')"
                                span("menu_tooltip_text") { +"""LAST 30 MINUTES""" }
                            }
                            div("item") {
                                id = "last_hour_time"
                                onClick = "updateTime('last_hour')"
                                span("menu_tooltip_text") { +"""LAST HOUR""" }
                            }
                            div("item") {
                                id = "last_3_hours_time"
                                onClick = "updateTime('last_3_hours')"
                                span("menu_tooltip_text") { +"""LAST 3 HOURS""" }
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
                            div("full_height") {
                                id = "overview_chart"
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
                                +"""n/a"""
                            }
                            div("label") {
                                id = "card_throughput_average_header_label"
                                +"""AVG THROUGHPUT"""
                            }
                        }
                    }
                    div("item") {
                        div("ui mini statistic") {
                            onClick = "clickedViewAverageResponseTimeChart()"
                            div("value spp_red_color align_left") {
                                id = "card_responsetime_average_header"
                                +"""n/a"""
                            }
                            div("label spp_red_color") {
                                id = "card_responsetime_average_header_label"
                                +"""AVG RESP TIME"""
                            }
                        }
                    }
                    div("item") {
                        div("ui mini statistic") {
                            onClick = "clickedViewAverageSLAChart()"
                            div("value align_left") {
                                id = "card_servicelevelagreement_average_header"
                                +"""n/a"""
                            }
                            div("label") {
                                id = "card_servicelevelagreement_average_header_label"
                                +"""AVG SLA"""
                            }
                        }
                    }
                }
            }
        }

        block()
    }
}