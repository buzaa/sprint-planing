package giavu.co.jp.spintplaning.information

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @Author: Hoang Vu
 * @Date:   2019-07-09
 */
class AboutViewModel : ViewModel() {

    private val _onClickAbout: MutableLiveData<Unit> = MutableLiveData()
    private val _onClickPrivacy: MutableLiveData<Unit> = MutableLiveData()

    val onClickAboutEvent: LiveData<Unit>
        get() = _onClickAbout

    val onClickPrivacyEvent: LiveData<Unit>
        get() = _onClickPrivacy


    fun onClickAbout() {
        _onClickAbout.value = Unit
    }

    fun onClickPrivacy() {
        _onClickPrivacy.value = Unit
    }
}