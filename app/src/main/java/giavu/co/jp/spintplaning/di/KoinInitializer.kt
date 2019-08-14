package giavu.co.jp.spintplaning.di

import android.app.Application
import org.koin.android.ext.android.startKoin

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-14
 */
class KoinInitializer(private val application: Application) {
    fun initialize() {
        application.startKoin(
            androidContext = application,
            modules = Modules().get()
        )
    }
}