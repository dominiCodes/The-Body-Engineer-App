package com.parse.starter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

public class calorieCal extends AppCompatActivity {
    Spinner activitySpinner;
    EditText ageEditTextCal, weightEditTextCal, heightEditTextCal;

    TextView maintainWeight, looseWeight, gainWeight;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button calIntakeButton;
    Float weight, height;
    Integer age;
    public static Double calIntake;
    String calIntakeMaintain2, calIntakeLoose2, calIntakeGain2;
    String activityType;
    Double calIntakeMaintain, calIntakeLoose, calIntakeGain;
    String gender;
    ImageView backImageView, undoImageView;
    TextView saveDataTextView;
    public static String calorieCalObjectId = "";

    public void calIntakeClick(View view) {
        saveDataTextView.setVisibility(View.VISIBLE);
        if (weightEditTextCal.getText().toString().matches("") || heightEditTextCal.getText().toString().matches("") || ageEditTextCal.getText().toString().matches("") || radioGroup.getCheckedRadioButtonId() == -1 || activityType.equals("")) {
            Toast.makeText(this, "Some data is missing,", Toast.LENGTH_SHORT).show();
        } else {
            weight = Float.parseFloat(weightEditTextCal.getText().toString());
            height = Float.parseFloat(heightEditTextCal.getText().toString());
            age = Integer.parseInt(ageEditTextCal.getText().toString());
            if (gender.equals("Female")) {
                switch (activityType) {
                    case "Little no Excercise":
                        calIntake = ((10 * weight) + (6.25 * height) - (5 * age + 161)) * 1.2;
                        calIntakeMaintain = calIntake;
                        calIntakeMaintain2 = Double.toString(calIntakeMaintain);
                        maintainWeight.setText(calIntakeMaintain2.substring(0, 6));
                        calIntakeLoose = calIntake - 500;
                        calIntakeLoose2 = Double.toString(calIntakeLoose);
                        looseWeight.setText(calIntakeLoose2.substring(0, 6));
                        calIntakeGain = calIntake + 500;
                        calIntakeGain2 = Double.toString(calIntakeGain);
                        gainWeight.setText(calIntakeGain2.substring(0, 6));
                        break;
                    case "1-3 days per week":
                        calIntake = ((10 * weight) + (6.25 * height) - (5 * age + 161)) * 1.375;
                        calIntakeMaintain = calIntake;
                        calIntakeMaintain2 = Double.toString(calIntakeMaintain);
                        maintainWeight.setText(calIntakeMaintain2.substring(0, 6));
                        calIntakeLoose = calIntake - 500;
                        calIntakeLoose2 = Double.toString(calIntakeLoose);
                        looseWeight.setText(calIntakeLoose2.substring(0, 6));
                        calIntakeGain = calIntake + 500;
                        calIntakeGain2 = Double.toString(calIntakeGain);
                        gainWeight.setText(calIntakeGain2.substring(0, 6));
                        break;
                    case "Moderate Excercise(3-5 days per week":
                        calIntake = ((10 * weight) + (6.25 * height) - (5 * age + 161)) * 1.55;
                        calIntakeMaintain = calIntake;
                        calIntakeMaintain2 = Double.toString(calIntakeMaintain);
                        maintainWeight.setText(calIntakeMaintain2.substring(0, 6));
                        calIntakeLoose = calIntake - 500;
                        calIntakeLoose2 = Double.toString(calIntakeLoose);
                        looseWeight.setText(calIntakeLoose2.substring(0, 6));
                        calIntakeGain = calIntake + 500;
                        calIntakeGain2 = Double.toString(calIntakeGain);
                        gainWeight.setText(calIntakeGain2.substring(0, 6));
                        break;
                    case "Heavy Excercise (6-7 days per week)":
                        calIntake = ((10 * weight) + (6.25 * height) - (5 * age + 161)) * 1.725;
                        calIntakeMaintain = calIntake;
                        calIntakeMaintain2 = Double.toString(calIntakeMaintain);
                        maintainWeight.setText(calIntakeMaintain2.substring(0, 6));
                        calIntakeLoose = calIntake - 500;
                        calIntakeLoose2 = Double.toString(calIntakeLoose);
                        looseWeight.setText(calIntakeLoose2.substring(0, 6));
                        calIntakeGain = calIntake + 500;
                        calIntakeGain2 = Double.toString(calIntakeGain);
                        gainWeight.setText(calIntakeGain2.substring(0, 6));
                        break;
                    default:
                        calIntake = ((10 * weight) + (6.25 * height) - (5 * age + 161)) * 1.9;
                        calIntakeMaintain = calIntake;
                        calIntakeMaintain2 = Double.toString(calIntakeMaintain);
                        maintainWeight.setText(calIntakeMaintain2.substring(0, 6));
                        calIntakeLoose = calIntake - 500;
                        calIntakeLoose2 = Double.toString(calIntakeLoose);
                        looseWeight.setText(calIntakeLoose2.substring(0, 6));
                        calIntakeGain = calIntake + 500;
                        calIntakeGain2 = Double.toString(calIntakeGain);
                        gainWeight.setText(calIntakeGain2.substring(0, 6));
                        break;
                }

            } else if (gender.equals("Male")) {

                switch (activityType) {
                    case "Little no Excercise":
                        calIntake = ((10 * weight) + (6.25 * height) - (5 * age + 161)) * 1.2;
                        calIntakeMaintain = calIntake;
                        calIntakeMaintain2 = Double.toString(calIntakeMaintain);
                        maintainWeight.setText(calIntakeMaintain2.substring(0, 6));
                        calIntakeLoose = calIntake - 500;
                        calIntakeLoose2 = Double.toString(calIntakeLoose);
                        looseWeight.setText(calIntakeLoose2.substring(0, 6));
                        calIntakeGain = calIntake + 500;
                        calIntakeGain2 = Double.toString(calIntakeGain);
                        gainWeight.setText(calIntakeGain2.substring(0, 6));
                        break;
                    case "1-3 days per week":
                        calIntake = ((10 * weight) + (6.25 * height) - (5 * age + 161)) * 1.375;
                        calIntakeMaintain = calIntake;
                        calIntakeMaintain2 = Double.toString(calIntakeMaintain);
                        maintainWeight.setText(calIntakeMaintain2.substring(0, 6));
                        calIntakeLoose = calIntake - 500;
                        calIntakeLoose2 = Double.toString(calIntakeLoose);
                        looseWeight.setText(calIntakeLoose2.substring(0, 6));
                        calIntakeGain = calIntake + 500;
                        calIntakeGain2 = Double.toString(calIntakeGain);
                        gainWeight.setText(calIntakeGain2.substring(0, 6));
                        break;
                    case "Moderate Excercise(3-5 days per week":
                        calIntake = ((10 * weight) + (6.25 * height) - (5 * age + 161)) * 1.55;
                        calIntakeMaintain = calIntake;
                        calIntakeMaintain2 = Double.toString(calIntakeMaintain);
                        maintainWeight.setText(calIntakeMaintain2.substring(0, 6));
                        calIntakeLoose = calIntake - 500;
                        calIntakeLoose2 = Double.toString(calIntakeLoose);
                        looseWeight.setText(calIntakeLoose2.substring(0, 6));
                        calIntakeGain = calIntake + 500;
                        calIntakeGain2 = Double.toString(calIntakeGain);
                        gainWeight.setText(calIntakeGain2.substring(0, 6));
                        break;
                    case "Heavy Excercise (6-7 days per week)":
                        calIntake = ((10 * weight) + (6.25 * height) - (5 * age + 161)) * 1.725;
                        calIntakeMaintain = calIntake;
                        calIntakeMaintain2 = Double.toString(calIntakeMaintain);
                        maintainWeight.setText(calIntakeMaintain2.substring(0, 6));
                        calIntakeLoose = calIntake - 500;
                        calIntakeLoose2 = Double.toString(calIntakeLoose);
                        looseWeight.setText(calIntakeLoose2.substring(0, 6));
                        calIntakeGain = calIntake + 500;
                        calIntakeGain2 = Double.toString(calIntakeGain);
                        gainWeight.setText(calIntakeGain2.substring(0, 6));
                        break;
                    default:
                        calIntake = ((10 * weight) + (6.25 * height) - (5 * age + 161)) * 1.9;
                        calIntakeMaintain = calIntake;
                        calIntakeMaintain2 = Double.toString(calIntakeMaintain);
                        maintainWeight.setText(calIntakeMaintain2.substring(0, 6));
                        calIntakeLoose = calIntake - 500;
                        calIntakeLoose2 = Double.toString(calIntakeLoose);
                        looseWeight.setText(calIntakeLoose2.substring(0, 6));
                        calIntakeGain = calIntake + 500;
                        calIntakeGain2 = Double.toString(calIntakeGain);
                        gainWeight.setText(calIntakeGain2.substring(0, 6));
                        break;
                }

            }
        }
    }


