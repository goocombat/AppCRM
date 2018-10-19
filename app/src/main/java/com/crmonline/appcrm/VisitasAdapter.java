package com.crmonline.appcrm;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class VisitasAdapter extends RecyclerView.Adapter {


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
     Visitas
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class VisitasViewHolder extends RecyclerView.ViewHolder {
      TextView txtTit, txtDat, txtHor;

        public VisitasViewHolder(View itemView) {
            super(itemView);

            txtTit = itemView.findViewById(R.id.txtTitulo);
            txtDat = itemView.findViewById(R.id.txtData);
            txtHor = itemView.findViewById(R.id.txtHora);

        }
    }
}
