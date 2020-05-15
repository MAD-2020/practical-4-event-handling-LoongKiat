package sg.edu.np.WhackAMole;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class Main2Activity extends AppCompatActivity {

    private static final String TAG = "Whack-A-Mole 2.0";
    private int score = 0;
    private int countdown = 10;
    private Button target = null;
    CountDownTimer countDown;
    private TextView tv;
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent receive = getIntent();
        score = receive.getIntExtra("Score",0);
        Log.d(TAG, "Current User Score: " + score);
        tv = findViewById(R.id.updatedScore);
        tv.setText(String.valueOf(score));

        button0 = findViewById(R.id.zero);
        button1 = findViewById(R.id.one);
        button2 = findViewById(R.id.two);
        button3 = findViewById(R.id.three);
        button4 = findViewById(R.id.four);
        button5 = findViewById(R.id.five);
        button6 = findViewById(R.id.six);
        button7 = findViewById(R.id.seven);
        button8 = findViewById(R.id.eight);

        button0.setOnClickListener(buttonClick);
        button1.setOnClickListener(buttonClick);
        button2.setOnClickListener(buttonClick);
        button3.setOnClickListener(buttonClick);
        button4.setOnClickListener(buttonClick);
        button5.setOnClickListener(buttonClick);
        button6.setOnClickListener(buttonClick);
        button7.setOnClickListener(buttonClick);
        button8.setOnClickListener(buttonClick);
        readyTimer();
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume(){
        super.onResume();
        countDown.start();
    }
    private View.OnClickListener buttonClick = new View.OnClickListener() {
        Button test;
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.zero:{
                    test = findViewById(R.id.zero);
                    break;
                }
                case R.id.one:{
                    test = findViewById(R.id.one);
                    break;
                }
                case R.id.two:{
                    test = findViewById(R.id.two);
                    break;
                }
                case R.id.three:{
                    test = findViewById(R.id.three);
                    break;
                }
                case R.id.four:{
                    test = findViewById(R.id.four);
                    break;
                }
                case R.id.five:{
                    test = findViewById(R.id.five);
                    break;
                }
                case R.id.six:{
                    test = findViewById(R.id.six);
                    break;
                }
                case R.id.seven:{
                    test = findViewById(R.id.seven);
                    break;
                }
                default:{
                    test = findViewById(R.id.eight);
                    break;
                }
            }
            doCheck(test);
        }
    };
    public void setNewMole()
    {
        Random ran = new Random();
        int randomLocation = ran.nextInt(9);
        switch (randomLocation){
            case 0:{
                target = button0;
                target.setText("*");
                button1.setText("0");
                button2.setText("0");
                button3.setText("0");
                button4.setText("0");
                button5.setText("0");
                button6.setText("0");
                button7.setText("0");
                button8.setText("0");
                break;
            }
            case 1:{
                target = button1;
                target.setText("*");
                button0.setText("0");
                button2.setText("0");
                button3.setText("0");
                button4.setText("0");
                button5.setText("0");
                button6.setText("0");
                button7.setText("0");
                button8.setText("0");
                break;
            }
            case 2:{
                target = button2;
                target.setText("*");
                button0.setText("0");
                button1.setText("0");
                button3.setText("0");
                button4.setText("0");
                button5.setText("0");
                button6.setText("0");
                button7.setText("0");
                button8.setText("0");
                break;
            }
            case 3:{
                target = button3;
                target.setText("*");
                button0.setText("0");
                button1.setText("0");
                button2.setText("0");
                button4.setText("0");
                button5.setText("0");
                button6.setText("0");
                button7.setText("0");
                button8.setText("0");
                break;
            }
            case 4:{
                target = button4;
                target.setText("*");
                button0.setText("0");
                button1.setText("0");
                button2.setText("0");
                button3.setText("0");
                button5.setText("0");
                button6.setText("0");
                button7.setText("0");
                button8.setText("0");
                break;
            }
            case 5:{
                target = button5;
                target.setText("*");
                button0.setText("0");
                button1.setText("0");
                button2.setText("0");
                button3.setText("0");
                button4.setText("0");
                button6.setText("0");
                button7.setText("0");
                button8.setText("0");
                break;
            }
            case 6:{
                target = button6;
                target.setText("*");
                button0.setText("0");
                button1.setText("0");
                button2.setText("0");
                button3.setText("0");
                button4.setText("0");
                button5.setText("0");
                button7.setText("0");
                button8.setText("0");
                break;
            }
            case 7:{
                target = button7;
                target.setText("*");
                button0.setText("0");
                button1.setText("0");
                button2.setText("0");
                button3.setText("0");
                button4.setText("0");
                button5.setText("0");
                button6.setText("0");
                button8.setText("0");
                break;
            }
            default:{
                target = button8;
                target.setText("*");
                button0.setText("0");
                button1.setText("0");
                button2.setText("0");
                button3.setText("0");
                button4.setText("0");
                button5.setText("0");
                button6.setText("0");
                button7.setText("0");
                break;
            }
        }
    }
    private void doCheck(Button checkButton)
    {
        switch (checkButton.getId()){
            case R.id.zero:{
                if (button0.getText() == "*" ){
                    score += 1;
                    Log.d(TAG, "Hit, score added!");
                }
                else {
                    score -= 1;
                    Log.d(TAG, "Missed, score deducted!");
                }
                tv.setText(String.valueOf(score));
                break;
            }
            case R.id.one:{
                if (button1.getText() == "*"){
                    score += 1;
                    Log.d(TAG, "Hit, score added!");
                }
                else{
                    score -= 1;
                    Log.d(TAG, "Missed, score deducted!");
                }
                tv.setText(String.valueOf(score));
                break;
            }
            case R.id.two:{
                if (button2.getText() == "*"){
                    score += 1;
                    Log.d(TAG, "Hit, score added!");
                }
                else{
                    score -= 1;
                    Log.d(TAG, "Missed, score deducted!");
                }
                tv.setText(String.valueOf(score));
                break;
            }
            case R.id.three:{
                if (button3.getText() == "*"){
                    score += 1;
                    Log.d(TAG, "Hit, score added!");
                }
                else{
                    score -= 1;
                    Log.d(TAG, "Missed, score deducted!");
                }
                tv.setText(String.valueOf(score));
                break;
            }
            case R.id.four:{
                if (button4.getText() == "*"){
                    score += 1;
                    Log.d(TAG, "Hit, score added!");
                }
                else{
                    score -= 1;
                    Log.d(TAG, "Missed, score deducted!");
                }
                tv.setText(String.valueOf(score));
                break;
            }
            case R.id.five:{
                if (button5.getText() == "*"){
                    score += 1;
                    Log.d(TAG, "Hit, score added!");
                }
                else{
                    score -= 1;
                    Log.d(TAG, "Missed, score deducted!");
                }
                tv.setText(String.valueOf(score));
                break;
            }
            case R.id.six:{
                if (button6.getText() == "*"){
                    score += 1;
                    Log.d(TAG, "Hit, score added!");
                }
                else{
                    score -= 1;
                    Log.d(TAG, "Missed, score deducted!");
                }
                tv.setText(String.valueOf(score));
                break;
            }
            case R.id.seven:{
                if (button7.getText() == "*"){
                    score += 1;
                    Log.d(TAG, "Hit, score added!");
                }
                else{
                    score -= 1;
                    Log.d(TAG, "Missed, score deducted!");
                }
                tv.setText(String.valueOf(score));
                break;
            }
            default:{
                if (button8.getText() == "*"){
                    score += 1;
                    Log.d(TAG, "Hit, score added!");
                }
                else{
                    score -= 1;
                    Log.d(TAG, "Missed, score deducted!");
                }
                tv.setText(String.valueOf(score));
                break;
            }
        }
    }
    private void readyTimer(){
        Toast.makeText(this,"Get ready in " + countdown + " seconds",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Ready CountDown!" + countdown);
        countDown = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                countdown -= 1;
                Toast.makeText(Main2Activity.this,"Get ready in " + countdown + " seconds",Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Ready CountDown!" + millisUntilFinished/1000);

            }
            @Override
            public void onFinish() {
                Toast.makeText(Main2Activity.this,"GO!",Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Ready CountDown Complete!");
                countDown.cancel();
                placeMoleTimer();
            }
        };
    }
    private void placeMoleTimer(){
        countDown = new CountDownTimer(1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                setNewMole();
                Log.d(TAG, "new Mole Location!");

            }
            @Override
            public void onFinish() {
                countDown.start();
            }
        };
        countDown.start();
    }
}



