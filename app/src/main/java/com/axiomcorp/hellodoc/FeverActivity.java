package com.axiomcorp.hellodoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FeverActivity extends AppCompatActivity {
    String selection;
    RadioGroup radiogroup;
    Intent getprev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fever);
        radiogroup=(RadioGroup)findViewById(R.id.RadioGroup2_1_2);
        getprev=getIntent();
    }

    public void goNext(View view){
        if(radiogroup.getCheckedRadioButtonId()!=-1){
            selection=((RadioButton)findViewById(radiogroup.getCheckedRadioButtonId())).getText().toString();
            Intent intent=new Intent(this,FinalActivity.class);
            intent.putExtra("source",selection);
            intent.putExtra("name",getprev.getStringExtra("name"));
            startActivity(intent);
        }
    }
}
