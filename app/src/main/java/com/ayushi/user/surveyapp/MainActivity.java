package com.ayushi.user.surveyapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ayushi.user.surveyapp.util.Options;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup1,radioGroup2,radioGroup3,radioGroup4,radioGroup5;
    private RadioButton rb11,rb21,rb31,rb41,rb51,rb12,rb22,rb32,rb42,rb13,rb23,rb33,rb43
            ,rb14,rb24,rb34,rb44,rb15,rb25,rb35,rb45;
    DatabaseReference db;
    private Button btnSubmit;
    String  d;
    int select1,select2,select3,select4,select5,count1=0,count2=0,count3=0,count4=0,count21=0,count22=0,count23=0,count24=0
    ,count31=0,count32=0,count33=0,count34=0,count41=0,count42=0,count43=0,count44=0,count51=0,count52=0,count53=0,count54=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit=(Button)findViewById(R.id.btn1);
        radioGroup1=(RadioGroup)findViewById(R.id.rg1);
        radioGroup2=(RadioGroup)findViewById(R.id.rg2);
        radioGroup3=(RadioGroup)findViewById(R.id.rg3);
        radioGroup4=(RadioGroup)findViewById(R.id.rg4);
        radioGroup5=(RadioGroup)findViewById(R.id.rg5);

        db= FirebaseDatabase.getInstance().getReference("Question");

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submittheanswers();
            }
        });

    }

    private void submittheanswers() {

        select1=radioGroup1.getCheckedRadioButtonId();
        rb11=(RadioButton)findViewById(select1);
        if(radioGroup1.isEnabled()) {
            d=rb11.getText().toString();
            Log.d("checkkk", "onDataChange: "+d);
            db.child("Question").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Log.d("check", "onDataChange: "+dataSnapshot);
                    for (DataSnapshot snap : dataSnapshot.getChildren()) {
                        Log.d("checkk"," "+snap);
                        String coun = snap.child("Count1").getValue(String.class);

                        Log.d("a", "hello: "+coun);
                        int coun1=Integer.parseInt(coun);
                        Log.d("aa", "theree: "+coun1);

                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            if(d.equals("Very Satisfied"))
            {


            }
            if(d.equals("Somewhat satisfied"))
            {
               // count2++;
            }
            if(d.equals("Somewhat dissatisfied"))
            {
              //  count3++;
            }
            if(d.equals("Very dissatisfiedd"))
            {
               // count4++;
            }

//            Options op=new Options(count1,count2,count3,count4);
//            db.child("1").setValue(op);
//            Toast.makeText(MainActivity.this, "option added 1", Toast.LENGTH_SHORT).show();

        }
//        select2=radioGroup2.getCheckedRadioButtonId();
//        rb21=(RadioButton)findViewById(select2);
//        if(radioGroup2.isEnabled()) {
//            d=rb21.getText().toString();
//            if(d.equals("Very Satisfied"))
//            { Toast.makeText(MainActivity.this, d, Toast.LENGTH_SHORT).show();
//
//                count21++;
//            }
//            if(d.equals("Somewhat satisfied"))
//            {
//                count22++;
//            }
//            if(d.equals("Somewhat dissatisfied"))
//            {
//                count23++;
//            }
//            if(d.equals("Very dissatisfiedd"))
//            {
//                count24++;
//            }
//
////            Options op=new Options(count21,count22,count23,count24);
////            db.child("2").setValue(op);
////            Toast.makeText(MainActivity.this, "option added 2", Toast.LENGTH_SHORT).show();
//
//        }
//        select3=radioGroup3.getCheckedRadioButtonId();
//        rb31=(RadioButton)findViewById(select3);
//        if(radioGroup3.isEnabled()) {
//            d=rb31.getText().toString();
//            if(d.equals("Very Satisfied"))
//            { Toast.makeText(MainActivity.this, d, Toast.LENGTH_SHORT).show();
//
//                count1++;
//            }
//            if(d.equals("Somewhat satisfied"))
//            {
//                count2++;
//            }
//            if(d.equals("Somewhat dissatisfied"))
//            {
//                count3++;
//            }
//            if(d.equals("Very dissatisfiedd"))
//            {
//                count4++;
//            }
////
////            Options op=new Options(count1,count2,count3,count4);
////            db.child("3").setValue(op);
////            Toast.makeText(MainActivity.this, "option added 3", Toast.LENGTH_SHORT).show();
//
//        }
//        select4=radioGroup4.getCheckedRadioButtonId();
//        rb41=(RadioButton)findViewById(select4);
//        if(radioGroup4.isEnabled()) {
//            d=rb41.getText().toString();
//            if(d.equals("Very Satisfied"))
//            { Toast.makeText(MainActivity.this, d, Toast.LENGTH_SHORT).show();
//
//                count1++;
//            }
//            if(d.equals("Somewhat satisfied"))
//            {
//                count2++;
//            }
//            if(d.equals("Somewhat dissatisfied"))
//            {
//                count3++;
//            }
//            if(d.equals("Very dissatisfiedd"))
//            {
//                count4++;
//            }
//
////            Options op=new Options(count1,count2,count3,count4);
////            db.child("4").setValue(op);
////            Toast.makeText(MainActivity.this, "option added 4", Toast.LENGTH_SHORT).show();
//
//        }
//        select5=radioGroup5.getCheckedRadioButtonId();
//        rb51=(RadioButton)findViewById(select5);
//        if(radioGroup5.isEnabled()) {
//            d=rb51.getText().toString();
//            if(d.equals("Very Satisfied"))
//            { Toast.makeText(MainActivity.this, d, Toast.LENGTH_SHORT).show();
//
//                count1++;
//            }
//            if(d.equals("Somewhat satisfied"))
//            {
//                count2++;
//            }
//            if(d.equals("Somewhat dissatisfied"))
//            {
//                count3++;
//            }
//            if(d.equals("Very dissatisfiedd"))
//            {
//                count4++;
//            }
//
////            Options op=new Options(count1,count2,count3,count4);
////            db.child("5").setValue(op);
////            Toast.makeText(MainActivity.this, "option added 5", Toast.LENGTH_SHORT).show();

//        }
    }


}
