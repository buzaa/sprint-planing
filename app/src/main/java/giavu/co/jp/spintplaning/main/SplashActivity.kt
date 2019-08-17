package giavu.co.jp.spintplaning.main

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import giavu.co.jp.spintplaning.R
import giavu.co.jp.spintplaning.databinding.ActivitySplashBinding
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    companion object {
        private const val ANIMATION_DELAY_SHOW = 600L
    }

    val viewModel by lazy {
        ViewModelProviders.of(this).get(SplashViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initialize()
        observeViewModel()
    }

    private fun initialize() {
        initializeDataBinding()
        initializeView()
    }

    private fun initializeView() {
        introduce_text.startAnimation(
            AnimationUtils.loadAnimation(
                this,
                R.anim.fade_in
            ).apply {
                startOffset = ANIMATION_DELAY_SHOW
            }
        )
        start_button.startAnimation(
            AnimationUtils.loadAnimation(
                this,
                R.anim.transition_up
            ).apply {
                startOffset = ANIMATION_DELAY_SHOW + 300L
            }
        )
    }

    private fun initializeDataBinding() {
        DataBindingUtil.setContentView<ActivitySplashBinding>(
            this, R.layout.activity_splash
        ).apply {
            viewModel = this@SplashActivity.viewModel
            lifecycleOwner = this@SplashActivity
        }
    }

    private fun observeViewModel() {
        with(viewModel) {
            buttonStartEvent.observe(this@SplashActivity, Observer {
                startActivity(MainActivity.createIntent(this@SplashActivity))
            })
        }
    }
}
