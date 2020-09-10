package com.sourceplusplus.portal.server.page

import com.sourceplusplus.portal.server.portal
import com.sourceplusplus.portal.server.template.*
import com.sourceplusplus.portal.server.template.MenuItem.*
import com.sourceplusplus.portal.server.template.TraceType.*
import kotlinx.html.*
import kotlinx.html.stream.appendHTML

class ConfigurationPage {
    fun renderPage(): String {
        return buildString {
            appendLine("<!DOCTYPE html>")
            appendHTML().portal {
                configurationPage {
                    leftNav {
                        menu {
                            menuItem(Overview) {}
                            menuItem(Traces) {
                                subMenuItem(Latest)
                                subMenuItem(Slowest)
                                subMenuItem(Failed)
                            }
                            menuItem(Configuration, isActive = true) {}
                        }
                        sidebar {
                            tabs {
                                overviewTab()
                                tracesTab { activeClass ->
                                    traces(activeClass, LATEST, SLOWEST, FAILED)
                                }
                                configurationTab(isActive = true)
                            }
                        }
                    }
                    configurationContent("pusher background_color") {
                        configurationNavBar {
                            rightAlign {
                                externalPortalButton()
                            }
                        }
                        configurationTable()
                    }
                    configurationScripts()
                }
            }
        }
    }
}

fun HTML.configurationPage(title: String = "Configuration - Source++", bodyClass: String = "", block: FlowContent.() -> Unit) {
    head {
        configurationHead(title) {}
    }
    body(bodyClass) {
        block()
    }
}