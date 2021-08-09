package com.parse.starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class bmiSecondPage extends AppCompatActivity {
    Button dietButton, workoutButton,gymWorkoutButton, homeWorkoutButton,vegDietButton,nonVegDietButton,dietBack,workoutBack;
    TextView dietInfo, workoutInfo;
    TextView workoutPreference, dietPreference;
    TextView orTextView;

    public void dietClick(View view){
        dietButton.setVisibility(View.INVISIBLE);
        workoutButton.setVisibility(View.INVISIBLE);
        dietInfo.setVisibility(View.INVISIBLE);
        workoutInfo.setVisibility(View.INVISIBLE);
        vegDietButton.setVisibility(View.VISIBLE);
        nonVegDietButton.setVisibility(View.VISIBLE);
        dietPreference.setVisibility(View.VISIBLE);
        orTextView.setVisibility(View.VISIBLE);
        dietBack.setVisibility(View.VISIBLE);
    }

    public void workoutClick(View view) {
        dietButton.setVisibility(View.INVISIBLE);
        workoutButton.setVisibility(View.INVISIBLE);
        dietInfo.setVisibility(View.INVISIBLE);
        workoutInfo.setVisibility(View.INVISIBLE);
        gymWorkoutButton.setVisibility(View.VISIBLE);
        homeWorkoutButton.setVisibility(View.VISIBLE);
        workoutPreference.setVisibility(View.VISIBLE);
        orTextView.setVisibility(View.VISIBLE);
        workoutBack.setVisibility(View.VISIBLE);
    }

        public void dietBackClick(View view){
            dietBack.setVisibility(View.INVISIBLE);
            dietButton.setVisibility(View.VISIBLE);
            workoutButton.setVisibility(View.VISIBLE);
            dietInfo.setVisibility(View.VISIBLE);
            workoutInfo.setVisibility(View.VISIBLE);
            vegDietButton.setVisibility(View.INVISIBLE);
            nonVegDietButton.setVisibility(View.INVISIBLE);
            dietPreference.setVisibility(View.INVISIBLE);
            orTextView.setVisibility(View.INVISIBLE);
        }

        public void workoutBackClick(View view){
            dietButton.setVisibility(View.VISIBLE);
            workoutButton.setVisibility(View.VISIBLE);
            dietInfo.setVisibility(View.VISIBLE);
            workoutInfo.setVisibility(View.VISIBLE);
            gymWorkoutButton.setVisibility(View.INVISIBLE);
            homeWorkoutButton.setVisibility(View.INVISIBLE);
            workoutPreference.setVisibility(View.INVISIBLE);
            orTextView.setVisibility(View.INVISIBLE);
            workoutBack.setVisibility(View.INVISIBLE);
        }
          public void gymWorloutClick(View view){
              Intent intent = new Intent(getApplicationContext(),WorkoutActivity.class);
              startActivity(intent);
          }




        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_bmi_second_page);
            dietButton=findViewById(R.id.dietButton);
            workoutButton=findViewById(R.id.workoutButton);
            gymWorkoutButton=findViewById(R.id.gymWorkoutButton);
            homeWorkoutButton=findViewById(R.id.homeWorkoutButton);
            vegDietButton=findViewById(R.id.vegDietButton);
            nonVegDietButton=findViewById(R.id.nonVegDietButton);
            dietInfo=findViewById(R.id.dietInfo);
            workoutInfo=findViewById(R.id.workoutInfo);
            workoutPreference=findViewById(R.id.workoutPreference);
            dietPreference=findViewById(R.id.dietPreference);
            orTextView=findViewById(R.id.orTextView);
            dietBack=findViewById(R.id.dietBack);
            workoutBack=findViewById(R.id.workoutBack);
            Intent intent= getIntent();
        }
    }

























































            //    if (Double.compare(newBmi, 15d) <= 0) {
//                    Log.i("Type", "1");
//                        bmiCategoryeditText.setText("Very Severely Underweight");
//                            textcategory1.setTypeface(null, Typeface.BOLD_ITALIC);}
//                else if(Double.compare(newBmi, 15d) > 0  &&  Double.compare(newBmi, 16d) <= 0){
//                    bmiCategoryeditText.setText("Severely Underweight");
//                        Log.i("Type", "2");
//                              textcategory2.setTypeface(null, Typeface.BOLD_ITALIC);}
//                else if(Double.compare(newBmi, 16d) > 0  &&  Double.compare(newBmi, 18.5d) <= 0){
//                    bmiCategoryeditText.setText("Underweight");
//                        Log.i("Type", "3");
//                            textcategory3.setTypeface(null, Typeface.BOLD_ITALIC);}
//                else if(Double.compare(newBmi, 18.5d) > 0  &&  Double.compare(newBmi, 25d) <= 0){
//                    bmiCategoryeditText.setText("Normal");
//                        Log.i("Type", "4");
//                            textcategory4.setTypeface(null, Typeface.BOLD_ITALIC);}
//                else if (Double.compare(newBmi, 25d) > 0  &&  Double.compare(newBmi, 30d) <= 0){
//                        bmiCategoryeditText.setText("Overweight");
//                    Log.i("Type", "5");
//                        textcategory5.setTypeface(null, Typeface.BOLD_ITALIC);}
//                else if((Double.compare(newBmi, 30d) > 0  &&  Double.compare(newBmi, 35d) <= 0)){
//                    bmiCategoryeditText.setText("Obese Class 1");
//                    Log.i("Type", "6");
//                        textcategory6.setTypeface(null, Typeface.BOLD_ITALIC);}
//                else if (Double.compare(newBmi, 35d) > 0  &&  Double.compare(newBmi, 40d) <= 0) {
//                    bmiCategoryeditText.setText("Obese Class 2");
//                        Log.i("Type", "7");
//                             textcategory7.setTypeface(null, Typeface.BOLD_ITALIC);}
//                else {
//                    Log.i("Type", "8");
//                        bmiCategoryeditText.setText("Obese Class 3");
//                            textcategory8.setTypeface(null, Typeface.BOLD_ITALIC);}




//            bmiResultTextView = findViewById(R.id.bmiResultTextView);
//            bmiCategoryeditText = findViewById(R.id.bmiCategoryeditText);
//            checkCategoryButton = findViewById(R.id.checkCategoryButton);
//            bmiCategoryeditText = findViewById(R.id.bmiCategoryeditText);
//            nextButton = findViewById(R.id.nextButton);
//            linearLayout = findViewById(R.id.linearLayout);
//            textcategory1 = findViewById(R.id.textcategory1);
//            textcategory2 = findViewById(R.id.textcategory2);
//            textcategory3 = findViewById(R.id.textcategory3);
//            textcategory4 = findViewById(R.id.textcategory4);
//            textcategory5 = findViewById(R.id.textcategory5);
//            textcategory6 = findViewById(R.id.textcategory6);
//            textcategory7 = findViewById(R.id.textcategory7);
//            textcategory8 = findViewById(R.id.textcategory8);
//            Intent intent = getIntent();
//            float bmi = intent.getFloatExtra("bmi", 0);//here name is the key value which should be same as previous activity's intent.
//            String bmi2 = Float.toString(bmi);//here we are getting the bmi value from previous activity through intent which in float datatype, so we are converting int into string and storing it in bmi2 below.
//            bmiResultTextView.setText(bmi2);