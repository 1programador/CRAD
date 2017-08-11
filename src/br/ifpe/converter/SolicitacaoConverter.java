package br.ifpe.converter;
import org.springframework.core.convert.converter.Converter;
import br.ifpe.dao.SolicitacaoDao;
import br.ifpe.dao.UsuarioDao;
import br.ifpe.basicas.Solicitacao;

public class SolicitacaoConverter implements Converter<String,Solicitacao> {

	// este if verifica se a solicitação foi preenchida
	@Override
	public Solicitacao convert(String id) {
		if (id != null && !id.equals("")) {
			SolicitacaoDao dao = new SolicitacaoDao();
			return dao.buscarPorId(Integer.valueOf(id));
		} 
		else 
			return null;
	}

}
