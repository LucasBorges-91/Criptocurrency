package br.com.portal.cryptocurrency.data.remote

import br.com.portal.cryptocurrency.data.remote.dto.CoinDetailDto
import br.com.portal.cryptocurrency.data.remote.dto.CoinDto
import br.com.portal.cryptocurrency.domain.model.Coin
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET( "/v1/coins" )
    suspend fun getCoins(): List<CoinDto>

    @GET( "v1/coins/{coinId}" )
    suspend fun getCoinById( @Path( "coinId" ) coinId: String ): CoinDetailDto
}