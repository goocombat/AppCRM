package com.crmonline.appcrm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editLogin;
    EditText editSenha;
    Button   btnAcessar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     editLogin = (EditText) findViewById(R.id.editLogin);
     editSenha = (EditText) findViewById(R.id.editSenha);
     btnAcessar = (Button) findViewById(R.id.btnAcessar);

     btnAcessar.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             if (editLogin.getText().length() ==0 || editSenha.getText().length() ==0) {
                 Toast.makeText(getApplication(),
                         "Os campos Login e Senha são obrigatórios",
                         Toast.LENGTH_LONG).show();
             }else{
                 Toast.makeText(getApplication(),
                         "Seja Bem Vindo" + editLogin.getText().toString()+"!",
                         Toast.LENGTH_SHORT).show();
             }

         }
     });
    }
}
