package com.example.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Iterator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.example.service.PlaceService;
import com.example.websocket.WebSocketServer;

public class ParkInfoPostListener implements ServletContextListener {
	private MyThread myThread;

	@Override
	public void contextDestroyed(ServletContextEvent e) {
		if (myThread != null && myThread.isInterrupted()) {
			myThread.interrupt();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent e) {
		String str = null;
		if (str == null && myThread == null) {
			myThread = new MyThread();
			myThread.start(); // servlet 上下文初始化时启动 socket
		}
	}
}

/**
 * 自定义一个 Class 线程类继承自线程类，重写 run() 方法，用于从后台获取并处理数据
 * 
 * @author Champion.Wong
 */

class MyThread extends Thread {
	
	Socket socket = null;
	BufferedReader read = null;

	public void run() {
		
		while (!this.isInterrupted()) {// 线程未中断执行循环
			try {
				String readLine = read.readLine();
				PlaceService service = (PlaceService) SpringBeanFactoryUtils.getBean("placeService");
				if (service == null) {
					return;
				}
				Iterator<WebSocketServer> iterator = WebSocketServer.getWebSocketSet().iterator();
				while (iterator.hasNext()) {
					WebSocketServer next = iterator.next();
					try {
						next.sendMessage(service.listPlaceByPage("", "", 1, 100).toString());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				socket = connect();
				try {
					read = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	
	public static Socket connect() {
		Socket socket = null;
		while (true) {
			try {
				String IP = "127.0.0.1";
				String port = "10011";
				socket = new Socket(IP, Integer.parseInt(port));
			} catch (UnknownHostException e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
				}
				continue;
			} catch (IOException e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
				}
				continue;
			}
			break;
		}
		return socket;
	}
}
