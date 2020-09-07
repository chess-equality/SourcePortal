package com.sourceplusplus.portal.server.template

import kotlinx.html.*

fun FlowContent.areaChart(classes: String = "ui padded equal height grid background_color", block: FlowContent.() -> Unit) {
    div(classes) {
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