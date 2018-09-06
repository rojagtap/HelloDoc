package com.axiomcorp.hellodoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class YesNoActivity extends AppCompatActivity {
    Intent intent,intentnext;
    String display;
    TextView question;

    public String getDisplay(Intent intent){
        switch(intent.getStringExtra("source")){
            case "Cough":
                display="do you also experience a blocked/runny nose and/or sneezing?";
                break;
            case "cough_yes":
            case "cough_no":
                display="are you experiencing this since a long time?";
                break;
            case "Dried Mouth":
                display="do you also always feel thirsty and light headed?";
                break;
            case "Vomiting":
                display="do you also experience problems like loss of appetite/blood in stools/loss in weight?";
                break;
        }
        return display;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yes_no);
        intent=getIntent();
        question=(TextView)findViewById(R.id.Question);
        question.setText(getDisplay(intent));
    }

    public void goYes(View view){
        switch(intent.getStringExtra("source")){
            case "Cough":
                intentnext=new Intent(this,YesNoActivity.class);
                intentnext.putExtra("source","cough_yes");
                intentnext.putExtra("name",intent.getStringExtra("name"));
                startActivity(intentnext);
                break;
            case "cough_yes":
            case "cough_no":
                intentnext=new Intent(this,ToDoctor.class);
                intentnext.putExtra("name",intent.getStringExtra("name"));
                startActivity(intentnext);
                break;
            case "Dried Mouth":
                intentnext=new Intent(this,FinalActivity.class);
                intentnext.putExtra("source","Dehydration");
                intentnext.putExtra("name",intent.getStringExtra("name"));
                startActivity(intentnext);
                break;
            case "Vomiting":
                intentnext=new Intent(this,FinalActivity.class);
                intentnext.putExtra("source","Diarrhoea");
                intentnext.putExtra("name",intent.getStringExtra("name"));
                startActivity(intentnext);
                break;
        }
    }

    public void goNo(View view){
        switch(intent.getStringExtra("source")){
            case "Cough":
                intentnext=new Intent(this,YesNoActivity.class);
                intentnext.putExtra("source","cough_no");
                intentnext.putExtra("name",intent.getStringExtra("name"));
                startActivity(intentnext);
                break;
            case "cough_yes":
            case "cough_no":
                intentnext=new Intent(this,FinalActivity.class);
                intentnext.putExtra("source","cold");
                intentnext.putExtra("name",intent.getStringExtra("name"));
                startActivity(intentnext);
                break;
            case "Dried Mouth":
                intentnext=new Intent(this,ToDoctor.class);
                startActivity(intentnext);
                break;
            case "Vomiting":
                intentnext=new Intent(this,ToDoctor.class);
                intentnext.putExtra("name",intent.getStringExtra("name"));
                startActivity(intentnext);
                break;
        }
    }
}