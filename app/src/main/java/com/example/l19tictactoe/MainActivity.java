package com.example.l19tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activeplayer = 0;

    int[] gamestat = {2,2,2,2,2,2,2,2,2};

    int[][] winningposition = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    boolean isgameactive = true;
    public void dropIn(View view){
        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        gamestat[tappedCounter]= activeplayer;

        if (isgameactive) {


            if (activeplayer == 0) {
                counter.setImageResource((R.drawable.x));

                activeplayer = 1;
            } else {
                counter.setImageResource((R.drawable.o));
                activeplayer = 0;
            }

            counter.setTranslationY(-1500);
            counter.animate().translationYBy(1500).setDuration(300);

            for (int[] winningposition : winningposition) {
                if (gamestat[winningposition[0]] == gamestat[winningposition[1]] && gamestat[winningposition[1]] == gamestat[winningposition[2]] && gamestat[winningposition[0]] != 2) {
                    //someone has won
                  //  Toast.makeText(this, "You Have WON the Match", Toast.LENGTH_SHORT).show();

                    isgameactive = false;

                    if (activeplayer == 0) {
                        Toast.makeText(this, "O has WON the Match", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "X has WON the Match", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        }
        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}