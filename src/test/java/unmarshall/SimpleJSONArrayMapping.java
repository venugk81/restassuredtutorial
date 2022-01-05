package unmarshall;

public class SimpleJSONArrayMapping {
	private String name;
	private String mobile;
	private int id;
	private double sal;
	
	public String getName() {
		return name;
	}
	public String getMobile() {
		return mobile;
	}
	public int getId() {
		return id;
	}
	public double getSal() {
		return sal;
	}
	@Override
	public String toString() {
		return "SimpleObjectMapping [name=" + name + ", mobile=" + mobile + ", id=" + id + ", sal=" + sal + "]";
	}
	

}



/*
{
	  "name": "venu",
	  "mobile": "7875454",
	  "id": 123,
	  "sal": 12.3
}
*/