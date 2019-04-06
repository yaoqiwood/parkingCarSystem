package com.example.utils;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.util.Base64Util;

public class AipOcrSample {
	public static final String APP_ID = "15610858";
	public static final String API_KEY = "EwSfDOp7hpbNoNPxRGdaSkkT";
	public static final String SECRET_KEY = "OUTIVbrIsiaaRpdMt7ZncRcvWQA2iu9a";
	static AipFace client = null;
	static {
		client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
		// 可选：设置网络连接参数
		// 设置http代理
		// client.setHttpProxy("proxy_host", proxy_port);
		// 设置socket代理
		// client.setSocketProxy("proxy_host", proxy_port);
		// 可选：设置log4j日志输出格式，若不设置，则使用默认配置
		// 也可以直接通过jvm启动参数设置此环境变量
//	        System.setProperty("aip.log4j.conf", "src/main/java/log4j.properties");
		client.setConnectionTimeoutInMillis(2000);
		// 可选：设置代理服务器地址, http和socket二选一，或者均不设置
		client.setSocketTimeoutInMillis(60000);
	}
	
	
    /**
     * 获取用户人脸列表
     * @param userId
     * @param groupId
     * @return
     */
    public static String getUserFaceList(String userId, String groupId) {
        HashMap<String, String> options = new HashMap<String, String>();
        // 获取用户人脸列表
        JSONObject res = client.faceGetlist(userId, groupId, options);
        return res.toString(2);
    }
    
    /**
     * 人脸搜索
     * @param arg0
     * @param groupIdList
     * @param userId
     * @return
     */
    public static JSONObject searchFace(byte[] arg0, String groupIdList, String userId) {
        String imgStr = Base64Util.encode(arg0);
        String imageType = "BASE64";
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        if (userId != null) {
            options.put("user_id", userId);
        }
        options.put("max_user_num", "1");
        JSONObject res = client.search(imgStr, imageType, groupIdList, options);
        return res;
    }
    
    
//    public static void main(String[] args) throws IOException {
//    	File file = new File("C:\\Users\\91293\\Desktop\\usertest.png");
//    	InputStream in = new FileInputStream(file);
//    	 ByteArrayOutputStream out = new ByteArrayOutputStream();
//         byte[] buffer = new byte[1024 * 4];
//         int n = 0;
//         while ((n = in.read(buffer)) != -1) {
//             out.write(buffer, 0, n);
//         }
//        byte[] data = out.toByteArray();
//    	System.out.println(searchFace(data, "User", null));
//	}
//	

}
