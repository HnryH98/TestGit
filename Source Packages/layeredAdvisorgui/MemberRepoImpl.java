/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layeredAdvisorgui;
import java.util.ArrayList;
import java.sql.*;


public class MemberRepoImpl implements Repo {
    private ArrayList<Member> members;
    public ArrayList read(Connection conn){
        System.out.println("Reading from the database... ");
        ArrayList list = new ArrayList();
        try {
               Statement st = conn.createStatement();

               ResultSet rs=null;
               String sql = "SELECT * FROM CUSTOMER";
               rs=st.executeQuery(sql);

               while(rs.next()){
                   Member memb = new Member();
                   memb.setRef(rs.getInt("REF"));
                   memb.setFirstName("FIRSTNAME");
                   memb.setSurname("SURNAME");
                   memb.setPhone("PHONE");
                   memb.setMemType("MEMTYPE");
                   
                   list.add(memb);
                  
                   System.out.println(rs.getInt("REF")
                           +"\t"+rs.getString("FIRSTNAME")
                           +"\t"+rs.getString("SURNAME")
                           +"\t"+rs.getString("PHONE")
                           +"\t"+rs.getString("MEMTYPE"));
               }

               rs.close();
               st.close();
                       
        
        } catch (SQLException ex) {
            System.out.println("SQLException failed !");
           
        }
        members = list;
        return members;
                
    }

    public void write(Connection conn, ArrayList members){
        System.out.println("Writing to the database... ");
        System.out.println("record size: " + members.size());
        Statement st;
        
        try {
            st = conn.createStatement();
            String sql = "DELETE FROM CUSTOMER";
            st.executeUpdate(sql);
            
            st.close();         
        }
        catch (SQLException ex) {
                    System.out.println("SQLException error ");
            }
        
        for (int i = 0; i<members.size(); i++) {
            Member member = (Member)members.get(i);
            try {
                st = conn.createStatement();
                
                String sql = "INSERT IN TO CUSTOMER VALUES (" + member.getRef()
                        + ", '" + member.getFirstName() + "' , '"
                        + member.getSurname() + "' , '"
                        + member.getPhone() + "' , '"
                        +member.getMemType() + "')";
                st.executeUpdate(sql);
                               
                st.close();
            }
            catch (SQLException ex) {
                    System.out.println("SQLException error ");
            }        
            
            
        }//end for
    }
}


