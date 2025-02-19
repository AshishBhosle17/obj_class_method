package finalize;

import java.util.Objects;

class Emp {
	int id = 9;
	String name = "ashish";
	double sal = 2000;

	public Emp(int id, String name, double sal) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Obj deleted");
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", sal=" + sal + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, sal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		return id == other.id && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(sal) == Double.doubleToLongBits(other.sal);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}

public class Main {
	public static void main(String[] args) {

		// Creating an object of Emp
		Emp emp1 = new Emp(1, "John", 5000);
		Emp emp2 = new Emp(2, "Doe", 6000);

		// Printing emp1
		System.out.println(emp1.toString());

		// Checking equality of two objects
		System.out.println("emp1.equals(emp2): " + emp1.equals(emp2));

		// Getting hash code
		System.out.println("emp1 HashCode: " + emp1.hashCode());
		System.out.println("emp2 HashCode: " + emp2.hashCode());

		// Calling finalize explicitly
		emp1 = null;
		System.gc(); // Requesting garbage collection

	}

}
