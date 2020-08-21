package com.sourceplusplus.portal.server

class PortalServer {
}

//import com.apollographql.apollo.ApolloClient
//import com.apollographql.apollo.api.toJson
//import com.apollographql.apollo.coroutines.toDeferred
//import com.apollographql.apollo.exception.ApolloException
//import com.sourceplusplus.portal.shared.model.metadata.GetTimeInfoQuery
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.runBlocking
//import okio.ByteString.Companion.encodeUtf8
//
//fun main() = runBlocking {
//    val apolloClient = ApolloClient.builder()
//        .serverUrl("http://localhost:12800/graphql")
//        .build()
//
//    val job = launch {
//        val response = try {
//            apolloClient.query(GetTimeInfoQuery()).toDeferred().await()
//        } catch (e: ApolloException) {
//            println(e)
//            return@launch
//        }
//
//        var countries = response.data!!.toJson()
//        var countries2 = GetTimeInfoQuery().parse(countries.encodeUtf8())
//        println(countries2.data!!.result!!.timezone)
//        if (countries == null || response.hasErrors()) {
//            println(response)
//            return@launch
//        } else {
//            println(countries)
//        }
//    }
//
//    job.join()
//}