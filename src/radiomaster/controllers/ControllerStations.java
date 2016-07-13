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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import radiomaster.model.ModelStations;
import radiomaster.restful.HttpWrapper;
import static radiomaster.restful.HttpWrapper.HTTP_METHOD_GET;
import static radiomaster.restful.HttpWrapper.STATIONS_URL;

public class ControllerStations {
    //region CLASS PARAMETERS
    List<ModelStations.Station> stations = new ArrayList<>();  

    //endregion
    //region CLASS CONSTRUCT
    public ControllerStations() {

    }

    //endregion
    //region CUSTOM METHODS
    
    /**
     * 
     * 
     */

    public  List<ModelStations.Station> getStations(String countrycode) { 
        HttpWrapper httpRequest = new HttpWrapper();
        httpRequest.setURL(STATIONS_URL + countrycode +  "/100/0");
        httpRequest.setMethod(HTTP_METHOD_GET);
        httpRequest.run();
      
        java.lang.reflect.Type type = new TypeToken<ModelStations>(){
        }.getType();
        ModelStations response = new Gson()
                .fromJson(httpRequest.mResponseBody, type);
  
        for (ModelStations.Station item : response.getContent().getStations()) {
              ModelStations modStationRoot = new ModelStations();
              ModelStations.Station modelStation = modStationRoot.new Station(); 
              modelStation.setId(item.getId());
              modelStation.setCreated_at(item.getCreated_at());
              modelStation.setUpdated_at(item.getUpdated_at());
              modelStation.setSlug(item.getSlug());
              modelStation.setName(item.getName());
              modelStation.setFavorite(item.isFavorite());
              modelStation.setDescription(item.getDescription());
              modelStation.setCountry(item.getCountry());
              modelStation.setWebsite(item.getWebsite());
              modelStation.setTwitter_url(item.getTwitter_url());
              modelStation.setFacebook_url(item.getFacebook_url());
              modelStation.setImage_url(item.getImage_url());
              modelStation.setThumb_url(item.getThumb_url());
              modelStation.setStream_url(item.getStream_url());
              modelStation.setStream_bitrate(item.getStream_bitrate());
              modelStation.setCategories(item.getCategories());
              modelStation.setRating(item.getRating());
              modelStation.setFavorite_count(item.getFavorite_count());
              stations.add(modelStation);
        }
    return stations;
    }
    
    //endregion


}
