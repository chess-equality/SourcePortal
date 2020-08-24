package com.sourceplusplus.portal.server

import io.vertx.ext.web.Route
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import io.vertx.kotlin.core.http.listenAwait
import io.vertx.kotlin.coroutines.CoroutineVerticle
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.launch

class PortalServer : CoroutineVerticle() {

    override suspend fun start() {

        // Build Vert.x Web router
        val router = Router.router(vertx)
        router.get("/overview").coroutineHandler { ctx -> getOverview(ctx) }
        router.get("/traces").coroutineHandler { ctx -> getTraces(ctx) }
        router.get("/configuration").coroutineHandler { ctx -> getConfiguration(ctx) }

        // Start the server
        vertx.createHttpServer()
            .requestHandler(router)
            .listenAwait(config.getInteger("http.port", 8080))
    }

    private suspend fun getOverview(ctx: RoutingContext) {
        ctx.respond("/overview route")
    }

    private suspend fun getTraces(ctx: RoutingContext) {
        ctx.respond("/traces route")
    }

    private suspend fun getConfiguration(ctx: RoutingContext) {
        ctx.respond("/configuration route")
    }

    private fun RoutingContext.respond(respondBody: String = "", status: Int = 200) {
        this.response()
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