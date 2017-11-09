import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Hayley Swick
 *
 */
public class Main {
	
	public static SalesAssociate SCHMO = null;
	public static WareHouseManager BLOW = null;
	
	/** Initializes SalesAssociate SCHMO and WareHouseManager BLOW.
	 * @return void
	 * @param none
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public static void init() throws NoSuchAlgorithmException, InvalidKeySpecException {
		boolean thrown = false;
	try {
		SCHMO = new SalesAssociate("Joe", "Schmo", 30, "555-555-5555", 
				"joeschmo@gmail.com", "joeschmo", "xyz1834", "Bike Warehouse 1");
		BLOW = new WareHouseManager("Joe", "Blow", 45, "555-555-5556",
				"joeblow@gmail.com", "joeblow", "1834xyz", "Bike Warehouse 2");
	}
	catch (NoSuchAlgorithmException | InvalidKeySpecException e){
		thrown = true;
	}
	finally {
		if (!thrown) {
			SCHMO = new SalesAssociate("Joe", "Schmo", 30, "555-555-5555", 
					"joeschmo@gmail.com", "joeschmo", "xyz1834", "Bike Warehouse 1");
			BLOW = new WareHouseManager("Joe", "Blow", 45, "555-555-5556",
					"joeblow@gmail.com", "joeblow", "1834xyz", "Bike Warehouse 2");
		}
	}
	}
	
	public static Scanner scan = new Scanner(System.in);
	
	public static final int SA = 1;
	public static final int WHM = 2;
	public static final int NONE = 3;
	
	public static boolean out = false;
	public static String displayName;
	
	/** Prompts user for login info, checks to see if username
	 * and password are valid, and returns account type.
	 * @param none
	 * @return int
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public static int getLoginInfo() throws NoSuchAlgorithmException, InvalidKeySpecException {
		System.out.println("Enter username");
		String username = scan.next();
		System.out.println("Enter password");
		String pass = scan.next();
		if (SCHMO.valid(username, pass)) {
			displayName = username;
			return SA;
		}
		else if (BLOW.valid(username, pass)) {
			displayName = username;
			return WHM;
		}
		return NONE;
	}
	
	/** Adds items to warehouses for SCHMO and BLOW.
	 * @param none
	 * @return void
	 */
	public static void fill() {
		String[] names = {"handlebars", "spokes", "wheel", "tire", "brakes", "gear"};
		for (int i = 0; i < 3; i++) {
			SCHMO.modifyWareHouse(names[i]);
		}
		for (int i = 3; i < 6; i++) {
			BLOW.modifyWareHouse(names[i]);
		}
	}
	
	/** Prints a list of parts of the warehouse 
	 * of the user that is logged in
	 * @return void
	 * @param int
	 */
	public static void printParts(int type) {
		ArrayList<String> list = new ArrayList<String>();
		if (type == SA)
			list = SCHMO.getWareHouse().getList();
		else if (type == WHM)
			list = BLOW.getWareHouse().getList();
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
	}
	
	/** Logs the user out and stops the program
	 * @param none
	 * @return void
	 */
	public static void logOut() {
		out = true;
	}
	
	/** Executes command specified by the user
	 * @return void
	 * @param String
	 * @param int
	 */
	public static void execute(String command, int type) {
		if (command.equalsIgnoreCase("list"))
			printParts(type);
		else if (command.equalsIgnoreCase("logout"))
			logOut();
		else
			System.err.println("Invalid command");
	}
	
	/** While program is running, prompts for login information then executes
	 * commands if information is valid. 
	 * @return void
	 * @param String[]
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
		init();
		fill();
		int type = getLoginInfo();
		while (!out) {
			if (type == NONE) {
				System.err.println("Invalid login attempt");
				type = getLoginInfo();
			}
			else {
				System.out.println(displayName + ":");
				String command = scan.next();
				execute(command, type);
			}
		}
		
	}
}
