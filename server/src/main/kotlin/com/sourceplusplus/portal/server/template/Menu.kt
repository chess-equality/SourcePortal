package com.sourceplusplus.portal.server.template

import com.sourceplusplus.portal.server.model.*
import com.sourceplusplus.portal.server.model.trace.TraceType
import kotlinx.html.*

fun FlowContent.menu(block: FlowContent.() -> Unit) {
    div("ui accordion displaynone") {
        a(classes = "item openbtn openbtn_background_white") {
            +"Close menu"
        }
        block()
    }
    div("ui dropdown item openbtn") {
        i("icon demo-icon content white_color")
    }
}

fun FlowContent.menuItem(pageType: PageType, isActive: Boolean, block: (FlowContent.() -> Unit)? = null) {
    when (pageType) {
        PageType.OVERVIEW -> apply {
            if (isActive) {
                a(classes = "item active_tab") { +"Dashboard" }
            } else {
                a(classes = "item inactive_tab") {
                    id = "sidebar_overview_link"
                    href = "overview"
                    +"Dashboard"
                }
            }
        }
        PageType.TRACES -> apply {
            var activeClass = "active_tab"
            if (!isActive) {
                activeClass = "inactive_tab"
            }
            div("title item $activeClass") {
                i("dropdown icon")
                +"Traces"
            }
            div("content") {
                block?.let { it() }
            }
        }
        PageType.CONFIGURATION -> apply {
            if (isActive) {
                a(classes = "item active_tab") { + "Configuration" }
            } else {
                a(classes = "item inactive_tab") {
                    id = "sidebar_configuration_link"
                    href = "configuration"
                    +"Configuration"
                }
            }
        }
    }
}

fun FlowContent.subMenuItem(vararg traceTypes: TraceType = arrayOf()) {
    for (traceType in traceTypes) {
        a(classes = "item sidebar_sub_text_color") {
            id = "sidebar_traces_link_${traceType.id}"
            href = traceType.id
            +traceType.description
        }
    }
}