package com.sourceplusplus.portal.server.model

enum class TraceTableType(val description: String, val css: String) {
    OPERATION("Operation", "trace_th"),
    OCCURRED("Occurred", "trace_th_center"),
    EXEC("Exec", "trace_th_center"),
    EXEC_PCT("Exec (%)", "trace_th_center"),
    STATUS("Status", "trace_th_center");
}