package com.pattern.demo.abstractfactory;

public interface Factory {
	public Displayer createDisplayer();
	public Mainframe createMainframe();
	public Mouse createMouse();
	public Keyboard createKeyboard();
}
