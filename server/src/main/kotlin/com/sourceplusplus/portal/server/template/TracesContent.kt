package com.sourceplusplus.portal.server.template

import com.sourceplusplus.portal.server.model.trace.TraceTableType
import com.sourceplusplus.portal.server.model.trace.TraceSpanInfoType
import kotlinx.html.*

fun FlowContent.tracesContent(block: FlowContent.() -> Unit) {
    div("pusher background_color") {
        block()
    }
}

fun FlowContent.tracesTable(block: FlowContent.() -> Unit) {
    div("wide column marginlefting") {
        block()
    }
}

fun FlowContent.topTraceTable(vararg traceTableTypes: TraceTableType = arrayOf()) {
    table("ui celled striped table unstackable secondary_background_color no_top_margin") {
        id = "top_trace_table"
        thead {
            tr {
                for (traceTableType in traceTableTypes) {
                    th(classes = "secondary_background_color ${if (traceTableType.isCentered) "trace_th_center" else "trace_th"}") {
                        + traceTableType.description
                    }
                }
            }
        }
        tbody {
            id = "trace_table"
        }
    }
}

fun FlowContent.traceStackTable(vararg traceTableTypes: TraceTableType = arrayOf()) {
    table("ui celled striped table unstackable trace_stack_table hidden_full_height") {
        id = "trace_stack_table"
        thead("secondary_background_color") {
            tr {
                for (traceTableType in traceTableTypes) {
                    th(classes = "secondary_background_color ${if (traceTableType.isCentered) "trace_th_center" else "trace_th"}") {
                        + traceTableType.description
                    }
                }
            }
        }
        tbody("stack_table_background") {
            id = "stack_table"
        }
    }
}

fun FlowContent.spanInfoPanel(vararg traceSpanInfoTypes: TraceSpanInfoType = arrayOf()) {
    div("visibility_hidden") {
        id = "span_info_panel"
        div("ui segments") {
            div("ui segment span_segment_background") {
                for (traceSpanInfoType in traceSpanInfoTypes) {
                    p {
                        + "${traceSpanInfoType.description}:"
                        span {
                            id = "span_info_${traceSpanInfoType.id1}"
                        }
                        + "("
                        span("trace_time") {
                            id = "span_info_${traceSpanInfoType.id2}"
                        }
                        + ")"
                    }
                }
            }
            div("ui segment displaynone no_padding") {
                id = "span_tag_div"
                table("ui celled striped table unstackable") {
                    id = "span_tag_table"
                    thead {
                        tr {
                            th { + "Tag"}
                            th { + "Value"}
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
                            th { + "Trace Logs"}
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