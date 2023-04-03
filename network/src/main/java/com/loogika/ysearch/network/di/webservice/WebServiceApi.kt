package com.loogika.ysearch.network.di.webservice

import com.loogika.ysearch.network.di.model.Data
import com.loogika.ysearch.network.di.model.home.HomeResponse
import com.loogika.ysearch.network.di.model.proposal.ProposalResponse
import com.loogika.ysearch.network.di.model.schedule.ScheduleResponse
import retrofit2.Response
import retrofit2.http.GET

interface WebServiceApi {

    @GET("josearroyo/getHome")
    suspend fun getHomeInfo() : Response<Data<HomeResponse>>

    @GET("josearroyo/getProposal")
    suspend fun getProposalInfo() : Response<Data<List<ProposalResponse>>>

    @GET("josearroyo/getSchedule")
    suspend fun getScheduleInfo() : Response<Data<List<ScheduleResponse>>>
}