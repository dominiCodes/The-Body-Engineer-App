/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;


public class MainActivity extends AppCompatActivity implements  View.OnClickListener, View.OnKeyListener {
    TextView loginTextView;
    Boolean signUpModeActive = true;
    EditText userNameEditText;
    EditText passwordEditText;
//    public static final   ParseUser currentUser = ParseUser.getCurrentUser();
//    public static final String currentUserString = String.valueOf(currentUser.getUsername());
//    public static ParseUser user = new ParseUser();
    public static String userId;


    public void secondPageActivity(){
        Intent intent =new Intent(getApplicationContext(), SecondPageActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if(i==KeyEvent.KEYCODE_ENTER && keyEvent.getAction()== keyEvent.ACTION_DOWN){
            signUpClicked(view);
        }
        return false;
    }

    @Override
    //SwitchingBetweenSignUpAndLoginMode
    public void onClick(View view) {
    if(view.getId()==R.id.loginTextView){
        Button signUpButton= (Button) findViewById(R.id.signUpButton);
        if(signUpModeActive){
            signUpModeActive=false;
            signUpButton.setText("Login!");
            loginTextView.setText("or sign up?");}
            else{
                signUpModeActive=true;
                signUpButton.setText("Sign Up!");
                loginTextView.setText("or, login?");
            }
        }
    //DisaapearingTheKeyBoardWhenClickedElseWhere
    else if(view.getId()==R.id.logoImageView || view.getId()==R.id.layout){
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
//        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
    }
    }

    public void signUpClicked(View view){
        if(userNameEditText.getText().toString().matches("") || passwordEditText.getText().toString().matches("")){
      Toast.makeText( this ,"A Username and a Password is required.",Toast.LENGTH_SHORT).show();
    }
    else{
        if(signUpModeActive) {
            //SignUpMode

            ParseUser user = new ParseUser();
            user.setUsername(userNameEditText.getText().toString());
            user.setPassword(passwordEditText.getText().toString());
            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done( ParseException e) {
                    if (e == null) {
//                        userId = user.getObjectId();
                        //Its correct.
                        Log.i("Sign Up", "Signed Up Successfully!");
                        Toast.makeText(MainActivity.this, "Singed Up Sucecessfull!", Toast.LENGTH_SHORT).show();
//                        secondPageActivity();
                    }

                    else {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else{
            //LoginMode
            ParseUser.logInInBackground(userNameEditText.getText().toString(), passwordEditText.getText().toString(), new LogInCallback() {
                @Override
                public void done(ParseUser user, ParseException e) {
                    if(user!=null) {
                        userId = user.getObjectId();
                        Log.i("Login", "Login Successfull!");
                        secondPageActivity();
                        Log.i("user id",userId );

                    }
                        else{
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

            });
        }
    }
  }
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      Log.i("Parse Result", "Successful!");

      //Log.i("Username.......",currentUserString);
      loginTextView = (TextView) findViewById(R.id.loginTextView);
      loginTextView.setOnClickListener(this);
      userNameEditText= (EditText) findViewById(R.id.usernameEditText);;
      passwordEditText= (EditText) findViewById(R.id.passwordEditText);
      ImageView logoImageView= (ImageView) findViewById(R.id.logoImageView);
      RelativeLayout layout= (RelativeLayout) findViewById(R.id.layout);
      logoImageView.setOnClickListener(this);
      layout.setOnClickListener(this);
      passwordEditText.setOnKeyListener(this);
//      if(ParseUser.getCurrentUser()!=null){
//          secondPageActivity();
//      }

    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }


}