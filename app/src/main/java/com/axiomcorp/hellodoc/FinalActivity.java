package com.axiomcorp.hellodoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {
    TextView answer;
    public String display,name;

    public String getDisplay(Intent intent){
        name=intent.getStringExtra("name");
        switch(intent.getStringExtra("source")){
            case "Just Headache":
                display="You need to take Paramet tablets for 3 days, 1 after meal. Not more than 3 days.";
                break;
            case "Headache & Body Pain":
                display="You need to take Crocin Pain Relief tablets- 1 after meal. Have a sound sleep.";
                break;
            case "Normal Fever":
                display="You need to take Metacin(500mg) tablets- 1 after meal. Have a sound sleep.";
                break;
            case "Fever since long time":
                display="This could be serious. Fever since long time can be a symptom for TB. You need to visit a Doctor.";
                break;
            case "Red rashes all over":
                display="You probably have Chickenpox. Please visit a Doctor for future healthcare.";
                break;
            case "Normal Cut":
                display="In general, cuts do not need any special care. But you might need to consult a doctor if the cut(s) are on the face. Plus, you can clean the cut with an antiseptic";
                break;
            case "Cut by a metal":
                display="In general, cuts do not need any special care. But you might need to consult a doctor if the cut(s) are on the face. Plus, you can clean the cut with an antiseptic and take a tetanus vaccine to prevent infections.";
                break;
            case "Deep Wound":
                display="First you need to stop the blood by covering the wound with a cloth. Then clean it with an antiseptic. Further consult a Doctor to check if there is some infection.";
                break;
            case "cold":
                display="This seems to be Common Cold. Generally, common colds need not be diagnosed. Yet, you may apply Vicks VapoRub for relief.";
                break;
            case "Acidity":
                display="You may take antacids like ENO. Also, avoid having oily foodstuffs and have bland food till you get completely fit.";
                break;
            case "Dehydration":
                display="You are suffering from Dehydration. Dehydration can be from mild to fatal. In case of severe Dehydration, go to the Doctor straight away! You may take Oral Rehydration Solution(ORS). It is prepared by mixing 6 teaspoons of Sugar and half teaspoon of Salt in 1 litre of drinking or boiled(then cooled) water. And regularly keep drinking small amounts of fluids.";
            case "Diarrhoea":
                display="Take Imodium tablets after every stool. Do not exceed more than 8mg in 24 hours. Diarrhoea generally results in dehydration, so it is recommended that you take fluids in plenty. If the medicine results into any extra symptoms, rush to a Doctor to treat the side effects.";
                break;
            case "Toothache":
                display="Toothache has to be treated in person by a dentist. But as a temporary aid, take a Combiflam pain killer tablet.";
                break;
        }
        display=name+", your diagnosis is complete. "+display;
        return display;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        Intent intent=getIntent();
        answer=(TextView)findViewById(R.id.finalAnswer);
        answer.setText(getDisplay(intent));
    }
}