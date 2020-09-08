package com.sourceplusplus.portal.server.page

import com.sourceplusplus.portal.server.portal
import com.sourceplusplus.portal.server.template.*
import kotlinx.html.*
import kotlinx.html.stream.appendHTML

class OverviewPage {
    fun renderPage(): String {
        return buildString {
            appendLine("<!DOCTYPE html>")
            appendHTML().portal {
                overviewPage {
                    leftNav {
                        menu {
                            dashboardMenuItem(isActive = true)
                            tracesMenuItem(isActive = false)
                            configurationMenuItem(isActive = false)
                        }
                        sidebar {
                            tabs {
                                overviewTab(isActive = true)
                                tracesTab(isActive = false) { activeClass ->
                                    traces(activeClass, LATEST, SLOWEST, FAILED)
                                }
                                configurationTab(isActive = false)
                            }
                        }
                    }
                    mainContent {
                        navBar {}
                        areaChart {}
                    }
                    overviewScripts()
                }
            }
        }
    }
}

fun HTML.overviewPage(title: String = "Overview - Source++", bodyClass: String = "overflow_y_hidden", block: FlowContent.() -> Unit) {
    head {
        overviewHead(title) {}
    }
    body(bodyClass) {
        block()
    }
}