package com.axiomcorp.hellodoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class HeadacheActivity extends AppCompatActivity {
    RadioGroup radiogroup;
    String selection,selection1;
    Intent getprev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headache);
        radiogroup=(RadioGroup)findViewById(R.id.RadioGroup2_1);
        getprev=getIntent();
        selection1=getprev.getStringExtra("fromstartheadache");
    }

    public void goNext(View view){
        if(radiogroup.getCheckedRadioButtonId()!=-1) {
            selection=((RadioButton)findViewById(radiogroup.getCheckedRadioButtonId())).getText().toString();
            Intent intent;
            switch(selection) {
                case "Just Headache":
                    intent = new Intent(this, FinalActivity.class);
                    intent.putExtra("source", selection);
                    intent.putExtra("name",getprev.getStringExtra("name"));
                    startActivity(intent);
                break;
                case "Headache & Fever":
                    intent = new Intent(this, FeverActivity.class);
                    intent.putExtra("name",getprev.getStringExtra("name"));
                    startActivity(intent);
                break;
                case "Headache & Body Pain":
                    intent = new Intent(this, FinalActivity.class);
                    intent.putExtra("source", selection);
                    intent.putExtra("name",getprev.getStringExtra("name"));
                    startActivity(intent);
                break;
            }
        }
    }
}
