package com.sourceplusplus.portal.server.template

import com.sourceplusplus.portal.server.model.*
import kotlinx.html.*

class PortalNavigationConfiguration(private val flowContent: FlowContent) {
    val menuItems = ArrayList<() -> Unit>()
    val tabItems = ArrayList<() -> Unit>()
    var mode = ModeType.MENU

    fun navItem(pageType: PageType, isActive: Boolean = false, block: FlowContent.(activeClass: String) -> Unit) {
        menuItems.add {
            flowContent.menuItem(pageType, isActive, block)
        }
        tabItems.add {
            flowContent.tabItem(pageType, isActive, block)
        }
    }

    fun navSubItem(activeClass: String = "", vararg traceTypes: TraceType = arrayOf()) {
        when (mode) {
            ModeType.MENU -> flowContent.subMenuItem(*traceTypes)
            ModeType.TAB -> flowContent.subTabItem(activeClass, *traceTypes)
        }
    }
}

fun FlowContent.portalNav(block: PortalNavigationConfiguration.() -> Unit) {
    div("ui sidebar vertical left menu overlay visible very thin icon spp_blue webkit_transition") {
        style = "overflow: visible !important;"
        val items = PortalNavigationConfiguration(this).apply(block)
        menu {
            items.menuItems.forEach {
                it.invoke()
            }
        }
        items.mode = ModeType.TAB
        tabs {
            items.tabItems.forEach {
                it.invoke()
            }
        }
    }
}