package com.sourceplusplus.portal.server.template

import kotlinx.html.*

fun FlowContent.navBar(classes: String = "ui menu fixed asd marginlefting middle aligned content menu_style", block: FlowContent.() -> Unit) {
    div(classes) {
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
    block()
}