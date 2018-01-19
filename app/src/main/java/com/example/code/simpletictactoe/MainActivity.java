package com.example.code.simpletictactoe;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.code.ixox.R;

public class MainActivity extends AppCompatActivity {

    private int buttons[] = {
            R.id.b_1_1, R.id.b_1_2, R.id.b_1_3,
            R.id.b_2_1, R.id.b_2_2, R.id.b_2_3,
            R.id.b_3_1, R.id.b_3_2, R.id.b_3_3};

    private Player currentPlayer = Player.IKS_PLAYER;

    public enum ButtonState {EMPTY, IKS, OKS}
    public enum Player {IKS_PLAYER, OKS_PLAYER}

    private ButtonState[][] buttonState = {
            {ButtonState.EMPTY, ButtonState.EMPTY, ButtonState.EMPTY},
            {ButtonState.EMPTY, ButtonState.EMPTY, ButtonState.EMPTY},
            {ButtonState.EMPTY, ButtonState.EMPTY, ButtonState.EMPTY}
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comsly);
        for (int i = 0; i < buttons.length; i++) {
            Button button = findViewById(buttons[i]);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View viwe) {
                    buttonClick(viwe);
                }
            });
        }
    }

    private void buttonClick(View viwe) {
        switch (viwe.getId()) {
            case R.id.b_1_1:
                ispisiToast("Prvi red, prvo dugme");
                odigrajPotez(viwe,0,0);
                break;
            case R.id.b_1_2:
                ispisiToast("Prvi red, drugo dugme");
                odigrajPotez(viwe,0,1);
                break;
            case R.id.b_1_3:
                ispisiToast("Prvi red, trece dugme");
                odigrajPotez(viwe,0,2);
                break;
            case R.id.b_2_1:
                ispisiToast("Drugi red, prvo dugme");
                odigrajPotez(viwe,1,0);
                break;
            case R.id.b_2_2:
                ispisiToast("Drugi red, drugo dugme");
                odigrajPotez(viwe,1,1);
                break;
            case R.id.b_2_3:
                ispisiToast("Drugi red, trece dugme");
                odigrajPotez(viwe,1,2);
                break;
            case R.id.b_3_1:
                ispisiToast("Treci red, prvo dugme");
                odigrajPotez(viwe,2,0);
                break;
            case R.id.b_3_2:
                ispisiToast("Treci red, drugo dugme");
                odigrajPotez(viwe,2,1);
                break;
            case R.id.b_3_3:
                ispisiToast("Treci red, trece dugme");
                odigrajPotez(viwe,2,2);
                break;
        }
    }

    private void odigrajPotez(View button, int row, int col) {
        switch (buttonState [row][col]){
            case EMPTY:
                switch (currentPlayer){
                    case IKS_PLAYER:
                        button.setBackgroundResource(R.drawable.iks_background);
                        buttonState[row][col]=ButtonState.IKS;
                        currentPlayer = Player.OKS_PLAYER;
                    case OKS_PLAYER:
                        button.setBackgroundResource(R.drawable.ox_background);
                        buttonState[row][col]=ButtonState.OKS;
                        currentPlayer = Player.IKS_PLAYER;
                }
                button.setBackgroundResource(R.drawable.iks_background);
                buttonState[row][col] = ButtonState.IKS;
                break;
            //case IKS:
            //    button.setBackgroundResource(R.drawable.ox_background);
            //    buttonState[row][col] = ButtonState.OKS;
            //    break;
            //case OKS:
            //    button.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            //    buttonState[row][col] = ButtonState.EMPTY;
            //    break;
        }
    }


    private void ispisiToast(String s) {
        Toast.makeText(MainActivity.this,
                s,
                Toast.LENGTH_SHORT)
                .show();
    }
}


