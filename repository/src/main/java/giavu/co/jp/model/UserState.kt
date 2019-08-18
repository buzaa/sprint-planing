package giavu.co.jp.model

import android.service.autofill.UserData

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-17
 */
sealed class UserState {
    class UserInfo(userInfo: UserData) : UserState()
    object NoneUser : UserState()
}