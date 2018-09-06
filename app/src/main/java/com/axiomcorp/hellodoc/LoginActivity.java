package com.axiomcorp.hellodoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.*;

public class LoginActivity extends AppCompatActivity {
    String name,age;
    public static final String regex_alpha="^[a-zA-Z]+$";
    public Intent intent;
    EditText text1,text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        text1=(EditText)findViewById(R.id.optName);
        text2=(EditText)findViewById(R.id.optAge);
    }

    public void goNext(View view){
        name=text1.getText().toString();
        age=text2.getText().toString();
        if(name.isEmpty()||age.isEmpty())
            Toast.makeText(this, "empty field(s)", Toast.LENGTH_SHORT).show();
        else if(Integer.parseInt(age)<5||Integer.parseInt(age)>99)
            Toast.makeText(this,"age should be between 5 and 99 years",Toast.LENGTH_LONG).show();
        else if(!name.matches(regex_alpha))
            Toast.makeText(this,"invalid name or age",Toast.LENGTH_SHORT).show();
        else {
            intent = new Intent(this, StartActivity.class);
            intent.putExtra("name", name);
            startActivity(intent);
        }
    }

    public void goAbout(View view){
        intent=new Intent(this,AboutActivity.class);
        startActivity(intent);
    }
}