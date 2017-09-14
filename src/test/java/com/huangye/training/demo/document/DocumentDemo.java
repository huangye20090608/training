package com.huangye.training.demo.document;

import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

/**
 * Created by huangye on 2017/5/25.
 */
public class DocumentDemo {

    public static void main(String agrs[]) throws ParserConfigurationException, IOException, SAXException {

            Map<String,String> map = new HashMap<String,String>();
            String  requestBody = "<xml><appid><![CDATA[wxc4dc87fc89101e45]]></appid>\n" +
                    "<bank_type><![CDATA[CFT]]></bank_type>\n" +
                    "<cash_fee><![CDATA[20]]></cash_fee>\n" +
                    "<coupon_count><![CDATA[1]]></coupon_count>\n" +
                    "<coupon_fee>30</coupon_fee>\n" +
                    "<coupon_fee_0><![CDATA[30]]></coupon_fee_0>\n" +
                    "<coupon_id_0><![CDATA[2000000000227885127]]></coupon_id_0>\n" +
                    "<fee_type><![CDATA[CNY]]></fee_type>\n" +
                    "<is_subscribe><![CDATA[N]]></is_subscribe>\n" +
                    "<mch_id><![CDATA[1239271402]]></mch_id>\n" +
                    "<nonce_str><![CDATA[0.649960724868794]]></nonce_str>\n" +
                    "<openid><![CDATA[oo__ct1BRhD1htUuwv-F9ghsqDb8]]></openid>\n" +
                    "<out_trade_no><![CDATA[2028695-7045-20170602155101]]></out_trade_no>\n" +
                    "<result_code><![CDATA[SUCCESS]]></result_code>\n" +
                    "<return_code><![CDATA[SUCCESS]]></return_code>\n" +
                    "<sign><![CDATA[D0AD6973B9B3E98189BAF84A308F7373]]></sign>\n" +
                    "<time_end><![CDATA[20170602161056]]></time_end>\n" +
                    "<total_fee>50</total_fee>\n" +
                    "<trade_type><![CDATA[NATIVE]]></trade_type>\n" +
                    "<transaction_id><![CDATA[4002812001201706023895897297]]></transaction_id>\n" +
                    "</xml>";


        String  requestBody3 = "<xml><appid><![CDATA[wxc4dc87fc89101e45]]></appid>\n" +
                "<bank_type><![CDATA[CFT]]></bank_type>\n" +
                "<cash_fee><![CDATA[1]]></cash_fee>\n" +
                "<coupon_count><![CDATA[1]]></coupon_count>\n" +
                "<coupon_fee>27</coupon_fee>\n" +
                "<coupon_fee_0><![CDATA[27]]></coupon_fee_0>\n" +
                "<coupon_id_0><![CDATA[2000000000231303047]]></coupon_id_0>\n" +
                "<fee_type><![CDATA[CNY]]></fee_type>\n" +
                "<is_subscribe><![CDATA[N]]></is_subscribe>\n" +
                "<mch_id><![CDATA[1239271402]]></mch_id>\n" +
                "<nonce_str><![CDATA[0.5920949411604436]]></nonce_str>\n" +
                "<openid><![CDATA[oo__ct1PCW-a3qBA0zkGXr2RmYzw]]></openid>\n" +
                "<out_trade_no><![CDATA[2028815-7093-20170602184953]]></out_trade_no>\n" +
                "<result_code><![CDATA[SUCCESS]]></result_code>\n" +
                "<return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "<sign><![CDATA[640BB178379D94B189F909234B7C8D1F]]></sign>\n" +
                "<time_end><![CDATA[20170602185009]]></time_end>\n" +
                "<total_fee>28</total_fee>\n" +
                "<trade_type><![CDATA[NATIVE]]></trade_type>\n" +
                "<transaction_id><![CDATA[4001932001201706023924929864]]></transaction_id>\n" +
                "</xml>";

//        appid=wxc4dc87fc89101e45
//                &bank_type=CFT
//                &cash_fee=20
//                &coupon_fee=30
//                &coupon_fee_0=30
//                &coupon_id_0=2000000000227885127
//                &fee_type=CNY
//                &is_subscribe=N
//                &mch_id=1239271402
//                &nonce_str=0.649960724868794
//                &openid=oo__ct1BRhD1htUuwv-F9ghsqDb8
//                &out_trade_no=2028695-7045-20170602155101
//                &result_code=SUCCESS
//                &return_code=SUCCESS
//                &time_end=20170602161056
//                &total_fee=50&trade_type=NATIVE
//                &transaction_id=4002812001201706023895897297


        //无优惠劵（鼓励金）
        String  requestBody1 = "<xml><appid><![CDATA[wxc4dc87fc89101e45]]></appid>\n" +
                "<bank_type><![CDATA[CFT]]></bank_type>\n" +
                "<cash_fee><![CDATA[1]]></cash_fee>\n" +
                "<fee_type><![CDATA[CNY]]></fee_type>\n" +
                "<is_subscribe><![CDATA[N]]></is_subscribe>\n" +
                "<mch_id><![CDATA[1239271402]]></mch_id>\n" +
                "<nonce_str><![CDATA[0.8401653459393938]]></nonce_str>\n" +
                "<openid><![CDATA[oo__ct1Vn513Iz1n9b-ZcnOwwtrI]]></openid>\n" +
                "<out_trade_no><![CDATA[2028777-7081-20170602165931]]></out_trade_no>\n" +
                "<result_code><![CDATA[SUCCESS]]></result_code>\n" +
                "<return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "<sign><![CDATA[C545D4949FB33649CAE669D65101F7B5]]></sign>\n" +
                "<time_end><![CDATA[20170602165946]]></time_end>\n" +
                "<total_fee>1</total_fee>\n" +
                "<trade_type><![CDATA[NATIVE]]></trade_type>\n" +
                "<transaction_id><![CDATA[4001162001201706023906710598]]></transaction_id>\n" +
                "</xml>";
            StringReader stringReader  =  new StringReader(requestBody);
            InputSource inputSource  =  new  InputSource(stringReader);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document  =  builder.parse(inputSource);
            Node root = document.getFirstChild();
            NodeList nodeList = root.getChildNodes();
        for(Integer i = 0; i < nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            String nodeTag = node.getNodeName();
            if(nodeTag.equals("return_code")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.CDATA_SECTION_NODE) {
                        CDATASection cdataNode = (CDATASection) node1;
                        String content = cdataNode.getTextContent();
                        map.put("return_code",content);
                    }
                }else{
                    map.put("return_code", node.getNodeValue());
                }
            }
            else if(nodeTag.equals("return_msg")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.CDATA_SECTION_NODE) {
                        CDATASection cdataNode = (CDATASection) node1;
                        String content = cdataNode.getTextContent();
                        map.put("return_msg", content);
                    }
                }else{
                    map.put("return_msg", node.getNodeValue());
                }
            }
            else if(nodeTag.equals("appid")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.CDATA_SECTION_NODE) {
                        CDATASection cdataNode = (CDATASection) node1;
                        String content = cdataNode.getTextContent();
                        map.put("appid", content);
                    }
                }else{
                    map.put("appid", node.getNodeValue());
                }
            }
            else if(nodeTag.equals("mch_id")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.CDATA_SECTION_NODE) {
                        CDATASection cdataNode = (CDATASection) node1;
                        String content = cdataNode.getTextContent();
                        map.put("mch_id", content);
                    }
                }else{
                    map.put("mch_id", node.getNodeValue());
                }
            }
            else if(nodeTag.equals("device_info")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.CDATA_SECTION_NODE) {
                        CDATASection cdataNode = (CDATASection) node1;
                        String content = cdataNode.getTextContent();
                        map.put("device_info", content);
                    }
                }else{
                    map.put("device_info", node.getNodeValue());
                }
            }
            else if(nodeTag.equals("nonce_str")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.CDATA_SECTION_NODE) {
                        CDATASection cdataNode = (CDATASection) node1;
                        String content = cdataNode.getTextContent();
                        map.put("nonce_str", content);
                    }
                }else{
                    map.put("nonce_str", node.getNodeValue());
                }
            }
            else if(nodeTag.equals("sign")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.CDATA_SECTION_NODE) {
                        CDATASection cdataNode = (CDATASection) node1;
                        String content = cdataNode.getTextContent();
                        map.put("sign", content);
                    }
                }else{
                    map.put("sign", node.getNodeValue());
                }
            }
            else if(nodeTag.equals("result_code")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.CDATA_SECTION_NODE) {
                        CDATASection cdataNode = (CDATASection) node1;
                        String content = cdataNode.getTextContent();
                        map.put("result_code", content);
                    }
                }else{
                    map.put("result_code", node.getNodeValue());
                }
            }
            else if(nodeTag.equals("err_code")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.CDATA_SECTION_NODE) {
                        CDATASection cdataNode = (CDATASection) node1;
                        String content = cdataNode.getTextContent();
                        map.put("err_code", content);
                    }
                }else{
                    map.put("err_code", node.getNodeValue());
                }
            }
            else if(nodeTag.equals("err_code_des")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.CDATA_SECTION_NODE) {
                        CDATASection cdataNode = (CDATASection) node1;
                        String content = cdataNode.getTextContent();
                        map.put("err_code_des", content);
                    }
                }else{
                    map.put("err_code_des", node.getNodeValue());
                }
            }
            else if(nodeTag.equals("openid")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.CDATA_SECTION_NODE) {
                        CDATASection cdataNode = (CDATASection) node1;
                        String content = cdataNode.getTextContent();
                        map.put("openid", content);
                    }
                }else{
                    map.put("openid", node.getNodeValue());
                }
            }
            else if(nodeTag.equals("is_subscribe")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.CDATA_SECTION_NODE) {
                        CDATASection cdataNode = (CDATASection) node1;
                        String content = cdataNode.getTextContent();
                        map.put("is_subscribe", content);
                    }
                }else{
                    map.put("is_subscribe", node.getNodeValue());
                }
            }
            else if(nodeTag.equals("trade_type")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.CDATA_SECTION_NODE) {
                        CDATASection cdataNode = (CDATASection) node1;
                        String content = cdataNode.getTextContent();
                        map.put("trade_type", content);
                    }
                }else{
                    map.put("trade_type", node.getNodeValue());
                }
            }
            else if(nodeTag.equals("bank_type")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.CDATA_SECTION_NODE) {
                        CDATASection cdataNode = (CDATASection) node1;
                        String content = cdataNode.getTextContent();
                        map.put("bank_type", content);
                    }
                }else{
                    map.put("bank_type", node.getNodeValue());
                }
            }
            else if(nodeTag.equals("total_fee")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.TEXT_NODE) {
                        String content = node1.getTextContent();
                        map.put("total_fee", content);
                    }
                }else{
                    map.put("total_fee", node.getNodeValue());
                }
            }
            else if(nodeTag.equals("settlement_total_fee")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.TEXT_NODE) {
                        String content = node1.getTextContent();
                        map.put("settlement_total_fee", content);
                    }
                }else{
                    map.put("settlement_total_fee", node.getNodeValue());
                }
            }
            else if(nodeTag.equals("fee_type")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.CDATA_SECTION_NODE) {
                        CDATASection cdataNode = (CDATASection) node1;
                        String content = cdataNode.getTextContent();
                        map.put("fee_type", content);
                    }
                }else{
                    map.put("fee_type", node.getNodeValue());
                }
            }
            else if(nodeTag.equals("cash_fee")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.CDATA_SECTION_NODE) {
                        CDATASection cdataNode = (CDATASection) node1;
                        String content = cdataNode.getTextContent();
                        map.put("cash_fee", content);
                    }
                }else{
                    map.put("cash_fee", node.getNodeValue());
                }
            }
            else if(nodeTag.equals("cash_fee_type")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.CDATA_SECTION_NODE) {
                        CDATASection cdataNode = (CDATASection) node1;
                        String content = cdataNode.getTextContent();
                        map.put("cash_fee_type", content);
                    }
                }else{
                    map.put("cash_fee_type", node.getNodeValue());
                }
            }
            else if(nodeTag.equals("coupon_fee")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.TEXT_NODE) {
                        String content = node1.getTextContent();
                        map.put("coupon_fee", content);
                    }
                }else{
                    map.put("coupon_fee", node.getNodeValue());
                }
            }
            else if(nodeTag.equals("coupon_count")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.TEXT_NODE) {
                        String content = node1.getTextContent();
                        map.put("coupon_count", content);
                    }else if(node1.getNodeType() == Node.CDATA_SECTION_NODE){
                        CDATASection cdataNode = (CDATASection) node1;
                        String content = cdataNode.getTextContent();
                        map.put("coupon_count", content);
                    }
                }else{
                    map.put("coupon_count", node.getNodeValue());
                }
            }
            else if(nodeTag.equals("coupon_type_$n")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.TEXT_NODE) {
                        String content = node1.getTextContent();
                        map.put("coupon_type_$n", content);
                    }
                }else{
                    map.put("coupon_type_$n", node.getNodeValue());
                }
            }
            else if(nodeTag.equals("coupon_id_$n")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.CDATA_SECTION_NODE) {
                        CDATASection cdataNode = (CDATASection) node1;
                        String content = cdataNode.getTextContent();
                        map.put("coupon_id_$n", content);
                    }
                }else{
                    map.put("coupon_id_$n", node.getNodeValue());
                }
            }
            else if(nodeTag.equals("coupon_fee_$n")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.TEXT_NODE) {
                        String content = node1.getTextContent();
                        map.put("coupon_fee_$n", content);
                    }
                }else{
                    map.put("coupon_fee_$n", node.getNodeValue());
                }
            }
            //start modify 2017-05-31 解决微信支付有鼓励金的情况验证签名不一致
            else if(nodeTag.indexOf("coupon_type_") >-1){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.CDATA_SECTION_NODE) {
                        CDATASection cdataNode = (CDATASection) node1;
                        String content = cdataNode.getTextContent();
                        map.put(nodeTag, content);
                    }else{
                        String content = node1.getTextContent();
                        map.put(nodeTag, content);
                    }
                }else{
                    map.put(nodeTag, node.getNodeValue());
                }
            }
            else if(nodeTag.indexOf("coupon_id_") >-1 ){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    System.out.println(node.getTextContent());
                    if (node1.getNodeType() == Node.CDATA_SECTION_NODE) {
                        CDATASection cdataNode = (CDATASection) node1;
                        String content = cdataNode.getTextContent();
                        map.put(nodeTag, content);
                    }else{
                        String content = node1.getTextContent();
                        map.put(nodeTag, content);
                    }
                }else{
                    map.put(nodeTag, node.getNodeValue());
                }
            }
            else if(nodeTag.indexOf("coupon_fee_") >-1 ){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.CDATA_SECTION_NODE) {
                        CDATASection cdataNode = (CDATASection) node1;
                        String content = cdataNode.getTextContent();
                        map.put(nodeTag, content);
                    }else{
                        String content = node1.getTextContent();
                        map.put(nodeTag, content);
                    }
                }else{
                    map.put(nodeTag, node.getNodeValue());
                }
            }
            //end modify 2017-05-31 解决微信支付有鼓励金的情况验证签名不一致
            else if(nodeTag.equals("transaction_id")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.CDATA_SECTION_NODE) {
                        CDATASection cdataNode = (CDATASection) node1;
                        String content = cdataNode.getTextContent();
                        map.put("transaction_id", content);
                    }
                }else{
                    map.put("transaction_id", node.getNodeValue());
                }
            }
            else if(nodeTag.equals("out_trade_no")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.CDATA_SECTION_NODE) {
                        CDATASection cdataNode = (CDATASection) node1;
                        String content = cdataNode.getTextContent();
                        map.put("out_trade_no", content);
                    }
                }else{
                    map.put("out_trade_no", node.getNodeValue());
                }
            }
            else if(nodeTag.equals("attach")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.CDATA_SECTION_NODE) {
                        CDATASection cdataNode = (CDATASection) node1;
                        String content = cdataNode.getTextContent();
                        map.put("attach", content);
                    }
                }else{
                    map.put("attach", node.getNodeValue());
                }
            }
            else if(nodeTag.equals("time_end")){
                if(node.getChildNodes() != null && node.getChildNodes().getLength()>0){
                    Node node1 = node.getChildNodes().item(0);
                    if (node1.getNodeType() == Node.CDATA_SECTION_NODE) {
                        CDATASection cdataNode = (CDATASection) node1;
                        String content = cdataNode.getTextContent();
                        map.put("time_end", content);
                    }
                }else{
                    map.put("time_end", node.getNodeValue());
                }
            }
        }

        String oldSign = map.get("sign");
        Collection<String> keyset = map.keySet();
        List<String> list  = new ArrayList<String>(keyset);
        //对key键值按字典升序排序
        Collections.sort(list);

        //拼接sign，排除sign
        StringBuffer sign = new StringBuffer();
        for (int i = 0;i < list.size();i++){
            if (!"sign".equals(list.get(i))){
                sign.append(list.get(i)+"="+map.get(list.get(i))+"&");
            }
        }
        String signStr = sign.substring(0,sign.length()-1);

        String  secretKey= "1234zxcv5678asdf4321vcxz5678fdsa";

        System.out.println("校验微信签名begin：" + signStr);

        sign = new StringBuffer(MD5.sign(signStr, "&key=" + secretKey, "UTF-8").toUpperCase());

        System.out.println("校验微信签名end："+ sign.toString() + ",oldSign=" + oldSign);

        if (!oldSign.equals(sign.toString())){

            System.out.println("微信支付回调签名校验失败!原签名和新生成签名不一致!");
        }else{
            System.out.println("微信支付回调签名校验失败!原签名和新生成签名一致!");
        }



//        String asdStr = "appid=wxc4dc87fc89101e45&bank_type=CFT&cash_fee=20&coupon_fee=30&coupon_fee_$n=30&coupon_id_$n=2000000000227885127&fee_type=CNY&is_subscribe=N&mch_id=1239271402&nonce_str=0.649960724868794&openid=oo__ct1BRhD1htUuwv-F9ghsqDb8&out_trade_no=2028695-7045-20170602155101&result_code=SUCCESS&return_code=SUCCESS&time_end=20170602161056&total_fee=50&trade_type=NATIVE&transaction_id=4002812001201706023895897297"
//;
//
//        StringBuffer sign123 = new StringBuffer(MD5.sign(asdStr, "&key=" + secretKey, "UTF-8").toUpperCase());
//
//        System.out.println("校验微信签名end：sign = "+ sign123.toString() + ",oldSign=" + oldSign);
        //wxc4dc87fc89101e45
        //wxc4dc87fc89101e45
    }
}
