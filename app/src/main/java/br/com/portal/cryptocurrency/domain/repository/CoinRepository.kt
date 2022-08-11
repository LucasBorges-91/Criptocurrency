package br.com.portal.cryptocurrency.domain.repository

import br.com.portal.cryptocurrency.data.remote.dto.CoinDetailDto
import br.com.portal.cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById( coinId: String ): CoinDetailDto
}