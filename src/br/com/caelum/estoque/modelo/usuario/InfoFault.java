package br.com.caelum.estoque.modelo.usuario;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
public class InfoFault {

    private String mensagem;
    private Date dataErro;

    public InfoFault(String mensagem, Date dataErro) {
        this.mensagem = mensagem;
        this.dataErro = dataErro;
    }

    InfoFault() {

    }
}
