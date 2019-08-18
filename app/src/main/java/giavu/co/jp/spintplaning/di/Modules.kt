package giavu.co.jp.spintplaning.di

import org.koin.dsl.module.Module

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-14
 */
class Modules {
    fun get(): List<Module> = listOf(
        ApiModule().module,
        UseCaseModule().module
    )
}