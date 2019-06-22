package giavu.co.jp.spintplaning

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @Author: Hoang Vu
 * @Date:   2019-06-22
 */
class MainViewModel : ViewModel() {

    companion object {
        const val TAG = "MainViewModel"
    }

    private val _numberValue: MutableLiveData<String> = MutableLiveData()
    val numberValue: LiveData<String>
        get() = _numberValue

    fun numberClick(number: Int) {
        _numberValue.value = number.toString()
    }

    fun floatClick() {
        _numberValue.value = "1/2"
    }

    fun optionClick() {

    }
}