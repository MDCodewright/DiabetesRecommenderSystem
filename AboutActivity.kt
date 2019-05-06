package ke.co.codewright.diabetesrecommendersystem.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ke.co.codewright.diabetesrecommendersystem.R


class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

//        supportActionBar?.title = intent.getStringExtra(AppConstants.FIT_NAME)
    }
}
