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
	public static String app_id = "2016092700611461";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC5n0oHAAqoUa4USJnXB0WlOfdSCgJwG9NHodlaJ6kWfyhkxW7+42ijmukb+JzFtGAkpdnxRHoGgCiLNPsWRzTMWrmyMQ+mvgBW8Q2dJ6b01pWGqQkYkWPNx7vl5Ded26S9zPyOKLb33X7SyH/WE72zFc6zUlViAQdJB724H5vHmMXJLgx2oGL+49Rby7XIRDnWy4fC89WkLJklF7QxOjb63Wp/4jS01F5jPoIuS+07b6ebwpXZh/hVunfR0I0pzz+GtBdiYIUnVkgHqpQZjGBIkuKg12xMVVl6la/JOfnVjiVHDiwQKriILaD8AbfQgjVxtWVDlYCVIS/ROvzzv047AgMBAAECggEBAJbLwf7n2MCfApW12Uynuruc2MAMI6jh4gWKhaHJIIOHL9CV2DM3mZV3zrKLiQjQHV8IYYKwh5VqXgWhN+4EUO9HMR6C3t0t8+atk8q9INQ802J/RkVwL61H+uyrN0eF3VLYCcCPcPzyMwqYGcpXZT/skmx5kaW5giqhIE5JV2uQ3SwHuUVcZXzfvcO2xsAYSF81UWBNw5l6LFpSYVKUG7TgH/HCm7ufLoIYtaqa2E5TokdAL9+YX5V/ohKCW0qXaftErF/rHexcuKAZkJzjAq3w3mvL80Q/OsXafaEGyDPfngwWySm+yJNk/seB4c5pP5BvIMxJFuPuTqcwr4U+LIkCgYEA5w0XATw1QIJXJ7MawZIlbLFkmMdmZT+4BMSz5EyWiqxCtmxeGXZUSNFmHBEOGQ/RHMAomTQHDlNVtDGmLk49dMNWXfBIuFlzJ+MPCwTRVtYK8CcQEzDncTKaRsKBpgxOKqfJZN5kwkFX6iIlt1my7cl3J73fHXgcdcPdfjnusQ0CgYEAzapqRQsHfNuQ0iqfvOgcIqLAdPfpc5umt4D2d7pWpHDSN2WdkuEDMnADTMXZBwqolYct9SpxZFfmJNDMtcwZBMM/YD+X9QEcq/Dqyt8BE7kXL3dR4p1aSNO+jv/6DlTf+fNMvBM0/8W0W6sYYhwyUSyliVQP7oaburkVUZN12mcCgYAE6TlQ9GepXFvf4yWxcZrMCaU6vhpGEqmlqEyukJYukmTEnd8OKX63IYRLGm2zSKvIMalrQDjaLBlJQDjpCQ6zWaePTZkuGfChq2jZchvE/b2zxxDHZ6WzuUCgOmgpEF/k9jYIp9V6b4sf1eP5VrW/6iVXOejxJmlsc2JU2YRiTQKBgQCAVC59KFWivepOiVQk7nvnzL/j/HEJtvy/EdQ4fufjMZaqBFjfNlHlXelhNS6nayooKzItAS/B2er72+FwKosN4rqf1u59bRUz4F7Q+XdVlC94aa6JhX+5Y45K8kRYPvOGph6iWCXA1t8kN80+IrPu3Lnpx68tOYbgau53eViXTwKBgBbQ4xcGznmXGMcYIKxYeb7g3E00mBV/loysO2qVmGmkEU4fkzvTspZ6kgiP268n/+ulGtObJ6QVooCcFRsvb2gA3ApfLW3r66X2+i83oP1HfDUsn5P9tbNOyUrYreG0OA/enaartdQ0WrI2IKUQkesKwsbu9XYx0wtQdkNWqa2D";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAr7XKKZSdfP5I12iGK0xBZEzyo5gmycL10PBafDqLwUbf9wGq3IBhYvnjyhbaSKcIuv7BKd5hWPNadGAxyTt/9UbiDadnjYSbma8TqbuVnGTfNaCvuJ9HRvCFKEwHgzqO1pElsGPGfT7ASpkaDHVCd8Cgfts4u/Ygp0TxpaWJr7sw0fLvbK45Wp/vwkFc4YTXJ4hbdkGMZ71wGbR1B2JELU1jgutzLFqrljiPC9aC29ucJy4Ly+sdO1AmatL2WGYDWNuqK+JyWvFWAuNRahw8eQ0qh1nG0PEq3MsOHXeNprCFa1VJfF+shjEOATYpxK2y1tUciYgPtqVEd7z9zo+ivwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp
	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	//http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp
	//websocket 
	public static String return_url = "http://localhost:8080/parking.web.mgr/payment";

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

