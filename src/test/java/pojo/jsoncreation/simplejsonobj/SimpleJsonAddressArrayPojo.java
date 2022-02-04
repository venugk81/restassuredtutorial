package pojo.jsoncreation.simplejsonobj;

public class SimpleJsonAddressArrayPojo {
	/*
		  [
			  {
			    "street": "Tarnaka",
			    "landmark": "Flyover",
			    "pincode": 454523
		      }
	 	  ]
	 */
	private String street;
	private String landmark;
	private int pincode;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "SimpleJsonAddressArrayPojo [street=" + street + ", landmark=" + landmark + ", pincode=" + pincode + "]";
	}
	
	
	
	
}
