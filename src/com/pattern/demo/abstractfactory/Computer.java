package com.pattern.demo.abstractfactory;

public interface Computer {
	public Displayer displayer();
	public Mainframe mainframe();
	public Mouse mouse();
	public Keyboard keyboard();
}
