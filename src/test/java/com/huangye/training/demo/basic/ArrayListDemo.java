package com.huangye.training.demo.basic;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
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
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import sun.misc.BASE64Decoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created by huangye on 2017/4/10.
 */
public class ArrayListDemo {

    public static void main(String args[]) {

        //String jsonResponse = "sign_type=SHA&sign_data=90B5046A627770BA783C1E2AB79D7B5064534F70&trade_no=20170721100042000079876919&merchant_no=110056526001&notify_datetime=20172321T102407908&biz_trade_no=20160330110_156541_1_P&bank_code=CMB&customer_no=360080004000748916&out_trade_no=20160330110_156541_1_P&trade_class=DEFY&trade_status=FINI&pay_tool=TRAN&trade_pay_time=Fri Jul 21 10:23:15 CST 2017&is_success=Y&card_type=DE&buyer_info={}&trade_subject=卖家100292055,的结算&trade_pay_date=Fri Jul 21 10:23:15 CST 2017&trade_finish_time=Fri Jul 21 10:23:15 CST 2017&seller_info={\"customerNo\":\"360080004000748916\"}&trade_amount=6&trade_finish_date=Fri Jul 21 10:23:15 CST 2017&refund_amount=0&category_code=20EN0401&trade_currency=CNY&return_params=b2b_jd_cloud";
        String jsonResponse = "sign_type=SHA&sign_data=C2995A5D1A9FFB992602608B96699A0D2E646C2B&trade_no=20170721100042000079989432&merchant_no=110056526001&notify_datetime=20170721T182407658&biz_trade_no=20160330110_156551_1_P&bank_code=CMB&customer_no=360080004000748916&out_trade_no=20160330110_156551_1_P&trade_class=DEFY&trade_status=FINI&pay_tool=TRAN&trade_pay_time=Fri Jul 21 18:07:36 CST 2017&is_success=Y&card_type=DE&buyer_info={}&trade_subject=卖家100292055,的结算&trade_pay_date=Fri Jul 21 18:07:36 CST 2017&trade_finish_time=Fri Jul 21 18:07:36 CST 2017&seller_info={\"customerNo\":\"360080004000748916\"}&trade_amount=2&trade_finish_date=Fri Jul 21 18:07:36 CST 2017&refund_amount=0&category_code=20EN0401&trade_currency=CNY&return_params=b2b_jd_cloud";
        //String jsonResponse ="sign_type=SHA&sign_data=272192C5EA2A2281E46289B3A41BA084DDF4E097&trade_no=20170727100042000080920251&merchant_no=110056526001&notify_datetime=20172827T112407773&biz_trade_no=20160330110_158542_10_P&bank_code=CMB&customer_no=360080004000748916&out_trade_no=20160330110_158542_10_P&trade_class=DEFY&trade_status=FINI&pay_tool=TRAN&trade_pay_time=Thu Jul 27 11:28:34 CST 2017&is_success=Y&card_type=DE&buyer_info={}&trade_subject=卖家100292055,的结算&trade_pay_date=Thu Jul 27 11:28:34 CST 2017&trade_finish_time=Thu Jul 27 11:28:34 CST 2017&seller_info={\\\"customerNo\\\":\\\"360080004000748916\\\"}&trade_amount=4&trade_finish_date=Thu Jul 27 11:28:34 CST 2017&refund_amount=0&category_code=20EN0401&trade_currency=CNY&return_params=b2b_jd_cloud";
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
            HttpEntity httpEntity= new StringEntity(jsonResponse,"UTF-8");
            httpPost.setEntity(httpEntity);
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

        //String str =  "//b2b.jcloud.jd.com.oss.cn-north-1.jcloudcs.com/dbcc2f7c-a75e-4814-b208-af965a5779c5.jpg";
//        List<String> list = new ArrayList<String>();
//        list.add("1");
//        list.add("2");
//        String[] strSettlementIds = "1".split(",");
//        System.out.println(strSettlementIds[0].toString());
//        String content = null;
//        try {
//            content = new String(jssService.getObjByteArr("//b2b.jcloud.jd.com.oss.cn-north-1.jcloudcs.com/20170612115350387"),"UTF-8");
//        } catch (Exception e) {
//            LOGGER.error("为移动端获取移动装修的发布版本platformId:"+platformId+" 通过云存储服务获取失败  异常：",e);
//            //jss异常,直接从数据库取M站首页报文
//            content = mobileDecorationPublishVo.getContent();
//        }

//        String ret = null;
//        //ret = "{\"platform_id\":20160330110,\"floors\":[{\"type\":\"banner_sys_module\",\"data\":[{\"pic_url\":\"//b2b.jcloud.jd.com.oss.cn-north-1.jcloudcs.com/66b60a92-7486-4cb2-b468-29735f3204ee.jpg\",\"type\":\"item\",\"id\":\"1001666\",\"link_url\":\"item|1001666\"},{\"pic_url\":\"//b2b.jcloud.jd.com.oss.cn-north-1.jcloudcs.com/925e8e53-5a54-432b-8aa5-3f2f6532ab15.jpg\",\"type\":\"item\",\"id\":\"1001667\",\"link_url\":\"item|1001667\"},{\"pic_url\":\"//b2b.jcloud.jd.com.oss.cn-north-1.jcloudcs.com/219193a1-2fea-4f35-a954-b4991ab79afd.jpg\",\"type\":\"shop\",\"id\":\"1000349\",\"link_url\":\"shop|1000349\"},{\"pic_url\":\"//b2b.jcloud.jd.com.oss.cn-north-1.jcloudcs.com/dffb5dd2-9ddb-4dea-afe0-f41018abf140.jpg\",\"type\":\"shop\",\"id\":\"1000350\",\"link_url\":\"shop|1000350\"}],\"moduleId\":29},{\"type\":\"pic_sys_module\",\"data\":[{\"pic_url\":\"http://s-bj.jcloud.com/b2b.jcloud.jd.com/3043e481-83b3-481b-a780-4c84d2d22266.png\",\"type\":\"item\",\"id\":\"1003332\",\"link_url\":\"item|1003332\"},{\"pic_url\":\"http://s-bj.jcloud.com/b2b.jcloud.jd.com/4aa3428b-c222-4b31-bd05-a99406434281.png\",\"type\":\"item\",\"id\":\"1003648\",\"link_url\":\"item|1003648\"}],\"row\":\"1\",\"col\":\"2\",\"moduleId\":30},{\"type\":\"activity_sys_module\",\"data\":[{\"type\":\"item\",\"id\":\"1001681\",\"price\":\"0.01 - 5988.00\",\"desc\":\"Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机\",\"pic_url\":\"http://s-bj.jcloud.com/b2b.jcloud.jd.com/32958f13-5a47-483b-ad8c-47b13a05a33e.png\"},{\"type\":\"item\",\"id\":\"1001666\",\"price\":\"699.00 - 799.00\",\"desc\":\"锤子 坚果 32GB  移动联通4G手机 双卡双待\",\"pic_url\":\"http://s-bj.jcloud.com/b2b.jcloud.jd.com/fb9d425e-ade9-4a73-8a2b-eb68910a9c68.png\"},{\"type\":\"item\",\"id\":\"1001682\",\"price\":\"40.90 - 40.90\",\"desc\":\"高性能JavaScript\",\"pic_url\":\"http://s-bj.jcloud.com/b2b.jcloud.jd.com/9163615d-1e8e-4ded-a212-9e4f7cec6fe7.png\"},{\"type\":\"item\",\"id\":\"1001684\",\"price\":\"0.01 - 77.80\",\"desc\":\"OReilly精品图书系列：JavaScript权威指南（第6版）\",\"pic_url\":\"http://s-bj.jcloud.com/b2b.jcloud.jd.com/117100af-c6d6-45da-a22b-b7a93230d259.png\"},{\"type\":\"item\",\"id\":\"1001689\",\"price\":\"0.01 - 0.02\",\"desc\":\"姚---扳手手机\",\"pic_url\":\"http://s-bj.jcloud.com/b2b.jcloud.jd.com/b4c41908-3bdf-4215-b6bc-e08460d1770f.png\"}],\"title\":\"热卖商品\",\"more_url\":{\"type\":\"shop\",\"id\":\"1000349\",\"link_url\":\"shop|1000349\"},\"moduleId\":31},{\"type\":\"banner_sys_module\",\"data\":[{\"pic_url\":\"//oss-cn-hb-1.jcloudcs.com/04cfd551-7bb3-4e3b-9f04-c0b0196b6b8f.jpg\",\"type\":\"link\",\"id\":\"\",\"link_url\":\"m-b2bp1bj.jcloud.com\"},{\"pic_url\":\"//oss-cn-hb-1.jcloudcs.com/8adb213f-c04e-4e60-b16e-cd1f86db877c.png\",\"type\":\"link\",\"id\":\"\",\"link_url\":\"m-b2bp1bj.jcloud.com\"}],\"moduleId\":54}]}";
//        JSONObject retJSON = JSONObject.parseObject(ret);
//        retJSON.put("httpsCheck", "123");
//        System.out.println(retJSON);

//        StringBuffer readBuffer = new StringBuffer();
//        readBuffer.append("123");
//        String params = "132";
//
//        if(StringUtils.isNotBlank(params)){
//            System.out.println("1312123");
//        }else{
//            System.out.println("1312eqweqw123");
//        }

//            long skuPrice = new BigDecimal("0.02").multiply(new BigDecimal("100")).longValue();
//            float f1 = ((float) 1 / skuPrice) * 10;
//            System.out.println(new BigDecimal("10").setScale(1, BigDecimal.ROUND_HALF_UP));

//        String resp = "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz4NCjxDSElOQUJBTks%2BCiAgPFZFUlNJT04%2BMS4wLjA8L1ZFUlNJT04%2BCiAgPE1FUkNIQU5UPjExMDA1NjUyNjAwMjwvTUVSQ0hBTlQ%2BCiAgPFRFUk1JTkFMPjAwMDAwMDAxPC9URVJNSU5BTD4KICA8REFUQT42ZGEyMUVMUzNOMllsNzBFdkM2b3Jha1dOYlBwc0NGN0hMMzNaVDg4aWl6cU5NRjAyc0dSTU5pcVVlMmNEcEVxdnhWMHJxSWJiUGJKRUFYNWg0L2RRaG9COGkza1ptSEQxeVpIeWIyWGZXRGd3MWFaN1ZNOG11THpVUkNjUWE3K2M5ZTdiM3NubjNabHNGbWFxM3ljeFJ1YmllNFZoYTdEZGlBTExzWTNWaUZHbllXQlYwK3puNjdObG9pY21QOXJGcVVrdjBEYStPbHNWQWZEeTdEalBUcURvemgrWXc4ZzVoU2VaZGFyTnljOVRqa0lxQW54eTFjSWhuYTJoMXh0Vm1QNmhZdFlYVktEOGYwK21Xblk3ZXppK2NKcnhTSm9peUw1d0xpcHl2UzF2Tk0yVWxza3RDakZpdU04R3dvUVJ5b1FMNHFMYngxdE9pc2pLV0YvODQwOTFFdXo0M2R3LzgyL1dacUN6elByVFcvWHpmaHZmWmFVMjdYRXZRWGZ6bmxHcWVaTityRm82VTNZVkJQN3VLUkNUcGhZVVcrVUFybHlZWFJCUEp4OVRYMVdjUWlZamQ0a1pKT1JqT3hWczNVRHgxTjVXN0ViVGM5K2RpNytDUT09PC9EQVRBPgogIDxTSUdOPjZkYTIyZTljMjg2MTkyNjhmYTRmNTEyNjVkMjcyY2EyPC9TSUdOPgo8L0NISU5BQkFOSz4%3D";
//        String desKey = "jHrqLyoC09zl3CN6lCpd6dkyktzfZ/L+";//wepay.des.key
//        String md5Key = "iQvjuwxlr8Sm1RZeVsdzjd11JqgRdqSV";//wepay.md5.key
//        byte[] decryptBASE64Arr =  BASE64.decode(resp);
//        try {
//            AsynNotificationResp dto = AsynNotificationResp.parseXML(decryptBASE64Arr);
//            String ownSign = PAYMD5.getMD5Code(dto.getVersion() + dto.getMerchant() + dto.getTerminal() + dto.getData() + md5Key).toLowerCase();
//            System.out.println("根据传输数据生成的签名:"+ownSign);
//            if (!dto.getSign().equals(ownSign)) {
//                //验签不对
//                System.out.println("签名验证错误!");
//                throw new RuntimeException();
//            }
//
//            //验签成功，业务处理
//            //对Data数据进行解密
//            byte[] rsaKey = (new BASE64Decoder()).decodeBuffer(desKey);
//            String decryptArr = DESUtil.decrypt(dto.getData(), rsaKey, "utf-8");
//            //解密出来的数据也为XML文档，可以用dom4j解析
//            System.out.println("对<DATA>进行解密得到的数据:" + decryptArr);
//
//            Map<String, String> data = AsynNotificationResp.parseDataXML(decryptArr.getBytes());
//            String status = data.get("STATUS");
//            System.out.println("对<DATA>进行解密得到的数据:" + decryptArr);
//            String tradeNum = data.get("ID");
//            String v_AMOUNT =   data.get("AMOUNT");
//            System.out.println(":v_AMOUNT:"+v_AMOUNT);
//        } catch (Exception e) {
//        }


        //System.out.print(new BigDecimal("0").setScale(3,BigDecimal.ROUND_HALF_UP));

//        List<Long> skuIds = new ArrayList<Long>();
//        skuIds.size();
//        //Hashtable
//        //HashMap
//        List<String> list=new ArrayList();
//        list.add("A");
//        list.add("B");
//        list.add("C");
//        list.add("A");
//        // List中允许元素重复
//        for(int i=0;i<list.size();i++)
//            System.out.print(" "+list.get(i));// A B C A
//        // 去除重复的元素且保持原有元素的顺序
//        List list2=new ArrayListDemo().function(list);
//
//        System.out.println("----------");
//
//        for(int i=0;i<list2.size();i++)
//            System.out.print(" "+list2.get(i));// A B C
//        }
//    public <e> List<e> function (List<e> list) {
//        return new ArrayList<e>(new LinkedHashSet<e>(list));


//        List<String> list = new ArrayList();
//        System.out.println("----------"+list.size());
//        //list.get(0);
//        list.add("A");
//        list.add("B");
//        list.add("C");
//        list.add("D");
//        // List中允许元素重复
//        for(int i=0;i<list.size();i++)
//            System.out.print(" "+list.get(i));// A B C A
//        // 去除重复的元素且保持原有元素的顺序
//        System.out.println("----------");
//        list.remove("B");
//        for(int i=0;i<list.size();i++)
//            System.out.print(" "+list.get(i));// A B C
//        }
    }
}
