package com.sourceplusplus.portal.server.template

import com.sourceplusplus.portal.server.model.ChartItemType
import com.sourceplusplus.portal.server.model.ChartItemType.*
import kotlinx.html.*

fun FlowContent.overviewContent(cssClasses: String = "pusher", block: FlowContent.() -> Unit) {
    div(cssClasses) {
        block()
    }
}

fun FlowContent.areaChart(vararg chartItemTypes: ChartItemType = arrayOf(), cssClasses: String = "ui padded equal height grid background_color") {
    div(cssClasses) {
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
                for (chartItemType in chartItemTypes) {
                    div("item") {
                        div("ui mini statistic") {
                            when (chartItemType) {
                                AVG_THROUGHPUT -> avgThroughput()
                                AVG_RESPONSE_TIME -> avgResponseTime()
                                else -> avgSLA()
                            }
                        }
                    }
                }
            }
        }
    }
}

fun DIV.avgThroughput() {
    onClick = "clickedViewAverageThroughputChart()"
    div("value align_left") {
        id = "card_throughput_average_header"
        +"n/a"
    }
    div("label align_left") {
        id = "card_throughput_average_header_label"
        +"AVG THROUGHPUT"
    }
}

fun DIV.avgResponseTime() {
    onClick = "clickedViewAverageResponseTimeChart()"
    div("value spp_red_color align_left") {
        id = "card_responsetime_average_header"
        +"n/a"
    }
    div("label align_left spp_red_color") {
        id = "card_responsetime_average_header_label"
        +"AVG RESP TIME"
    }
}

fun DIV.avgSLA() {
    onClick = "clickedViewAverageSLAChart()"
    div("value align_left") {
        id = "card_servicelevelagreement_average_header"
        +"n/a"
    }
    div("label align_left") {
        id = "card_servicelevelagreement_average_header_label"
        +"AVG SLA"
    }
}