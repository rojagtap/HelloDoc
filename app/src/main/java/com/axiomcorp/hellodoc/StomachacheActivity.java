package com.axiomcorp.hellodoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class StomachacheActivity extends AppCompatActivity {
    RadioGroup radiogroup;
    String selection;
    Intent getprev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stomachache);
        radiogroup=(RadioGroup)findViewById(R.id.RadioGroupStomachache);
        getprev=getIntent();
    }

    public void goNext(View view){
        if(radiogroup.getCheckedRadioButtonId()!=-1){
            selection=((RadioButton)findViewById(radiogroup.getCheckedRadioButtonId())).getText().toString();
            Intent intent;
            switch(selection){
                case "Acidity":
                    intent=new Intent(this,FinalActivity.class);
                    intent.putExtra("source",selection);
                    intent.putExtra("name",getprev.getStringExtra("name"));
                    startActivity(intent);
                    break;
                case "Vomiting":
                    intent=new Intent(this,YesNoActivity.class);
                    intent.putExtra("source",selection);
                    intent.putExtra("name",getprev.getStringExtra("name"));
                    startActivity(intent);
                    break;
            }
        }
    }
}
