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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import it.framework.client.service.enums.SeverityLevelEnum;
import it.framework.client.service.inferf.IResultStatus;
import it.framework.core.util.JaxbUtil;


/**
 * 
 * Tipo da estendere per gestire i warning e aggiungere campi con ulteriori
 * informazioni
 * 
 * 
 * <p>
 * Classe Java per resultStatusType complex type.
 * 
 * <p>
 * Il seguente frammento di schema specifica il contenuto previsto contenuto in
 * questa classe.
 * 
 * <pre>
 * &lt;complexType name="resultStatusType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="code" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="severity" type="{http://www.posteitaliane.it/framework/core/xml/model}severityLevel" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name = "resultStatusType")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resultStatusType", propOrder = { "code", "message", "timestamp", "severity" })
@XmlSeeAlso({ BaseFaultType.class })
public class ResultStatusType implements Serializable, IResultStatus {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2717692438253546077L;
	@XmlElement(required = true)
	protected String code;
	protected String message;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar timestamp;
	@XmlSchemaType(name = "string")
	protected SeverityLevelEnum severity;

	ResultStatusType() {
	}

	public ResultStatusType(IResultStatus resultStatus) {
		message = resultStatus.getMessage();
		code = resultStatus.getCode();
		timestamp = JaxbUtil.convert(resultStatus.getDateTimestamp());
		severity = SeverityLevelEnum.fromValue(resultStatus.getSeverity().name());
	}

	/**
	 * Recupera il valore della proprietà message.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/**
	 * Imposta il valore della proprietà message.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMessage(String value) {
		this.message = value;
	}

	/**
	 * Recupera il valore della proprietà code.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */

	@Override
	public String getCode() {
		return code;
	}

	/**
	 * Imposta il valore della proprietà code.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCode(String value) {
		this.code = value;
	}

	/**
	 * Recupera il valore della propriet� timestamp.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getTimestamp() {
		return timestamp;
	}

	/**
	 * Imposta il valore della propriet� timestamp.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setTimestamp(XMLGregorianCalendar value) {
		this.timestamp = value;
	}

	/**
	 * Recupera il valore della proprietà severity.
	 * 
	 * @return possible object is {@link SeverityLevel }
	 * 
	 */

	public SeverityLevelEnum getSeverity() {
		return severity;
	}

	/**
	 * Imposta il valore della proprietà severity.
	 * 
	 * @param value
	 *            allowed object is {@link SeverityLevel }
	 * 
	 */
	public void setSeverity(SeverityLevelEnum value) {
		this.severity = value;
	}

	@Override
	public Date getDateTimestamp() {
		return JaxbUtil.convert(timestamp);
	}
}
