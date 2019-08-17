package giavu.co.jp.spintplaning.di

import giavu.co.jp.domain.usecase.FetchDataStoreUseCase
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-14
 */
class UseCaseModule {
    val module: Module = module {
        single { FetchDataStoreUseCase(dataStoreApi = get()) }
    }
}