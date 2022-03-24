package com.example.texttalkmedia.data.utils

import kotlinx.coroutines.flow.*
import java.lang.Exception


fun <ResultType, RequestType> networkBoundResource(
    query: () -> Flow<ResultType>,
    fetch: suspend () -> RequestType,
    saveFetchResult: suspend (RequestType) -> Unit,
    shouldFetch: (ResultType) -> Boolean = { true }
) = flow {
    val data = query().first()
    val flow = if (shouldFetch(data)) {
        emit(Resource.Loading(data))
        try {
            saveFetchResult(fetch())
            query().map { Resource.Success(it) }
        } catch (e: Exception) {
            query().map { e.message?.let { e -> Resource.Error(e, it) } }
        }
    } else {
        query().map { Resource.Success(it) }
    }

    emitAll(flow)
}