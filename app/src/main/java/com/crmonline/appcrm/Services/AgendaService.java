package com.crmonline.appcrm.Services;

import com.crmonline.appcrm.Entities.Visita;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AgendaService {

    @GET("visita/agendadas")
    Call<List<Visita>> buscaVisitas();



}
