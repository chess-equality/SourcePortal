package com.sourceplusplus.portal.server.template

import kotlinx.html.*

fun FlowContent.menu(classes: String = "ui accordion displaynone",
                     block: DIV.() -> Unit) {
    div(classes) {
        a(classes = "item openbtn openbtn_background_white") {
            +"""Close menu"""
        }
        a(classes = "item active_tab") { +"""Dashboard""" }
        div("title item inactive_tab") {
            i("dropdown icon") {
            }
            +"""Traces"""
        }
        div("content") {
            a(classes = "item sidebar_sub_text_color") {
                id = "sidebar_traces_link_latest"
                href = "traces"
                +"Latest"
            }
            a(classes = "item sidebar_sub_text_color") {
                id = "sidebar_traces_link_slowest"
                href = "traces"
                +"Slowest"
            }
            a(classes = "item sidebar_sub_text_color") {
                id = "sidebar_traces_link_failed"
                href = "traces"
                +"Failed"
            }
        }
        a(classes = "item inactive_tab") {
            id = "sidebar_configuration_link"
            href = "configuration"
            +"""Configuration"""
        }

        block()
    }
}