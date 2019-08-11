package giavu.co.jp.spintplaning.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-11
 */
class SplashViewModel : ViewModel() {

    private val _buttonStartEvent = MutableLiveData<Unit>()
    val buttonStartEvent: LiveData<Unit>
        get() = _buttonStartEvent

    fun startGame() {
        _buttonStartEvent.value = Unit
    }

}