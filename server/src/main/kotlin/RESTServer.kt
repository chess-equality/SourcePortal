import io.vertx.core.Vertx

fun main() {
    val vertx = Vertx.vertx()
    val server = vertx.createHttpServer()
    server.requestHandler { request ->
        val response = request.response()
        response.putHeader("content-type", "text/plain")
        response.end("Hello Vert.x!")
    }
    server.listen(8080)
}