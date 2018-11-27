package com.crmonline.appcrm;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.crmonline.appcrm.Entities.Visita;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class VisitasAdapter extends RecyclerView.Adapter<VisitasAdapter.VisitasViewHolder> {

    private Context context;
    private List<Visita> visitas;

    public VisitasAdapter(Context context, List<Visita> visitas) {
        this.context = context;
        this.visitas = visitas;

    }

    @Override
    public VisitasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_visitas,parent,false);
        VisitasViewHolder holder = new VisitasViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final VisitasViewHolder holder, int position) {

        Visita v = visitas.get(position);
        holder.txtTit.setText(v.getNome());
        holder.txtHor.setText(v.getHora());
        holder.id = v.getCodigo();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt","br"));
        holder.txtDat.setText( format.format(v.getData()));
        holder.btnRealizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RealizarActivity.class);
                intent.putExtra("id",holder.id);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.visitas != null ? this.visitas.size() : 0;
    }

    public static class VisitasViewHolder extends RecyclerView.ViewHolder {

        TextView txtTit, txtDat, txtHor;

      Button btnRealizar;

      Integer id;

        public VisitasViewHolder(View itemView) {

            super(itemView);

            txtTit = itemView.findViewById(R.id.txtTitulo);
            txtDat = itemView.findViewById(R.id.txtData);
            txtHor = itemView.findViewById(R.id.txtHora);
            btnRealizar = itemView.findViewById(R.id.btnRealizar);

        }
    }
}
