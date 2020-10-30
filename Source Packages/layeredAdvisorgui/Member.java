package layeredAdvisorgui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hunth4
 */
public class Member {

	private int ref;
	private String firstName;
        private String surname;
        private String phone;
        private String memType;

	public Member() {
	}

	public int getRef() {
		return ref;
	}
        
        public void setRef(int aRef) {
		ref = aRef;
	}
        
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String aFirstName) {
		firstName = aFirstName;
	}

        public String getSurname() {
		return surname;
	}
	public void setSurname(String aSurname) {
		surname = aSurname;
	}
        
        public String getPhone() {
                return surname;
	}
	public void setPhone(String aPhone) {
		phone = aPhone;
	}       
	public String getMemType() {
		return memType;
	}
        
        public void setMemType(String aMemType) {
		memType = aMemType;
	}



}
