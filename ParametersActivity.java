package ke.co.codewright.diabetesrecommendersystem.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import androidx.core.widget.NestedScrollView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import android.view.View;
import android.widget.Toast;

import ke.co.codewright.diabetesrecommendersystem.R;
import ke.co.codewright.diabetesrecommendersystem.User;
import ke.co.codewright.diabetesrecommendersystem.helpers.InputValidation;
import ke.co.codewright.diabetesrecommendersystem.sql.DatabaseHelper;

public class ParametersActivity extends AppCompatActivity /*implements View.OnClickListener*/ {

        private final AppCompatActivity activity = ParametersActivity.this;

        private NestedScrollView nestedScrollView;

        private TextInputLayout textInputLayoutBMI;
        private TextInputLayout textInputLayoutInsulin;
        private TextInputLayout textInputLayoutGlucose;
        private TextInputLayout textInputLayoutTricepsThickness;
        private TextInputLayout textInputLayoutBloodPressure;

        private TextInputEditText textInputBMI;
        private TextInputEditText textInputInsulin;
        private TextInputEditText textInputGlucose;
        private TextInputEditText textInputTricepsThickness;
        private TextInputEditText textInputBloodPressure;

        private AppCompatButton appCompatButtonSubmit;


        private InputValidation inputValidation;
        private DatabaseHelper databaseHelper;
        private User user;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_parameters_input);
//            getSupportActionBar().show();

            initViews();
//            initListeners();
            initObjects();
        }

        /**
         * This method is to initialize views
         */
        private void initViews() {
            nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

            textInputLayoutBMI = (TextInputLayout) findViewById(R.id.textInputLayoutBMI);
            textInputLayoutInsulin = (TextInputLayout) findViewById(R.id.textInputLayoutInsulin);
            textInputLayoutGlucose = (TextInputLayout) findViewById(R.id.textInputLayoutGlucose);
            textInputLayoutTricepsThickness = (TextInputLayout) findViewById(R.id.textInputLayoutTricepsThickness);
            textInputLayoutBloodPressure = (TextInputLayout) findViewById(R.id.textInputLayoutBloodPressure);

            textInputBMI = (TextInputEditText) findViewById(R.id.textInputBMI);
            textInputInsulin = (TextInputEditText) findViewById(R.id.textInputInsulin);
            textInputGlucose = (TextInputEditText) findViewById(R.id.textInputGlucose);
            textInputTricepsThickness = (TextInputEditText) findViewById(R.id.textInputTricepsThickness);

            appCompatButtonSubmit = (AppCompatButton) findViewById(R.id.appCompatButtonSubmit);


        }

        /**
         * This method is to initialize listeners
         */
//        private void initListeners() {
//            appCompatButtonSubmit.setOnClickListener(this);
//
//        }

        /**
         * This method is to initialize objects to be used
         */
        private void initObjects() {
            inputValidation = new InputValidation(activity);
            databaseHelper = new DatabaseHelper(activity);
            user = new User();

        }


        /**
         * This implemented method is to listen the click on view
         *
         * @param v
         */
//        @Override
//        public void onClick(View v) {
//            switch (v.getId()) {
//
//                case R.id.appCompatButtonSubmit:
//                    postDataToSQLite();
//                    break;
//
//
//            }
//        }

        /**
         * This method is to validate the input text fields and post data to SQLite
         */
//        private void postDataToSQLite() {
//            if (!inputValidation.isInputEditTextFilled(textInputEditTextName, textInputLayoutName, getString(R.string.error_message_name))) {
//                return;
//            }
//            if (!inputValidation.isInputEditTextFilled(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
//                return;
//            }
//            if (!inputValidation.isInputEditTextEmail(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
//                return;
//            }
//            if (!inputValidation.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.error_message_password))) {
//                return;
//            }
//            if (!inputValidation.isInputEditTextMatches(textInputEditTextPassword, textInputEditTextConfirmPassword,
//                    textInputLayoutConfirmPassword, getString(R.string.error_password_match))) {
//                return;
//            }
//
//            if (!databaseHelper.checkUser(textInputEditTextEmail.getText().toString().trim())) {
//
//                user.setName(textInputEditTextName.getText().toString().trim());
//                user.setEmail(textInputEditTextEmail.getText().toString().trim());
//                user.setPassword(textInputEditTextPassword.getText().toString().trim());
//
//                databaseHelper.addUser(user);
//
//                // Snack Bar to show success message that record saved successfully
////            Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
//                Toast.makeText(this, R.string.success_message,Toast.LENGTH_LONG);
//                Intent loginIntent = new Intent(activity, LoginActivity.class);
//                startActivity(loginIntent);
////            emptyInputEditText();
//
//
//            } else {
//                // Snack Bar to show error message that record already exists
//                Snackbar.make(nestedScrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
//            }
//
//
//        }

        /**
         * This method is to empty all input edit text
         */
//        private void emptyInputEditText() {
//            textInputEditTextName.setText(null);
//            textInputEditTextEmail.setText(null);
//            textInputEditTextPassword.setText(null);
//            textInputEditTextConfirmPassword.setText(null);
//        }
    }
