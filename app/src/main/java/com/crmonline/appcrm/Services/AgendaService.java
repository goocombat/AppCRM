package com.crmonline.appcrm.Services;

import com.crmonline.appcrm.Entities.RespostaGenerica;
import com.crmonline.appcrm.Entities.Visita;
import com.crmonline.appcrm.Entities.VisitaRealizada;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AgendaService {

    @GET("visita/agendadas")
    Call<List<Visita>> buscaVisitas();

    @POST("visita/realizar")
    Call<RespostaGenerica>visitaRealizada(@Body VisitaRealizada vr);




}
