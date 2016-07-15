package com.example.djape.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Canvas;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button b_rock, b_paper, b_scissors;
    ImageView iv_cpu, iv_me;
    TextView textTitle;
    TextView scoreText;
    int counter = 0;
    int br = 0;
    Toast toast;

    String myChoise, cpuChoise, result;
    Random r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //score
        scoreText = (TextView)findViewById(R.id.editText);
        textTitle = (TextView)findViewById(R.id.myTextTitle);

        //Image
        iv_cpu = (ImageView) findViewById(R.id.iv_cpu);
        iv_me = (ImageView) findViewById(R.id.iv_me);

        //Button
        b_rock = (Button) findViewById(R.id.b_rock);
        b_paper = (Button) findViewById(R.id.b_paper);
        b_scissors = (Button) findViewById(R.id.b_scissors);

        r = new Random();
        scoreText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
        textTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);





        b_rock.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        myChoise = "rock";
                        iv_me.setImageResource(R.drawable.rock);
                        calculate();
                    }
                }
        );
        b_paper.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        myChoise = "paper";
                        iv_me.setImageResource(R.drawable.paper);
                        calculate();
                    }
                }
        );
        b_scissors.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        myChoise = "scissors";
                        iv_me.setImageResource(R.drawable.scissors);
                        calculate();
                    }
                }
        );
    }
    //Calculate variation of game
    public void calculate(){
        int cpu = r.nextInt(3);
        if (cpu == 0){
            cpuChoise = "rock";
            iv_cpu.setImageResource(R.drawable.rock);
        }else  if (cpu == 1){
            cpuChoise = "paper";
            iv_cpu.setImageResource(R.drawable.paper);
        }else  if (cpu == 2){
            cpuChoise = "scissors";
            iv_cpu.setImageResource(R.drawable.scissors);
        }
        //If statement for each outcome
        //rock conditional
        if (!scoreText.getText().toString().equals("5") && !textTitle.getText().toString().equals("5")) {
            if (myChoise.equals("rock") && cpuChoise.equals("paper")) {
                br++;
                textTitle.setText(Integer.toString(br));
            } else if (myChoise.equals("rock") && cpuChoise.equals("scissors")) {
                counter++;
                scoreText.setText(Integer.toString(counter));
            } else
                //paper conditional
                if (myChoise.equals("paper") && cpuChoise.equals("rock")) {
                    counter++;
                    scoreText.setText(Integer.toString(counter));
                } else if (myChoise.equals("paper") && cpuChoise.equals("scissors")) {
                    br++;
                    textTitle.setText(Integer.toString(br));
                } else
                    //scissors conditional
                    if (myChoise.equals("scissors") && cpuChoise.equals("paper")) {
                        counter++;
                        scoreText.setText(Integer.toString(counter));
                    } else if (myChoise.equals("scissors") && cpuChoise.equals("rock")) {
                        br++;
                        textTitle.setText(Integer.toString(br));
                    } else
                        //if both choose the same
                        if (myChoise.equals(cpuChoise)) {
                            result = "draw";
                            Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                        }
            if (counter == 5){
                result = "You win! :)";
                toast.makeText(this, result, Toast.LENGTH_LONG).show();
                scoreText.setText(Integer.toString(0));
                textTitle.setText(Integer.toString(0));
                counter = 0;
                br = 0;
            }
            if (br == 5){
                result = "You lose! :(";
                toast.makeText(this, result, Toast.LENGTH_LONG).show();
                scoreText.setText(Integer.toString(0));
                textTitle.setText(Integer.toString(0));
                counter = 0;
                br = 0;
            }

        }
    }




}
