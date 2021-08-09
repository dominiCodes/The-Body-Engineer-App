package com.parse.starter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.parse.GetCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class WorkoutActivity extends AppCompatActivity {
    ImageView workoutImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
//        workoutImageView=findViewById(R.id.workoutImageView);


        ParseQuery<ParseObject> workoutQuery = ParseQuery.getQuery("Workout");
        workoutQuery.getInBackground("ravn2Ool6t", new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if(e==null && object !=null){
                    ParseFile file = (ParseFile) object.get("WorkoutPlan");
                    file.getDataInBackground(new GetDataCallback() {
                        @Override
                        public void done(byte[] data, ParseException e) {
                            if(e==null && data!=null){
                                Bitmap bitmap = BitmapFactory.decodeByteArray(data,0,data.length);
                                workoutImageView = new ImageView(getApplicationContext());
                                workoutImageView.setLayoutParams(new ViewGroup.LayoutParams(
                                        ViewGroup.LayoutParams.MATCH_PARENT,
                                        ViewGroup.LayoutParams.WRAP_CONTENT
                                ));
                                workoutImageView.setImageBitmap(bitmap);
                                Log.i("Workout Image Upload","Sucessfull!!!!");
                            }else{
                                Log.i("Failed!!",e.getMessage());
                            }
                        }
                    });
                }else{
                    Log.i("Soryyyy",e.getMessage());
                }
            }
        });
    }
}