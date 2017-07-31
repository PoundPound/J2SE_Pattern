package com.pattern.factory.abstractfactory;

public class LowWheel implements Wheel {

	@Override
	public void roadholding() {
		System.out.println("低端轮胎抓地力弱！");
	}

}
