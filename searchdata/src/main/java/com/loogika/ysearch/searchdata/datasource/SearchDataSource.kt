package com.loogika.ysearch.searchdata.datasource

import com.loogika.ysearch.network.di.DefaultDispatcher
import com.loogika.ysearch.network.di.model.error.ErrorModel
import com.loogika.ysearch.network.di.model.error.ErrorModel.Companion.StatusCode401
import com.loogika.ysearch.network.di.model.error.ErrorModel.Companion.StatusCode422
import com.loogika.ysearch.network.di.model.error.ErrorModel.Companion.StatusCode500
import com.loogika.ysearch.network.di.model.search.NextVideoRequest
import com.loogika.ysearch.network.di.model.search.SearchResponse
import com.loogika.ysearch.network.di.util.ErrorType
import com.loogika.ysearch.network.di.util.ResultType
import com.loogika.ysearch.network.di.util.toErrorMessage
import com.loogika.ysearch.network.di.webservice.WebServiceApi
import com.loogika.ysearch.searchdata.repository.SearchRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.net.SocketTimeoutException
import javax.inject.Inject

class SearchDataSource @Inject constructor(
    private val api: WebServiceApi,
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher,
) : SearchRepository {
    override suspend fun search(text: String, language: String, accent: String): Flow<ResultType<SearchResponse?, ErrorType>> {
        val loanApplicationsResult = kotlin.runCatching {
            val queryResult = api.search(text, language, accent)
            queryResult
        }

        return flow {
            loanApplicationsResult.onSuccess { data ->
                if (data.isSuccessful) {
                    emit(
                        ResultType.Success(
                            data.body()
                        )
                    )
                } else {
                    when (data.code()) {
                        StatusCode401 -> emit(
                            ResultType.Error(
                                ErrorType.NetworkAuthHttpException
                            )
                        )
                        StatusCode422 -> emit(
                            ResultType.Error(
                                ErrorType.Error(
                                    ErrorModel(
                                        code = data.code().toString(),
                                        message = data.errorBody()?.toErrorMessage("") ?: ""
                                    )
                                )
                            )
                        )
                        StatusCode500 -> emit(
                            ResultType.Error(
                                ErrorType.NetworkConnectionHttpException
                            )
                        )
                        else -> emit(
                            ResultType.Error(
                                ErrorType.Error(
                                    ErrorModel(
                                        code = data.code().toString(),
                                        message = data.message()
                                    )
                                )
                            )
                        )
                    }
                }

            }.onFailure { ex ->
                if (ex is SocketTimeoutException) {
                    emit(
                        ResultType.Error(
                            ErrorType.NetworkConnectionHttpException
                        )
                    )
                }

                if (ex is HttpException) {
                    emit(
                        ResultType.Error(
                            ErrorType.NetworkHttpExceptionWithCode(
                                retrofitHttpException = ex
                            )
                        )
                    )
                }
                emit(ResultType.Error(ErrorType.Exception(ex)))
            }

        }.flowOn(dispatcher)
    }

    override suspend fun nextVideo(parameter: NextVideoRequest): Flow<ResultType<SearchResponse?, ErrorType>> {
        TODO("Not yet implemented")
    }

}