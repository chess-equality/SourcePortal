package com.sourceplusplus.portal.server.page

import kotlinx.html.*
import kotlinx.html.stream.appendHTML

@Suppress("unused")
class ConfigurationPage {
    fun renderPage(): String {
        return buildString {
            appendLine("<!DOCTYPE html>")
            appendHTML().html {
                head {
                    meta {
                        charset = "UTF-8"
                    }
                    title { + """Configuration - Source++"""}
                    link {
                        rel = "stylesheet"
                        href = "semantic.min.css"
                    }
                    script {
                        src = "jquery-3.5.1.min.js"
                    }
                    script {
                        src = "portal_theme.js"
                    }
                }
                body {
                    div("ui sidebar vertical left menu overlay visible very thin icon spp_blue") {
                        style = "-webkit-transition-duration: 0.1s; overflow: visible !important;"
                        div("ui accordion displaynone") {
                            a(classes = "item openbtn") {
                                style = "background-color: white; height: 45px !important;"
                                + """Close menu"""
                            }
                            a(classes = "item inactive_tab") {
                                id = "sidebar_overview_link"
                                href = "overview"
                                + """Dashboard"""
                            }
                            div("title item inactive_tab") {
                                i("dropdown icon") {
                                }
                                + """Traces"""
                            }
                            div("content") {
                                a(classes = "item sidebar_sub_text_color") {
                                    id = "sidebar_traces_link_latest"
                                    href = "traces"
                                    + """Latest"""
                                }
                                a(classes = "item sidebar_sub_text_color") {
                                    id = "sidebar_traces_link_slowest"
                                    href = "traces"
                                    + """Slowest"""
                                }
                                a(classes = "item sidebar_sub_text_color") {
                                    id = "sidebar_traces_link_failed"
                                    href = "traces"
                                    + """Failed"""
                                }
                            }
                            a(classes = "item active_tab") { + """Configuration"""}
                        }
                        div("ui dropdown item openbtn") {
                            style = "color: white"
                            i("icon demo-icon content") {
                            }
                        }
                        a(classes = "ui item hide_on_toggle") {
                            id = "overview_link"
                            href = "configuration"
                            i("icon dashboard inactive_tab") {
                            }
                        }
                        div("ui dropdown item inactive_tab") {
                            unsafe {
                                +"""<z class="displaynone">Traces</z>"""
                            }
                            i("icon demo-icon code") {
                            }
                            div("menu background_color") {
                                a(classes = "item") {
                                    id = "traces_link_latest"
                                    href = "traces"
                                    span("menu_tooltip_text") { + """Latest"""}
                                }
                                a(classes = "item") {
                                    id = "traces_link_slowest"
                                    href = "traces"
                                    span("menu_tooltip_text") { + """Slowest"""}
                                }
                                a(classes = "item") {
                                    id = "traces_link_failed"
                                    href = "traces"
                                    span("menu_tooltip_text") { + """Failed"""}
                                }
                            }
                        }
                        a(classes = "ui dropdown item active_tab") {
                            i("icon configure") {
                            }
                        }
                    }
                    div("pusher background_color") {
                        div("ui menu marginlefting aligned content") {
                            style = "border-radius: 0!important; border: 0; align-content: center;"
                            div("ui sidebar horizontal top menu fixed overlay visible very thin icon background_color") {
                                style = "overflow: visible !important;"
                                div("right menu") {
                                    style = "height: 45px; line-height: 45px; align-content:center;"
                                    a {
                                        id = "current_page_external"
                                        href = "#"
                                        onClick = "clickedViewAsExternalPortal()"
                                        i("external link icon spp_red_color") {
                                            style = "font-size: 20px; margin-top: -2px"
                                        }
                                    }
                                }
                            }
                        }
                        div("ui grid marginlefting") {
                            style = "min-height: 100%"
                            div("six wide column") {
                                style = "min-height: 100%"
                                div("ui form") {
                                    div("ui segment secondary_background_color") {
                                        div("field") {
                                            div("ui toggle checkbox") {
                                                id = "entry_method_toggle"
                                                input {
                                                    id = "entry_method_checkbox"
                                                    type = InputType.checkBox
                                                }
                                                label("secondary_background_color") { + """Entry method"""}
                                            }
                                        }
                                        div("field") {
                                            div("ui toggle checkbox") {
                                                id = "auto_subscribe_toggle"
                                                input {
                                                    id = "auto_subscribe_checkbox"
                                                    type = InputType.checkBox
                                                }
                                                label("secondary_background_color") { + """Auto-subscribe"""}
                                            }
                                        }
                                    }
                                }
                            }
                            div("ten wide column background_color") {
                                style = "min-height: 100%"
                                div("ui segments secondary_background_color") {
                                    style = "margin-right: 10px; background-color: white"
                                    table("ui small very compact very basic collapsing celled table") {
                                        style = "padding: 0 !important; margin-left: 10px"
                                        tbody {
                                            tr {
                                                td {
                                                    h4("ui header secondary_background_color") {
                                                        div("content") { + """Qualified Name"""}
                                                    }
                                                }
                                                td("secondary_background_color") {
                                                    id = "artifact_qualified_name"
                                                }
                                            }
                                            tr {
                                                td {
                                                    h4("ui header secondary_background_color") {
                                                        div("content") { + """Create Date"""}
                                                    }
                                                }
                                                td("secondary_background_color") {
                                                    id = "artifact_create_date"
                                                }
                                            }
                                            tr {
                                                td {
                                                    h4("ui header secondary_background_color") {
                                                        div("content") { + """Last Updated"""}
                                                    }
                                                }
                                                td("secondary_background_color") {
                                                    id = "artifact_last_updated"
                                                }
                                            }
                                            tr {
                                                td {
                                                    h4("ui header secondary_background_color") {
                                                        div("content") { + """Endpoint"""}
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
                    script {
                        src = "semantic.min.js"
                    }
                    script {
                        src = "moment.min.js"
                    }
                    script {
                        src = "sockjs.min.js"
                    }
                    script {
                        src = "vertx-eventbus.min.js"
                    }
                    script {
                        src = "source_eventbus_bridge.js"
                    }
                    script {
                        src = "js/configuration.js"
                    }
                    script {
                        src = "js/views/configuration_view.js"
                    }
                }
            }
        }
    }

    // Temporary - for reference
    private val configurationHtml = """
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Configuration - Source++</title>
            <link rel='stylesheet' href='semantic.min.css'>
            <script src='jquery-3.5.1.min.js'></script>
            <script src='portal_theme.js'></script>
        </head>
        <body>
        <div class="ui sidebar vertical left menu overlay visible very thin icon spp_blue"
             style="-webkit-transition-duration: 0.1s; overflow: visible !important;">
            <div class="ui accordion displaynone">
                <a class="item openbtn" style="background-color: white; height: 45px !important;">Close menu</a>
                <a id="sidebar_overview_link" class="item inactive_tab" href="overview">Dashboard</a>

                <div class="title item inactive_tab">
                    <i class="dropdown icon"></i> Traces
                </div>
                <div class="content">
                    <a id="sidebar_traces_link_latest" class="item sidebar_sub_text_color" href="traces">Latest</a>
                    <a id="sidebar_traces_link_slowest" class="item sidebar_sub_text_color" href="traces">Slowest</a>
                    <a id="sidebar_traces_link_failed" class="item sidebar_sub_text_color" href="traces">Failed</a>
                </div>

                <a class="item active_tab">Configuration</a>
            </div>
            <div class="ui dropdown item openbtn" style="color: white">
                <i class="icon demo-icon content"></i>
            </div>
            <a id="overview_link" class="ui item hide_on_toggle" href="configuration">
                <i class="icon dashboard inactive_tab"></i>
            </a>
            <div class="ui dropdown item inactive_tab">
                <z class="displaynone">Traces</z>
                <i class="icon demo-icon code"></i>

                <div class="menu background_color">
                    <a id="traces_link_latest" class="item" href="traces">
                        <span class="menu_tooltip_text">Latest</span>
                    </a>
                    <a id="traces_link_slowest" class="item" href="traces">
                        <span class="menu_tooltip_text">Slowest</span>
                    </a>
                    <a id="traces_link_failed" class="item" href="traces">
                        <span class="menu_tooltip_text">Failed</span>
                    </a>
                </div>
            </div>
            <a class="ui dropdown item active_tab"><i class="icon configure"></i></a>
        </div>
        <div class="pusher background_color">
            <div class="ui menu marginlefting aligned content"
                 style="border-radius: 0!important; border: 0; align-content: center;">
                <div class="ui sidebar horizontal top menu fixed overlay visible very thin icon background_color"
                     style="overflow: visible !important;">
                    <div class="right menu" style="height: 45px; line-height: 45px; align-content:center;">
                        <a id="current_page_external" href="#" onclick="clickedViewAsExternalPortal()">
                            <i class="external link icon spp_red_color" style="font-size: 20px; margin-top: -2px"></i>
                        </a>
                    </div>
                </div>
            </div>
            <div class="ui grid marginlefting" style="min-height: 100%">
                <div class="six wide column" style="min-height: 100%">

                    <div class="ui form">
                        <div class="ui segment secondary_background_color">
                            <div class="field">
                                <div class="ui toggle checkbox" id="entry_method_toggle">
                                    <input id="entry_method_checkbox" type="checkbox">
                                    <label class="secondary_background_color">Entry method</label>
                                </div>
                            </div>
                            <div class="field">
                                <div class="ui toggle checkbox" id="auto_subscribe_toggle">
                                    <input id="auto_subscribe_checkbox" type="checkbox">
                                    <label class="secondary_background_color">Auto-subscribe</label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="ten wide column background_color" style="min-height: 100%">
                    <div class="ui segments secondary_background_color" style="margin-right: 10px; background-color: white">
                        <table class="ui small very compact very basic collapsing celled table"
                               style="padding: 0 !important; margin-left: 10px">
                            <tbody>
                            <tr>
                                <td>
                                    <h4 class="ui header secondary_background_color">
                                        <div class="content">Qualified Name</div>
                                    </h4>
                                </td>
                                <td id="artifact_qualified_name" class="secondary_background_color"></td>
                            </tr>
                            <tr>
                                <td>
                                    <h4 class="ui header secondary_background_color">
                                        <div class="content">Create Date</div>
                                    </h4>
                                </td>
                                <td id="artifact_create_date" class="secondary_background_color"></td>
                            </tr>
                            <tr>
                                <td>
                                    <h4 class="ui header secondary_background_color">
                                        <div class="content">Last Updated</div>
                                    </h4>
                                </td>
                                <td id="artifact_last_updated" class="secondary_background_color"></td>
                            </tr>
                            <tr>
                                <td>
                                    <h4 class="ui header secondary_background_color">
                                        <div class="content">Endpoint</div>
                                    </h4>
                                </td>
                                <td id="artifact_endpoint" class="secondary_background_color"></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <script src='semantic.min.js'></script>
        <script src="moment.min.js"></script>
        <script src="sockjs.min.js"></script>
        <script src='vertx-eventbus.min.js'></script>
        <script src='source_eventbus_bridge.js'></script>
        <script src='js/configuration.js'></script>
        <script src='js/views/configuration_view.js'></script>
        </body>
        </html>
    """.trimIndent()
}