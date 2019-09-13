package br.com.ebix.validation;

import java.util.ArrayList;

import br.com.ebix.model.Segurado;

public class Validation{


	public ArrayList<String> validarCampos(Segurado segurado) {
		
		ArrayList<String> erros = new ArrayList<String>();
		
		

        if (null == segurado.getCpf() || segurado.getCpf().equals("")) {
        	erros.add("Campo nome obrigatorio!");
        }
        if(null == segurado.getRg() || segurado.getRg().equals("")) {
        	erros.add("Campo rg obrigatorio!");
        }
        if(null == segurado.getNome() || segurado.getNome().equals("")) {
        	erros.add("Campo nome obrigatorio!");
        }
        if(null == segurado.getCorrentista() || segurado.getCorrentista().equals("")) {
        	erros.add("Campo correntista obrigatorio!");
        }
        if(null == segurado.getSeguros() || segurado.getSeguros().equals("")) {
        	erros.add("Campo seguros obrigatorio!");
        }
        if(null == segurado.getSexo() || segurado.getSexo().equals("")){
        	erros.add("Campo sexo obrigatorio!");
        }
        if(null == segurado.getDiasVisita() || segurado.getDiasVisita().equals("")) {
        	erros.add("Campo dias obrigatorio!");
        }
        return erros;
}
}
