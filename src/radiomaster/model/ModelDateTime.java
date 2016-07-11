/**
 * Model DateTime
 * 
* This model class represents the DateTime object and also have logic to update
 * controller if its data changes.
 * 
* @author Ema Božić and Goran Jumić
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

import java.text.SimpleDateFormat;
import java.util.Date;




public class ModelDateTime {
    
    //region CLASS PARAMETERS
    private String date;
    private int timezone_type;
    private String timezone;

    //endregion

    //region GETTERS AND SETTERS
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTimezone_type() {
        return timezone_type;
    }

    public void setTimezone_type(int timezone_type) {
        this.timezone_type = timezone_type;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
    
    //endregion
    
     //region CUSTOM METHOD
    /**
     * * This method overrides toString method
     * @return Date, Timezone and Timezone type
     */
    
    @Override
    public String toString() {
        return getDate() + " " + getTimezone() + " " + getTimezone_type(); //To change body of generated methods, choose Tools | Templates.
    }
    
    //endregion
    
}
