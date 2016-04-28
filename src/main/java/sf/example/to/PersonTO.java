package sf.example.to;

/**
 * Transfer object to receive updates to Person. Contains only updatable fields from Person.
 */
public class PersonTO {
	private String name;
	private String notes;
	private boolean hasNiceHair;
	private double payPercentile;
	private long jobId;

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

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}
}