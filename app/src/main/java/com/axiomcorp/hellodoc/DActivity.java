package com.axiomcorp.hellodoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class DActivity extends AppCompatActivity {
    RadioGroup radiogroup;
    String selection;
    Intent getprev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);
        radiogroup=(RadioGroup)findViewById(R.id.RadioGroupD);
        getprev=getIntent();
    }

    public void goNext(View view){
        if((radiogroup.getCheckedRadioButtonId())!=-1){
            selection=((RadioButton)findViewById(radiogroup.getCheckedRadioButtonId())).getText().toString();
            Intent intent;
            switch(selection){
                case "Dried Mouth":
                    intent=new Intent(this,YesNoActivity.class);
                    intent.putExtra("source",selection);
                    intent.putExtra("name",getprev.getStringExtra("name"));
                    startActivity(intent);
                    break;
                case "Stomach ache":
                    intent=new Intent(this,StomachacheActivity.class);
                    intent.putExtra("name",getprev.getStringExtra("name"));
                    startActivity(intent);
                    break;
            }
        }
    }
}
