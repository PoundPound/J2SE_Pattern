package com.pattern.demo.abstractfactory;

public class DellFactory implements Factory{

	@Override
	public Displayer createDisplayer() {
		return new Displayer("low");
	}

	@Override
	public Mainframe createMainframe() {
		return new Mainframe("low");
	}

	@Override
	public Mouse createMouse() {
		return new Mouse("luxury");
	}

	@Override
	public Keyboard createKeyboard() {
		return new Keyboard("luxury");
	}
}
