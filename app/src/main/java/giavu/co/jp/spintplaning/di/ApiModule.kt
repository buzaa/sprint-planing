package giavu.co.jp.spintplaning.di

import giavu.co.jp.repository.DataStoreApi
import giavu.co.jp.repository.DataStoreApiImpl
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-14
 */
class ApiModule {
    val module: Module = module {
        single<DataStoreApi> { DataStoreApiImpl() }
    }
}