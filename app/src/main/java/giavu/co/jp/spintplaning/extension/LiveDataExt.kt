package giavu.co.jp.spintplaning.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-11
 */
/**
 * Remove the observer after received the first result
 * @param observer
 */

fun <T> LiveData<T>.observeOnce(observer: (T) -> Unit) {
    observeForever(object : Observer<T> {
        override fun onChanged(value: T) {
            removeObserver(this)
            observer(value)
        }
    })
}

/**
 * Remove the observer after received the first result
 * @param observer
 * @param owner
 */

fun <T> LiveData<T>.observeOnce(owner: LifecycleOwner, observer: (T) -> Unit) {
    observe(owner, object : Observer<T> {
        override fun onChanged(value: T) {
            removeObserver(this)
            observer(value)
        }
    })
}