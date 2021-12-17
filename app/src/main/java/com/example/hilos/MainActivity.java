package com.example.hilos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.RenderScript;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText campo1;
    EditText campo2;
    TextView tv1;
    int minutos = 0, segundos = 0, horas = 0;
    int minutos2 = 0, segundos2 = 0, horas2 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        campo1 = findViewById(R.id.EditTextReloj1);
        campo2 = findViewById(R.id.EditTextReloj2);
        tv1 = findViewById(R.id.TextViewHorario1);
    }

    public void relojes(View v){
        String cadena1 = campo1.getText().toString();
        String[] valoresCadena1 = cadena1.split(":");
        horas = Integer.parseInt(valoresCadena1[0]);
        minutos = Integer.parseInt(valoresCadena1[1]);
        segundos = Integer.parseInt(valoresCadena1[2]);


        Thread objeto = new Thread(new Runnable() {
            @Override
            public void run() {

              while(true){
                   runOnUiThread(new Runnable() {
                       @Override
                       public void run() {
                           campo1.setText("");
                           if(horas<10){
                               campo1.setText(campo1.getText().toString() + "0");
                           }
                           campo1.setText(campo1.getText().toString() + horas + ":");
                           if(minutos<10){
                               campo1.setText(campo1.getText().toString() + "0");
                           }
                           campo1.setText(campo1.getText().toString() + minutos + ":");
                           if(segundos<10){
                               campo1.setText(campo1.getText().toString() + "0");
                           }
                           campo1.setText(campo1.getText().toString() + segundos);

                           segundos++;
                           if(segundos == 60){
                               segundos = 0;
                               minutos++;
                               if(minutos==60){
                                   minutos = 0;
                                   horas++;
                                       if(horas>12){
                                           horas = 1;
                                       }
                               }
                           }

                       }
                   });
                   try {
                       Thread.sleep(500);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                  if(horas == 12 && minutos == 0 && segundos == 0 && tv1.getText().toString().equals("PM")){
                      tv1.setText("AM");

                  }
                  else if(horas == 12 && minutos == 0 && segundos == 0 && tv1.getText().toString().equals("AM")){
                      tv1.setText("PM");
                  }

               }

            }
        });

        objeto.start();

        String cadena2 = campo2.getText().toString();
        String[] valoresCadena2 = cadena2.split(":");
        horas2 = Integer.parseInt(valoresCadena2[0]);
        minutos2 = Integer.parseInt(valoresCadena2[1]);
        segundos2 = Integer.parseInt(valoresCadena2[2]);
        Thread objeto2 = new Thread(new Runnable() {
            @Override
            public void run() {

                while(true){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            campo2.setText("");
                            if(horas2<10){
                                campo2.setText(campo2.getText().toString() + "0");
                            }
                            campo2.setText(campo2.getText().toString() + horas2 + ":");
                            if(minutos2<10){
                                campo2.setText(campo2.getText().toString() + "0");
                            }
                            campo2.setText(campo2.getText().toString() + minutos2 + ":");
                            if(segundos2<10){
                                campo2.setText(campo2.getText().toString() + "0");
                            }
                            campo2.setText(campo2.getText().toString() + segundos2);

                            segundos2++;
                            if(segundos2 == 60){
                                segundos2 = 0;
                                minutos2++;
                                if(minutos2==60){
                                    minutos2 = 0;
                                    horas2++;
                                    if(horas2==24){
                                        horas2=0;
                                    }
                                }
                            }

                        }
                    });
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        });
        objeto2.start();
    }



}