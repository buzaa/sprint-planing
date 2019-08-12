package giavu.co.jp.domain.usecase

import giavu.co.jp.model.AppData
import giavu.co.jp.repository.DataStoreApi
import io.reactivex.Observable

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-12
 */
class DataStoreUseCase(val dataStoreApi: DataStoreApi) {

    fun fetch(): Observable<AppData> {
        return dataStoreApi.fetch().toObservable()
            .flatMapIterable {
                it.map { info ->
                    AppData(info.appVersionCode, info.appVersionName)
                }
            }
    }

}