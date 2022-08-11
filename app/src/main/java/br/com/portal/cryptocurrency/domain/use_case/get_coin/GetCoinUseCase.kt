package br.com.portal.cryptocurrency.domain.use_case.get_coin

import br.com.portal.cryptocurrency.commom.Resource
import br.com.portal.cryptocurrency.data.remote.dto.toCoin
import br.com.portal.cryptocurrency.data.remote.dto.toCoinDetail
import br.com.portal.cryptocurrency.domain.model.Coin
import br.com.portal.cryptocurrency.domain.model.CoinDetail
import br.com.portal.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke( coinId: String ): Flow<Resource<CoinDetail>> = flow {
        try {
            emit( Resource.Loading() )
            val coin = repository.getCoinById( coinId ).toCoinDetail()
            emit( Resource.Success( coin ) )
        } catch ( e: HttpException ) {
            emit( Resource.Error( e.localizedMessage ?: "An unexpected error occured" ) )
        } catch ( e: IOException ) {
            emit( Resource.Error( "Couldn't reach server. Check your internet connection" ) )
        }
    }
}