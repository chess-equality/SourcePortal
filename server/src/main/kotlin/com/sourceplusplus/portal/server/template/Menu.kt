package com.sourceplusplus.portal.server.template

import kotlinx.html.*

fun FlowContent.menu(classes: String = "ui accordion displaynone",
                     block: FlowContent.() -> Unit) {
    div(classes) {
        a(classes = "item openbtn openbtn_background_white") {
            +"""Close menu"""
        }
        block()
    }
    div("ui dropdown item openbtn") {
        i("icon demo-icon content white_color") {
        }
    }
}

fun FlowContent.dashboardMenuItem(isActive: Boolean) {
    if (isActive) {
        a(classes = "item active_tab") { +"""Dashboard""" }
    } else {
        a(classes = "item inactive_tab") {
            id = "sidebar_overview_link"
            href = "overview"
            + """Dashboard"""
        }
    }
}

fun FlowContent.tracesMenuItem(isActive: Boolean) {
    var activeClass = "active_tab"
    if (!isActive) {
        activeClass = "inactive_tab"
    }
    div("title item") {
        classes = classes.plus(activeClass)
        i("dropdown icon") {
        }
        + """Traces"""
    }
    div("content") {
        a(classes = "item sidebar_sub_text_color") {
            id = "sidebar_traces_link_latest"
            href = "traces"
            + "Latest"
        }
        a(classes = "item sidebar_sub_text_color") {
            id = "sidebar_traces_link_slowest"
            href = "traces"
            + "Slowest"
        }
        a(classes = "item sidebar_sub_text_color") {
            id = "sidebar_traces_link_failed"
            href = "traces"
            + "Failed"
        }
    }
}

fun FlowContent.configurationMenuItem(isActive: Boolean) {
    if (isActive) {
        a(classes = "item active_tab") { +"""Configuration""" }
    } else {
        a(classes = "item inactive_tab") {
            id = "sidebar_configuration_link"
            href = "configuration"
            + """Configuration"""
        }
    }
}