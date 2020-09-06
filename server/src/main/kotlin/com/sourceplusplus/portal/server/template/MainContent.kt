package com.sourceplusplus.portal.server.template

import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.div

fun FlowContent.mainContent(classes: String = "pusher", block: DIV.() -> Unit) {
    div(classes) {
        block()
    }
}