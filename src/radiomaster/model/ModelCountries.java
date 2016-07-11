/**
 * \brief
 * \details
 *
 * @author Goran Jumić
 * @version 1.0 \date Jul 8, 2016 \copyright This code and information is
 * provided "as is" without warranty of any kind, either expressed or implied,
 * including but not limited to the implied warranties of merchantability and/or
 * fitness for a particular purpose. \par Copyright (c) Gauss d.o.o. All rights
 * reserved
 */


package radiomaster.model;



public class ModelCountries {
    //region CLASS PARAMETERS
    
    
    private int     id;
    private int     stations_count;
    private String  name;
    private String  country_code;
    private String  region;
    private String  subregion;
    private String  flag_img_url;
    
    //endregion
    
    //region GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStations_count() {
        return stations_count;
    }

    public void setStations_count(int stations_count) {
        this.stations_count = stations_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public String getFlag_img_url() {
        return flag_img_url;
    }

    public void setFlag_img_url(String flag_img_url) {
        this.flag_img_url = flag_img_url;
    }
    
    //endregion
    //region CUSTOM METHODS
    
    /**
     * 
     * @return Method is returning Country name in string format
     */
    
        @Override
    public String toString() {
        return getName(); 
    }
    
    //endregion
    
}
