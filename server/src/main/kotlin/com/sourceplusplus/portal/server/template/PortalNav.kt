package com.sourceplusplus.portal.server.template

import kotlinx.html.*

fun FlowContent.portalNav(block: DIV.() -> Unit) {
    div("ui sidebar vertical left menu overlay visible very thin icon spp_blue webkit_transition") {
        style = "overflow: visible !important;"
        block()
    }
}