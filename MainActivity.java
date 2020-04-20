/*this is the file for mainactivity */

package com.app.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextView Tv1;
    EditText Et,Et1,Et2,Et3;
    Button B1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tv1=(TextView) findViewById(R.id.textView4);
        Et=(EditText) findViewById(R.id.editText);
        Et1=(EditText) findViewById(R.id.editText1);
        Et2=(EditText) findViewById(R.id.editText2);
        Et3=(EditText) findViewById(R.id.editText3);
        B1=(Button) findViewById(R.id.button);

        B1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if(Validate()==false)
                {
                    return ;
                }

                Tv1.setText("Welcome");
            }
        });


    }

    private boolean Validate()
    {

        String name = Et.getText().toString();
        if (isValidName(name)==false) {
            Et.setError("Enter Name");
            return false;
        }

        String email = Et1.getText().toString();
        if (isValidEmail(email)==false) {
            Et1.setError("Invalid Email");
            return false;
        }

        String pass = Et2.getText().toString();
        if (isValidPassword(pass)==false) {
            Et2.setError("Invalid Password");
            return false;
        }
        int num = Integer.parseInt(Et3.getText().toString());
        if (isAge(num)==false) {
            Et3.setError("Enter again");
            return false;
        }

        return true;
    }

    // validating email
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // validating password with retype password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 6) {
            return true;
        }
        return false;
    }

    //validating User Name for blank
    private boolean isValidName(String name) {
        if (name != null && name.length() > 0) {
            return true;
        }
        return false;
    }

    private boolean isAge(int num) {
        if (num> 0 && num<100) {
            return true;
        }
        return false;
    }





}

