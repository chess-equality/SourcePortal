package com.sourceplusplus.portal.server.template

import kotlinx.html.*

fun FlowContent.menu(cssClasses: String = "ui accordion displaynone",
                     block: FlowContent.() -> Unit) {
    div(cssClasses) {
        a(classes = "item openbtn openbtn_background_white") {
            +"Close menu"
        }
        block()
    }
    div("ui dropdown item openbtn") {
        i("icon demo-icon content white_color") {
        }
    }
}

fun FlowContent.menuItem(pageType: PageType, isActive: Boolean = false, block: FlowContent.() -> Unit) {
    pageType.applyThis(this, isActive, block)
}

enum class PageType {
    OVERVIEW {
        override fun applyThis(flowContent: FlowContent, isActive: Boolean, block: FlowContent.() -> Unit) {
            flowContent.apply {
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
        }
    },
    TRACES {
        override fun applyThis(flowContent: FlowContent, isActive: Boolean, block: FlowContent.() -> Unit) {
            flowContent.apply {
                var activeClass = "active_tab"
                if (!isActive) {
                    activeClass = "inactive_tab"
                }
                div("title item") {
                    classes = classes.plus(activeClass)
                    i("dropdown icon") {
                    }
                    +"Traces"
                }
                div("content") {
                    block()
                }
            }
        }
    },
    CONFIGURATION {
        override fun applyThis(flowContent: FlowContent, isActive: Boolean, block: FlowContent.() -> Unit) {
            flowContent.apply {
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
    };

    abstract fun applyThis(flowContent: FlowContent, isActive: Boolean = false, block: FlowContent.() -> Unit)
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