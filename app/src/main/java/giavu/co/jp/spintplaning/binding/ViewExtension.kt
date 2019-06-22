package giavu.co.jp.spintplaning.binding

import android.annotation.SuppressLint
import android.view.View
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

@SuppressLint("CheckResult")
fun View.setOnProtectBarrageClickListener(callback: () -> Unit) {
    RxView.clicks(this)
            .throttleFirst(1000L, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { callback() }
}

@SuppressLint("CheckResult")
fun View.setOnProtectBarrageClickListener(listener: View.OnClickListener) {
    RxView.clicks(this)
        .throttleFirst(1000L, TimeUnit.MILLISECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe { listener.onClick(this) }
}