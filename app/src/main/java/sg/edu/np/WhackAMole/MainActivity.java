package sg.edu.np.WhackAMole;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="Whack-A-Mole";
    private Button middle_button;
    private Button right_button;
    private Button left_button;
    private String mole;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        left_button = findViewById(R.id.left);
        middle_button = findViewById(R.id.middle);
        right_button = findViewById(R.id.right);

        left_button.setOnClickListener(buttonOnClickListener);
        middle_button.setOnClickListener(buttonOnClickListener);
        right_button.setOnClickListener(buttonOnClickListener);
        Log.v(TAG, "Finished Pre-Initialisation!");


    }
    @Override
    protected void onStart(){
        super.onStart();
        setNewMole();
        Log.v(TAG, "Starting GUI!");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.v(TAG, "Paused Whack-A-Mole!");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TAG, "Stopped Whack-A-Mole!");
        finish();
    }

    private View.OnClickListener buttonOnClickListener = new View.OnClickListener() {
        Button test;
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.left:{
                    test = findViewById(R.id.left);
                    break;
                }
                case R.id.middle:{
                    test = findViewById(R.id.middle);
                    break;
                }
                default:{
                    test = findViewById(R.id.right);
                    break;
                }
            }
            doCheck(test);
        }
    };

    private void doCheck(Button checkButton) {
        TextView textView = (TextView) findViewById(R.id.textView);
        switch (checkButton.getId()){
            case R.id.left:{
                if (left_button.getText() == "*" ){
                    score += 1;
                    Log.d(TAG, "Hit, score added!");
                }
                else {
                    score -= 1;
                    Log.d(TAG, "Missed, score deducted!");
                }
                Log.d(TAG, "Left button is clicked!");
                textView.setText("Score is: " + score);
                setNewMole();
                break;
            }
            case R.id.middle:{
                if (middle_button.getText() == "*"){
                    score += 1;
                    Log.d(TAG, "Hit, score added!");
                }
                else{
                    score -= 1;
                    Log.d(TAG, "Missed, score deducted!");
                }
                Log.d(TAG, "Middle button is clicked!");
                textView.setText("Score is: " + score);
                setNewMole();
                break;
            }
            default:{
                if (right_button.getText() == "*"){
                    score += 1;
                    Log.d(TAG, "Hit, score added!");
                }
                else{
                    score -= 1;
                    Log.d(TAG, "Missed, score deducted!");
                }
                Log.d(TAG, "Right button is clicked!");
                textView.setText("Score is: " + score);
                setNewMole();
                break;
            }
        }
        if (score % 10 == 0 ) {
            nextLevelQuery();
        }
    }

    private void nextLevel(){
        Intent in = new Intent(this,Main2Activity.class);
        in.putExtra("Score",score);
        startActivity(in);
    }

    private void nextLevelQuery() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Warning! Insane Whack-A-Mole Incoming!");
        builder.setMessage("Would you like to advance to advanced mode?");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                Log.d(TAG, "User accepts!");
                nextLevel();
                Log.d(TAG, "Advance option given to user!");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                Log.d(TAG, "User decline!");
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void setNewMole() {
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);
        switch (randomLocation){
            case 0:{
                mole = "zero";
                break;
            }
            case 1:{
                mole = "one";
                break;
            }
            default:{
                mole = "two";
                break;
            }
        }
        switch (mole){
            case "zero":{
                left_button.setText("*");
                middle_button.setText("O");
                right_button.setText("O");
                break;
            }
            case "one":{
                left_button.setText("O");
                middle_button.setText("*");
                right_button.setText("O");
                break;
            }
            default:{
                left_button.setText("O");
                middle_button.setText("O");
                right_button.setText("*");
                break;
            }
        }
    }
}