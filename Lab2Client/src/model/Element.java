/**
 * Element.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package model;

public class Element  implements java.io.Serializable {
    private int cid;

    private java.lang.String description;

    private int eid;

    private java.lang.String ename;

    private double rating;

    public Element() {
    }

    public Element(
           int cid,
           java.lang.String description,
           int eid,
           java.lang.String ename,
           double rating) {
           this.cid = cid;
           this.description = description;
           this.eid = eid;
           this.ename = ename;
           this.rating = rating;
    }


    /**
     * Gets the cid value for this Element.
     * 
     * @return cid
     */
    public int getCid() {
        return cid;
    }


    /**
     * Sets the cid value for this Element.
     * 
     * @param cid
     */
    public void setCid(int cid) {
        this.cid = cid;
    }


    /**
     * Gets the description value for this Element.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Element.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the eid value for this Element.
     * 
     * @return eid
     */
    public int getEid() {
        return eid;
    }


    /**
     * Sets the eid value for this Element.
     * 
     * @param eid
     */
    public void setEid(int eid) {
        this.eid = eid;
    }


    /**
     * Gets the ename value for this Element.
     * 
     * @return ename
     */
    public java.lang.String getEname() {
        return ename;
    }


    /**
     * Sets the ename value for this Element.
     * 
     * @param ename
     */
    public void setEname(java.lang.String ename) {
        this.ename = ename;
    }


    /**
     * Gets the rating value for this Element.
     * 
     * @return rating
     */
    public double getRating() {
        return rating;
    }


    /**
     * Sets the rating value for this Element.
     * 
     * @param rating
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Element)) return false;
        Element other = (Element) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.cid == other.getCid() &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            this.eid == other.getEid() &&
            ((this.ename==null && other.getEname()==null) || 
             (this.ename!=null &&
              this.ename.equals(other.getEname()))) &&
            this.rating == other.getRating();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getCid();
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        _hashCode += getEid();
        if (getEname() != null) {
            _hashCode += getEname().hashCode();
        }
        _hashCode += new Double(getRating()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Element.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model", "Element"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model", "cid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model", "eid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ename");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model", "ename"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rating");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model", "rating"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
