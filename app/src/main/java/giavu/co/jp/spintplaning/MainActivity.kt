package giavu.co.jp.spintplaning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import giavu.co.jp.spintplaning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

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
            numberValue.observe(this@MainActivity, Observer {
                startActivity(ShowNumberActivity.createIntent(this@MainActivity, it))
            })
        }
    }
}
