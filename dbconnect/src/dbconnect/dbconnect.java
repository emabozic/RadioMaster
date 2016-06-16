package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Slaven
 */

    public class dbconnect {
      public static void main(String[] args)){
          
      }
        private static Connection con;
        String username;
        String email;
        public Boolean loggedIn = false;
        private ResultSet rs;
        CreateUser createuserClass = new CreateUser();

        public String getUsername(){
            return username;
        }

        public String getPassword(){
            return email;
        }


        public void setUsername(String username){
            this.username = username;

        }

        public void setPassword(String password){
            this.email = email;
        }






        public synchronized static void init(){
            if(con!=null)
                return;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql:radiomaster.gaussx.com/web/app_dev.php/api/stations/list");  

            } catch (ClassNotFoundException e) {

                e.printStackTrace();
                System.out.println("Could not find class, quitting.");

            }// Loading DB driver
            catch (SQLException e) {

                e.printStackTrace();
                System.out.println("SQLException, quitting");
            }

        }

        public void checkLogin(){
            try { 
                PreparedStatement login = con.prepareStatement("SELECT * FROM Stations WHERE username=? AND email=?"); 

                login.setString(1, username);
                login.setString(2, email);

                rs = login.executeQuery();


                if(rs.next()){
                    loggedIn = true;
                    setInfo();
                }else{
                    loggedIn = false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("SQL exception in dbconnect, method = checklogin");
            }
        }



        public void setInfo(){
            try {
                this.name = rs.getString(1) + " " + rs.getString(2);
                this.username = rs.getString(5);
                this.age = rs.getInt(3);
            } catch (SQLException e) {

                e.printStackTrace();
                System.out.println("Error");
            }



        }



        class CreateUser{

            String username;
            String email;
            public void setUsername(String username){
                this.username = username;
            }
            public void setEmail(String email){
                this.email = email;
            }

            public void createUser(){



                try
                {
                    PreparedStatement punjenjeBaze = con.prepareStatement("INSERT INTO users VALUES(?,?)");
                    punjenjeBaze.setString(1, username);
                    punjenjeBaze.setString(2, email);
                    punjenjeBaze.executeUpdate();

                }
                catch(Exception e) {
                e.printStackTrace();
                System.out.println(username + " " + email );
                System.out.println("greška pri upisu");
            }
        }


    
}
