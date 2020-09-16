package com.sourceplusplus.portal.server.page

import com.sourceplusplus.portal.server.portal
import com.sourceplusplus.portal.server.template.*
import com.sourceplusplus.portal.server.model.PageType.*
import com.sourceplusplus.portal.server.model.TraceType.*
import kotlinx.html.*
import kotlinx.html.stream.appendHTML

class TracesPage {
    fun renderPage(): String {
        return buildString {
            appendLine("<!DOCTYPE html>")
            appendHTML().portal {
                tracesPage {
                    portalNav {
                        navItem(OVERVIEW) {}
                        navItem(TRACES, isActive = true) { activeClass ->
                            navSubItem(activeClass, LATEST, SLOWEST, FAILED)
                        }
                        navItem(CONFIGURATION) {}
                    }
                    tracesContent {
                        tracesNavBar {
                            tracesHeader()
                            rightAlign {
                                externalPortalButton()
                            }
                        }
                        tracesTable {
                            topTraceTable()
                            traceStackTable()
                            spanInfoPanel()
                        }
                    }
                    tracesScripts()
                }
            }
        }
    }
}

fun HTML.tracesPage(title: String = "Traces - Source++", bodyClass: String = "", block: FlowContent.() -> Unit) {
    head {
        tracesHead(title) {}
    }
    body(bodyClass) {
        block()
    }
}