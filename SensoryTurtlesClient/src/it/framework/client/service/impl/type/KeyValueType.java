//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2016.05.12 alle 04:18:14 PM CEST 
//

package it.framework.client.service.impl.type;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import it.framework.client.service.inferf.IKeyValue;



/**
 * <p>
 * Classe Java per keyValueType complex type.
 * 
 * <p>
 * Il seguente frammento di schema specifica il contenuto previsto contenuto in
 * questa classe.
 * 
 * <pre>
 * &lt;complexType name="keyValueType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}anySimpleType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlType(name = "keyValueType", propOrder = { "key", "value" })
public class KeyValueType implements IKeyValue, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2143951767855653738L;

	@XmlElement(required = true)
	/**
	 * Recupera il valore della proprietà key.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Override
	public String getKey() {
		return key;
	}

	protected String key;

	@XmlElement(required = true)
	@XmlSchemaType(name = "anySimpleType")
	/**
	 * Recupera il valore della proprietà value.
	 * 
	 * @return possible object is {@link Serializable }
	 * 
	 */
	@Override
	public Object getValue() {
		return value;
	}

	protected Serializable value;

	/**
	 * Imposta il valore della proprietà key.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setKey(String value) {
		this.key = value;
	}

	/**
	 * Imposta il valore della proprietà value.
	 * 
	 * @param value
	 *            allowed object is {@link Object }
	 * 
	 */
	public void setValue(Object value) {
		this.value = (Serializable) value;
	}

}
