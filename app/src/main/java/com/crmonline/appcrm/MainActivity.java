package com.crmonline.appcrm;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.crmonline.appcrm.Entities.Usuario;
import com.crmonline.appcrm.Services.UsuarioService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText editLogin;
    EditText editSenha;
    Button btnAcessar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editLogin = findViewById(R.id.editLogin);
        editSenha = findViewById(R.id.editSenha);
        btnAcessar = findViewById(R.id.btnAcessar);


        btnAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editLogin.getText().toString().trim().equals("") || editSenha.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "Insira os parametros de login", Toast.LENGTH_SHORT).show();
                } else {
                    UsuarioService usuarioService = RetrofitInstance.getInstance().create(UsuarioService.class);

                    String nif = editLogin.getText().toString().trim();

                    Call<Usuario> usuarioCall = usuarioService.buscaUsuario(nif);

                    usuarioCall.enqueue(new Callback<Usuario>() {
                        @Override
                        public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                            if (response.isSuccessful()) {
                                Usuario local = response.body();
                                if (local != null) {

                                    String senha = editSenha.getText().toString().trim();

                                    if (local.getPassword().equals(senha)) {
                                        Intent intent = new Intent(getContext(), HomeActivity.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(MainActivity.this, "Senhas incorretas !", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(MainActivity.this, "Usuario não encontrado !", Toast.LENGTH_SHORT).show();
                                }

                            }
                        }


                        @Override
                        public void onFailure(Call<Usuario> call, Throwable t) {
                            Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }


            }
        });


    }


    private Context getContext() {
        return this;
    }
}
