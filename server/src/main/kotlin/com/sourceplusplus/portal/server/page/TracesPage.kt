package com.sourceplusplus.portal.server.page

import com.sourceplusplus.portal.server.portal
import com.sourceplusplus.portal.server.template.*
import kotlinx.html.*
import kotlinx.html.stream.appendHTML

class TracesPage {
    fun renderPage(): String {
        return buildString {
            appendLine("<!DOCTYPE html>")
            appendHTML().portal {
                tracesPage {
                    leftNav {
                        menu {
                            dashboardMenuItem(isActive = false)
                            tracesMenuItem(isActive = true)
                            configurationMenuItem(isActive = false)
                        }
                        sidebar {
                            tabs {
                                overviewTab(isActive = false)
                                tracesTab(isActive = true) { activeClass ->
                                    traces(activeClass, LATEST, SLOWEST, FAILED)
                                }
                                configurationTab(isActive = false)
                            }
                        }
                    }
                    mainContent("pusher background_color") {
                        traces {}
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