package com.sourceplusplus.portal.server.model

enum class ChartItemType(val type: String, val id: String, val description: String, val label: String) {
    AVG_THROUGHPUT("average", "throughput", "Throughput", "THROUGHPUT"),
    AVG_RESPONSE_TIME("average","responsetime", "ResponseTime", "RESP TIME"),
    AVG_SLA("average","servicelevelagreement", "SLA", "SLA")
}