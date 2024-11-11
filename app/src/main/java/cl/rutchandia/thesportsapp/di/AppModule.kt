package cl.rutchandia.thesportsapp.di

import cl.rutchandia.thesportsapp.data.repository.CountryRepositoryImpl
import cl.rutchandia.thesportsapp.domain.repository.CountryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    abstract fun bindsCountryRepository(repository: CountryRepositoryImpl): CountryRepository
}
