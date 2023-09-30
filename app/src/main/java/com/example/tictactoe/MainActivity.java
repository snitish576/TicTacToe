package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button[] bt = new Button[9];

    Button resetbt;



    int ct = 0;
    static char board[] = new char[9];

    boolean chance = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt[0] = findViewById(R.id.bt1);
        bt[1] = findViewById(R.id.bt2);
        bt[2] = findViewById(R.id.bt3);
        bt[3] = findViewById(R.id.bt4);
        bt[4] = findViewById(R.id.bt5);
        bt[5] = findViewById(R.id.bt6);
        bt[6] = findViewById(R.id.bt7);
        bt[7] = findViewById(R.id.bt8);
        bt[8] = findViewById(R.id.bt9);

        resetbt = findViewById(R.id.resetbt);

        resetbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetgame();
            }
        });

        setListener();


    }

    public void setListener(){

        bt[0].setOnClickListener(this);
        bt[1].setOnClickListener(this);
        bt[2].setOnClickListener(this);
        bt[3].setOnClickListener(this);
        bt[4].setOnClickListener(this);
        bt[5].setOnClickListener(this);
        bt[6].setOnClickListener(this);
        bt[7].setOnClickListener(this);
        bt[8].setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        ct++;

        switch (v.getId()) {

            case R.id.bt1:

                if (chance) {
                    bt[0].setText("O");
                    chance = false;
                } else {
                    bt[0].setText("X");
                    chance = true;
                }
                bt[0].setOnClickListener(null);

                setValue(chance, 0);
                break;


            case R.id.bt2:

                if (chance) {
                    bt[1].setText("O");
                    chance = false;
                } else {
                    bt[1].setText("X");
                    chance = true;
                }
                bt[1].setOnClickListener(null);
                setValue(chance, 1);
                break;


            case R.id.bt3:
                if (chance) {
                    bt[2].setText("O");
                    chance = false;
                } else {
                    bt[2].setText("X");
                    chance = true;
                }
                bt[2].setOnClickListener(null);
                setValue(chance, 2);
                break;

            case R.id.bt4:
                if (chance) {
                    bt[3].setText("O");
                    chance = false;
                } else {
                    bt[3].setText("X");
                    chance = true;
                }
                bt[3].setOnClickListener(null);
                setValue(chance, 3);
                break;

            case R.id.bt5:
                if (chance) {
                    bt[4].setText("O");
                    chance = false;
                } else {
                    bt[4].setText("X");
                    chance = true;
                }
                bt[4].setOnClickListener(null);
                setValue(chance, 4);
                break;

            case R.id.bt6:
                if (chance) {
                    bt[5].setText("O");
                    chance = false;
                } else {
                    bt[5].setText("X");
                    chance = true;
                }
                bt[5].setOnClickListener(null);
                setValue(chance, 5);
                break;


            case R.id.bt7:
                if (chance) {
                    bt[6].setText("O");
                    chance = false;
                } else {
                    bt[6].setText("X");
                    chance = true;
                }
                bt[6].setOnClickListener(null);
                setValue(chance, 6);
                break;


            case R.id.bt8:
                if (chance) {
                    bt[7].setText("O");
                    chance = false;
                } else {
                    bt[7].setText("X");
                    chance = true;
                }
                bt[7].setOnClickListener(null);
                setValue(chance, 7);
                break;


            case R.id.bt9:
                if (chance) {
                    bt[8].setText("O");
                    chance = false;
                } else {
                    bt[8].setText("X");
                    chance = true;
                }
                bt[8].setOnClickListener(null);
                setValue(chance, 8);
                break;


        }

    }

    public void setValue(boolean player, int index) {

        if (player)
            board[index] = 'X';
        else
            board[index] = 'O';

        check_for_win(board,player);

    }

    public void disable_all_buttons(){

        for(int i = 0;i<9;i++)
            bt[i].setOnClickListener(null);

    }

    public void resetgame(){

        setListener();

        bt[0].setText("");
        bt[1].setText("");
        bt[2].setText("");
        bt[3].setText("");
        bt[4].setText("");
        bt[5].setText("");
        bt[6].setText("");
        bt[7].setText("");
        bt[8].setText("");

        chance = true;

        ct = 0;

        for(int i = 0;i<board.length;i++)
            board[i] = 0;


    }

    public void check_for_win(char board[], boolean player){

        if( (board[0]== 'X' && board[1] == 'X' && board[2]== 'X') ||  (board[0]== 'O' && board[1] == 'O' && board[2]== 'O')){

            if(player)
                Toast.makeText(getApplicationContext(), "Player Two won", Toast.LENGTH_LONG).show();

            else
                Toast.makeText(getApplicationContext(), "Player One won", Toast.LENGTH_LONG).show();

            disable_all_buttons();


        }
        else if((board[0]== 'X' && board[3] == 'X' && board[6]== 'X') ||  (board[0]== 'O' && board[3] == 'O' && board[6]== 'O') ){

            if(player)
                Toast.makeText(getApplicationContext(),"Player Two won",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(),"Player One won",Toast.LENGTH_LONG).show();


            disable_all_buttons();

        }
        else if((board[6]== 'X' && board[7] == 'X' && board[8]== 'X') ||  (board[6]== 'O' && board[7] == 'O' && board[8]== 'O') ){

            if(player)
                Toast.makeText(getApplicationContext(),"Player Two won",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(),"Player One won",Toast.LENGTH_LONG).show();

            disable_all_buttons();


        }
        else if((board[2]== 'X' && board[5] == 'X' && board[8]== 'X') ||  (board[2]== 'O' && board[5] == 'O' && board[8]== 'O') ){


            if(player)
                Toast.makeText(getApplicationContext(),"Player Two won",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(),"Player One won",Toast.LENGTH_LONG).show();

            disable_all_buttons();

        }
        else if((board[0]== 'X' && board[4] == 'X' && board[8]== 'X') ||  (board[0]== 'O' && board[4] == 'O' && board[8]== 'O') ){


            if(player)
                Toast.makeText(getApplicationContext(),"Player Two won",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(),"Player One won",Toast.LENGTH_LONG).show();

            disable_all_buttons();
        }
        else if((board[2]== 'X' && board[4] == 'X' && board[6]== 'X') ||  (board[2]== 'O' && board[4] == 'O' && board[6]== 'O') ){


            if(player)
                Toast.makeText(getApplicationContext(),"Player Two won",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(),"Player One won",Toast.LENGTH_LONG).show();

            disable_all_buttons();
        }
        else if((board[3]== 'X' && board[4] == 'X' && board[5]== 'X') ||  (board[3]== 'O' && board[4] == 'O' && board[5]== 'O') ){


            if(player)
                Toast.makeText(getApplicationContext(),"Player Two won",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(),"Player One won",Toast.LENGTH_LONG).show();

            disable_all_buttons();
        }
        else if((board[1]== 'X' && board[4] == 'X' && board[7]== 'X') ||  (board[1]== 'O' && board[4] == 'O' && board[7]== 'O') ){


            if(player)
                Toast.makeText(getApplicationContext(),"Player Two won",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(),"Player One won",Toast.LENGTH_LONG).show();

            disable_all_buttons();
        }
        else{

            if(ct==9)
                Toast.makeText(getApplicationContext(),"Game Draw",Toast.LENGTH_LONG).show();


        }




    }
}