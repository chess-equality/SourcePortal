package com.sourceplusplus.portal.server.model

enum class TraceStackHeaderType(val id: String, val cssClasses: String) {
    TRACE_ID("trace_id", "crosshairs no_padding_top"),
    TIME_OCCURRED("time_occurred", "clock outline no_padding_top")
}