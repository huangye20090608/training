package com.huangye.training.demo.basic;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangye on 2017/4/10.
 */
public class ArrayListDemoClass {

    public static void main(String args[]) {
        org.apache.http.client.HttpClient httpClient = null;
        HttpPost httpPost = null;
        HttpResponse response = null;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {
            httpClient = new DefaultHttpClient();
            httpPost = new HttpPost("http://bp1bj.jcloud.com/settlement/notify");
            //设置超时
            org.apache.http.params.HttpParams httpParams = httpClient.getParams();
            httpParams.setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);
            httpParams.setIntParameter(CoreConnectionPNames.SO_TIMEOUT, 10000);
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            list.add(new BasicNameValuePair("sign_type","SHA"));
            list.add(new BasicNameValuePair("sign_data","272192C5EA2A2281E46289B3A41BA084DDF4E097"));
            list.add(new BasicNameValuePair("trade_no","20170727100042000080920251"));
            list.add(new BasicNameValuePair("merchant_no","110056526001"));
            list.add(new BasicNameValuePair("notify_datetime","20172827T112407773"));
            list.add(new BasicNameValuePair("biz_trade_no","20160330110_158542_10_P"));
            list.add(new BasicNameValuePair("bank_code","CMB"));
            list.add(new BasicNameValuePair("customer_no","360080004000748916"));
            list.add(new BasicNameValuePair("out_trade_no","20160330110_158542_10_P"));
            list.add(new BasicNameValuePair("trade_class","DEFY"));
            list.add(new BasicNameValuePair("trade_status","FINI"));
            list.add(new BasicNameValuePair("pay_tool","TRAN"));
            list.add(new BasicNameValuePair("trade_pay_time","Thu Jul 27 11:28:34 CST 2017"));
            list.add(new BasicNameValuePair("is_success","Y"));
            list.add(new BasicNameValuePair("card_type","DE"));
            list.add(new BasicNameValuePair("buyer_info","{}"));
            list.add(new BasicNameValuePair("trade_subject","卖家100292055,的结算"));
            list.add(new BasicNameValuePair("trade_pay_date","Thu Jul 27 11:28:34 CST 2017"));
            list.add(new BasicNameValuePair("trade_finish_time","Thu Jul 27 11:28:34 CST 2017"));
            list.add(new BasicNameValuePair("seller_info","{\"customerNo\":\"360080004000748916\"}"));
            list.add(new BasicNameValuePair("trade_amount","4"));
            list.add(new BasicNameValuePair("trade_finish_date","Thu Jul 27 11:28:34 CST 2017"));
            list.add(new BasicNameValuePair("refund_amount","0"));
            list.add(new BasicNameValuePair("category_code","20EN0401"));
            list.add(new BasicNameValuePair("trade_currency","CNY"));
            list.add(new BasicNameValuePair("return_params","b2b_jd_cloud"));
            //设置消息主体
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, "UTF-8");
            httpPost.setEntity(urlEncodedFormEntity);
            //执行post请求
            response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                throw new Exception(response.getStatusLine().toString());
            }else{
                HttpEntity entity = response.getEntity();
                if (entity == null) {
                } else {

                    br = new BufferedReader(new InputStreamReader(
                            entity.getContent(), "UTF-8"));
                    String s = null;
                    while ((s = br.readLine()) != null) {
                        sb.append(s);
                    }

                    String json_string = EntityUtils.toString(response.getEntity());
                    System.out.println("json_string:" + json_string);
                }
            }
        } catch (Exception e) {
            System.out.println("异常"+e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                }
            }
            httpClient.getConnectionManager().shutdown();
        }

    }
}
