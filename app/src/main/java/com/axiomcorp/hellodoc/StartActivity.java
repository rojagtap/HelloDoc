package com.axiomcorp.hellodoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class StartActivity extends AppCompatActivity {
    RadioGroup radiogroup;
    String selection;
    Intent previntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        radiogroup=(RadioGroup)findViewById(R.id.RadioGroup1);
        previntent=getIntent();
    }

    public void goNext(View view){
        if(radiogroup.getCheckedRadioButtonId()!=-1){
            selection=((RadioButton)findViewById(radiogroup.getCheckedRadioButtonId())).getText().toString();
            Intent intent;
            switch(selection) {
                case "Headache":
                    intent = new Intent(this, HeadacheActivity.class);
                    intent.putExtra("name",previntent.getStringExtra("name"));
                    startActivity(intent);
                    break;
                case "Got Cuts/Wounds":
                    intent = new Intent(this, CutActivity.class);
                    intent.putExtra("name",previntent.getStringExtra("name"));
                    startActivity(intent);
                    break;
                case "Fever":
                    intent = new Intent(this, FeverActivity.class);
                    intent.putExtra("name",previntent.getStringExtra("name"));
                    startActivity(intent);
                    break;
                case "Cough":
                    intent=new Intent(this,YesNoActivity.class);
                    intent.putExtra("source",selection);
                    intent.putExtra("name",previntent.getStringExtra("name"));
                    startActivity(intent);
                    break;
                case "Tired":
                    intent=new Intent(this,DActivity.class);
                    intent.putExtra("name",previntent.getStringExtra("name"));
                    startActivity(intent);
                    break;
                case "Stomach ache":
                    intent=new Intent(this,StomachacheActivity.class);
                    intent.putExtra("name",previntent.getStringExtra("name"));
                    startActivity(intent);
                    break;
                case "Toothache":
                    intent=new Intent(this,FinalActivity.class);
                    intent.putExtra("source",selection);
                    intent.putExtra("name",previntent.getStringExtra("name"));
                    startActivity(intent);
                    break;
            }
        }
    }
}