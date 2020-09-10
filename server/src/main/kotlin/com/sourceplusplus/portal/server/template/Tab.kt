package com.sourceplusplus.portal.server.template

import kotlinx.html.*

fun FlowContent.tabs(block: FlowContent.() -> Unit) {
    block()
}

fun FlowContent.overviewTab(isActive: Boolean = false) {
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

fun FlowContent.tracesTab(isActive: Boolean = false, block: FlowContent.(activeClass: String) -> Unit) {
    var activeClass = "active_tab"
    if (!isActive) {
        activeClass = "inactive_tab"
    }
    block(activeClass)
}

fun FlowContent.configurationTab(isActive: Boolean = false) {
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

fun FlowContent.traces(activeClass: String = "", vararg traceTypes: TraceType = arrayOf()) {
    div("ui dropdown item") {
        classes = classes.plus(activeClass)
        unsafe {
            +"""<z class="displaynone">Traces</z>"""
        }
        i("icon demo-icon code") {
        }
        div("menu secondary_background_color") {
            for (traceType in traceTypes) {
                a(classes = "item") {
                    id = "traces_link_${traceType.id}"
                    href = traceType.id
                    span("menu_tooltip_text") { +traceType.name }
                }
            }
        }
    }
}

enum class TraceType {
    Latest,
    Slowest,
    Failed;

    val id = name.toLowerCase()
}