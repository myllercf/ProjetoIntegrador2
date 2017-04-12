package com.example.casa.projetointegrador2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by casa on 11/04/2017.
 */

public class Resultado extends Activity {

    private int[] imagens = {R.drawable.imc_masculino, R.drawable.imc_feminino};
    String cateoria = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);

        Intent it = getIntent();

        if(it != null){
            Bundle informacoes = it.getExtras();

            if(informacoes != null){
                Float imc = informacoes.getFloat("imc");
                int sexo = informacoes.getInt("sexo");

                NumberFormat formatarFloat = new DecimalFormat("#.#");
                imc = Float.parseFloat(formatarFloat.format(imc).replace(",", "."));

                TextView tela2 = (TextView) findViewById(R.id.calculo);
                tela2.setText(imc.toString());

                TextView faixaPeso = (TextView) findViewById(R.id.categoria);
                qualCategoria(imc, sexo);

                faixaPeso.setText(cateoria);

                final ImageView imgTabela = (ImageView) findViewById(R.id.tabela);
                imgTabela.setImageResource(imagens[sexo]);

                Toast.makeText(Resultado.this, "Para maiores informações o médico deverá ser consultado.", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void qualCategoria(Float imc, int sexo) {
        switch (sexo){
            case 0:
                if (imc < 20.7){
                    cateoria = "Abaixo do peso";
                } else if (imc >= 20.7 && imc <= 26.4){
                    cateoria = "Peso ideal";
                } else if (imc >= 26.5 && imc <= 27.8){
                    cateoria = "Pouco acima do peso";
                } else if (imc >= 27.9 && imc <= 31.1){
                    cateoria = "Acima do peso";
                } else if (imc >= 31.2){
                    cateoria = "Obesidade";
                }

            case 1:
                if (imc < 19.1){
                    cateoria = "Abaixo do peso";
                } else if (imc >= 19.1 && imc <= 25.8){
                    cateoria = "Peso ideal";
                } else if (imc >= 25.9 && imc <= 27.3){
                    cateoria = "Pouco acima do peso";
                } else if (imc >= 27.4 && imc <= 32.3){
                    cateoria = "Acima do peso";
                } else if (imc >= 32.4){
                    cateoria = "Obesidade";
                }
        }
    }

}