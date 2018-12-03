package com.crmonline.appcrm;

import android.app.SearchManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.crmonline.appcrm.Entities.RespostaGenerica;
import com.crmonline.appcrm.Entities.VisitaRealizada;
import com.crmonline.appcrm.Services.AgendaService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RealizarActivity extends AppCompatActivity {

    RatingBar ratingBar;
    EditText editText;
    VisitaRealizada visitaRealizada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizar);
        ratingBar = findViewById(R.id.ratingBar);

        Integer id = getIntent().getIntExtra("id", 0);

        Log.i("teste", id.toString());

        Toast.makeText(this, id.toString(), Toast.LENGTH_SHORT).show();

        visitaRealizada = new VisitaRealizada();

        Button button = findViewById(R.id.btnenviar);
        editText = findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                visitaRealizada.setClassificacao(ratingBar.getNumStars());
                visitaRealizada.setTexto(editText.getText().toString().trim());

                AgendaService Agnd = RetrofitInstance.getInstance().create(AgendaService.class);

                Agnd.visitaRealizada(visitaRealizada).enqueue(new Callback<RespostaGenerica>() {
                    @Override
                    public void onResponse(Call<RespostaGenerica> call, Response<RespostaGenerica> response) {

                        if (response.isSuccessful()){
                            RespostaGenerica resposta = response.body();

                            if (resposta != null){
                                if (resposta.isResposta()){
                                    Toast.makeText(RealizarActivity.this, "Sucesso ao Inserir", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(RealizarActivity.this, "Falha ao Inserir", Toast.LENGTH_SHORT).show();

                                }
                                Toast.makeText(RealizarActivity.this, resposta.toString(), Toast.LENGTH_SHORT).show();

                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<RespostaGenerica> call, Throwable t) {

                    }
                });

            }
        });

    }

}
