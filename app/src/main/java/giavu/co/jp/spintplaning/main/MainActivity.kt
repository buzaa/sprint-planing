package giavu.co.jp.spintplaning.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import giavu.co.jp.spintplaning.R
import giavu.co.jp.spintplaning.databinding.ActivityMainBinding
import giavu.co.jp.spintplaning.information.AboutActivity
import giavu.co.jp.spintplaning.show_card.ShowNumberActivity

class MainActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    val viewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()
        observeViewModel()
    }

    private fun initialize() {
        initializeDataBinding()
    }

    private fun initializeDataBinding() {
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        ).apply {
            viewModel = this@MainActivity.viewModel
            lifecycleOwner = this@MainActivity
        }
    }

    private fun observeViewModel() {
        with(viewModel) {
            pointSelectEvent.observe(this@MainActivity, Observer {
                startActivity(ShowNumberActivity.createIntent(this@MainActivity, it))
            })

            informationEvent.observe(this@MainActivity, Observer {
                startActivity(AboutActivity.createIntent(this@MainActivity))
            })
        }
    }
}
