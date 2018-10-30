package com.crmonline.appcrm.Services;

import com.crmonline.appcrm.Entities.Usuario;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UsuarioService {

    @GET("logon/busca/{id}")
    Call<Usuario> buscaUsuario(@Path("id") String nif);
}
