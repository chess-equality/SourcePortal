package com.sourceplusplus.portal.server.template

import kotlinx.html.*

fun FlowContent.mainContent(classes: String = "pusher", block: DIV.() -> Unit) {
    div(classes) {
        block()
    }
}