package com.sourceplusplus.portal.server.page

import kotlinx.html.*
import kotlinx.html.stream.appendHTML

@Suppress("unused")
class TracesPage {
    fun renderPage(): String {
        return buildString {
            appendLine("<!DOCTYPE html>")
            appendHTML().html {
                head {
                    meta {
                        charset = "UTF-8"
                    }
                    title { + """Traces - Source++"""}
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
                    style {
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
                            div("title item active_tab") {
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
                            a(classes = "item inactive_tab") {
                                id = "sidebar_configuration_link"
                                href = "configuration"
                                + """Configuration"""
                            }
                        }
                        div("ui dropdown item openbtn") {
                            style = "color: white"
                            i("icon demo-icon content") {
                            }
                        }
                        a(classes = "ui item hide_on_toggle") {
                            id = "overview_link"
                            href = "overview"
                            i("icon demo-icon dashboard inactive_tab") {
                            }
                        }
                        div("ui dropdown item active_tab") {
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
                                div("dropdown-divider") {
                                }
                                a(classes = "item") {
                                    id = "traces_link_failed"
                                    href = "traces"
                                    span("menu_tooltip_text") { + """Failed"""}
                                }
                            }
                        }
                        a(classes = "ui item hide_on_toggle") {
                            id = "configuration_link"
                            href = "configuration"
                            i("icon configure inactive_tab") {
                            }
                        }
                    }
                    div("pusher background_color") {
                        div("ui menu borderless marginlefting background_color") {
                            style = "border-radius: 0 !important; border: 0; -webkit-transition-duration: 0.1s; height: 45px; margin-bottom: 0"
                            a(classes = "ui item dropdown active_sub_tab") {
                                id = "latest_traces_header"
                                onClick = "clickedBackToTraces()"
                                span {
                                    id = "latest_traces_header_text"
                                    + """Latest Traces"""
                                }
                                div("menu") {
                                    id = "latest_traces_menu"
                                    div("ui input item") {
                                        i("play icon spp_blue_color") {
                                        }
                                        input {
                                            id = "traces_start_field"
                                            type = InputType.text
                                            style = "width: 210px"
                                            readonly = true
                                        }
                                    }
                                    div("ui input item") {
                                        i("stop icon spp_red_color") {
                                        }
                                        input {
                                            id = "traces_stop_field"
                                            type = InputType.text
                                            style = "width: 210px"
                                            readonly = true
                                        }
                                    }
                                    div("divider") {
                                    }
                                    div("ui input item") {
                                        style = "text-align: center"
                                        label {
                                            id = "traces_total_label"
                                            + """Total: 0"""
                                        }
                                    }
                                }
                            }
                            a(classes = "ui item dropdown") {
                                id = "trace_stack_header"
                                onClick = "clickedBackToTraceStack()"
                                style = "visibility: hidden"
                                span {
                                    id = "trace_stack_header_text"
                                    + """Trace Stack"""
                                }
                                div("menu") {
                                    id = "trace_stack_menu"
                                    div("ui input item") {
                                        i("crosshairs icon") {
                                            style = "padding-top: 0"
                                        }
                                        input {
                                            id = "trace_id_field"
                                            type = InputType.text
                                            style = "width: 210px"
                                            readonly = true
                                        }
                                    }
                                    div("ui input item") {
                                        i("clock outline icon") {
                                            style = "padding-top: 0"
                                        }
                                        input {
                                            id = "time_occurred_field"
                                            type = InputType.text
                                            style = "width: 210px"
                                            readonly = true
                                        }
                                    }
                                }
                            }
                            a(classes = "ui item dropdown") {
                                id = "span_info_header"
                                style = "visibility: hidden"
                                span {
                                    id = "span_info_header_text"
                                    + """Span Info"""
                                }
                            }
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
                        div("wide column marginlefting") {
                            table("ui celled striped table unstackable secondary_background_color") {
                                style = "margin-top: 0"
                                id = "top_trace_table"
                                thead {
                                    tr {
                                        th(classes = "secondary_background_color") {
                                            style = "padding-top: 5px; padding-bottom: 5px"
                                            + """Operation"""
                                        }
                                        th(classes = "secondary_background_color") {
                                            style = "padding-top: 5px; padding-bottom: 5px; text-align: center"
                                            + """Occurred"""
                                        }
                                        th(classes = "secondary_background_color") {
                                            style = "padding-top: 5px; padding-bottom: 5px; text-align: center"
                                            + """Exec"""
                                        }
                                        th(classes = "secondary_background_color") {
                                            style = "padding-top: 5px; padding-bottom: 5px; text-align: center"
                                            + """Status"""
                                        }
                                    }
                                }
                                tbody {
                                    id = "trace_table"
                                }
                            }
                            table("ui celled striped table unstackable trace_stack_table") {
                                id = "trace_stack_table"
                                style = "visibility: hidden; margin-top: 0"
                                thead("secondary_background_color") {
                                    tr {
                                        th(classes = "secondary_background_color") {
                                            style = "padding-top: 5px; padding-bottom: 5px"
                                            + """Operation"""
                                        }
                                        th(classes = "secondary_background_color") {
                                            style = "padding-top: 5px; padding-bottom: 5px; text-align: center"
                                            + """Exec"""
                                        }
                                        th(classes = "secondary_background_color") {
                                            style = "padding-top: 5px; padding-bottom: 5px; text-align: center"
                                            + """Exec (%)"""
                                        }
                                        th(classes = "secondary_background_color") {
                                            style = "padding-top: 5px; padding-bottom: 5px; text-align: center"
                                            + """Status"""
                                        }
                                    }
                                }
                                tbody("stack_table_background") {
                                    id = "stack_table"
                                }
                            }
                            div {
                                id = "span_info_panel"
                                style = "visibility: hidden"
                                div("ui segments") {
                                    div("ui segment span_segment_background") {
                                        p {
                                            + """Start time:"""
                                            span {
                                                id = "span_info_start_time"
                                            }
                                            + """("""
                                            span("trace_time") {
                                                id = "span_info_start_trace_time"
                                            }
                                            + """)"""
                                        }
                                        p {
                                            + """Start time:"""
                                            span {
                                                id = "span_info_end_time"
                                            }
                                            + """("""
                                            span("trace_time") {
                                                id = "span_info_end_trace_time"
                                            }
                                            + """)"""
                                        }
                                    }
                                    div("ui segment displaynone") {
                                        id = "span_tag_div"
                                        style = "padding: 0"
                                        table("ui celled striped table unstackable") {
                                            id = "span_tag_table"
                                            thead {
                                                tr {
                                                    th { + """Tag"""}
                                                    th { + """Value"""}
                                                }
                                            }
                                            tbody {
                                                id = "tag_table"
                                            }
                                        }
                                    }
                                    div("ui segment displaynone") {
                                        id = "span_log_div"
                                        style = "padding: 0; overflow-x: auto"
                                        table("ui celled striped table unstackable") {
                                            id = "log_tag_table"
                                            thead {
                                                tr {
                                                    th { + """Trace Logs"""}
                                                }
                                            }
                                            tbody {
                                                id = "log_table"
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
                        src = "themes/default/assets/all.min.js"
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
                        src = "js/traces.js"
                    }
                    script {
                        src = "js/views/traces_view.js"
                    }
                }
            }
        }
    }

    // Temporary - for reference
    private val tracesHtml = """
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Traces - Source++</title>
            <link rel='stylesheet' href='semantic.min.css'>
            <script src='jquery-3.5.1.min.js'></script>
            <script src='portal_theme.js'></script>
            <style>
                tbody tr, td {
                    max-height: 44px !important;
                    height: 44px !important;
                    padding-top: 0 !important;
                    padding-bottom: 0 !important;
                }
            </style>
        </head>
        <body>
        <div class="ui sidebar vertical left menu overlay visible very thin icon spp_blue"
             style="-webkit-transition-duration: 0.1s; overflow: visible !important;">
            <div class="ui accordion displaynone">
                <a class="item openbtn" style="background-color: white; height: 45px !important;">Close menu</a>
                <a id="sidebar_overview_link" class="item inactive_tab" href="overview">Dashboard</a>

                <div class="title item active_tab">
                    <i class="dropdown icon"></i> Traces
                </div>
                <div class="content">
                    <a id="sidebar_traces_link_latest" class="item sidebar_sub_text_color" href="traces">Latest</a>
                    <a id="sidebar_traces_link_slowest" class="item sidebar_sub_text_color" href="traces">Slowest</a>
                    <a id="sidebar_traces_link_failed" class="item sidebar_sub_text_color" href="traces">Failed</a>
                </div>
                <a id="sidebar_configuration_link" class="item inactive_tab" href="configuration">Configuration</a>
            </div>
            <div class="ui dropdown item openbtn" style="color: white">
                <i class="icon demo-icon content"></i>
            </div>
            <a id="overview_link" class="ui item hide_on_toggle" href="overview">
                <i class="icon demo-icon dashboard inactive_tab"></i>
            </a>
            <div class="ui dropdown item active_tab">
                <z class="displaynone">Traces</z>
                <i class="icon demo-icon code"></i>

                <div class="menu background_color">
                    <a id="traces_link_latest" class="item" href="traces">
                        <span class="menu_tooltip_text">Latest</span>
                    </a>
                    <a id="traces_link_slowest" class="item" href="traces">
                        <span class="menu_tooltip_text">Slowest</span>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a id="traces_link_failed" class="item" href="traces">
                        <span class="menu_tooltip_text">Failed</span>
                    </a>
                </div>
            </div>
            <a id="configuration_link" class="ui item hide_on_toggle" href="configuration">
                <i class="icon configure inactive_tab"></i>
            </a>
        </div>
        <div class="pusher background_color">
            <div class="ui menu borderless marginlefting background_color"
                 style="border-radius: 0 !important; border: 0; -webkit-transition-duration: 0.1s; height: 45px; margin-bottom: 0">
                <a id="latest_traces_header" onClick="clickedBackToTraces()" class="ui item dropdown active_sub_tab">
                    <span id="latest_traces_header_text">Latest Traces</span>
                    <div id="latest_traces_menu" class="menu">
                        <div class="ui input item">
                            <i class="play icon spp_blue_color"></i>
                            <input id="traces_start_field" type="text" style="width: 210px" readonly>
                        </div>
                        <div class="ui input item">
                            <i class="stop icon spp_red_color"></i>
                            <input id="traces_stop_field" type="text" style="width: 210px" readonly>
                        </div>
                        <div class="divider"></div>
                        <div class="ui input item" style="text-align: center">
                            <label id="traces_total_label">Total: 0</label>
                        </div>
                    </div>
                </a>
                <a id="trace_stack_header" onClick="clickedBackToTraceStack()" class="ui item dropdown"
                   style="visibility: hidden">
                    <span id="trace_stack_header_text">Trace Stack</span>
                    <div id="trace_stack_menu" class="menu">
                        <div class="ui input item">
                            <i style="padding-top: 0" class="crosshairs icon"></i>
                            <input id="trace_id_field" type="text" style="width: 210px" readonly>
                        </div>
                        <div class="ui input item">
                            <i style="padding-top: 0" class="clock outline icon"></i>
                            <input id="time_occurred_field" type="text" style="width: 210px" readonly>
                        </div>
                    </div>
                </a>
                <a id="span_info_header" class="ui item dropdown" style="visibility: hidden">
                    <span id="span_info_header_text">Span Info</span>
                </a>
                <div class="right menu" style="height: 45px; line-height: 45px; align-content:center;">
                    <a id="current_page_external" href="#" onClick="clickedViewAsExternalPortal()">
                        <i class="external link icon spp_red_color" style="font-size: 20px; margin-top: -2px"></i>
                    </a>
                </div>
            </div>
            <div class="wide column marginlefting">
                <table style="margin-top: 0" id="top_trace_table"
                       class="ui celled striped table unstackable secondary_background_color">
                    <thead>
                    <tr>
                        <th style="padding-top: 5px; padding-bottom: 5px" class="secondary_background_color">Operation</th>
                        <th style="padding-top: 5px; padding-bottom: 5px; text-align: center"
                            class="secondary_background_color">Occurred
                        </th>
                        <th style="padding-top: 5px; padding-bottom: 5px; text-align: center"
                            class="secondary_background_color">Exec
                        </th>
                        <th style="padding-top: 5px; padding-bottom: 5px; text-align: center"
                            class="secondary_background_color">Status
                        </th>
                    </tr>
                    </thead>
                    <tbody id="trace_table">
                    </tbody>
                </table>
                <table id="trace_stack_table" style="visibility: hidden; margin-top: 0"
                       class="ui celled striped table unstackable trace_stack_table">
                    <thead class="secondary_background_color">
                    <tr>
                        <th style="padding-top: 5px; padding-bottom: 5px" class="secondary_background_color">Operation</th>
                        <th style="padding-top: 5px; padding-bottom: 5px; text-align: center"
                            class="secondary_background_color">Exec
                        </th>
                        <th style="padding-top: 5px; padding-bottom: 5px; text-align: center"
                            class="secondary_background_color">Exec (%)
                        </th>
                        <th style="padding-top: 5px; padding-bottom: 5px; text-align: center"
                            class="secondary_background_color">Status
                        </th>
                    </tr>
                    </thead>
                    <tbody id="stack_table" class="stack_table_background">
                    </tbody>
                </table>
                <div id="span_info_panel" style="visibility: hidden">
                    <div class="ui segments">
                        <div class="ui segment span_segment_background">
                            <p>
                                Start time: <span id="span_info_start_time"></span>
                                (<span id="span_info_start_trace_time" class="trace_time"></span>)
                            </p>
                            <p>
                                Start time: <span id="span_info_end_time"></span>
                                (<span id="span_info_end_trace_time" class="trace_time"></span>)
                            </p>
                        </div>
                        <div id="span_tag_div" class="ui segment displaynone" style="padding: 0">
                            <table id="span_tag_table" class="ui celled striped table unstackable">
                                <thead>
                                <tr>
                                    <th>Tag</th>
                                    <th>Value</th>
                                </tr>
                                </thead>
                                <tbody id="tag_table">
                                </tbody>
                            </table>
                        </div>
                        <div id="span_log_div" class="ui segment displaynone" style="padding: 0; overflow-x: auto">
                            <table id="log_tag_table" class="ui celled striped table unstackable">
                                <thead>
                                <tr>
                                    <th>Trace Logs</th>
                                </tr>
                                </thead>
                                <tbody id="log_table">
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src='semantic.min.js'></script>
        <script src='themes/default/assets/all.min.js'></script>
        <script src="moment.min.js"></script>
        <script src="sockjs.min.js"></script>
        <script src='vertx-eventbus.min.js'></script>
        <script src='source_eventbus_bridge.js'></script>
        <script src='js/traces.js'></script>
        <script src='js/views/traces_view.js'></script>
        </body>
        </html>
    """.trimIndent()
}