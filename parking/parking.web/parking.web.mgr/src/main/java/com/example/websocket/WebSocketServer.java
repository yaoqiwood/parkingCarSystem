package com.example.websocket;


import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/WebSocketServer")
public class WebSocketServer{    
	//静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet  = new  CopyOnWriteArraySet<>();
    
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    /**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session){
    	System.out.println("建立");
    	this.session = session;
    	getWebSocketSet().add(this);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(){
    	System.out.println("关闭");
    	getWebSocketSet().remove(this);
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session) {
    	System.out.println("接受");
    	System.out.println(message);
    }

    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException{
        this.session.getBasicRemote().sendText(message);
        //this.session.getAsyncRemote().sendText(message);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

	public static CopyOnWriteArraySet<WebSocketServer> getWebSocketSet() {
		Iterator<WebSocketServer> iterator = webSocketSet.iterator();
		int count = 0;
		while(iterator.hasNext()){
			System.out.println(iterator.next().toString());
			count += 1;
		}
		System.out.println(count);
		return webSocketSet;
	}
    
}
