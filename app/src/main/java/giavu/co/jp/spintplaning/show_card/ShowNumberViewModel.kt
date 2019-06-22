package giavu.co.jp.spintplaning.show_card

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @Author: Hoang Vu
 * @Date:   2019-06-22
 */

class ShowNumberViewModel : ViewModel() {
    private val _readyVisibility: MutableLiveData<Int> = MutableLiveData()
    private val _pointVisibility: MutableLiveData<Int> = MutableLiveData()
    private val _closeEvent: MutableLiveData<Unit> = MutableLiveData()
    private val _point: MutableLiveData<String> = MutableLiveData()

    val readyVisibility: LiveData<Int>
        get() = _readyVisibility

    val pointVisibility: LiveData<Int>
        get() = _pointVisibility

    val closeEvent: LiveData<Unit>
        get() = _closeEvent

    val point: LiveData<String>
        get() = _point

    fun initialize(point: String) {
        _readyVisibility.value = View.VISIBLE
        _pointVisibility.value = View.GONE
        _point.value = point
    }

    fun readyClick() {
        _readyVisibility.value = View.GONE
        _pointVisibility.value = View.VISIBLE
    }

    fun pointClick() {
        _closeEvent.value = Unit
    }
}