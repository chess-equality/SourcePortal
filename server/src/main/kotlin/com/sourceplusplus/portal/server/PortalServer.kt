package com.sourceplusplus.portal.server

class PortalServer {
}

//import com.apollographql.apollo.ApolloClient
//import com.apollographql.apollo.coroutines.toDeferred
//import com.apollographql.apollo.exception.ApolloException
//import com.sourceplusplus.portal.shared.model.metadata.GetTimeInfoQuery
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.runBlocking
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
//        val countries = response.data?.result
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