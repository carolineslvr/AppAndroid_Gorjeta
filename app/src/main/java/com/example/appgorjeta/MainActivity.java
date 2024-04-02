package com.example.appgorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textPorcent;
    private TextView textGorjeta;
    private TextView textTotal;
    private EditText editValor;
    private SeekBar seek;

    private double porcentagem = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textPorcent = findViewById(R.id.textViewPorcent);
        textGorjeta = findViewById(R.id.textViewGorjeta);
        textTotal = findViewById(R.id.textViewTotal);
        editValor = findViewById(R.id.edtValor);
        seek = findViewById(R.id.seekBar2);

       seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                textPorcent.setText(Math.round(porcentagem) + " %");
                calculaValor();
           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {

           }
       });


    }


    public void calculaValor(){

        String valor = editValor.getText().toString();

        if (valor == null || valor.equals("")){
            Toast.makeText(getApplicationContext(), "Primeiro digite um valor!", Toast.LENGTH_LONG).show();

        } else {
            double valDigitado = Double.parseDouble(valor);

            double gorjeta = valDigitado * (porcentagem/100);
            double total = gorjeta + valDigitado;

            textGorjeta.setText("R$ " + gorjeta);
            textTotal.setText("R$ " + total);
        }
    }
}