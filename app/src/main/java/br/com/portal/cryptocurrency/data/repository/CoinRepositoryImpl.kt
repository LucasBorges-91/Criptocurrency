package br.com.portal.cryptocurrency.data.repository

import br.com.portal.cryptocurrency.data.remote.CoinPaprikaApi
import br.com.portal.cryptocurrency.data.remote.dto.CoinDetailDto
import br.com.portal.cryptocurrency.data.remote.dto.CoinDto
import br.com.portal.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById( coinId: String ): CoinDetailDto {
        return api.getCoinById( coinId )
    }
}