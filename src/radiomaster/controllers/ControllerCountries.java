/**
* \brief 
* \details 
* @author Goran
* @version 1.0
* \date Jul 8, 2016
* \copyright
* This code and information is provided "as is" without warranty of
* any kind, either expressed or implied, including but not limited to
* the implied warranties of merchantability and/or fitness for a
* particular purpose.
* \par
* Copyright (c) Gauss d.o.o. All rights reserved
*/


package radiomaster.controllers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import radiomaster.model.ModelCountries;
import radiomaster.restful.HttpWrapper;
import static radiomaster.restful.HttpWrapper.COUNTRIES_URL;
import static radiomaster.restful.HttpWrapper.HTTP_METHOD_GET;


/**
 *
 * @author Goran
 */


public class ControllerCountries {
    //region CLASS PARAMETERS
    
       
    List<ModelCountries> countries = new ArrayList<>();
    ModelCountries modc;
    List<String> cc;

    
    //endregion
    //region CLASS CONSTRUCT
    
    
    public ControllerCountries() {
        
    }
    
    
    //endregion
    //region CUSTOM METHODS
    
     /**
     * Calling this method will get countries list from the HttpWrapper
     * and put them into the lost modeled by ModelCountries
     */   
    public  List<ModelCountries> getCountries() {
        //HttpWrapper httpreq = new HttpWrapper();
        HttpWrapper httpreq1 = new HttpWrapper();
        httpreq1.setURL(COUNTRIES_URL);
        httpreq1.setMethod(HTTP_METHOD_GET);
        //httpreq1.setOnCompletionListener(this);
        httpreq1.run();
        java.lang.reflect.Type tip1 = new TypeToken<Response<ModelCountries>>() 
        { }.getType();
        Response<ModelCountries> odgovor1 = new Gson()
                .fromJson(httpreq1.mResponseBody, tip1);
        for (ModelCountries item : odgovor1.getContent()) {
            //System.out.println("title: " + item.getRegion());
            modc = new ModelCountries();
            modc.setName(item.getName());
            modc.setId(item.getId());
            modc.setStations_count(item.getStations_count());
            modc.setCountry_code(item.getCountry_code());
            modc.setRegion(item.getRegion());
            modc.setSubregion(item.getSubregion());
            countries.add(modc);

        }
    return countries;
}
    
     /**
     * This method will get country code from the specific country
     * and put it into String
     */   
    public List<String> getCountryCode(){
        HttpWrapper wrapper = new HttpWrapper();
        cc = new ArrayList<>();
        wrapper.setURL(COUNTRIES_URL).setMethod(HTTP_METHOD_GET);
        wrapper.run();
        java.lang.reflect.Type tip = new TypeToken<Response<ModelCountries>>() {
        }.getType();
        Response<ModelCountries> odgovor = new Gson()
                .fromJson(wrapper.getmResponseBody(), tip);
        for (ModelCountries item : odgovor.getContent()) {
            cc.add(String.valueOf(item.getCountry_code()));
        }
    return cc;
    }
    
    //endregion
    
    
}
