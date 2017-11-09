/** Has the attributes of a person
 * 
 * @author Hayley Swick
 *
 */
public class Person {
	
	private String firstName;
	private String lastName;
	private int age;
	private String phoneNumber;
	private String email;
	
	/** Default constructor
	 * 
	 */
	public Person() {
		
	}
	
	/** Constructs a person based on attributes as parameters
	 * 
	 * @param String
	 * @param String
	 * @param int
	 * @param String
	 * @param String
	 */
	public Person(String fn, String ln, int a, String pn, String e) {
		this.firstName = fn;
		this.lastName = ln;
		this.age = a;
		this.phoneNumber = pn;
		this.email = e;
	}
	
	/** Getter method for first name
	 * @param none
	 * @return String
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/** Getter method for last name
	 * @param none
	 * @return String
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/** Getter method for age
	 * @param none
	 * @return int
	 */
	public int getAge() {
		return this.age;
	}
	
	/** Getter method for phone number
	 * @param none
	 * @return String
	 */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	/** Getter method for phone number
	 * @param none
	 * @return String
	 */
	public String getEmail() {
		return this.email;
	}
}
