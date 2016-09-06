//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2016.05.04 alle 11:52:23 AM CEST 
//

package it.framework.client.service.impl.type;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import it.framework.client.service.inferf.IRequestContext;
import it.framework.core.util.JaxbUtil;
;

/**
 * <p>
 * Classe Java per contextType complex type.
 * 
 * <p>
 * Il seguente frammento di schema specifica il contenuto previsto contenuto in
 * questa classe.
 * 
 * <pre>
 * &lt;complexType name="contextType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="clientId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="traceabilityId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="operationId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contextType", propOrder = { "clientId", "sessionId", "traceabilityId", "operationId", "timestamp" })
@XmlSeeAlso({ ExecutionContextType.class })
public class ContextType implements IRequestContext, Serializable {

	@Override
	public String toString() {
		return "clientId: " + clientId + " sessionId: " + sessionId + " traceabilityId: " + traceabilityId
				+ " operationId: " + operationId + " timestamp: " + timestamp.toXMLFormat();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8472535156923802033L;
	protected String clientId;
	protected String sessionId;
	@XmlElement(required = true)
	protected String traceabilityId;
	protected String operationId;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar timestamp;

	public ContextType() {
		// per jaxb
	}

	public ContextType(IRequestContext requestContext) {
		clientId = requestContext.getClientId();
		sessionId = requestContext.getSessionId();
		traceabilityId = requestContext.getTraceabilityId();
		operationId = requestContext.getOperationId();
		timestamp = JaxbUtil.convert(requestContext.getDateTimestamp());
	}

	/**
	 * Recupera il valore della proprietà clientId.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Override
	public String getClientId() {
		return clientId;
	}

	/**
	 * Imposta il valore della proprietà clientId.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setClientId(String value) {
		this.clientId = value;
	}

	/**
	 * Recupera il valore della proprietà sessionId.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Override
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * Imposta il valore della proprietà sessionId.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSessionId(String value) {
		this.sessionId = value;
	}

	/**
	 * Recupera il valore della proprietà traceabilityId.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Override
	public String getTraceabilityId() {
		return traceabilityId;
	}

	/**
	 * Imposta il valore della proprietà traceabilityId.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTraceabilityId(String value) {
		this.traceabilityId = value;
	}

	/**
	 * Recupera il valore della proprietà operationId.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Override
	public String getOperationId() {
		return operationId;
	}

	/**
	 * Imposta il valore della proprietà operationId.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOperationId(String value) {
		this.operationId = value;
	}

	/**
	 * Recupera il valore della proprietà timestamp.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getTimestamp() {
		return timestamp;
	}

	/**
	 * Imposta il valore della proprietà timestamp.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setTimestamp(XMLGregorianCalendar value) {
		this.timestamp = value;
	}

	@Override
	public Date getDateTimestamp() {
		if (timestamp != null)
			return JaxbUtil.convert(timestamp);
		else
			return null;
	}
}
