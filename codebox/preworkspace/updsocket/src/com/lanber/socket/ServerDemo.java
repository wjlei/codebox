package com.lanber.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerDemo {
	public static void main(String[] args) throws Exception {
		
		//DatagramSocket此类表示用来发送和接收数据报包的套接字。 
		DatagramSocket ds = new DatagramSocket(2013);

		byte[] by = new byte[1000];
		// 构造 DatagramPacket，用来接收长度为 length 的数据包。
		DatagramPacket dp = new DatagramPacket(by,1000);
		while(true){
		    ds.receive(dp);	
		    System.out.println(new String(by,0,dp.getLength()));
		}
		
		//ds.close();
	}
 
}
