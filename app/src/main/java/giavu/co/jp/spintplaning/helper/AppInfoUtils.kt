package giavu.co.jp.spintplaning.helper

import giavu.co.jp.spintplaning.BuildConfig

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-17
 */
object AppInfoUtils {
    fun getAppInfo(): String {
        return StringBuilder()
            .append(BuildConfig.VERSION_NAME)
            .append(" (")
            .append(BuildConfig.VERSION_CODE)
            .append(")")
            .toString()
    }
}