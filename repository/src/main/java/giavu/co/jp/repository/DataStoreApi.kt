package giavu.co.jp.repository

import giavu.co.jp.model.AppInfo
import io.reactivex.Single

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-12
 */
interface DataStoreApi {
    fun fetch(): Single<List<AppInfo>>
}

class DataStoreApiImpl : DataStoreApi {
    override fun fetch(): Single<List<AppInfo>> {
        return Single.fromCallable {
            val appInfos = mutableListOf<AppInfo>()
            appInfos.apply {
                add(0, AppInfo(appVersionCode = "1", appVersionName = "11"))
                add(1, AppInfo(appVersionCode = "2", appVersionName = "12"))
                add(2, AppInfo(appVersionCode = "3", appVersionName = "13"))
                add(3, AppInfo(appVersionCode = "4", appVersionName = "14"))
            }
        }
    }
}