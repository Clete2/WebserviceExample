package com.clete2.example.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
	@XmlID
	@Id
	@GeneratedValue
	private String id;

	private String name;
	private String notes;
	private boolean hasNiceHair;
	private double payPercentile;
	private transient double salary;
	
	@XmlIDREF
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
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}