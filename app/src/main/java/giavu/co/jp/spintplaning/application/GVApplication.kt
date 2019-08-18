package giavu.co.jp.spintplaning.application

import android.app.Application
import giavu.co.jp.spintplaning.di.KoinInitializer

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-14
 */

open class GVApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInitializer(this).initialize()
    }
}