    public void rbClick(View view) {
        int selectedRadioButton = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(selectedRadioButton);
        Log.i("RadioButton", radioButton.getText().toString());
        gender = radioButton.getText().toString();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_cal);
        activitySpinner = (Spinner) findViewById(R.id.activitySpinner);
        ageEditTextCal = findViewById(R.id.ageEditTextCal);
        weightEditTextCal = findViewById(R.id.weightEditTextCal);
        heightEditTextCal = findViewById(R.id.heightEditTextCal);
        calIntakeButton = findViewById(R.id.calIntakeButton);
        maintainWeight = findViewById(R.id.maintainWeight);
        looseWeight = findViewById(R.id.looseWeight);
        gainWeight = findViewById(R.id.gainWeight);
        radioGroup = findViewById(R.id.radioGroup);
        backImageView = findViewById(R.id.backImageView);
        undoImageView = findViewById(R.id.undoImageView);
        saveDataTextView = findViewById(R.id.saveDataTextView);


        List<String> activity = new ArrayList<>();
        activity.add("Little no Excercise");
        activity.add("1-3 days per week");
        activity.add("Moderate Excercise(3-5 days per week");
        activity.add("Heavy Excercise (6-7 days per week)");
        activity.add("Very Heavy Excercise(Twice per day,extra heavy workouts");

