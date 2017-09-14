package com.huangye.training.demo.basic;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by huangye on 2017/6/23.
 */
public class AsynNotificationResp {

    /**
     * 接口版本
     */
    private String version;

    /**
     * 商户号
     */
    private String merchant;

    /**
     * 终端号
     */
    private String terminal;

    /**
     * 加密数据
     */
    private String data;

    /**
     * 签名
     */
    private String sign;


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public static AsynNotificationResp parseXML(byte[] xmlString) throws DocumentException {
        InputStream is = new ByteArrayInputStream(xmlString);
        SAXReader sax = new SAXReader(false);
        Document document = sax.read(is);
        AsynNotificationResp dto = new AsynNotificationResp();
        Element rootElement = document.getRootElement();
        if (null == rootElement) {
            return dto;
        }
        Element versionElement = rootElement.element("VERSION");
        if (null != versionElement) {
            dto.setVersion(versionElement.getText());
        }
        Element merchantElement = rootElement.element("MERCHANT");
        if (null != merchantElement) {
            dto.setMerchant(merchantElement.getText());
        }
        Element terminalElement = rootElement.element("TERMINAL");
        if (null != terminalElement) {
            dto.setTerminal(terminalElement.getText());
        }
        Element dataElement = rootElement.element("DATA");
        if (null != dataElement) {
            dto.setData(dataElement.getText());
        }
        Element signElement = rootElement.element("SIGN");
        if (null != signElement) {
            dto.setSign(signElement.getText());
        }
        return dto;
    }

    //DATA解密出来的数据
    /*
    <?xml version="1.0" encoding="UTF-8"?>
    <DATA>
        <TRADE>
            <TYPE>S</TYPE>
            <ID>223127811409087990546</ID>
            <AMOUNT>1</AMOUNT>
            <CURRENCY>CNY</CURRENCY>
            <DATE>20140826</DATE>
            <TIME>213101</TIME>
            <NOTE>交易描述</NOTE>
            <STATUS>7</STATUS>
        </TRADE>
        <RETURN>
            <CODE>EEB0004</CODE>
            <DESC>银行交易失败 需自动签到重试</DESC>
        </RETURN>
    </DATA>
    */
    public static Map<String, String> parseDataXML(byte[] dataXmlString) throws DocumentException {
        InputStream is = new ByteArrayInputStream(dataXmlString);
        SAXReader sax = new SAXReader(false);
        Document document = sax.read(is);
        Map<String, String> dto = new HashMap<String, String>();
        Element rootElement = document.getRootElement();
        if (null == rootElement) {
            return dto;
        }
        Element tradeElement = rootElement.element("TRADE");
        if (null != tradeElement) {
            Iterator<Element> it = tradeElement.elementIterator();
            while (it.hasNext()) {
                Element e = it.next();
                dto.put(e.getName(), e.getText());
            }
        }
        Element returnElement = rootElement.element("RETURN");
        if (null != returnElement) {
            Iterator<Element> it = returnElement.elementIterator();
            while (it.hasNext()) {
                Element e = it.next();
                dto.put(e.getName(), e.getText());
            }
        }
        return dto;
    }
}