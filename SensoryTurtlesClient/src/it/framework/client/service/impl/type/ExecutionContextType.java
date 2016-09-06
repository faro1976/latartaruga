//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2016.05.04 alle 11:52:23 AM CEST 
//

package it.framework.client.service.impl.type;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import it.framework.client.service.inferf.IExecutionContext;


/**
 * <p>
 * Classe Java per executionContextType complex type.
 * 
 * <p>
 * Il seguente frammento di schema specifica il contenuto previsto contenuto in
 * questa classe.
 * 
 * <pre>
 * &lt;complexType name="executionContextType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.posteitaliane.it/framework/core/xml/model}contextType">
 *       &lt;attribute name="executionId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "executionContextType", propOrder = {
		"executionId"
})
public class ExecutionContextType extends ContextType implements IExecutionContext, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -355243972262679200L;
	protected String executionId;

	/**
	 * Recupera il valore della proprietà executionId.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Override
	public String getExecutionId() {
		return executionId;
	}

	/**
	 * Imposta il valore della proprietà executionId.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setExecutionId(String value) {
		this.executionId = value;
	}

	@Override
	public String getOperatonId() {
		// TODO Auto-generated method stub
		return null;
	}

}
