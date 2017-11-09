import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/** Stores account information specific to a sales associate.
 * 
 * @author Hayley Swick
 *
 */
public class SalesAssociate extends LoginAccount {
	private String wareHouseName;
	private WareHouse w = new WareHouse();
	
	/** Creates a login account for a sales associate.
	 * 
	 * @param String
	 * @param String
	 * @param int
	 * @param String
	 * @param String
	 * @param String
	 * @param String
	 * @param String
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public SalesAssociate(String fn, String ln, int a, String pn, String e, String u, String p, 
		String whn) throws NoSuchAlgorithmException, InvalidKeySpecException {
		super(fn, ln, a, pn, e, u, p);
		this.wareHouseName = whn;
	}
	
	/** Getter method for warehouse name
	 * 
	 * @return String
	 */
	public String getWareHouseName() {
		return this.wareHouseName;
	}
	
	/** Getter method for Warehouse
	 * @param none
	 * @return WareHouse
	 */
	public WareHouse getWareHouse() {
		return this.w;
	}
	
	/** Updates Warehouse
	 * @return void
	 * @param Stirng
	 */
	public void modifyWareHouse(String s) {
		w.add(s);
	}
}
