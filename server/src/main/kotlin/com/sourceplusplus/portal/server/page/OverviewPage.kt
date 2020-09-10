package com.sourceplusplus.portal.server.page

import com.sourceplusplus.portal.server.portal
import com.sourceplusplus.portal.server.template.*
import com.sourceplusplus.portal.server.template.MenuItem.*
import com.sourceplusplus.portal.server.template.TraceType.*
import com.sourceplusplus.portal.server.template.TimeIntervalType.*
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
                            menuItem(Overview, isActive = true) {}
                            menuItem(Traces) {
                                subMenuItem(Latest)
                                subMenuItem(Slowest)
                                subMenuItem(Failed)
                            }
                            menuItem(Configuration) {}
                        }
                        sidebar {
                            tabs {
                                overviewTab(isActive = true)
                                tracesTab { activeClass ->
                                    traces(activeClass, LATEST, SLOWEST, FAILED)
                                }
                                configurationTab()
                            }
                        }
                    }
                    overviewContent {
                        overviewNavBar {
                            leftAlign {
                                timeDropdown(FIVE_MINUTES, FIFTEEN_MINUTES, THIRTY_MINUTES, ONE_HOUR, THREE_HOURS)
                            }
                            rightAlign {
                                externalPortalButton()
                            }
                        }
                        areaChart()
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