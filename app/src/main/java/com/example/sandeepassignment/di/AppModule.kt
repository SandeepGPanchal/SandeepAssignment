package com.example.sandeepassignment.di

import android.content.Context
import com.example.sandeepassignment.data.network.MovieApi
import com.example.sandeepassignment.repository.MovieRepository
import com.example.sandeepassignment.repository.MovieRepositoryImp
import com.example.sandeepassignment.utils.ConnectivityInterceptor
import com.example.sandeepassignment.utils.Constants.Companion.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesOkHttp(@ApplicationContext context: Context) = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.MINUTES)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(ConnectivityInterceptor(context))
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()


    @Singleton
    @Provides
    fun providesMovieApi(retrofit: Retrofit) = retrofit.create(MovieApi::class.java)


    @Singleton
    @Provides
    fun providesProductRepository(movieApi: MovieApi) =
        MovieRepositoryImp(movieApi) as MovieRepository
}