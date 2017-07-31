package com.pattern.factory.abstractfactory;

public class Client {
	public static void main(String[] args) {
		CarFactory hcf = new LuxuryCarFactory();
		Engine he = hcf.createEngine();
		he.run();
		he.start();
		Seat hs = hcf.createSeat();
		hs.massage();
		Wheel hw = hcf.createWheel();
		hw.roadholding();
		
		CarFactory lcf = new LowCarFactory();
		Engine le = lcf.createEngine();
		le.run();
		le.start();
		Seat ls = lcf.createSeat();
		ls.massage();
		Wheel lw = lcf.createWheel();
		lw.roadholding();
	}
}
