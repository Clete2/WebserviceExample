package com.clete2.example.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Person {
	@Id
	@GeneratedValue
	private long id;

	private String name;
	private String notes;
	private boolean hasNiceHair;
	private double payPercentile;
	private transient double salary;
	
	@ManyToOne
	private Job job;

	public Person(String name, String notes, double payPercentile, Job job) {
		this.name = name;
		this.notes = notes;
		this.payPercentile = payPercentile;
		this.job = job;
	}

	public Person(String name, String notes, double payPercentile, Job job, boolean hasNiceHair) {
		this(name, notes, payPercentile, job);
		this.hasNiceHair = hasNiceHair;
	}

	protected Person() {
	}

	public void calculateSalary() {
		double minPay = job.getMinPay();
		double maxPay = job.getMaxPay();
				
		this.salary = minPay + ((maxPay - minPay) * (payPercentile / 100));
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public boolean isHasNiceHair() {
		return hasNiceHair;
	}

	public void setHasNiceHair(boolean hasNiceHair) {
		this.hasNiceHair = hasNiceHair;
	}

	public double getPayPercentile() {
		return payPercentile;
	}

	public void setPayPercentile(double payPercentile) {
		this.payPercentile = payPercentile;
	}

	public long getId() {
		return id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
}