package com.sourceplusplus.portal.server.page

import com.sourceplusplus.portal.server.template.*
import kotlinx.html.*
import kotlinx.html.stream.appendHTML

class ConfigurationPage {
    fun renderPage(): String {
        return buildString {
            appendLine("<!DOCTYPE html>")
            appendHTML().html {
                head {
                    configurationHead("Configuration - Source++") {}
                }
                body {
                    leftNav {
                        menu {
                            dashboardMenuItem(isActive = false)
                            tracesMenuItem(isActive = false)
                            configurationMenuItem(isActive = true)
                        }
                        sidebar {
                            tabs {
                                overviewTab(isActive = false)
                                tracesTab(isActive = false)
                                configurationTab(isActive = true)
                            }
                        }
                    }
                    mainContent("pusher background_color") {
                        configuration {}
                    }
                    configurationScripts()
                }
            }
        }
    }
}