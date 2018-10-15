package com.example.rina.clicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result_activity extends AppCompatActivity {
    private TextView text_result;
    PlayActivity sum_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_activity);
        text_result=(TextView)findViewById(R.id.text_result);
        text_result.setText("За отведенное количество времени получено "+sum_click.getSum_click() );

    }


}
