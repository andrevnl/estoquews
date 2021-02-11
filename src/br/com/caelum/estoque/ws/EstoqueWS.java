package br.com.caelum.estoque.ws;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ItemValidador;
import br.com.caelum.estoque.modelo.item.ListaItens;
import br.com.caelum.estoque.modelo.usuario.AutorizacaoException;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;
import br.com.caelum.estoque.modelo.usuario.Usuario;
import jdk.nashorn.internal.parser.Token;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService
public class EstoqueWS {

    private ItemDao dao = new ItemDao();

    @WebMethod(operationName="TodosOsItens")
    @WebResult(name="itens")
    public ListaItens getItens(@WebParam(name="filtros") Filtros filtros) {
        System.out.println("Chamando getItens()");
        List<Filtro> listaFiltros = filtros.getLista();
        List<Item> lista = dao.todosItens(listaFiltros);
        return new ListaItens(lista);
    }

    @WebMethod(operationName = "CadastrarItem")
    @WebResult(name = "item")
    public Item cadastrarItem(
            @WebParam(name = "tokenUsuario", header = true) TokenUsuario token,
            @WebParam(name = "item") Item item)
            throws AutorizacaoException {
        System.out.println("Chamando cadastrarItem()");

        boolean valido = new TokenDao().ehValido(token);

        if(!valido) {
            throw new AutorizacaoException("Autorização falhou");
        }

        new ItemValidador(item).validate();

        this.dao.cadastrar(item);
        return item;
    }
}
