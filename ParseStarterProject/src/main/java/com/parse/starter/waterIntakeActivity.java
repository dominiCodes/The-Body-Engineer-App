package com.parse.starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.List;

public class waterIntakeActivity extends AppCompatActivity {

    Button waterCalButton;
    EditText weightText;
    TextView ozText,ltrText;
    float weight;
    String ltrresult,ozresult;
    ImageView backImageView, undoImageView;
    TextView saveDataTextView;
    public static String waterIntakeVal="";
    public static String wIntakeObjectId="";


    public void waterCalClick(View view){
        saveDataTextView.setVisibility(View.VISIBLE);
        weight=Float.parseFloat(weightText.getText().toString());
        double ltrformula= weight*0.033;
        ltrresult=Double.toString(ltrformula);
        ltrText.setText(ltrresult.substring(0,3)+"   Ltr");
        double ozformula= ltrformula*33.814; //weight*33.814 is the formula for conversion from ltr to oz.
        ozresult=Double.toString(ozformula);
        ozText.setText(ozresult.substring(0,3)+"   Oz");
        waterIntakeVal=ltrresult.substring(0,4)+" Ltr"+"/"+ozresult.substring(0,4)+" Oz";
        Log.i("Water Intake",waterIntakeVal);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_intake);
        waterCalButton=findViewById(R.id.waterCalButton);
        weightText=findViewById(R.id.weightText);
        ozText=findViewById(R.id.ozText);
        ltrText=findViewById(R.id.ltrText);
        backImageView=findViewById(R.id.backImageView);
        undoImageView=findViewById(R.id.undoImageView);
        saveDataTextView=findViewById(R.id.saveDataTextView);


        undoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weightText.setText("");
                ozText.setText("0");
                ltrText.setText("0");

            }
        });
        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),SecondPageActivity.class);
                startActivity(intent);
            }
        });
        saveDataTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseQuery<ParseObject> query = ParseQuery.getQuery("WaterIntake");
                query.whereEqualTo("UserId", MainActivity.userId);
                query.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {
                        if (e == null) {
                            for (ParseObject object : objects) {
                                wIntakeObjectId=object.getObjectId();
//
                                Log.i("FindINBackgrondResult",wIntakeObjectId);
                                //Log.i("FindInBackground:", object.getString("Bmi"));

                            }
                            if (objects.size() > 0) {
//                                                               int k=objects.size();
                                Log.i("Water Intake object size",Integer.toString(objects.size()));

                                ParseQuery<ParseObject> query1 = ParseQuery.getQuery("WaterIntake");
                                query1.getInBackground(wIntakeObjectId, new GetCallback<ParseObject>() {
                                    @Override
                                    public void done(ParseObject object, ParseException e) {
                                        if (e == null && object != null) {
                                            object.put("wIntake", waterIntakeVal);
                                            object.saveInBackground();
                                            saveDataTextView.setVisibility(View.INVISIBLE);
                                            Toast.makeText(waterIntakeActivity.this,"Data Updated Sucessfully!", Toast.LENGTH_SHORT).show();

                                            Log.i("Bmr Value", object.getString("wIntake"));
                                        } else {
                                            Toast.makeText(waterIntakeActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                                            Log.i("Sorry", "Failed!!!!");
                                        }
                                    }
                                });

                            } else {
                                ParseObject object = new ParseObject("WaterIntake");
                                object.put("UserId", MainActivity.userId);
                                object.put("wIntake", waterIntakeVal);
                                object.saveInBackground(new SaveCallback() {
                                    @Override
                                    public void done(ParseException e) {
                                        if (e == null) {
                                            Log.i("Congrats!!!! Water Intake  Saved", waterIntakeVal);

                                        } else {
                                            Log.i("Sorryyy!!!!!", "Data Not Saved....");
                                        }
                                    }
                                });

                                Toast.makeText(waterIntakeActivity.this, "Data saved Sucessfully!", Toast.LENGTH_SHORT).show();
                                saveDataTextView.setVisibility(View.INVISIBLE);

                            }
                        }
                    }
                });

            }
        });
    }
}