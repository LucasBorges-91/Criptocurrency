package br.com.portal.cryptocurrency.presentation.coin_detail

import br.com.portal.cryptocurrency.domain.model.Coin
import br.com.portal.cryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
