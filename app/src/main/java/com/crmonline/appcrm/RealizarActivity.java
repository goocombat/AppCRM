package com.crmonline.appcrm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.crmonline.appcrm.Entities.VisitaRealizada;

public class RealizarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizar);

        Integer id =  getIntent().getIntExtra("id",0);

        Log.i("teste",id.toString());

        Toast.makeText(this, id.toString(), Toast.LENGTH_SHORT).show();

        VisitaRealizada visitaRealizada = new VisitaRealizada();
        visitaRealizada.setId(id);


    }
}
