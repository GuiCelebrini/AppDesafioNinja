package com.celebrini.desafioninja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoFogo(View view){
        this.elementoSelecionado(0);
    }

    public void selecionadoAgua(View view){
        this.elementoSelecionado(1);
    }

    public void selecionadoNeve(View view){
        this.elementoSelecionado(2);
    }

    public void elementoSelecionado (int elemento){

        ImageView elementoSensei = findViewById(R.id.elementoSensei);
        ImageView sensei = findViewById(R.id.sensei);
        TextView textoResultado = findViewById(R.id.textoResultado);

        int sorteado = new Random().nextInt(3);//0-1-2

        switch (sorteado){
            case 0:
                elementoSensei.setImageResource(R.drawable.fogo);
                break;
            case 1:
                elementoSensei.setImageResource(R.drawable.agua);
                break;
            case 2:
                elementoSensei.setImageResource(R.drawable.neve);
                break;
        }

        if (sorteado==0 && elemento==2 || sorteado==1 && elemento==0 || sorteado==2 && elemento==1){ //Sensei ganha
            sensei.setImageResource(R.drawable.sensei_derrota);
            textoResultado.setText("Gafanhoto precisa treinar mais");
        } else if (elemento==0 && sorteado==2 || elemento==1 && sorteado==0 || elemento==2 && sorteado==1){ //Usuário ganha
            sensei.setImageResource(R.drawable.sensei_vitoria);
            textoResultado.setText("Parabéns gafanhoto, vitória!");
        } else {
            //sensei.setImageResource(R.drawable.sensei);
            sensei.setImageResource(R.drawable.sensei_empate);
            textoResultado.setText("Empate já é um avanço gafanhoto!");
        }



    }


}
