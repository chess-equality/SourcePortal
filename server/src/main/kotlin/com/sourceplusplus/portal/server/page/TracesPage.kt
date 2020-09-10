package com.sourceplusplus.portal.server.page

import com.sourceplusplus.portal.server.portal
import com.sourceplusplus.portal.server.template.*
import com.sourceplusplus.portal.server.template.PageType.*
import com.sourceplusplus.portal.server.template.TraceType.*
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
                            menuItem(Overview) {}
                            menuItem(Traces, isActive = true) {
                                subMenuItem(LATEST, SLOWEST, FAILED)
                            }
                            menuItem(Configuration) {}
                        }
                        sidebar {
                            tabs {
                                overviewTab()
                                tracesTab(isActive = true) { activeClass ->
                                    traces(activeClass, LATEST, SLOWEST, FAILED)
                                }
                                configurationTab()
                            }
                        }
                    }
                    tracesContent {
                        tracesNavBar {
                            leftAlign {
                                tracesHeader()
                            }
                            rightAlign {
                                externalPortalButton()
                            }
                        }
                        tracesTable()
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