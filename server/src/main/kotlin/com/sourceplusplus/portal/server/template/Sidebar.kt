package com.sourceplusplus.portal.server.template

import kotlinx.html.*

fun FlowContent.sidebar(block: DIV.() -> Unit) {
    div("ui dropdown item openbtn") {
        i("icon demo-icon content white_color") {
        }
    }
    a(classes = "ui dropdown item active_tab") {
        i("icon demo-icon dashboard") {
        }
    }
    div("ui dropdown item inactive_tab") {
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
    a(classes = "ui item hide_on_toggle") {
        id = "configuration_link"
        href = "configuration"
        i("icon configure inactive_tab") {
        }
    }
}