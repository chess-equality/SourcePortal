package com.sourceplusplus.portal.server.model

enum class ArtifactInfoType(val id: String, val description: String) {
    QUALIFIED_NAME("qualified_name", "Qualified Name"),
    CREATE_DATE("create_date", "Create Date"),
    LAST_UPDATED("last_updated", "Last Updated"),
    ENDPOINT("endpoint", "Endpoint")
}