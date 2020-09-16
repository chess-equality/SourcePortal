package com.sourceplusplus.portal.server.page

import com.sourceplusplus.portal.server.portal
import com.sourceplusplus.portal.server.template.*
import com.sourceplusplus.portal.server.model.PageType.*
import com.sourceplusplus.portal.server.model.TraceType.*
import com.sourceplusplus.portal.server.model.ChartItemType.*
import com.sourceplusplus.portal.server.model.TimeIntervalType.*
import kotlinx.html.*
import kotlinx.html.stream.appendHTML

class OverviewPage {
    fun renderPage(): String {
        return buildString {
            appendLine("<!DOCTYPE html>")
            appendHTML().portal {
                overviewPage {
                    portalNav {
                        navItem(OVERVIEW, isActive = true) {}
                        navItem(TRACES) { activeClass ->
                            navSubItem(activeClass, LATEST, SLOWEST, FAILED)
                        }
                        navItem(CONFIGURATION) {}
                    }
                    overviewContent {
                        overviewNavBar {
                            timeDropdown(FIVE_MINUTES, FIFTEEN_MINUTES, THIRTY_MINUTES, ONE_HOUR, THREE_HOURS)
                            rightAlign {
                                externalPortalButton()
                            }
                        }
                        areaChart {
                            chartItem(AVG_THROUGHPUT)
                            chartItem(AVG_RESPONSE_TIME, isActive = true)
                            chartItem(AVG_SLA)
                        }
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