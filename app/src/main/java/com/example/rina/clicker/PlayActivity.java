package com.example.rina.clicker;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class PlayActivity extends AppCompatActivity {
    private ImageView img_click1, img_click2,img_click3;
    public static int sum_click=0;
    private int n;
    private TextView clickText;

    private static final long START_TIME_IN_MILLIS = 30000;

    private TextView mTextViewCountDown;
    private Button mButtonStartPause;

    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        img_click1=(ImageView) findViewById(R.id.img_click1);
        img_click2=(ImageView) findViewById(R.id.img_click2);
        img_click3=(ImageView) findViewById(R.id.img_click3);
        clickText=(TextView)findViewById(R.id.textViewClick);
        mTextViewCountDown = findViewById(R.id.text_view_countdown);
        mButtonStartPause = findViewById(R.id.button_start_pause);



        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();

                }
            }
        });

        updateCountDownText();

    }





    private void startTimer() {
        n=1;
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
                img_click1.setOnClickListener(myButtonClickListener);
                img_click2.setOnClickListener(myButtonClickListener);
                img_click3.setOnClickListener(myButtonClickListener);

            }
            @Override
            public void onFinish() {
                mTimerRunning = false;
                Intent intent = new Intent(PlayActivity.this, Result_activity.class);
                startActivity(intent);

            }
        }.start();
        mTimerRunning = true;
        mButtonStartPause.setText("pause");

    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mButtonStartPause.setText("Start");
        n=0;


    }


    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        mTextViewCountDown.setText(timeLeftFormatted);
    }


    public int getSum_click() {
        return sum_click;
    }
    public static void setSum_click(int sum_click) {
        PlayActivity.sum_click = sum_click;
    }

    View.OnClickListener myButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

             sum_click=sum_click+n;
            clickText.setText("Presently"+"\n"+ "score "+sum_click);
            if(sum_click<=50) {
                img_click1.setVisibility(View.VISIBLE);
                img_click2.setVisibility(View.GONE);
                img_click3.setVisibility(View.GONE);
            }
            if(sum_click<=100&&sum_click>50){
                img_click1.setVisibility(View.GONE);
                img_click2.setVisibility(View.VISIBLE);
                img_click3.setVisibility(View.GONE);
            }
            if (sum_click>100){
                img_click1.setVisibility(View.GONE);
                img_click2.setVisibility(View.GONE);
                img_click3.setVisibility(View.VISIBLE);
            }

        }
    };


    @Override
    public void onBackPressed() {

    }

}

