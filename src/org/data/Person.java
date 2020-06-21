package org.data;

public class Person {

	private String name;
	private String firstName;
	private String lastName;
	private int age;

	public Person() {
	}

	public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.name = this.firstName + this.lastName;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + '}';
	}
}
