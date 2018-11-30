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

import com.crmonline.appcrm.Entities.VisitaRealizada;

public class RealizarActivity extends AppCompatActivity {

    RatingBar ratingBar;
    EditText obs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizar);

        Integer id = getIntent().getIntExtra("id", 0);

        Log.i("teste", id.toString());

        Toast.makeText(this, id.toString(), Toast.LENGTH_SHORT).show();

        VisitaRealizada visitaRealizada = new VisitaRealizada();
        visitaRealizada.setId(id);



        
    }

    }
