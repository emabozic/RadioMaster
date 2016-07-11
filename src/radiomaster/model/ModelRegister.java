/**
 * Model Register
 * 
* This model class represents the Register object and also have logic to update
 * controller if its data changes.
 * 
* @author Nikolina Pepić
 * @version 1.0
 * 
* Jul 8, 2016
 * 
* This code and information is provided "as is" without warranty of any kind,
 * either expressed or implied, including but not limited to the implied
 * warranties of merchantability and/or fitness for a particular purpose.
 * 
* Copyright (c) Gauss d.o.o. All rights reserved
 */
package radiomaster.model;

public class ModelRegister extends ModelDateTime {

    private String username;
    private String email;
    private String password;
    private String created_at;

   //region GETTERS AND SETTERS
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    //endregion 
    
    //region CUSTOM METHOD
    /**
     * * This method overrides toString method
     * @return Date, Timezone and Timezone type
     */
    @Override
    public String toString() {
        return getDate() + " " + getTimezone() + " " + getTimezone_type();
    }
    //endregion
}
