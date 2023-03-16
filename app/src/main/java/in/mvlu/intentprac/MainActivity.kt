package `in`.mvlu.intentprac

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var buttonCall: AppCompatButton
    private lateinit var buttonDial: AppCompatButton
    private lateinit var buttonBrowser: AppCompatButton
    private lateinit var buttonHome: AppCompatButton
    private lateinit var buttonActivityLifeCycle: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCall = findViewById(R.id.btn_implicit_call)
        buttonDial = findViewById(R.id.btn_implicit_dial)
        buttonBrowser = findViewById(R.id.btn_implicit_browser)
        buttonHome = findViewById(R.id.btn_home)


        buttonCall.setOnClickListener{
            if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE),100)
            } else {
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+91123456789"))
                startActivity(intent)
            }
        }

        buttonDial.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+91123456789"))
            startActivity(intent)
        }

        buttonBrowser.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/"))
            startActivity(intent)
        }

        buttonHome.setOnClickListener{
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }


        }
    }

