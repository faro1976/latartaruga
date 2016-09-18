//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2016.05.12 alle 05:07:29 PM CEST 
//

package it.framework.client.service.impl.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import it.framework.client.service.inferf.IBaseFault;
import it.framework.client.service.inferf.IExecutionContext;
import it.framework.client.service.inferf.IKeyValue;
import it.framework.core.util.ListUtil;


/**
 * <p>
 * Classe Java per baseFaultType complex type.
 * 
 * <p>
 * Il seguente frammento di schema specifica il contenuto previsto contenuto in
 * questa classe.
 * 
 * <pre>
 * &lt;complexType name="baseFaultType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.posteitaliane.it/framework/core/xml/model}resultStatusType">
 *       &lt;sequence>
 *         &lt;element name="applicationId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="executionContext" type="{http://www.posteitaliane.it/framework/core/xml/model}executionContextType"/>
 *         &lt;element name="cause" type="{http://www.posteitaliane.it/framework/core/xml/model}baseFaultType" minOccurs="0"/>
 *         &lt;element name="sourceCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sourceMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="errorType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="errorSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toNotify" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="published" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="parameter" type="{http://www.posteitaliane.it/framework/core/xml/model}keyValueType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name = "baseFault")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "baseFaultType", propOrder = { "applicationId", "executionContext", "cause", "sourceCode",
		"sourceMessage", "userCode", "userMessage", "errorType", "errorSource", "toNotify", "published", "parameter" })
public class BaseFaultType extends ResultStatusType implements IBaseFault, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2001866228867819251L;
	@XmlElement(required = true)
	protected String applicationId;
	@XmlElement(required = true)
	protected IExecutionContext executionContext;
	protected BaseFaultType cause;
	@XmlElement(required = true)
	protected String sourceCode;
	protected String sourceMessage;
	protected String userCode;
	protected String userMessage;
	protected String errorType;
	protected String errorSource;
	@XmlElement(defaultValue = "false")
	protected boolean toNotify;
	@XmlElement(defaultValue = "false")
	protected boolean published;
	protected ArrayList<IKeyValue> parameter;


	
	/**
	 * Recupera il valore della proprietà applicationId.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Override
	public String getApplicationId() {
		return applicationId;
	}

	/**
	 * Imposta il valore della proprietà applicationId.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setApplicationId(String value) {
		this.applicationId = value;
	}

	/**
	 * Recupera il valore della proprietà executionContext.
	 * 
	 * @return possible object is {@link ExecutionContextType }
	 * 
	 */
	@Override
	public IExecutionContext getExecutionContext() {
		return executionContext;
	}

	/**
	 * Imposta il valore della proprietà executionContext.
	 * 
	 * @param value
	 *            allowed object is {@link ExecutionContextType }
	 * 
	 */
	public void setExecutionContext(IExecutionContext value) {
		this.executionContext = value;
	}

	/**
	 * Recupera il valore della proprietà cause.
	 * 
	 * @return possible object is {@link BaseFaultType }
	 * 
	 */
	@Override
	public BaseFaultType getCause() {
		return cause;
	}

	/**
	 * Imposta il valore della proprietà cause.
	 * 
	 * @param value
	 *            allowed object is {@link BaseFaultType }
	 * 
	 */
	public void setCause(BaseFaultType value) {
		this.cause = value;
	}

	/**
	 * Recupera il valore della proprietà sourceCode.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Override
	public String getSourceCode() {
		return sourceCode;
	}

	/**
	 * Imposta il valore della proprietà sourceCode.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSourceCode(String value) {
		this.sourceCode = value;
	}

	/**
	 * Recupera il valore della proprietà sourceMessage.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Override
	public String getSourceMessage() {
		return sourceMessage;
	}

	/**
	 * Imposta il valore della proprietà sourceMessage.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSourceMessage(String value) {
		this.sourceMessage = value;
	}

	/**
	 * Recupera il valore della proprietà userCode.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Override
	public String getUserCode() {
		return userCode;
	}

	/**
	 * Imposta il valore della proprietà userCode.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUserCode(String value) {
		this.userCode = value;
	}

	/**
	 * Recupera il valore della proprietà userMessage.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Override
	public String getUserMessage() {
		return userMessage;
	}

	/**
	 * Imposta il valore della proprietà userMessage.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUserMessage(String value) {
		this.userMessage = value;
	}

	/**
	 * Recupera il valore della proprietà errorType.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Override
	public String getErrorType() {
		return errorType;
	}

	/**
	 * Imposta il valore della proprietà errorType.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setErrorType(String value) {
		this.errorType = value;
	}

	/**
	 * Recupera il valore della proprietà errorSource.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Override
	public String getErrorSource() {
		return errorSource;
	}

	/**
	 * Imposta il valore della proprietà errorSource.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setErrorSource(String value) {
		this.errorSource = value;
	}

	/**
	 * Recupera il valore della proprietà toNotify.
	 * 
	 */
	@Override
	public boolean isToNotify() {
		return toNotify;
	}

	/**
	 * Imposta il valore della proprietà toNotify.
	 * 
	 */
	public void setToNotify(boolean value) {
		this.toNotify = value;
	}

	/**
	 * Recupera il valore della proprietà published.
	 * 
	 */
	@Override
	public boolean isPublished() {
		return published;
	}

	/**
	 * Imposta il valore della proprietà published.
	 * 
	 */
	public void setPublished(boolean value) {
		this.published = value;
	}

	/**
	 * Gets the value of the parameter property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the parameter property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getParameter().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link KeyValueType }
	 * 
	 * 
	 */
	public List<IKeyValue> getParameter() {
		if (parameter == null) {
			parameter = new ArrayList<>();
		}
		return this.parameter;
	}

	@Override
	public List<IKeyValue> getParameters() {
		return ListUtil.toSuperType(getParameter());
	}

}
