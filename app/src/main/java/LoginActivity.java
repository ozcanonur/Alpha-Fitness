package sp2016.cs310.com.traningtrackingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabHost host = (TabHost)findViewById(R.id.LoginTabHost);
        host.setup();


        TabHost.TabSpec spec = host.newTabSpec("Login Tab");
        spec.setContent(R.id.LoginTab);
        spec.setIndicator("Login");
        host.addTab(spec);

        spec = host.newTabSpec("SignUp Tab");
        spec.setContent(R.id.SignUpTab);
        spec.setIndicator("Sign Up");
        host.addTab(spec);


        spec = host.newTabSpec("Faq Tab");
        spec.setContent(R.id.FaqTab);
        spec.setIndicator("F.A.Q");
        host.addTab(spec);

        ///////////////////
        /*Login Button*///
        /////////////////
        Button loginButton = (Button) findViewById(R.id.loginButton);
        assert loginButton != null;

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                EditText userIDText = (EditText) findViewById(R.id.loginEmail);
                EditText userPasswordText = (EditText) findViewById(R.id.loginPassword);
                RadioButton clientRadioButton = (RadioButton) findViewById(R.id.clientRadioButton);
                RadioButton trainerRadioButton = (RadioButton) findViewById(R.id.trainerRadioButton);
                RadioButton adminRadioButton = (RadioButton) findViewById(R.id.adminRadioButton);
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.UserSelectRadioGroup);

                String userID = userIDText.getText().toString();
                String userPassword = userPasswordText.getText().toString();

                boolean correctCredentialsFormat = true;

                if(userID.equals("") || userPassword.equals(""))
                    correctCredentialsFormat = false;
                if(radioGroup.getCheckedRadioButtonId() == -1)
                    correctCredentialsFormat = false;

                if(!correctCredentialsFormat)
                    Toast.makeText(LoginActivity.this, "Username or password can't be empty\n" +
                            "One of the radio buttons must be selected", Toast.LENGTH_SHORT).show();
                else {

                    if(clientRadioButton.isChecked()){
                        if(userID.equals("a") && userPassword.equals("a")) { //validation from DB for admin
                            Intent navClientInterface = new Intent(LoginActivity.this,ClientInterface.class);
                            LoginActivity.this.startActivity(navClientInterface);

                        }
                    }
                    else if(trainerRadioButton.isChecked()){
                        if (userID.equals("a") && userPassword.equals("a")) { //validation from DB for trainer
                            //intent to trainer interface

                        }
                    }
                    else{
                        if (userID.equals("a") && userPassword.equals("a")) { //validation from DB for admin

                            //intent to admin interface

                        }
                    }
                }
            }
        });
        ///////////////////
        /*Sign Up Button*/
        /////////////////

        Button submit = (Button) findViewById(R.id.signUpSubmitButton);
        assert submit != null;

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                EditText signUpEmail = (EditText) findViewById(R.id.loginEmail);
                EditText signUpPassword = (EditText) findViewById(R.id.loginPassword);
                EditText signUpRepeatPassword = (EditText) findViewById(R.id.repeatSignUpPassword);
                boolean correctCredentialsFormat = true;

                if(signUpEmail.getText().toString().equals("") ||
                        signUpPassword.getText().toString().equals("") ||
                        signUpRepeatPassword.getText().toString().equals(""))
                    correctCredentialsFormat = false;

                if(!signUpPassword.getText().toString().equals(
                        signUpRepeatPassword.getText().toString()))
                    correctCredentialsFormat = false;

                if(correctCredentialsFormat) {    //if correct format
                                                 //submit registration query to DB
                    if(true) {                  //successful registration
                        Toast.makeText(LoginActivity.this, "Registration Success", Toast.LENGTH_SHORT).show();
                        Intent navClientInterface = new Intent(LoginActivity.this,ClientInterface.class);
                        LoginActivity.this.startActivity(navClientInterface);
                    }
                    else
                        Toast.makeText(LoginActivity.this, "Registration Failure", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    //////////////////////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
