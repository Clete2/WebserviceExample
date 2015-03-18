package com.clete2.example.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Job {
	@Id
	@GeneratedValue
	private long id;

	private String title;
	private double minPay;
	private double maxPay;

	public Job(String title, double minPay, double maxPay) {
		this.title = title;
		this.minPay = minPay;
		this.maxPay = maxPay;
	}
	
	protected Job() {
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getMinPay() {
		return minPay;
	}

	public void setMinPay(double minPay) {
		this.minPay = minPay;
	}

	public double getMaxPay() {
		return maxPay;
	}

	public void setMaxPay(double maxPay) {
		this.maxPay = maxPay;
	}

	public long getId() {
		return id;
	}
}