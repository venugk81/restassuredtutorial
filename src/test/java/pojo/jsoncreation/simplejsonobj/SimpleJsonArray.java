package pojo.jsoncreation.simplejsonobj;

public class SimpleJsonArray {
	/*
	 [
		  {
		    "street": "Tarnaka",
		    "landmark": "Flyover",
		    "pincode": 454523
		  }
	 ]
*/

	
	private String name;
	private int age;
	private String designation;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	@Override
	public String toString() {
		return "SimpleJsonPojo [name=" + name + ", age=" + age + ", designation=" + designation + "]";
	}
	
	
}
