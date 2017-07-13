package com.gal.vo;

public class AreaObject {
	
	private String type;
	private Double radius;
	private Double width;
	private Double height;
	public AreaObject() {
		super();
	}
	public AreaObject(String type, Double radius, Double width, Double height) {
		super();
		this.type = type;
		this.radius = radius;
		this.width = width;
		this.height = height;
	}
	
	public enum shape{
		circle,radius;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getRadius() {
		return radius;
	}
	public void setRadius(Double radius) {
		this.radius = radius;
	}
	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	
	
}
