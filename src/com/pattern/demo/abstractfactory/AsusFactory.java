package com.pattern.demo.abstractfactory;

public class AsusFactory implements Factory {

	@Override
	public Displayer createDisplayer() {
		return new Displayer("luxury");
	}

	@Override
	public Mainframe createMainframe() {
		return new Mainframe("luxury");
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
