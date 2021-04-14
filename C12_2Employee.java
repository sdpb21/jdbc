import java.math.BigDecimal;

public class C12_2Employee {
	private int id;
	private String lastName;
	private String firstName;
	private String email;
	private BigDecimal salary;
	//constructor
	public C12_2Employee(int id2,String lastName2,String firstName2,String email2,BigDecimal salary2) {
		super();
		id=id2;
		lastName=lastName2;
		firstName=firstName2;
		email=email2;
		salary=salary2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id3) {
		id=id3;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName3) {
		lastName=lastName3;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName3) {
		firstName=firstName3;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email3) {
		email=email3;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary3) {
		salary=salary3;
	}
}
