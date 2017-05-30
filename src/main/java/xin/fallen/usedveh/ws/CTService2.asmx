<?xml version="1.0" encoding="utf-8"?>
<wsdl:definitions xmlns:tm="http://microsoft.com/wsdl/mime/textMatching/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/" xmlns:tns="http://tempuri.org/" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:s="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" targetNamespace="http://tempuri.org/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
  <wsdl:types>
    <s:schema elementFormDefault="qualified" targetNamespace="http://tempuri.org/">
      <s:element name="GetExaminePhoto1">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="plateType" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="plateNo" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetExaminePhoto1Response">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetExaminePhoto1Result" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
    </s:schema>
  </wsdl:types>
  <wsdl:message name="GetExaminePhoto1SoapIn">
    <wsdl:part name="parameters" element="tns:GetExaminePhoto1" />
  </wsdl:message>
  <wsdl:message name="GetExaminePhoto1SoapOut">
    <wsdl:part name="parameters" element="tns:GetExaminePhoto1Response" />
  </wsdl:message>
  <wsdl:portType name="CTService2Soap">
    <wsdl:operation name="GetExaminePhoto1">
      <wsdl:input message="tns:GetExaminePhoto1SoapIn" />
      <wsdl:output message="tns:GetExaminePhoto1SoapOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:binding name="CTService2Soap" type="tns:CTService2Soap">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="GetExaminePhoto1">
      <soap:operation soapAction="http://tempuri.org/GetExaminePhoto1" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="CTService2Soap12" type="tns:CTService2Soap">
    <soap12:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="GetExaminePhoto1">
      <soap12:operation soapAction="http://tempuri.org/GetExaminePhoto1" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:service name="CTService2">
    <wsdl:port name="CTService2Soap" binding="tns:CTService2Soap">
      <soap:address location="http://10.35.139.118:8084/CTService2.asmx" />
    </wsdl:port>
    <wsdl:port name="CTService2Soap12" binding="tns:CTService2Soap12">
      <soap12:address location="http://10.35.139.118:8084/CTService2.asmx" />
    </wsdl:port>
  </wsdl:service>
</wsdl:definitions>