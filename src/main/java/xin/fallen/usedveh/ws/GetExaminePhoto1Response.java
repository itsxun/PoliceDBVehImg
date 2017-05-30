
package xin.fallen.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type?? Java ??
 * 
 * <p>??????????????????????е?????????
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetExaminePhoto1Result" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getExaminePhoto1Result"
})
@XmlRootElement(name = "GetExaminePhoto1Response")
public class GetExaminePhoto1Response {

    @XmlElement(name = "GetExaminePhoto1Result")
    protected String getExaminePhoto1Result;

    /**
     * ???getExaminePhoto1Result????????
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetExaminePhoto1Result() {
        return getExaminePhoto1Result;
    }

    /**
     * ????getExaminePhoto1Result????????
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetExaminePhoto1Result(String value) {
        this.getExaminePhoto1Result = value;
    }

}
