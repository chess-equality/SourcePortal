package com.sourceplusplus.portal.server

import io.vertx.ext.web.Route
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.handler.StaticHandler
import io.vertx.kotlin.core.http.listenAwait
import io.vertx.kotlin.coroutines.CoroutineVerticle
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.launch

import com.sourceplusplus.portal.server.page.OverviewPage
import com.sourceplusplus.portal.server.page.TracesPage
import com.sourceplusplus.portal.server.page.ConfigurationPage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Suppress("unused")
class PortalServer : CoroutineVerticle() {

    override suspend fun start() {
        // Build Vert.x Web router
        val router = Router.router(vertx)

        // Static handler
        router.route("/*").handler(StaticHandler.create())
        // Routes
        router.get("/overview*").coroutineHandler { ctx -> getOverview(ctx) }
        router.get("/traces*").coroutineHandler { ctx -> getTraces(ctx) }
        router.get("/configuration*").coroutineHandler { ctx -> getConfiguration(ctx) }

        // Start the server
        vertx.createHttpServer()
            .requestHandler(router)
            .listenAwait(config.getInteger("http.port", 8080))
    }

    private suspend fun getOverview(ctx: RoutingContext) {
        withContext(Dispatchers.Default) {
            ctx.respond(OverviewPage().renderPage())
        }
    }

    private suspend fun getTraces(ctx: RoutingContext) {
        withContext(Dispatchers.Default) {
            ctx.respond(TracesPage().renderPage())
        }
    }

    private suspend fun getConfiguration(ctx: RoutingContext) {
        withContext(Dispatchers.Default) {
            ctx.respond(ConfigurationPage().renderPage())
        }
    }

    private fun RoutingContext.respond(respondBody: String = "", status: Int = 200) {
        response()
            .putHeader("content-type", "text/html")
            .setStatusCode(status)
            .end(respondBody)
    }

    private fun Route.coroutineHandler(fn: suspend (RoutingContext) -> Unit) {
        handler { ctx ->
            launch(ctx.vertx().dispatcher()) {
                try {
                    fn(ctx)
                } catch (e: Exception) {
                    ctx.fail(e)
                }
            }
        }
    }
}