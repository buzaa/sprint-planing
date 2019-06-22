package giavu.co.jp.spintplaning.show_card

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import giavu.co.jp.spintplaning.R
import giavu.co.jp.spintplaning.databinding.ActivityShowNumberBinding

class ShowNumberActivity : AppCompatActivity() {

    companion object {

        private const val KEY_NUMBER = "key_number"

        fun createIntent(context: Context, number: String): Intent {
            return Intent(context, ShowNumberActivity::class.java).apply {
                putExtra(KEY_NUMBER, number)
            }
        }
    }

    private val choosePointNumber by lazy {
        intent.getStringExtra(KEY_NUMBER) as String
    }

    val viewModel by lazy {
        ViewModelProviders.of(this).get(ShowNumberViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()
        observeViewModel()
    }

    private fun initialize() {
        initDataBinding()
        initViewModel()
    }

    private fun initDataBinding() {
        DataBindingUtil.setContentView<ActivityShowNumberBinding>(
            this, R.layout.activity_show_number
        ).apply {
            viewModel = this@ShowNumberActivity.viewModel
            lifecycleOwner = this@ShowNumberActivity
        }
    }

    private fun initViewModel() {
        viewModel.initialize(choosePointNumber)
    }

    private fun observeViewModel() {
        with(viewModel) {
            closeEvent.observe(this@ShowNumberActivity, Observer {
                finish()
            })
        }
    }
}
