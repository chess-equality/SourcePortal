package com.sourceplusplus.portal.server.model

enum class ChartItemType(val id: String, val description: String, val label: String) {
    AVG_THROUGHPUT("throughput", "Throughput", "THROUGHPUT"),
    AVG_RESPONSE_TIME("responsetime", "ResponseTime", "RESP TIME"),
    AVG_SLA("servicelevelagreement", "SLA", "SLA")
}