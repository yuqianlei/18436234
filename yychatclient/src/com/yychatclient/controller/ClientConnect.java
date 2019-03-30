package com.yychatclient.controller;

import java.io.*;
import java.net.Socket;

import com.yychatclient.*;
import com.yychatclient.model.Message;
import com.yychatclient.model.User;

public class ClientConnect {
	
	public static Socket s;
	
	public ClientConnect() {
		try {
			s=new Socket("127.0.0.1",3456);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public Message loginValidate(User user){
		ObjectOutputStream oos;
		ObjectInputStream ois;
		Message mess=null;
		try {
			oos =new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(user);
			
			//
			ois=new ObjectInputStream(s.getInputStream());
			mess=(Message)ois.readObject();
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return mess;
		
	}
}