package giavu.co.jp.spintplaning

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ShowNumberActivity : AppCompatActivity() {

    companion object {

        private const val KEY_NUMBER = "key_number"

        fun createIntent(context: Context, number: String): Intent {
            return Intent(context, ShowNumberActivity::class.java).apply {
                putExtra(KEY_NUMBER, number)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_number)
    }
}
