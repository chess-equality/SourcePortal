package com.sourceplusplus.portal.server.template

import kotlinx.html.*

fun FlowContent.tabs(block: FlowContent.() -> Unit) {
    block()
}

fun FlowContent.overviewTab(isActive: Boolean) {
    if (isActive) {
        a(classes = "ui dropdown item active_tab") {
            i("icon demo-icon dashboard") {
            }
        }
    } else {
        a(classes = "ui item hide_on_toggle") {
            id = "overview_link"
            href = "overview"
            i("icon demo-icon dashboard inactive_tab") {
            }
        }
    }
}

fun FlowContent.tracesTab(isActive: Boolean) {
    var activeClass = "active_tab"
    if (!isActive) {
        activeClass = "inactive_tab"
    }
    div("ui dropdown item") {
        classes = classes.plus(activeClass)
        unsafe {
            +"""<z class="displaynone">Traces</z>"""
        }
        i("icon demo-icon code") {
        }
        div("menu secondary_background_color") {
            a(classes = "item") {
                id = "traces_link_latest"
                href = "traces"
                span("menu_tooltip_text") { +"Latest" }
            }
            a(classes = "item") {
                id = "traces_link_slowest"
                href = "traces"
                span("menu_tooltip_text") { +"Slowest" }
            }
            a(classes = "item") {
                id = "traces_link_failed"
                href = "traces"
                span("menu_tooltip_text") { +"Failed" }
            }
        }
    }
}

fun FlowContent.configurationTab(isActive: Boolean) {
    if (isActive) {
        a(classes = "ui dropdown item active_tab") {
            i("icon configure") {
            }
        }
    } else {
        a(classes = "ui item hide_on_toggle") {
            id = "configuration_link"
            href = "configuration"
            i("icon configure inactive_tab") {
            }
        }
    }
}