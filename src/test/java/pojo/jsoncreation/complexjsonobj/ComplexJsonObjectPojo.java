package pojo.jsoncreation.complexjsonobj;

import java.util.List;

import pojo.jsoncreation.simplejsonobj.SimpleJsonAddressArrayPojo;

public class ComplexJsonObjectPojo {
	
	private String name;
	
	private int age;
	private String designation;
	private List<SimpleJsonAddressArrayPojo> address;
	
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
	
	public List<SimpleJsonAddressArrayPojo> getAddress() {
		return address;
	}
	
	@Override
	public String toString() {
		return "ComplexJsonObjectPojo [name=" + name + ", age=" + age + ", designation=" + designation + ", address="
				+ address + "]";
	}
	
	public void setAddress(List<SimpleJsonAddressArrayPojo> address) {
		this.address = address;
	}
}


/*
	
	{
	  "name": "Venu",
	  "age": 26,
	  "designation": "QA",
	  "address": [
	    {
	      "street": "Tarnaka",
	      "landmark": "circle",
	      "pincode": 4654546
	    },
	    {
	      "street": "Uppal",
	      "landmark": "testing",
	      "pincode": 12312
	    }
	  ]
	}

*/
