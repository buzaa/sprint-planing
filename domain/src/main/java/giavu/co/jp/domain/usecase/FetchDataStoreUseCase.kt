package giavu.co.jp.domain.usecase

import giavu.co.jp.model.AppData
import giavu.co.jp.model.AppInfo
import giavu.co.jp.repository.DataStoreApi
import io.reactivex.Single

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-12
 */
class FetchDataStoreUseCase(val dataStoreApi: DataStoreApi) {

    operator fun invoke(): Single<List<AppData>> {
        return dataStoreApi.get()
            .map { appInfos ->
                appInfos.map { mapper(it) }
            }
    }

    private fun mapper(appInfo: AppInfo): AppData {
        return AppData(
            appRelease = appInfo.appVersionCode,
            appSummary = appInfo.appVersionCode + appInfo.appVersionName
        )
    }

}