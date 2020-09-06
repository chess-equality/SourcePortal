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
                    div("pusher background_color") {
                        div("ui menu marginlefting aligned content menu_style_3") {
                            div("ui sidebar horizontal top menu fixed overlay visible very thin icon background_color overflow_visible") {
                                div("right menu align_content_center") {
                                    a {
                                        id = "current_page_external"
                                        href = "#"
                                        onClick = "clickedViewAsExternalPortal()"
                                        i("external link icon spp_red_color spp_font_margin") {
                                        }
                                    }
                                }
                            }
                        }
                        div("ui grid marginlefting min_height") {
                            div("six wide column min_height") {
                                div("ui form") {
                                    div("ui segment secondary_background_color") {
                                        div("field") {
                                            div("ui toggle checkbox") {
                                                id = "entry_method_toggle"
                                                input {
                                                    id = "entry_method_checkbox"
                                                    type = InputType.checkBox
                                                }
                                                label("secondary_background_color") { +"""Entry method""" }
                                            }
                                        }
                                        div("field") {
                                            div("ui toggle checkbox") {
                                                id = "auto_subscribe_toggle"
                                                input {
                                                    id = "auto_subscribe_checkbox"
                                                    type = InputType.checkBox
                                                }
                                                label("secondary_background_color") { +"""Auto-subscribe""" }
                                            }
                                        }
                                    }
                                }
                            }
                            div("ten wide column background_color min_height") {
                                div("ui segments secondary_background_color margin_right_white") {
                                    table("ui small very compact very basic collapsing celled table margin_left_no_padding") {
                                        tbody {
                                            tr {
                                                td {
                                                    h4("ui header secondary_background_color") {
                                                        div("content") { +"""Qualified Name""" }
                                                    }
                                                }
                                                td("secondary_background_color") {
                                                    id = "artifact_qualified_name"
                                                }
                                            }
                                            tr {
                                                td {
                                                    h4("ui header secondary_background_color") {
                                                        div("content") { +"""Create Date""" }
                                                    }
                                                }
                                                td("secondary_background_color") {
                                                    id = "artifact_create_date"
                                                }
                                            }
                                            tr {
                                                td {
                                                    h4("ui header secondary_background_color") {
                                                        div("content") { +"""Last Updated""" }
                                                    }
                                                }
                                                td("secondary_background_color") {
                                                    id = "artifact_last_updated"
                                                }
                                            }
                                            tr {
                                                td {
                                                    h4("ui header secondary_background_color") {
                                                        div("content") { +"""Endpoint""" }
                                                    }
                                                }
                                                td("secondary_background_color") {
                                                    id = "artifact_endpoint"
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    configurationScripts()
                }
            }
        }
    }
}