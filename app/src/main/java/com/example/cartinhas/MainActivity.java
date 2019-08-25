package com.example.cartinhas;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    int cartaSelecionada = 0;
    public void btnConfirmar (View view){

        TextView mudarTxt = findViewById(R.id.msgTxt);
        if (cartaSelecionada != 0){

            ImageButton imageButton = findViewById(cartaSelecionada);
            Button btnCofirmar = findViewById(R.id.btnConfirmar);
            Button btnJogarNovamente = findViewById(R.id.btnTentarNovamente);
            btnJogarNovamente.setVisibility(View.INVISIBLE);

            int random = new Random().nextInt(3);

            Drawable dragaoBranco = getResources().getDrawable(R.drawable.dragaobranco);
            Drawable cartaKaribo = getResources().getDrawable(R.drawable.karibo);

            switch (random) {

                case 0:
                    cartaSelecionada(dragaoBranco);
                    mudarTxt.setText("VOCÊ GANHOU !!!");
                    mudarTxt.setTextColor(Color.GREEN);
                    btnJogarNovamente.setVisibility(View.VISIBLE);
                    btnCofirmar.setVisibility(View.INVISIBLE);


                    break;
                case 1:
                case 2:
                    cartaSelecionada(cartaKaribo);
                    mudarTxt.setText("VOCÊ PERDEU");
                    mudarTxt.setTextColor(Color.RED);
                    btnJogarNovamente.setVisibility(View.VISIBLE);
                    btnCofirmar.setVisibility(View.INVISIBLE);
                    break;
            }


        }else{
            mudarTxt.setText("Nenhuma Carta Selecionada");
            mudarTxt.setTextColor(Color.BLUE);
        }

    }

    public void cartaSelecionada (Drawable carta){

        ImageButton ibSelecionado = findViewById(cartaSelecionada);
        ibSelecionado.setImageDrawable(carta);
    }
    public void opcaoSelecionada (View view){

        TextView mudarTxt = findViewById(R.id.msgTxt);
        cartaSelecionada = view.getId();
        mudarTxt.setText("");
    }
    public void jogarNovamente (View view){


        ImageButton ibSelecionado = findViewById(cartaSelecionada);
        Drawable cartaVerso = getResources().getDrawable(R.drawable.cartavirada);
        ibSelecionado.setImageDrawable(cartaVerso);
        cartaSelecionada = 0;
        Button btnJogarNovamente = findViewById(R.id.btnTentarNovamente);
        btnJogarNovamente.setVisibility(View.INVISIBLE);
        Button btnConfirmar = findViewById(R.id.btnConfirmar);
        btnConfirmar.setVisibility(View.VISIBLE);

        TextView mudarTxt = findViewById(R.id.msgTxt);
        mudarTxt.setText("");

    }

}
