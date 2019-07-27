package giavu.co.jp.spintplaning.activity

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
    private val _selectSmallEvent: MutableLiveData<Unit> = MutableLiveData()
    private val _selectMediumEvent: MutableLiveData<Unit> = MutableLiveData()
    private val _selectLargeEvent: MutableLiveData<Unit> = MutableLiveData()

    val pointSelectEvent: LiveData<String>
        get() = _pointSelectEvent

    val informationEvent: LiveData<Unit>
        get() = _informationEvent

    val selectSmallEvent: LiveData<Unit>
        get() = _selectSmallEvent

    val selectMediumEvent: LiveData<Unit>
        get() = _selectMediumEvent

    val selectLargeEvent: LiveData<Unit>
        get() = _selectLargeEvent

    fun selectPoint(number: Int) {
        _pointSelectEvent.value = number.toString()
    }

    fun floatClick() {
        _pointSelectEvent.value = "1/2"
    }

    fun showInformation() {
        _informationEvent.value = Unit
    }

    fun selectSmall() {
        _selectSmallEvent.value = Unit
    }

    fun selectMedium() {
        _selectMediumEvent.value = Unit
    }

    fun selectLarge() {
        _selectLargeEvent.value = Unit
    }
}