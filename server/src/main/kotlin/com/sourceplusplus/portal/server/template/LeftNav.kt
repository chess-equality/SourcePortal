package com.sourceplusplus.portal.server.template

import kotlinx.html.*

fun FlowContent.leftNav(classes: String = "ui sidebar vertical left menu overlay visible very thin icon spp_blue webkit_transition",
                        block: DIV.() -> Unit) {
    div(classes) {
        style = "overflow: visible !important;"
        block()
    }
}