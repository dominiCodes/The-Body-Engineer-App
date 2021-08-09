package com.parse.starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.List;

public class bmrActivity extends AppCompatActivity {
    EditText ageEditText, weightEditText, heightEditText;
    public static TextView bmrResultTextView;
    Button calButton;
    float weight, height;
    int age;
    RadioGroup radioGroup;
    RadioButton radioButton;
    String gender;
     Double bmr;
    ImageView refreshButton,backButton;
    TextView  saveDataTextView;
    public static  String bmr2;
    public static String bmrObjectId=";";


    public void calClcik(View view) {
        saveDataTextView.setVisibility(View.VISIBLE);
        if (weightEditText.getText().toString().matches("") || heightEditText.getText().toString().matches("") || ageEditText.getText().toString().matches("") || radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Some data is missing,", Toast.LENGTH_SHORT).show();
        } else {
            weight = Float.parseFloat(weightEditText.getText().toString());
            height = Float.parseFloat(heightEditText.getText().toString());
            age = Integer.parseInt(ageEditText.getText().toString());
            if (gender.equals("Male")) {
                bmr = (10 * weight) + (6.25 * height) - (5 * age + 5);
                bmr2 = Double.toString(bmr);
                bmrResultTextView.setText(bmr2);
            } else {
                bmr = (10 * weight) + (6.25 * height) - (5 * age + 161);
                bmr2 = Double.toString(bmr);
                bmrResultTextView.setText(bmr2);

            }
        }
    }

    //RadioButton for male and female is selected by storing the method radiogroup.getCheckedRadioButtonId() in selecgtedRadioButton and the id od the RadioButton is of no use.
    public void rbClick(View view) {
        int selectedRadioButton = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(selectedRadioButton);
        Log.i("RadioButton", radioButton.getText().toString());
        gender = radioButton.getText().toString();
    }



        @Override
        protected void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_bmr);
            ageEditText = findViewById(R.id.ageEditTextCC);
            weightEditText = findViewById(R.id.weightEditTextCC);
            heightEditText = findViewById(R.id.heightEditTextCC);
            calButton = findViewById(R.id.calButton);
            bmrResultTextView=findViewById(R.id.bmrResultTextView);
            radioGroup=findViewById(R.id.radioGroup);
            refreshButton=findViewById(R.id.refreshButton);
            backButton=findViewById(R.id.backButton);
            saveDataTextView=findViewById(R.id. saveDataTextView);

            refreshButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        weightEditText.setText("");
                        heightEditText.setText("");
                        ageEditText.setText("");
                        bmrResultTextView.setText("0");

                    }
            });
            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(getApplicationContext(),SecondPageActivity.class);
                    startActivity(intent);

                }
            });
//
            saveDataTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ParseQuery<ParseObject> query = ParseQuery.getQuery("Bmr");
                    query.whereEqualTo("UserId", MainActivity.userId);
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> objects, ParseException e) {
                            if (e == null) {
                                for (ParseObject object : objects) {
                                    bmrObjectId=object.getObjectId();
//
                                    Log.i("FindINBackgrondResult",bmrObjectId);
                                    //Log.i("FindInBackground:", object.getString("Bmi"));

                                }
                                if (objects.size() > 0) {
//                                                               int k=objects.size();
                                    Log.i("object size",Integer.toString(objects.size()));

                                    ParseQuery<ParseObject> query1 = ParseQuery.getQuery("Bmr");
                                    query1.getInBackground(bmrObjectId, new GetCallback<ParseObject>() {
                                        @Override
                                        public void done(ParseObject object, ParseException e) {
                                            if (e == null && object != null) {
                                                object.put("Bmr", bmr2.substring(0,6));
                                                object.saveInBackground();
                                                saveDataTextView.setVisibility(View.INVISIBLE);
                                                Toast.makeText(bmrActivity.this,"Data Updated Sucessfully!", Toast.LENGTH_SHORT).show();

                                                Log.i("Bmr Value", object.getString("Bmr"));
                                            } else {
                                                Toast.makeText(bmrActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                                                Log.i("Sorry", "Failed!!!!");
                                            }
                                        }
                                    });

                                } else {
                                    ParseObject object = new ParseObject("Bmr");
                                    object.put("UserId", MainActivity.userId);
                                    object.put("Bmr", bmr2.substring(0,6));
                                    object.saveInBackground(new SaveCallback() {
                                        @Override
                                        public void done(ParseException e) {
                                            if (e == null) {
                                                Log.i("Congrats!!!! Bmr Saved", bmr2.substring(0,6));

                                            } else {
                                                Log.i("Sorryyy!!!!!", "Data Not Saved....");
                                            }
                                        }
                                    });

                                    Toast.makeText(bmrActivity.this, "Data saved Sucessfully!", Toast.LENGTH_SHORT).show();
                                    saveDataTextView.setVisibility(View.INVISIBLE);

                                }
                            }
                        }
                    });
                }
            });
    }
}

