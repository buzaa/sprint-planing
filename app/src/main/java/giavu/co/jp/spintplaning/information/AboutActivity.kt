package giavu.co.jp.spintplaning.information

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import giavu.co.jp.spintplaning.R
import giavu.co.jp.spintplaning.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, AboutActivity::class.java)
        }
    }

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(AboutViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()
        observeViewModel()
    }

    private fun initialize() {
        initializeActionBar()
        initDatabinding()
    }

    private fun initDatabinding() {
        DataBindingUtil.setContentView<ActivityAboutBinding>(
            this, R.layout.activity_about
        ).apply {
            viewModel = this@AboutActivity.viewModel
            lifecycleOwner = this@AboutActivity
        }
    }

    private fun initializeActionBar() {
        supportActionBar?.apply {
            title = getString(R.string.label_about)
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_clear)
        }
    }

    private fun observeViewModel() {
        with(viewModel) {
            onClickAboutEvent.observe(this@AboutActivity, Observer {
                startActivity(InformationActivity.createIntent(this@AboutActivity))
            })

            onClickPrivacyEvent.observe(this@AboutActivity, Observer {
                startActivity(PrivacyActivity.createIntent(this@AboutActivity))
            })
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
