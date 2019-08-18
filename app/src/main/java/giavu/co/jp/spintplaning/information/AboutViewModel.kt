package giavu.co.jp.spintplaning.information

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @Author: Hoang Vu
 * @Date:   2019-07-09
 */
class AboutViewModel : ViewModel() {

    private val _onClickAboutEvent: MutableLiveData<Unit> = MutableLiveData()
    private val _onClickPrivacyEvent: MutableLiveData<Unit> = MutableLiveData()
    private val _onClickDeveloperEvent: MutableLiveData<Unit> = MutableLiveData()

    val onClickAboutEvent: LiveData<Unit>
        get() = _onClickAboutEvent

    val onClickPrivacyEvent: LiveData<Unit>
        get() = _onClickPrivacyEvent

    val onClickDeveloperEvent: LiveData<Unit>
        get() = _onClickDeveloperEvent

    fun onClickAbout() {
        _onClickAboutEvent.value = Unit
    }

    fun onClickPrivacy() {
        _onClickPrivacyEvent.value = Unit
    }

    fun onClickDeveloper() {
        _onClickDeveloperEvent.value = Unit
    }
}