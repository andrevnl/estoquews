
package br.com.caelum.estoque.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Classe Java de tipoItem.
 * 
 * &lt;p&gt;O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="tipoItem"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *     &amp;lt;enumeration value="Livro"/&amp;gt;
 *     &amp;lt;enumeration value="Celular"/&amp;gt;
 *     &amp;lt;enumeration value="Tablet"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
 * 
 */
@XmlType(name = "tipoItem")
@XmlEnum
public enum TipoItem {

    @XmlEnumValue("Livro")
    LIVRO("Livro"),
    @XmlEnumValue("Celular")
    CELULAR("Celular"),
    @XmlEnumValue("Tablet")
    TABLET("Tablet");
    private final String value;

    TipoItem(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoItem fromValue(String v) {
        for (TipoItem c: TipoItem.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
