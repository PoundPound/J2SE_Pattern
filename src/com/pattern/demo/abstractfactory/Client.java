package com.pattern.demo.abstractfactory;

public class Client {
	public static void main(String[] args) {
		Factory asus = new AsusFactory();
		Displayer asusDisplayer = asus.createDisplayer();
		Keyboard asusKeyboard = asus.createKeyboard();
		Mainframe asusMainframe = asus.createMainframe();
		Mouse asusMouse = asus.createMouse();
		
		Factory dell = new DellFactory();
		Displayer dellDisplayer = dell.createDisplayer();
		Keyboard dellKeyboard = dell.createKeyboard();
		Mainframe dellMainframe = dell.createMainframe();
		Mouse dellMouse = dell.createMouse();
	}
}
