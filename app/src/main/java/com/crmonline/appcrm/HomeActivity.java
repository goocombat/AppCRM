package com.crmonline.appcrm;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.crmonline.appcrm.Entities.Visita;
import com.crmonline.appcrm.Services.AgendaService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.recyclerViewHome);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        AgendaService agendaService = RetrofitInstance.getInstance().create(AgendaService.class);
        Call<List<Visita>> busca = agendaService.buscaVisitas();

        busca.enqueue(new Callback<List<Visita>>() {
            @Override
            public void onResponse(Call<List<Visita>> call, Response<List<Visita>> response) {
                if (response.isSuccessful()) {
                    List<Visita> resultado = response.body();
                    recyclerView.setAdapter(new VisitasAdapter(HomeActivity.this, resultado));
                }
            }

            @Override
            public void onFailure(Call<List<Visita>> call, Throwable t) {
                Toast.makeText(HomeActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private Context getContext() {
        return this;
    }

}
