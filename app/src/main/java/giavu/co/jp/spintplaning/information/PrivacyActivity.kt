package giavu.co.jp.spintplaning.information

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Base64
import android.view.MenuItem
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import de.psdev.licensesdialog.NoticesHtmlBuilder
import de.psdev.licensesdialog.NoticesXmlParser
import giavu.co.jp.spintplaning.R

class PrivacyActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, PrivacyActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_privacy)
        initialize()

    }

    private fun initialize() {
        initializeActionBar()
        setupWebView()
    }

    private fun initializeActionBar() {
        supportActionBar?.apply {
            title = getString(R.string.label_privacy)
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_back)
        }
    }

    private fun setupWebView() {
        val webView = findViewById<WebView>(R.id.web_view)
        try {
            val html = NoticesHtmlBuilder.create(applicationContext)
                .setNotices(NoticesXmlParser.parse(resources.openRawResource(R.raw.notices)))
                .build()
            val data = Base64.encodeToString(html.toByteArray(), Base64.NO_PADDING)
            webView.loadData(data, "text/html", "base64")
        } catch (e: Exception) {
            finish()
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
