package com.example.djape.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.Toast;
import android.graphics.Canvas;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button b_rock, b_paper, b_scissors;
    ImageView iv_cpu, iv_me;

    String myChoise, cpuChoise, result;
    Random r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Image
        iv_cpu = (ImageView) findViewById(R.id.iv_cpu);
        iv_me = (ImageView) findViewById(R.id.iv_me);

        //Button
        b_rock = (Button) findViewById(R.id.b_rock);
        b_paper = (Button) findViewById(R.id.b_paper);
        b_scissors = (Button) findViewById(R.id.b_scissors);

        r = new Random();

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
        if(myChoise.equals("rock") && cpuChoise.equals("paper")){
            result = "You lose! :(";
        }else if(myChoise.equals("rock") && cpuChoise.equals("scissors")){
            result = "You win! :)";
        }else
        //paper conditional
        if(myChoise.equals("paper") && cpuChoise.equals("rock")){
            result = "You win! :)";
        }else if(myChoise.equals("paper") && cpuChoise.equals("scissors")){
            result = "You lose! :)";
        }else
        //scissors conditional
        if(myChoise.equals("scissors") && cpuChoise.equals("paper")){
            result = "You win! :)";
        }else if(myChoise.equals("scissors") && cpuChoise.equals("rock")){
            result = "You lose! :)";
        }else
        //if both choose the same
        if(myChoise.equals(cpuChoise)){
            result = "draw";
        }


        Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();


    }




}
