package com.sourceplusplus.portal.server.template

import kotlinx.html.*

fun FlowContent.menu(classes: String = "ui accordion displaynone",
                     block: FlowContent.() -> Unit) {
    div(classes) {
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

fun FlowContent.menuItem(menuItem: MenuItem, isActive: Boolean = false, block: FlowContent.() -> Unit) {
    menuItem.applyThis(this, isActive, block)
}

enum class MenuItem {
    Overview {
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
    Traces {
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
    Configuration {
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

fun FlowContent.subMenuItem(subMenuItem: SubMenuItem) {
    subMenuItem.applyThis(this)
}

enum class SubMenuItem {
    Latest {
        override fun applyThis(flowContent: FlowContent) {
            flowContent.apply {
                a(classes = "item sidebar_sub_text_color") {
                    id = "sidebar_traces_link_latest"
                    href = "traces"
                    +"Latest"
                }
            }
        }
    },
    Slowest {
        override fun applyThis(flowContent: FlowContent) {
            flowContent.apply {
                a(classes = "item sidebar_sub_text_color") {
                    id = "sidebar_traces_link_slowest"
                    href = "traces"
                    +"Slowest"
                }
            }
        }

    },
    Failed {
        override fun applyThis(flowContent: FlowContent) {
            flowContent.apply {
                a(classes = "item sidebar_sub_text_color") {
                    id = "sidebar_traces_link_failed"
                    href = "traces"
                    +"Failed"
                }
            }
        }
    };

    abstract fun applyThis(flowContent: FlowContent)
}