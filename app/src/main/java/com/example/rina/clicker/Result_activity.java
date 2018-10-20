package com.example.rina.clicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Result_activity extends AppCompatActivity {
    private TextView text_result;
    private ImageView mark_good, mark_great, mark_bad;
    private Button btn_restart;

    PlayActivity sum_click = new PlayActivity();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_activity);
        text_result=(TextView)findViewById(R.id.text_result);
        mark_good=(ImageView)findViewById(R.id.image_mark_good);
        mark_bad=(ImageView)findViewById(R.id.image_mark_bad);
        mark_great=(ImageView)findViewById(R.id.image_mark_great);
        btn_restart=(Button)findViewById(R.id.btn_restart);





        try{
            text_result.setText("You collected "+sum_click.getSum_click()+" clicks per game");
        }
        catch (NullPointerException e) {
            text_result.setText("Вы ничего не сделали");
        }
        if(sum_click.getSum_click()>=100)
            mark_great.setVisibility(View.VISIBLE);

        if(sum_click.getSum_click()>=50&&sum_click.getSum_click()<100)
            mark_good.setVisibility(View.VISIBLE);
        if (sum_click.getSum_click()<50)
            mark_bad.setVisibility(View.VISIBLE);

        btn_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Result_activity.this, PlayActivity.class));
            }
        });

        sum_click.setSum_click(0);
    }

    @Override
    public void onBackPressed() {

    }
}
