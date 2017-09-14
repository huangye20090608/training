package com.huangye.training.demo.basic;

import org.apache.http.message.BasicNameValuePair;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by huangye on 2017/7/27.
 */
public class RequestMapTest {

    public static void main(String args[]){
        Map<String, String[]> requestParamLists = new HashMap<String, String[]>();
        String[] strArray1 = {"SHA1","SHA2","{}"};
        requestParamLists.put("sign_type1", strArray1);
        String[] strArray2 = {"SHA11","SHA22","SHA33"};
        requestParamLists.put("sign_type2", strArray2);
        String[] values = (String[])requestParamLists.get("sign_type1");
        String params = "";
        for (int i = 0; i < values.length; i++) {
            params = params + "SHA1" + "=" + values[i] + "&";
        }

        System.out.println(params);

//        Map<String, String> requestParams = new HashMap<String, String>();
//
//        requestParams.put("sign_type","SHA");
//        requestParams.put("sign_data","272192C5EA2A2281E46289B3A41BA084DDF4E097");
//        requestParams.put("trade_no","20170721100042000079989432");
//        requestParams.put("merchant_no","110056526001");
//        requestParams.put("notify_datetime","20172827T112407773");
//        requestParams.put("biz_trade_no","20160330110_158542_10_P");
//        requestParams.put("bank_code","CMB");
//        requestParams.put("customer_no","360080004000748916");
//        requestParams.put("out_trade_no","20160330110_156551_1_P");
//        requestParams.put("trade_class","DEFY");
//        requestParams.put("trade_status","FINI");
//        requestParams.put("pay_tool","TRAN");
//        requestParams.put("trade_pay_time","Fri Jul 21 18:07:36 CST 2017");
//        requestParams.put("is_success","Y");
//        requestParams.put("card_type","DE");
//        requestParams.put("buyer_info","{}");
//        requestParams.put("trade_subject","卖家100292055,的结算");
//        requestParams.put("trade_pay_date","Fri Jul 21 18:07:36 CST 2017");
//        requestParams.put("trade_finish_time","Fri Jul 21 18:07:36 CST 2017");
//        requestParams.put("seller_info","{\"customerNo\":\"360080004000748916\"}");
//        requestParams.put("trade_amount","2");
//        requestParams.put("trade_finish_date","Fri Jul 21 18:07:36 CST 2017");
//        requestParams.put("refund_amount","0");
//        requestParams.put("category_code","20EN0401&");
//        requestParams.put("trade_currency","CNY");
//        requestParams.put("return_params","b2b_jd_cloud");
//        String params = "";
//        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
//            String key = (String) iter.next();
//            String value = (String)requestParams.get(key);
//            params = params + key + "=" + value + "&";
//        }
//        System.out.println(params.substring(0,params.length()-1));
    }
}
