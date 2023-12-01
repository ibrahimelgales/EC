package com.easycashwallet.tasks.utils.exception_handler

import com.easycashwallet.tasks.utils.extention.json
import com.google.gson.Gson
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import retrofit2.Response
import java.io.IOException
import java.net.ConnectException
import java.net.UnknownHostException


class CustomExceptionManager {


    open class EcThrowable(msg: String?, throwable: Throwable?) : Throwable(msg, throwable)

    class EcThrowableException(
        msg: String?,
        responseCode: Int,
    ) : EcThrowable(
        msg, Throwable(
            message = ApiErrorResponse(
                msg,
                responseCode,
            ).json()
        )
    )

    //region main parser
    @Throws
    fun <T> parseApiException(flow: Flow<Response<T>>): Flow<T> = flow.map {
        try {
            if (it.isSuccessful) {
                parseSuccessResponse(it)
            } else {
                throw parseErrorResponse(it)
            }
        } catch (e: Exception) {
            throw extracted(it.code(), e)
        }

    }.catch {
        val message = when (it) {
            is UnknownHostException -> "Network not available"
            else -> it.message
        }
        throw EcThrowable(message, it)
    }.flowOn(Dispatchers.IO)


    //endregion


    private fun <T> parseSuccessResponse(it: Response<T>) =
        it.body() ?: throw createEcThrowableException(
            "Unknown Error", it.code()
        )


    @Throws
    private fun <T> parseErrorResponse(it: Response<T>): EcThrowableException {
        val resError = apiErrorResponse(it)
        return createEcThrowableException(
            resError?.errorMessage() ?: "Unknown Error",
            it.code(),
        )
    }


    private fun extracted(code: Int, throwable: Throwable) = createEcThrowableException(
        if (shouldEscapeError(throwable)) null else (throwable.message ?: throwable.localizedMessage
        ?: "Unknown Error"), code
    )

    private fun shouldEscapeError(throwable: Throwable) = when (throwable) {
        is ConnectException, is CancellationException, is IOException -> true
        else -> false
    }

    private fun createEcThrowableException(
        msg: String?,
        responseCode: Int,

        ) = EcThrowableException(
        msg, responseCode,
    )

    private fun <T> apiErrorResponse(response: Response<T>) = try {
        Gson().fromJson(response.errorBody()?.string(), ApiErrorResponse::class.java)
    } catch (e: Exception) {
        null
    }
}