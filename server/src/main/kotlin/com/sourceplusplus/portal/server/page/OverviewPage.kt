package com.sourceplusplus.portal.server.page

import com.sourceplusplus.portal.server.template.*
import kotlinx.html.*
import kotlinx.html.stream.appendHTML

class OverviewPage {
    fun renderPage(): String {
        return buildString {
            appendLine("<!DOCTYPE html>")
            appendHTML().html {
                head {
                    overviewHead("Overview - Source++") {}
                }
                body("overflow_y_hidden") {
                    leftNav {
                        menu {
                            dashboardMenuItem(isActive = true)
                            tracesMenuItem(isActive = false)
                            configurationMenuItem(isActive = false)
                        }
                        sidebar {
                            tabs {
                                overviewTab(isActive = true)
                                tracesTab(isActive = false)
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