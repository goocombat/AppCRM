package com.crmonline.appcrm.Entities;

public class RespostaGenerica {

	public boolean resposta;
	public String respostaTexto;
	
	public boolean isResposta() {
		return resposta;
	}

	public void setResposta(boolean resposta) {
		this.resposta = resposta;
	}

	public String getRespostaTexto() {
		return respostaTexto;
	}

	public void setRespostaTexto(String respostaTexto) {
		this.respostaTexto = respostaTexto;
	}


	@Override
	public String toString() {
		return respostaTexto;
	}
}
