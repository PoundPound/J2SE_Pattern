package com.pattern.adapter;

public class Client {
	public void using(Target target){
		target.handlerRequest();
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		Target adapter = new Adapter();
		client.using(adapter);
		
		Module module = new Module();
		Target adapter2 = new Adapter2(module);
		client.using(adapter2);
	}
}
