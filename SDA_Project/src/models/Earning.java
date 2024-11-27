package models;

public class Earning {
	private double earningthismonth;
	private double totalEarning;
	
	Earning(double thismonth, double total){
		this.setEarningthismonth(thismonth);
		this.setTotalEarning(total);
	}

	public Earning() {
		// TODO Auto-generated constructor stub
	}

	public double getEarningthismonth() {
		return earningthismonth;
	}

	public void setEarningthismonth(double earningthismonth) {
		this.earningthismonth = earningthismonth;
	}

	public double getTotalEarning() {
		return totalEarning;
	}

	public void setTotalEarning(double totalEarning) {
		this.totalEarning = totalEarning;
	}
	
}
