package layeredAdvisorgui;
import java.util.*;

public class AdvisorController {
    
        ArrayList list = new ArrayList();
        
      	public ArrayList getMemList(){
            return list;
	}


	public void setMemList(ArrayList aList){
            list = aList;
	}


	 public void register(int ref, String firstName, String surname, String phone, String memType){
             
             Member mem = new Member();
             mem.setRef(ref);
             mem.setFirstName(firstName);
             mem.setSurname(surname);
             mem.setPhone(phone);
             mem.setMemType(memType);
                    
             
             //mem.setName(name);
             //mem.setSpeciality(spec);
            
             list.add(mem);
	 }

	public String viewAll() {
        String data = "";
            
        for (int i = 0; i<list.size(); i++){
                
                Member temp = (Member)list.get(i);
                String str = "\n Member ref no: " + temp.getRef() + 
                        " First name: " + temp.getFirstName() +
                        " surname: " + temp.getSurname() + 
                        " Phone number: " + temp.getPhone() +
                        " Membership Type: " + temp.getMemType() +                                                          
                        ";\n";
                data = data + str;

            }
            return data;
	}
        
        public void updateDetails(int ref, String memType){
            
            boolean found = false; 
            int i = 0;
            while (i<list.size() && !found){
                Member temp = (Member)list.get(i);
                if (ref == temp.getRef()){
                    temp.setMemType(memType);
                    
                    found = true;
                }
                i++;
            }          
        }
        
        public void deleteDetails(int ref){
            ArrayList tempList = new ArrayList();
            for (int i = 0; i<list.size(); i++){
                Member temp = (Member)list.get(i);
                if (ref != temp.getRef()){
                    tempList.add(temp);
                }
            }
            list = tempList;
        }
}
