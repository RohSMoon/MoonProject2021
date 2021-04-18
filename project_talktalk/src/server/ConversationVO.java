package server;

import java.io.Serializable;

public class ConversationVO implements Serializable{
	private String name = null;
	private String conver = null;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getConver() {
		return conver;
	}
	public void setConver(String conver) {
		this.conver = conver;
	}
}
