package sf.example.to;

/**
 * Transfer object to receive updates to Job. Contains only updatable fields from Job.
 */
public class JobTO {
	private String title;
	private double minPay;
	private double maxPay;

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
}