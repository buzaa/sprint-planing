package giavu.co.jp.spintplaning.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @Author: Hoang Vu
 * @Date:   2019-06-22
 */
class MainViewModel : ViewModel() {

    private val _pointSelectEvent: MutableLiveData<String> = MutableLiveData()
    private val _informationEvent: MutableLiveData<Unit> = MutableLiveData()

    val pointSelectEvent: LiveData<String>
        get() = _pointSelectEvent

    val informationEvent: LiveData<Unit>
        get() = _informationEvent

    fun selectPoint(number: Int) {
        _pointSelectEvent.value = number.toString()
    }

    fun floatClick() {
        _pointSelectEvent.value = "1/2"
    }

    fun showInformation() {
        _informationEvent.value = Unit
    }
}