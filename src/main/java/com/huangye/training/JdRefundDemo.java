package com.huangye.training;

import com.huangye.training.web.entity.BaseResponseDto;
import com.huangye.training.web.entity.RefundResultTradeEntity;
import com.huangye.training.web.entity.TradeRefundEntity;
import com.huangye.training.web.entity.TradeRefundReqDto;
import com.huangye.training.web.utils.*;
import sun.misc.BASE64Decoder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by huangye on 2017/8/22.
 */
public class JdRefundDemo {
    public static void main(String args[]) {
        try {
            //2165042-8983-20170822141052
            TradeRefundReqDto tradeRefundReqDto = new TradeRefundReqDto();
            tradeRefundReqDto.setVersion("1.0");//版本号
            tradeRefundReqDto.setMerchantNum("22294531");//商户号  22294531  110056526002
            tradeRefundReqDto.setoTradeNum("2166770-8565-20170823124234");//原交易号 数字或字母   2165042-8983-20170822141052   2165114-8985-20170822151314  2165113-8984-20170822151350  2166460-8987-20170823095316
            tradeRefundReqDto.setTradeNum("2166770-8565-20170823124234-001");//交易号 数字或字母
            tradeRefundReqDto.setTradeAmount(1);//交易金额 单位 分
            tradeRefundReqDto.setTradeCurrency("CNY");//交易币种 固定值 CNY
            Date date = new Date();
            SimpleDateFormat dfDate = new SimpleDateFormat("yyyyMMdd");
            String requestDate = dfDate.format(date);
            SimpleDateFormat dfTime = new SimpleDateFormat("HHmmss");
            String requestTime = dfTime.format(date);
            tradeRefundReqDto.setTradeDate(requestDate);//交易日期 yyyyMMdd
            tradeRefundReqDto.setTradeTime(requestTime);//交易时间 HHmmss
            tradeRefundReqDto.setTradeNote("电商云京东支付2166672退款测试");////交易备注
            String tradeJsonData = "{\"tradeNum\": \"" + tradeRefundReqDto.getTradeNum()
                    + "\",\"oTradeNum\": \"" + tradeRefundReqDto.getoTradeNum()
                    + "\",\"tradeAmount\":\"" + tradeRefundReqDto.getTradeAmount()
                    + "\",\"tradeCurrency\": \"" + tradeRefundReqDto.getTradeCurrency()
                    + "\",\"tradeDate\": \"" + tradeRefundReqDto.getTradeDate()
                    + "\",\"tradeTime\": \"" + tradeRefundReqDto.getTradeTime()
                    + "\",\"tradeNotice\": \"" + tradeRefundReqDto.getTradeNotice()
                    + "\",\"tradeNote\": \"" + tradeRefundReqDto.getTradeNote() + "\"}";


//            String merchantDESKey = "jHrqLyoC09zl3CN6lCpd6dkyktzfZ/L+";
//            String payRSAPrivateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBALLtyAhuLIUJOHwWSol24lb7xnwt50eF2ZdrOzKuHSv+C1qt8El3mrGCVRNoH1SFTvVfT/WIZUh7n8W2seIqSa86P3csEVdWqntBgiwP7QMkzb+RHozA8N9nBckjouPcpQtQyJFUsh4lzIJ1Ktt54SWtQS2aW+2BMrVUSTdH8FJdAgMBAAECgYAx1CxPxLbbOa0kSWTqkVQJG0a0UGhHL8xf8bnjrD9tf+sTjrsLCqbm5j/hDq8i75kElk2DOD/UhrEA85boQBSSo1njGv8WIiej4vXhspwvQKqfBdWViS8i+bwGuAGKf+pf4XGI0wzm/M1MqIAEgtOGAU1Ub2Ft+jFjHiyWthM44QJBAOdY7sWueMvkHKu44xvKJhhzPKwDG+ZbnfoEiZGGw17nY9l0duiCJfbQwAhU+bt3If1Da/KqpXZJULTUq2FfdMkCQQDF/uQCbgTGebMH8C+EOChmwcea4j/Djk9l6+EhBgcjfsooEn81sqCB2UaLdcybnRLd4bT3CwTN5AfQmDtZth71AkAQawxO9SnXdnHecfmUIE2B0LPOlU3mlDvq4WWN8V1uH8fDR/OkXpApKvll3fn3JuY/nghMKXYipeNXYfxjpa2ZAkAQVdI7/RW5xkqmCgPxlayHpc8xER+Po8sbLpXZYqTuIcTN/5CtPnqNm/58/RAPeqsW0Utb4nXYAss+Q4EKCsONAkB0Bfe2ykWX2unGmkbQHcE4WjZWrkkVINgVcVIV1mifdMo9KyU0ZLM5kJY5/Re8HEDscKRsr7CnXn5+I+E94N15";
            String merchantDESKey = "ta4E/aspLA3lgFGKmNDNRYU92RkZ4w2t";
            String payRSAPrivateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALXf6twUqul1TATO+5nA66p2wjnRd+g96IXpfV6Sf8WXxwizGj+L19LQYRBXpZHmRh82prJ48d0FcHboCiN8pKutnuZrrKYhvORysOc5bVli0hcCn1TfYDoUWJ1UhjUQloqZKWjUz6LV9QY6bIZ1W4+Hmw6HK1bfFwUq0WzIGkJNAgMBAAECgYBlIFQeev9tP+M86TnMjBB9f/sO2wGpCIM5slIbO6n/3By3IZ7+pmsitOrDg3h0X22t/V1C7yzMkDGwa+T3Rl7ogwc4UNVj0ZQorOTx3OEPx3nP1yT3zmJ9djKaHKAmee4XmhQHdqqIuMT2XQaqatBzcsnP+Jnw/WVOsIJIqMeFAQJBAP9yq4hE+UfM/YSXZ5JR33k9RolUUq8S/elmeJIDo/3N2qDmzLjOr9iEZHxioc8JOxubtZ0BxA+NdfKz4v0BSpkCQQC2RIrAPRj9vOk6GfT9W1hbJ4GdnzTb+4vp3RDQQ3x9JGXzWFlg8xJT1rNgM8R95Gkxn3KGnYHJQTLlCsIy2FnVAkAWXolM3pVhxz6wHL4SHx9Ns6L4payz7hrUFIgcaTs0H5G0o2FsEZVuhXFzPwPiaHGHomQOAriTkBSzEzOeaj2JAkEAtYUFefZfETQ2QbrgFgIGuKFboJKRnhOif8G9oOvU6vx43CS8vqTVN9G2yrRDl+0GJnlZIV9zhe78tMZGKUT2EQJAHQawBKGlXlMe49Fo24yOy5DvKeohobjYqzJAtbqaAH7iIQTpOZx91zUcL/yG4dWS6r+wGO7Z1RKpupOJLKG3lA==";

            String wangyinServerRefundUrl = "https://m.jdpay.com/wepay/refund";
            String commonRSAPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCKE5N2xm3NIrXON8Zj19GNtLZ8xwEQ6uDIyrS3S03UhgBJMkGl4msfq4Xuxv6XUAN7oU1XhV3/xtabr9rXto4Ke3d6WwNbxwXnK5LSgsQc1BhT5NcXHXpGBdt7P8NMez5qGieOKqHGvT0qvjyYnYA29a8Z4wzNR7vAVHp36uD5RwIDAQAB";
            //1.对退款信息进行3DES加密
            String threeDesData = TDESUtil.encrypt2HexStr(RSACoder.decryptBASE64(merchantDESKey), tradeJsonData);

            //2.对3DES加密的数据进行签名
            String sha256Data = SHAUtil.Encrypt(threeDesData, null);
            byte[] rsaResult = RSACoder.encryptByPrivateKey(sha256Data.getBytes(), payRSAPrivateKey);
            String merchantSign = RSACoder.encryptBASE64(rsaResult);

            //3.构造最终退款请求json
            TradeRefundEntity tradeRefundEntity = new TradeRefundEntity();
            tradeRefundEntity.setVersion(tradeRefundReqDto.getVersion());
            tradeRefundEntity.setMerchantNum(tradeRefundReqDto.getMerchantNum());
            tradeRefundEntity.setMerchantSign(FormatUtil.stringBlank(merchantSign));
            tradeRefundEntity.setData(threeDesData);

            String json = JsonUtil.write2JsonStr(tradeRefundEntity);

            //4.发送请求
            String resultJsonData = HttpsClientUtil.sendRequest(wangyinServerRefundUrl, json);

            //5.验签返回数据
            BaseResponseDto<Map<String, Object>> result = (BaseResponseDto<Map<String, Object>>) JsonUtil.json2Object(resultJsonData, BaseResponseDto.class);
            System.out.print(result.getResultData());
            //执行状态 成功
            if (result.getResultCode() == 0) {
                Map<String, Object> mapResult = result.getResultData();
                //有返回数据
                if (null != mapResult) {
                    String data = mapResult.get("data").toString();
                    String sign = mapResult.get("sign").toString();
                    System.out.println(data);
                    System.out.println(sign);
                    //1.解密签名内容
                    byte[] decryptBASE64Arr = new BASE64Decoder().decodeBuffer(sign);
                    byte[] decryptArr = RSACoder.decryptByPublicKey(decryptBASE64Arr, commonRSAPublicKey);
                    String decryptStr = ByteUtil.byte2HexString(decryptArr);

                    //2.对data进行sha256摘要加密
                    String sha256SourceSignString = ByteUtil.byte2HexLowerCase(SHA256Util.encrypt(data.getBytes("UTF-8")));

                    //3.比对结果
                    if (decryptStr.equals(sha256SourceSignString)) {
                        /**
                         * 验签通过
                         */
                        //解密data
                        String decrypData = TDESUtil.decrypt4HexStr(RSACoder.decryptBASE64(merchantDESKey), data);

                        //退款结果实体
                        RefundResultTradeEntity resultData = (RefundResultTradeEntity) JsonUtil.json2Object(decrypData, RefundResultTradeEntity.class);

                        //错误消息
                        if (null == resultData) {
                            //httpServletRequest.setAttribute("errorMsg", decrypData);
                        } else {
                            //httpServletRequest.setAttribute("resultData", resultData);
                            if(null != resultData.getTradeStatus() && "0".equals(resultData.getTradeStatus())){
                                System.out.println("交易成功");
                            }else if(null != resultData.getTradeStatus() && "6".equals(resultData.getTradeStatus())){
                                System.out.println("交易处理中");
                            }else if(null != resultData.getTradeStatus() && "7".equals(resultData.getTradeStatus())){
                                System.out.println("交易失败");
                            }
                        }
                    } else {
                        System.out.println("验签失败");
                        /**
                         * 验签失败  不受信任的响应数据
                         * 终止
                         */
                        //return "";

                    }
                }
            }
            //执行退款 失败
            else {
                //httpServletRequest.setAttribute("errorMsg", result.getResultMsg());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
