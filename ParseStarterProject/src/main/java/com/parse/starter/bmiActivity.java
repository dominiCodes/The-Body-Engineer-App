package com.parse.starter;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public class bmiActivity extends AppCompatActivity {
    EditText wieghtEditText;
    EditText hieghtEditText;
     float weigth, height;
     public static float bmi;
    Button calculateButton;
    TextView bmiCategoryeditText;
    public static TextView bmiResultTextView;
    TextView textcategory1, textcategory2, textcategory3, textcategory4, textcategory5, textcategory6, textcategory7, textcategory8;
    Button nextButton;
    LinearLayout linearLayout;
    ImageView refreshImageView, backImageView;
    TextView saveDataTextView;
    public static String bmi2="";
    public static String bmiObjectId="";
//    public static  ParseUser currentUser = ParseUser.getCurrentUser();
//    public static String currentUserString = String.valueOf(currentUser.getUsername());



    // Bmi is calculated in thiis calculateBmiCLicked Functon.
    public void calculateBmiClicked(View view) {
        if (wieghtEditText.getText().toString().matches("") || hieghtEditText.getText().toString().matches("")) {
            Toast.makeText(this, "Some data is missing,", Toast.LENGTH_SHORT).show();
        } else {
            weigth = Float.parseFloat(wieghtEditText.getText().toString());
            height = Float.parseFloat(hieghtEditText.getText().toString());
            bmi = weigth / (height * height);
            bmi2 = Double.toString(bmi);
            bmiResultTextView.setText(bmi2.substring(0,4));
            saveDataTextView.setVisibility(View.VISIBLE);

            if (bmi >= 0d && bmi <= 15d) {
                Log.i("Type", "1");
                bmiCategoryeditText.setText("Very Severely Underweight");
                textcategory1.setTypeface(null, Typeface.BOLD_ITALIC);
                textcategory1.setAllCaps(true);
                textcategory1.setPaintFlags(textcategory1.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
            } else if (bmi >= 15d && bmi <= 16d) {
                 bmiCategoryeditText.setText("Severely Underweight");
                Log.i("Type", "2");
                textcategory2.setTypeface(null, Typeface.BOLD_ITALIC);
                textcategory2.setAllCaps(true);
                textcategory2.setPaintFlags(textcategory2.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
            } else if (bmi >= 16d && bmi <= 18.5d) {
                  bmiCategoryeditText.setText("Underweight");
                Log.i("Type", "3");
                textcategory3.setTypeface(null, Typeface.BOLD_ITALIC);
                textcategory3.setAllCaps(true);
                textcategory3.setPaintFlags(textcategory3.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
            } else if (bmi >= 18.5d && bmi <= 25d) {
                bmiCategoryeditText.setText("Normal");
                Log.i("Type", "4");
                textcategory4.setTypeface(null, Typeface.BOLD_ITALIC);
                textcategory4.setAllCaps(true);
                textcategory4.setPaintFlags(textcategory4.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
            } else if (bmi >= 25d && bmi <= 30d) {
                bmiCategoryeditText.setText("Overweight");
                Log.i("Type", "5");
                textcategory5.setTypeface(null, Typeface.BOLD_ITALIC);
                textcategory5.setAllCaps(true);
                textcategory5.setPaintFlags(textcategory5.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
            } else if (bmi >= 30d && bmi <= 35d) {
                bmiCategoryeditText.setText("Obese Class 1");
                Log.i("Type", "6");
                textcategory6.setTypeface(null, Typeface.BOLD_ITALIC);
                textcategory6.setAllCaps(true);
                textcategory6.setPaintFlags(textcategory6.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
            } else if (bmi >= 35d && bmi <= 40d) {
                 bmiCategoryeditText.setText("Obese Class 2");
                Log.i("Type", "7");
                textcategory7.setTypeface(null, Typeface.BOLD_ITALIC);
                textcategory7.setAllCaps(true);
                textcategory7.setPaintFlags(textcategory7.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
            } else {
                Log.i("Type", "8"); ParseObject bmiParse =new ParseObject("Bmi");
                bmiCategoryeditText.setText("Obese Class 3");
                textcategory8.setTypeface(null, Typeface.BOLD_ITALIC);
                textcategory8.setAllCaps(true);
                textcategory8.setPaintFlags(textcategory8.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

//
            }
        }
    }

    public void nextClick(View view){
        Intent intent = new Intent(getApplicationContext(),bmiSecondPage.class);
        startActivity(intent);


    }


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        calculateButton=findViewById(R.id.calculateButton);
        wieghtEditText = findViewById(R.id.wieghtEditText);
        hieghtEditText = findViewById(R.id.heightEditTextCC);
            bmiResultTextView =(TextView)findViewById(R.id.bmiResultTextView);
            bmiCategoryeditText=findViewById(R.id.bmiCategoryeditText);
            nextButton = findViewById(R.id.nextButton);
            linearLayout = findViewById(R.id.linearLayout);
            textcategory1 = findViewById(R.id.textcategory1);
            textcategory2 = findViewById(R.id.textcategory2);
            textcategory3 = findViewById(R.id.textcategory3);
            textcategory4 = findViewById(R.id.textcategory4);
            textcategory5 = findViewById(R.id.textcategory5);
            textcategory6 = findViewById(R.id.textcategory6);
            textcategory7 = findViewById(R.id.textcategory7);
            textcategory8 = findViewById(R.id.textcategory8);
            refreshImageView=findViewById(R.id.refreshImageView);
            backImageView=findViewById(R.id.backImageView);
            saveDataTextView=findViewById(R.id.saveDataTextView);

            refreshImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    wieghtEditText.setText("");
                    hieghtEditText.setText("");
                    bmiResultTextView.setText("0");
                    bmiCategoryeditText.setText("");
                }
            });

            backImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),SecondPageActivity.class);
                    startActivity(intent);
                }
            });

                saveDataTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        ParseQuery<ParseObject> query = ParseQuery.getQuery("Bmi");
                        query.whereEqualTo("UserId", MainActivity.userId);
                        query.findInBackground(new FindCallback<ParseObject>() {
                                                   @Override
                                                   public void done(List<ParseObject> objects, ParseException e) {
                                                       if (e == null) {
                                                           for (ParseObject object : objects) {
                                                               bmiObjectId=object.getObjectId();
//
                                                               Log.i("FindINBackgrondResult",bmiObjectId);
                                                               //Log.i("FindInBackground:", object.getString("Bmi"));

                                                           }
                                                           if (objects.size() > 0) {
//                                                               int k=objects.size();
                                                               Log.i("object size",Integer.toString(objects.size()));

                                                               ParseQuery<ParseObject> query1 = ParseQuery.getQuery("Bmi");
                                                               query1.getInBackground(bmiObjectId, new GetCallback<ParseObject>() {
                                                                   @Override
                                                                   public void done(ParseObject object, ParseException e) {
                                                                       if (e == null && object != null) {
                                                                           object.put("Bmi", bmiActivity.bmi2.substring(0,4));
                                                                           object.saveInBackground();
                                                                           saveDataTextView.setVisibility(View.INVISIBLE);
                                                                           Toast.makeText(bmiActivity.this,"Data Updated Sucessfully!", Toast.LENGTH_SHORT).show();

                                                                           Log.i("Bmi Value", object.getString("Bmi"));
                                                                       } else {
                                                                           Toast.makeText(bmiActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                                                                           Log.i("Sorry", "Failed!!!!");
                                                                       }
                                                                   }
                                                               });

                                                           } else {
                                                               ParseObject object = new ParseObject("Bmi");
                                                               object.put("UserId", MainActivity.userId);
                                                               object.put("Bmi", bmi2.substring(0,4));
                                                               object.saveInBackground(new SaveCallback() {
                                                                   @Override
                                                                   public void done(ParseException e) {
                                                                       if (e == null) {
                                                                           Log.i("Congrats!!!! Bmi Saved", bmi2.substring(0,4));

                                                                       } else {
                                                                           Log.i("Sorryyy!!!!!", "Data Not Saved....");
                                                                       }
                                                                   }
                                                               });

                                                               Toast.makeText(bmiActivity.this, "Data saved Sucessfully!", Toast.LENGTH_SHORT).show();
                                                               saveDataTextView.setVisibility(View.INVISIBLE);

                                                           }
                                                       }
                                                   }
                            });
                    }
                });
        }
}

//                        Toast.makeText(bmiActivity.this, "Data saved Sucessfully!", Toast.LENGTH_SHORT).show();
//                        saveDataTextView.setVisibility(View.INVISIBLE);
//
//                        ParseObject object =new ParseObject("Bmi");
////                        object.put("Username",SecondPageActivity.currentUserString);
//                        object.put("UserId",MainActivity.userId);
//                        object.put("Bmi",bmi2);
//                        object.saveInBackground(new SaveCallback() {
//                            @Override
//                            public void done(ParseException e) {
//                                if(e==null){
//                                    Log.i("Congrats!!!! Bmi Saved", bmi2);
////                                    Log.i("Congratss!!!! UserName Save",SecondPageActivity.currentUserString);
//                                }
//                                else{
//                                    Log.i("Sorryyy!!!!!","Data Not Saved....");
//                                }
//                            }
//                        });
//
//
//                    }
//                });







































