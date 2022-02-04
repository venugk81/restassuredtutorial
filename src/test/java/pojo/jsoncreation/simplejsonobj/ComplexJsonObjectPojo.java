package pojo.jsoncreation.simplejsonobj;

public class ComplexJsonObjectPojo {
	/*
	 {
		  "name": "venu",
		  "age": 29,
		  "designation": "QA"
	 }
*/
	private String name;
	private int age;
	private String designation;
	private SimpleJsonAddressArrayPojo address;
	
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
	public SimpleJsonAddressArrayPojo getAddress() {
		return address;
	}
	public void setAddress(SimpleJsonAddressArrayPojo address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "ComplexJsonObjectPojo [name=" + name + ", age=" + age + ", designation=" + designation + ", address="
				+ address + "]";
	}
	
	
	
}
