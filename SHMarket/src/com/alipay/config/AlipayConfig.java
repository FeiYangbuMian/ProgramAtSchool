package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016091400510711";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
	public static String merchant_private_key ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCYyAURIneVnWMa5OlbXmJpLiBP5ZDRknoHygVvnDMhHAFqiUSZ9d0HSeuVNiX1eChicaQ3zASdZXVJZW4QlCBHJi6KIjvoQ4a3LH7EewmCtjQNwCpEtaphNoo9bQ9rFkVoD0cH0SKCv/ETe878pQKIPP/4MBmydSXvX7q+8jVwquX3dMMVj+sy2UtbkJyBbUb37jsjrL+9FtY3qvb4r0UH3KVRU6f56ENq5meZTAEgvfaVOdwY4WTzXG+5lxyr5gfjWW8KC7ZecU0fJXvPYipbGOlhyRlelwJN7q6BOB2dRXbeawY3kew7QpAmV2TPSC2Xx4MrRZ7hNE4mA25HQnLDAgMBAAECggEAKmQVQ9PUambpAKVTOk7N73Ek9gY0UHHb+h1LtNQaO62RlwXPSwi08zjHbPdBQQK98dKmRfUNsr5b9Kl4CJGRAyzM7PbiuGdEEb7+zXV2BhaYCtiu4bGmPKLtaG3CQWxEhcL3amvUr4KiWU2Y+PCv6y1BuJNgDewDQo/FOQXrXf8cdUjwkxPG//IXbMN/Zlk8fzVB0yAv/x7C3TE09d8k8t0OAO5pgTRMTb82c0qO6b4lKwd7ENJeZhjrAwDJGgJWyWqguYjjsHzgV9tH3VOCHU9mgD8HGMLEAv8/qoI4IC48le2/BtP4IGIKxFrvdo4TIQfyXpkr8JZ676RhMnzUwQKBgQD473hlJgZzYQZbdjxkUZ9B01WoHJcSuMIOUlfy9UVuDIJCFHZ/OdXvSSEDF5G4D9bDHt5YX6RA2X17E5J6La1xzkBgj78ghu3KJXn7vglbnVlnctwJdYrXza/gYxKnIIyceKak3McDnStkSYYlM5yxe9SMMg3N9s98yhYDETy0pwKBgQCdHfwPJznP11PKaEW+owNAmn3BMvsNUoLuBUC9aNUFPjmZ49OqDQbDYMraKopjXC3VSkFMpR1kLdC/xYAD/P1yNt2sGKEYIZ0tw1U7eD1yfRRC+uYzgNeAlD832WrqkkG9ZNVRL0bQAPIvfTrWnoUrB9u3P1WgWUv9iPzWON2ohQKBgGGZikumF/tevB5aAh2W/ujREhFifDzj4Xm6AS+JyJn4H44G9dq181HpCx9qO0C+PQatcKGXhg/C9fauWsy6Yflv0z/IvDfljw+ll+kCviqES8xKdUjkI/aud1lznpmWImsqxrN2uDSLh7q/NPAbB0Fy+oepDE6HiRw1I2I6fOGbAoGBAID4MAOwS0BUnK81UKrf3LeXGUsRsgqJhHglT7Mq7lFTdqzf2stnzflq5piW+un8rJK8VUW485tcEFKaqC6d6N1sNCIkRXgtf3wlLz2VwbrM+WjR00zLohollo8dpSnPzK7Oqlvt1s6/OA3LWhT6Io3j8XNGRd9N7Za8b+7Y1vqRAoGBAJyEaO8OjF0L6fdrZXUAu8/6Ng9UtyBpua/B+4MbIjptc51354lk4hetknMY94q7pQKSGcLjR2FNMiLfhuKPkf09ZOfXJf13L24VNb9q0fpGLgrGAMV/RAaiaRXb+QctrYCl6QT0ASCQlV3u/ZHsv9GMmvLIHW8cQWbFHidXHrOs";
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0Gm6X32ACo9us3hShCre268cTVc5Bb9bXqPUiJxtkyf+H9Bg1vjjxDGuCT8OjAGYJi5g2ti2W8PH4eOa9rWpJ8zKRpPuINAsDkk3gZBBjpY3AdGkXUWAv2Z4XsFT9rlqzSwUg5NlkEfdGKYzQJobj+8YwAm8a4TIqbilqN5Wfv4v9d5tbpsRBjgfGwuaeHLdyGwsR+0CsiMLMS2BMw3JLKRZ0NLYzfv31AfpWGgUp/WcC7c4TEVptn3DauWN88pNNSiN3Ag0ZWu8HK7TieBkbuStsX7VpU/aqTZGmLDemsE/suyjkLRrZSAuJkYDNuGJ77bMhhU8GNoBeL4PfQS0oQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/SHMarket/goods/clientaddAction";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/SHMarket/goods/clientaddAction";
	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

