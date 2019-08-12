package giavu.co.jp.model

import java.io.Serializable

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-12
 */
data class AppData(
    val appRelease: String,
    val appSummary: String
) : Serializable