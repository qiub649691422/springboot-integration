package com.demo.netty.messagePack;

import java.io.Serializable;

import org.msgpack.annotation.Message;

@Message
public class UserVO implements Serializable {

	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		return "id:"+id+",name:"+name;
	}
}
