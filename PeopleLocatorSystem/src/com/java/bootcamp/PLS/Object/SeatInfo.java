package com.java.bootcamp.PLS.Object;

public class SeatInfo {
	private String seatId;
	private String name;
	private String local;
	
	
	public SeatInfo(String seatId, String name, String local) {
		this.seatId = seatId;
		this.name = name;
		this.local = local;
	}
	
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}

	@Override
	public String toString() {
		return "SeatInfo [seatId=" + seatId + ", name=" + name + ", local="
				+ local + "]";
	}
	
	
}
