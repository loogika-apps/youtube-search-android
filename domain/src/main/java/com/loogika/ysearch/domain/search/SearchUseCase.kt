package com.josearroyo.app.domain.proposal

import com.josearroyo.app.domain.proposal.mapper.toProposalResult
import com.josearroyo.app.domain.usecase.EmptyParameterFlowUseCase
import com.josearroyo.app.domain.viewstate.UIState
import com.josearroyo.app.proposaldata.datasource.ProposalDataSource
import com.josearroyo.app.proposaldata.model.ProposalResult
import com.loogika.mikroisp.network.di.util.ErrorType
import com.loogika.mikroisp.network.di.util.ResultType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetProposalUseCase @Inject constructor(
    private val proposalDataSource: ProposalDataSource,
) : EmptyParameterFlowUseCase<List<ProposalResult>>() {
    override suspend fun execute()
            : Flow<UIState<List<ProposalResult>>> =
        proposalDataSource.getProposalInfo()
            .map { result ->
                if (result is ResultType.Success) {
                    return@map UIState.Success(
                        result.value?.map { it.toProposalResult() } ?: emptyList()
                    )
                }

                if (result is ResultType.Error) {
                    val error = result.value
                    if (error is ErrorType.Error) {
                        return@map UIState.FailureErrorModel(error.errorModel)
                    }
                    if (error is ErrorType.Exception) {
                        return@map UIState.Failure(error)
                    }
                    if (error is ErrorType.NetworkConnectionHttpException) {
                        return@map UIState.ConnectionError
                    }
                    if (error is ErrorType.NetworkAuthHttpException) {
                        return@map UIState.UnAuthorized
                    }
                }

                UIState.UnExpectedError
            }
}