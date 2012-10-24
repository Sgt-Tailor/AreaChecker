package me.sgt_tailor.areachecker;

import java.util.ArrayList;

public class Area {
	private int x1;
	private int y1;
	private int z1;
	
	private int x2;
	private int y2;
	private int z2;
	
	private String world;
	
	public Area(String world, int x1, int y1, int z1, int x2, int y2, int z2) {
		this.x1 = x1;
		this.y1 = y1;
		this.z1 = z1;
		
		this.x2 = x2;
		this.y2 = y2;
		this.z2 = z2;
		
		this.world = world;
	}
	
	public void setPoint1(int x, int y, int z) {
		this.x1=x;
		this.y1=y;
		this.z1=z;
	}
	public void setPoint2(int x, int y, int z) {
		this.x2=x;
		this.y2=y;
		this.z2=z;
	}
	public ArrayList<Integer> getPoints() {
		ArrayList<Integer> points = new ArrayList<Integer>();
		points.add(x1);
		points.add(y1);
		points.add(z1);
		
		points.add(x2);
		points.add(y2);
		points.add(z2);
		
		return points;
	}
	public String getWorld() {
		return world;
	}
	

}
