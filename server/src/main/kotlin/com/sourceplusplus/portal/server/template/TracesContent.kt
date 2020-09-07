package com.sourceplusplus.portal.server.template

import kotlinx.html.*

fun FlowContent.traces(block: FlowContent.() -> Unit) {
    div("ui menu borderless marginlefting background_color menu_style_2") {
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
                        classes = setOf("input_width")
                        id = "traces_start_field"
                        type = InputType.text
                        readonly = true
                    }
                }
                div("ui input item") {
                    i("stop icon spp_red_color") {
                    }
                    input {
                        classes = setOf("input_width")
                        id = "traces_stop_field"
                        type = InputType.text
                        readonly = true
                    }
                }
                div("divider") {
                }
                div("ui input item align_center") {
                    label {
                        id = "traces_total_label"
                        + """Total: 0"""
                    }
                }
            }
        }
        a(classes = "ui item dropdown visibility_hidden") {
            id = "trace_stack_header"
            onClick = "clickedBackToTraceStack()"
            span {
                id = "trace_stack_header_text"
                + """Trace Stack"""
            }
            div("menu") {
                id = "trace_stack_menu"
                div("ui input item") {
                    i("crosshairs icon no_padding_top") {
                    }
                    input {
                        classes = setOf("input_width")
                        id = "trace_id_field"
                        type = InputType.text
                        readonly = true
                    }
                }
                div("ui input item") {
                    i("clock outline icon no_padding_top") {
                    }
                    input {
                        classes = setOf("input_width")
                        id = "time_occurred_field"
                        type = InputType.text
                        readonly = true
                    }
                }
            }
        }
        a(classes = "ui item dropdown visibility_hidden") {
            id = "span_info_header"
            span {
                id = "span_info_header_text"
                + """Span Info"""
            }
        }
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
    div("wide column marginlefting") {
        table("ui celled striped table unstackable secondary_background_color no_top_margin") {
            id = "top_trace_table"
            thead {
                tr {
                    th(classes = "secondary_background_color trace_th") {
                        + """Operation"""
                    }
                    th(classes = "secondary_background_color trace_th_center") {
                        + """Occurred"""
                    }
                    th(classes = "secondary_background_color trace_th_center") {
                        + """Exec"""
                    }
                    th(classes = "secondary_background_color trace_th_center") {
                        + """Status"""
                    }
                }
            }
            tbody {
                id = "trace_table"
            }
        }
        table("ui celled striped table unstackable trace_stack_table hidden_full_height") {
            id = "trace_stack_table"
            thead("secondary_background_color") {
                tr {
                    th(classes = "secondary_background_color trace_th") {
                        + """Operation"""
                    }
                    th(classes = "secondary_background_color trace_th_center") {
                        + """Exec"""
                    }
                    th(classes = "secondary_background_color trace_th_center") {
                        + """Exec (%)"""
                    }
                    th(classes = "secondary_background_color trace_th_center") {
                        + """Status"""
                    }
                }
            }
            tbody("stack_table_background") {
                id = "stack_table"
            }
        }
        div("visibility_hidden") {
            id = "span_info_panel"
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
                div("ui segment displaynone no_padding") {
                    id = "span_tag_div"
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
                div("ui segment displaynone no_padding_auto") {
                    id = "span_log_div"
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

    block()
}