        ArrayAdapter<String> activityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, activity);
        activityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activitySpinner.setAdapter(activityAdapter);

        activitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                activityType = activitySpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        undoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weightEditTextCal.setText("");
                heightEditTextCal.setText("");
                ageEditTextCal.setText("");
                maintainWeight.setText("0");
                looseWeight.setText("0");
                gainWeight.setText("0");
            }
        });
        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondPageActivity.class);
                startActivity(intent);
            }
        });


        saveDataTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseQuery<ParseObject> query = ParseQuery.getQuery("CalorieCal");
                query.whereEqualTo("UserId", MainActivity.userId);
                query.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {
                        if (e == null) {
                            for (ParseObject object : objects) {
                                calorieCalObjectId = object.getObjectId();
//
                                Log.i("FindINBackgrondResult", calorieCalObjectId);
                                //Log.i("FindInBackground:", object.getString("Bmi"));

                            }
                            if (objects.size() > 0) {
//                                                               int k=objects.size();
                                Log.i("object size", Integer.toString(objects.size()));

                                ParseQuery<ParseObject> query1 = ParseQuery.getQuery("CalorieCal");
                                query1.getInBackground(calorieCalObjectId, new GetCallback<ParseObject>() {
                                    @Override
                                    public void done(ParseObject object, ParseException e) {
                                        if (e == null && object != null) {
                                            object.put("cCal", calIntake);
                                            object.saveInBackground();
                                            saveDataTextView.setVisibility(View.INVISIBLE);
                                            Toast.makeText(calorieCal.this, "Data Updated Sucessfully!", Toast.LENGTH_SHORT).show();

                                            Log.i("Bmr Value", object.getString("cCal"));
                                        } else {
                                            Toast.makeText(calorieCal.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                            Log.i("Sorry", "Failed!!!!");
                                        }
                                    }
                                });

                            } else {
                                ParseObject object = new ParseObject("CalorieCal");
                                object.put("UserId", MainActivity.userId);
                                object.put("cCal", calIntake);
                                object.saveInBackground(new SaveCallback() {
                                    @Override
                                    public void done(ParseException e) {
                                        if (e == null) {
                                            Log.i("Congrats!!!! Calorie Intake  Saved", calIntake.toString());

                                        } else {
                                            Log.i("Sorryyy!!!!!", "Data Not Saved....");
                                        }
                                    }
                                });

                                Toast.makeText(calorieCal.this, "Data saved Sucessfully!", Toast.LENGTH_SHORT).show();
                                saveDataTextView.setVisibility(View.INVISIBLE);

                            }
                        }
                    }
                });

            }
        });
    }
}