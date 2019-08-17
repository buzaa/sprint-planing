package giavu.co.jp.spintplaning.information

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import giavu.co.jp.model.Router
import giavu.co.jp.spintplaning.R
import kotlinx.android.synthetic.main.activity_information.*

class InformationActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_ROUTER = "key_router"
        fun createIntentForUsage(context: Context): Intent {
            return Intent(context, InformationActivity::class.java).apply {
                putExtra(EXTRA_ROUTER, Router.USAGE)
            }
        }

        fun createIntentForGreetings(context: Context): Intent {
            return Intent(context, InformationActivity::class.java).apply {
                putExtra(EXTRA_ROUTER, Router.GREETINGS)
            }
        }
    }

    private val router by lazy {
        intent.getSerializableExtra(EXTRA_ROUTER) as? Router
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)
        initialize()
    }

    private fun initialize() {
        initializeActionBar()
        initView()
    }

    private fun initializeActionBar() {
        supportActionBar?.apply {
            title = when (router) {
                Router.USAGE -> getString(R.string.app_name)
                Router.GREETINGS -> getString(R.string.greetings)
                null -> getString(R.string.app_name)
            }
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_back)
        }
    }

    private fun initView() {
        when (router) {
            Router.USAGE -> {
                content_text.text = getString(R.string.what_is_planning_poker)
                contact.isVisible = false
            }
            Router.GREETINGS -> {
                content_text.apply {
                    text = getString(R.string.greetings_from_dev)
                    textSize = 20F
                }
                contact.isVisible = true
            }
            null -> finish()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

/*    private fun getArrivalTimeWithColor(time: String): CharSequence {
        return HtmlCompat.fromHtml(
            getString(
                R.string.greetings_from_dev,
                getColor(R.color.jtx_pink).toString(),
                time
            ), HtmlCompat.FROM_HTML_MODE_LEGACY
        )
    }*/
}
