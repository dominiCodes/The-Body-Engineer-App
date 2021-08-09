package com.parse.starter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;
public class userProfile extends AppCompatActivity {

    TextView ubmiResult, ubmrResult, uwIntakeResult, ucalIntakeResult, ucalIntakeResult2, ucalIntakeResult3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        ubmiResult = findViewById(R.id.ubmiResult);
        ubmrResult = findViewById(R.id.ubmrResult);
        uwIntakeResult = findViewById(R.id.uwIntakeResult);
        ucalIntakeResult = findViewById(R.id.ucalIntakeResult);
        ucalIntakeResult2 = findViewById(R.id.ucalIntakeResult2);
        ucalIntakeResult3 = findViewById(R.id.ucalIntakeResult3);


        ParseQuery<ParseObject> bmiquery = ParseQuery.getQuery("Bmi");

        bmiquery.whereEqualTo("UserId", MainActivity.userId);
        bmiquery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
//
                    Log.i("Bmi object size", Integer.toString(objects.size()));
                    if (objects.size() > 0) {
                        for (ParseObject object : objects) {
                            Log.i("FindINBackgrondResult", object.getString("UserId"));
                            Log.i("FindInBackground:", object.getString("Bmi"));
                            ubmiResult.setText(object.getString("Bmi"));
                        }

                    } else {
//
                        Log.i("No BMi Found", "Failed!!!!");
                    }
                }
            }

        });

        ParseQuery<ParseObject> bmrquery = ParseQuery.getQuery("Bmr");
        bmrquery.whereEqualTo("UserId", MainActivity.userId);
        bmrquery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {

                    Log.i("Bmr object size", Integer.toString(objects.size()));
                    if (objects.size() > 0) {
                        for (ParseObject object : objects) {
                            Log.i("FindINBackgrondResult", object.getString("UserId"));
                            Log.i("FindInBackground:", object.getString("Bmr"));
                            ubmrResult.setText(object.getString("Bmr"));
                        }

                    } else {
//
                        Log.i("No Bmr Found", "Failed!!!!");
                    }
                }
            }

        });


        ParseQuery<ParseObject> wIntakequery = ParseQuery.getQuery("WaterIntake");
        wIntakequery.whereEqualTo("UserId", MainActivity.userId);
        wIntakequery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    Log.i("WaterIntake object size", Integer.toString(objects.size()));
                    if (objects.size() > 0) {
                        for (ParseObject object : objects) {
                            Log.i("FindINBackgrondResult", object.getString("UserId"));
                            Log.i("FindInBackground:", object.getString("wIntake"));
                            uwIntakeResult.setText(object.getString("wIntake"));
                        }

                    } else {
//
                        Log.i("No Water Intake  Found", "Failed");
                    }
                }
            }

        });

        ParseQuery<ParseObject> cCalquerry = ParseQuery.getQuery("CalorieCal");
        cCalquerry.whereEqualTo("UserId", MainActivity.userId);
        cCalquerry.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    Log.i("Calorie Intake object size", Integer.toString(objects.size()));
                    if (objects.size() > 0) {
                        for (ParseObject object : objects) {
                            Log.i("FindINBackgrondResult", object.getString("UserId"));
                            Log.i("FindInBackground:", "Calorie Intake is in Integer form");
                            Integer calM = object.getInt("cCal");
                            Integer calL = object.getInt("cCal") - 497;
                            Integer calG = object.getInt("cCal") + 497;
                            ucalIntakeResult.setText(calM.toString());
                            ucalIntakeResult2.setText(calL.toString());
                            ucalIntakeResult3.setText(calG.toString());
                        }

                    } else {
//
                        Log.i("No Calorie Intake  Found", "Failed");
                    }
                }
            }

        });
    }
}