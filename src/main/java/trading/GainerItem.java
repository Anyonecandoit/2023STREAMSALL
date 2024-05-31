package trading;
public class GainerItem {
	
	
	
	

	    private String companyName;
	    private double prevClose;
	    private double currentPrice;
	    private double percentChange;

	    public GainerItem(String companyName, double prevClose, double currentPrice, double percentChange) {
	        this.companyName = companyName;
	        this.prevClose = prevClose;
	        this.currentPrice = currentPrice;
	        this.percentChange = percentChange;
	    }

	    // Getters
	    public String getCompanyName() {
	        return companyName;
	    }

	    public double getPrevClose() {
	        return prevClose;
	    }

	    public double getCurrentPrice() {
	        return currentPrice;
	    }

	    public double getPercentChange() {
	        return percentChange;
	    }
	    
	    @Override
	    public String toString() {
	        return "Company: " + companyName +
	                ", Prev Close: " + prevClose +
	                ", Current Price: " + currentPrice +
	                ", % Change: " + percentChange;
	    }
	    
	}

	
	



