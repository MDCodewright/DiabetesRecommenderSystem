package ke.co.codewright.diabetesrecommendersystem.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import androidx.core.widget.NestedScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import android.view.View
import android.widget.EditText
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

import ke.co.codewright.diabetesrecommendersystem.R

import ke.co.codewright.diabetesrecommendersystem.helpers.InputValidation
import ke.co.codewright.diabetesrecommendersystem.User
import ke.co.codewright.diabetesrecommendersystem.server.Newuser
import ke.co.codewright.diabetesrecommendersystem.server.ServerInterface
import ke.co.codewright.diabetesrecommendersystem.sql.DatabaseHelper
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(){

    private var activity = this@RegisterActivity

//    private var nestedScrollView: NestedScrollView? = null
//
//    private var textInputLayoutName: TextInputLayout? = null
//    private var textInputLayoutEmail: TextInputLayout? = null
//    private var textInputLayoutPassword: TextInputLayout? = null
//    private var textInputLayoutConfirmPassword: TextInputLayout? = null
//
//    private var textInputEditTextName: TextInputEditText? = null
//    private var textInputEditTextEmail: TextInputEditText? = null
//    private var textInputEditTextPassword: TextInputEditText? = null
//    private var textInputEditTextConfirmPassword: TextInputEditText? = null

//    private var registerButton: AppCompatButton? = null
//    private var appCompatTextViewLoginLink: AppCompatTextView? = null
            //db side
    private var user: User? = null    /**
     * This method is to initialize views
     */
//    private fun initViews() {
//        nestedScrollView = findViewById<View>(R.id.nestedScrollView) as NestedScrollView
//
////        textInputLayoutName = findViewById<View>(R.id.textInputLayoutName) as TextInputLayout
//        textInputLayoutEmail = findViewById<View>(R.id.textInputLayoutEmail) as TextInputLayout
//        textInputLayoutPassword = findViewById<View>(R.id.textInputLayoutPassword) as TextInputLayout
//        textInputLayoutConfirmPassword = findViewById<View>(R.id.textInputLayoutConfirmPassword) as TextInputLayout
//
//        textInputEditTextName = findViewById<View>(R.id.textInputEditTextName) as TextInputEditText
//        textInputEditTextEmail = findViewById<View>(R.id.textInputEditTextEmail) as TextInputEditText
//        textInputEditTextPassword = findViewById<View>(R.id.textInputEditTextPassword) as TextInputEditText
//        textInputEditTextConfirmPassword = findViewById<View>(R.id.textInputEditTextConfirmPassword) as TextInputEditText
//
////        registerButton = findViewById<View>(R.id.appCompatButtonRegister) as AppCompatButton
//
////        appCompatTextViewLoginLink = findViewById<View>(R.id.appCompatTextViewLoginLink) as AppCompatTextView
//
//    }

    /**
     * This method is to initialize listeners
     */
//    private fun initListeners() {
//        appCompatButtonRegister!!.setOnClickListener(this)
//        appCompatTextViewLoginLink!!.setOnClickListener(this)
//
//    }

    /**
     * This method is to initialize objects to be used
     */
//    private fun initObjects() {
////        inputValidation = InputValidation(activity)
////        databaseHelper = DatabaseHelper(activity)
//            user = User()
//
//    }

    val Serve by lazy {
        ServerInterface.create()
    }
    var disposable: Disposable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

//        var textInputEditText = findViewById(R.id.textInputEditTextName) as EditText
//        initViews()
//        initObjects()
        appCompatButtonRegister.setOnClickListener {
            postDataToSQLite()
            newUser()
        }
        appCompatTextViewLoginLink.setOnClickListener{
            finish()
        }
    }

    /**
     * This implemented method is to listen the click on view
//     */
//    override fun onClick(v: View) {
//        when (v.id) {
//
//            R.id.appCompatButtonRegister ->
//            {
//                postDataToSQLite()
//                newUser()
//            }
//
//            R.id.appCompatTextViewLoginLink -> finish()
//        }
//    }

    /**
     * This method is to validate the input text fields and post data to SQLite
     */
    private fun postDataToSQLite() {
        if (!InputValidation(this).isInputEditTextFilled(textInputEditTextName, textInputLayoutName, getString(R.string.error_message_name))) {
            return
        }
        if (!InputValidation(this).isInputEditTextFilled(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return
        }
        if (!InputValidation(this).isInputEditTextEmail(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return
        }
        if (!InputValidation(this).isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.error_message_password))) {
            return
        }
        if (!InputValidation(this).isInputEditTextMatches(textInputEditTextPassword, textInputEditTextConfirmPassword,
                        textInputLayoutConfirmPassword, getString(R.string.error_password_match))) {
            return
        }

        if (!DatabaseHelper(this).checkUser(textInputEditTextEmail!!.text!!.toString().trim { it <= ' ' })) {

            user!!.name = textInputEditTextName!!.text!!.toString().trim { it <= ' ' }
            user!!.email = textInputEditTextEmail!!.text!!.toString().trim { it <= ' ' }
            user!!.password = textInputEditTextPassword!!.text!!.toString().trim { it <= ' ' }

            DatabaseHelper(this).addUser(user)
            // Snack Bar to show success message that record saved successfully
            //            Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            Toast.makeText(this, R.string.success_message, Toast.LENGTH_LONG).show()
            val loginIntent = Intent(activity, LoginActivity::class.java)
            startActivity(loginIntent)
            //            emptyInputEditText();


        } else {
            // Snack Bar to show error message that record already exists
            Snackbar.make(nestedScrollView!!, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show()
        }


    }

    /**
     * This method is to empty all input edit text
     */
    private fun emptyInputEditText() {
        textInputEditTextName!!.text = null
        textInputEditTextEmail!!.text = null
        textInputEditTextPassword!!.text = null
        textInputEditTextConfirmPassword!!.text = null
    }

    //post to server function
    fun newUser(){
        val username = textInputEditTextName!!.text.toString()
        val password  = textInputEditTextPassword!!.text.toString()
        val email = textInputEditTextEmail!!.text.toString()

        val user = Newuser(username,password, email)
        Log.d("Register","$user")
        disposable = Serve.signUp(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {result -> Toast.makeText(this,"",Toast.LENGTH_SHORT).show()},
                        {error -> Toast.makeText(this,error.message,Toast.LENGTH_SHORT).show()}
                )
    }

}
