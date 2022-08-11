package br.com.portal.cryptocurrency.di

import br.com.portal.cryptocurrency.commom.Constants
import br.com.portal.cryptocurrency.data.remote.CoinPaprikaApi
import br.com.portal.cryptocurrency.data.repository.CoinRepositoryImpl
import br.com.portal.cryptocurrency.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn( SingletonComponent::class ) // this garanted the object will live for whole lifetime app
object AppModule {

    @Provides
    @Singleton // this garanted there only instace in whole project
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl( Constants.BASE_URL )
            .addConverterFactory( GsonConverterFactory.create() )
            .build()
            .create( CoinPaprikaApi::class.java )
    }

    @Provides
    @Singleton
    fun provideCoinRepository( api: CoinPaprikaApi ): CoinRepository {
        return CoinRepositoryImpl( api )
    }
}