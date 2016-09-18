

package it.framework.client.service.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per severityLevel.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="severityLevel">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SEVERE"/>
 *     &lt;enumeration value="WARNING"/>
 *     &lt;enumeration value="INFO"/>
 *     &lt;enumeration value="CONFIG"/>
 *     &lt;enumeration value="FINE"/>
 *     &lt;enumeration value="FINER"/>
 *     &lt;enumeration value="FINEST"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "severityLevel")
@XmlEnum
public enum SeverityLevelEnum {

    SEVERE,
    WARNING,
    INFO,
    CONFIG,
    FINE,
    FINER,
    FINEST;

    public String value() {
        return name();
    }

    public static SeverityLevelEnum fromValue(String v) {
        return valueOf(v);
    }

}
