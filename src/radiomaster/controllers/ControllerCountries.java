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
package radiomaster.controllers;

import radiomaster.model.ModelResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import radiomaster.model.ModelCountries;
import radiomaster.restful.HttpWrapper;
import static radiomaster.restful.HttpWrapper.COUNTRIES_URL;
import static radiomaster.restful.HttpWrapper.HTTP_METHOD_GET;

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
     * Calling this method will get countries list from the HttpWrapper and put
     * them into the lost modeled by ModelCountries
     */

    public  List<ModelCountries> getCountries() {
       // HttpWrapper httpreq = new HttpWrapper();
        HttpWrapper httpRequest = new HttpWrapper();
        httpRequest.setURL(COUNTRIES_URL);
        httpRequest.setMethod(HTTP_METHOD_GET);
        httpRequest.run();
        java.lang.reflect.Type tip1 = new TypeToken<ModelResponse<ModelCountries>>(){
        }.getType();
        ModelResponse<ModelCountries> odgovor1 = new Gson()
                .fromJson(httpRequest.mResponseBody, tip1);
        for (ModelCountries item : odgovor1.getContent()) {
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

    //endregion
}
