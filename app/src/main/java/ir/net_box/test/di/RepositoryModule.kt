package ir.net_box.test.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.net_box.test.data.repository.VideoRepositoryImpl
import ir.net_box.test.domain.repository.VideoRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindVideoRepository(
        impl: VideoRepositoryImpl
    ): VideoRepository
}