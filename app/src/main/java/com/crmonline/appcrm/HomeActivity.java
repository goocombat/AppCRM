package com.crmonline.appcrm;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.crmonline.appcrm.Entities.Visita;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        List<Visita> visitas = new ArrayList<>();
        Visita v = new Visita();
        v.setNome("Teste");
        v.setData(new Date());
        v.setHora("00:00");

        visitas.add(v);
        //substituir pelo task do rest

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(new VisitasAdapter((getContext()), visitas));


    }

    private Context getContext() {
        return this;
    }

}
