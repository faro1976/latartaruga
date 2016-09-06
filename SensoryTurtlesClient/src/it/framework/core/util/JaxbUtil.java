package it.framework.core.util;

import java.io.OutputStream;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Utility Jaxb2
 *
 */
public class JaxbUtil {
	private static DatatypeFactory datatypeFactory;

	private JaxbUtil() {
		// costruttore privato vuoto per BugFix Sonar
	}

	static {
		try {
			datatypeFactory = DatatypeFactory.newInstance();
		} catch (DatatypeConfigurationException e) {
			throw new FrameworkCoreUtilRuntimeException(e);
		}
	}

	public static XMLGregorianCalendar convert(Date date) {
		XMLGregorianCalendar res = null;
		if (date != null) {
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(date);
			res = datatypeFactory.newXMLGregorianCalendar(c);
		}
		return res;
	}

	public static Date convert(XMLGregorianCalendar date) {
		if (date == null) {
			return null;
		}
		return date.toGregorianCalendar().getTime();
	}

	public static XMLGregorianCalendar now() {
		return datatypeFactory.newXMLGregorianCalendar(new GregorianCalendar());
	}

	public static <T> void sendJaxbToOutputStream(Class<T> _class, T object, OutputStream os) {
		try {
			JAXBContext ctx = JAXBContext.newInstance(_class);
			Marshaller marshaller = ctx.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(object, os);
		} catch (JAXBException e) {
			throw new FrameworkCoreUtilRuntimeException(e);
		}

	}
}
