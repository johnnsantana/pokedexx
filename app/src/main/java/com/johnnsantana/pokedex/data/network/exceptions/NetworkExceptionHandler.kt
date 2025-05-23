package com.johnnsantana.pokedex.data.network.exceptions

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.statement.bodyAsText

suspend fun <T> handleNetworkException(block: suspend () -> T): T {
    return try {
        block()
    } catch (e: ClientRequestException) {
        val errorMessage = e.response.bodyAsText()
        throw NetworkException.ApiException(errorMessage, e.response.status.value)
    } catch (e: Exception) {
        throw NetworkException.UnknownNetworkException(e)
    }
}