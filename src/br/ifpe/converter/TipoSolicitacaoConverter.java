package br.ifpe.converter;

import org.springframework.core.convert.converter.Converter;

import br.ifpe.basicas.TipoSolicitacao;
import br.ifpe.dao.TipoSolicitacaoDao;

public class TipoSolicitacaoConverter implements Converter <String, TipoSolicitacao>{

		public TipoSolicitacao convert(String id){
			// este if verifica se categoria produto foi preenchida
			if (id != null && !id.equals("")) {
				TipoSolicitacaoDao dao = new TipoSolicitacaoDao();
				return dao.buscarPorId(Integer.valueOf(id));
			} 
			else 
				return null;
		}
		
}
