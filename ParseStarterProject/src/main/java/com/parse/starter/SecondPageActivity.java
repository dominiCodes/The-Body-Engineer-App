package com.parse.starter;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;

public class SecondPageActivity extends AppCompatActivity {

    ConstraintLayout bmiLayout, bmrLayout, calorieIntakeLayout, waterIntakeLayout, dietLayout, workoutLayout;
    public static final   ParseUser currentUser = ParseUser.getCurrentUser();
    public static final String currentUserString = String.valueOf(currentUser.getUsername());



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        bmiLayout = findViewById(R.id.bmiLayout);
        bmrLayout = findViewById(R.id.bmrLayout);
        calorieIntakeLayout = findViewById(R.id.calorieIntakeLayout);
        waterIntakeLayout = findViewById(R.id.waterIntakeLayout);
        dietLayout = findViewById(R.id.dietLayout);
        workoutLayout = findViewById(R.id.workoutLayout);


        bmiLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), bmiActivity.class);
                startActivity(intent);
            }
        });

        dietLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), bmiSecondPage.class);
                startActivity(intent);
            }
        });

        workoutLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), bmiSecondPage.class);
                startActivity(intent);
            }
        });

        bmrLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), bmrActivity.class);
                startActivity(intent);
            }
        });

        calorieIntakeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), calorieCal.class);
                startActivity(intent);
            }
        });

        waterIntakeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), waterIntakeActivity.class);
                startActivity(intent);
            }
        });

    }

    //Menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.new_menu,menu);
//        Log.i("Username.......",currentUserString);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        if(item.getItemId()==R.id.add_info){
            Intent intent =new Intent(SecondPageActivity.this,userProfile.class);
            startActivity(intent);

            return  true;
        }else if(item.getItemId()==R.id.log_out){
            ParseUser.logOut();
            Intent i =new Intent(SecondPageActivity.this,MainActivity.class);
            startActivity(i);
        }

        return false;
    }
}