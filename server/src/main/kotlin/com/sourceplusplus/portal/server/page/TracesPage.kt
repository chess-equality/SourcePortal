package com.sourceplusplus.portal.server.page

import com.sourceplusplus.portal.server.template.*
import kotlinx.html.*
import kotlinx.html.stream.appendHTML

class TracesPage {
    fun renderPage(): String {
        return buildString {
            appendLine("<!DOCTYPE html>")
            appendHTML().html {
                head {
                    tracesHead("Traces - Source++") {}
                }
                body {
                    leftNav {
                        menu {
                            dashboardMenuItem(isActive = false)
                            tracesMenuItem(isActive = true)
                            configurationMenuItem(isActive = false)
                        }
                        sidebar {
                            tabs {
                                overviewTab(isActive = false)
                                tracesTab(isActive = true)
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