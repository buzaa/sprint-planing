package giavu.co.jp.spintplaning.binding

import android.util.Log
import android.view.View
import androidx.databinding.BindingAdapter

/**
 * @Author: Hoang Vu
 * @Date:   2019-06-22
 */
@BindingAdapter("android:onClick")
fun setClick(view: View, listener: View.OnClickListener) {
    view.setOnProtectBarrageClickListener(listener)
}