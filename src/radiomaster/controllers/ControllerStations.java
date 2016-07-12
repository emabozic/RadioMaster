/*
 * /**
license The MIT License

Copyright (c) 2012-2016 Gauss, www.gauss.hr

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */
 

package radiomaster.controllers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import radiomaster.model.ModelStations;
import radiomaster.restful.HttpWrapper;
import static radiomaster.restful.HttpWrapper.HTTP_METHOD_GET;
import static radiomaster.restful.HttpWrapper.STATIONS_URL;

/**
 *
 * @author Slaven Karakaš
 */


public class ControllerStations {
    //region CLASS PARAMETERS

    List<ModelStations> stations = new ArrayList<>();
    ModelStations mods;
    

    //endregion
    //region CLASS CONSTRUCT
    public ControllerStations() {

    }

    //endregion
    //region CUSTOM METHODS
    
    
    /**
     * Calling this method will get countries list from the HttpWrapper and put
     * them into the lost modeled by ModelCountries
     */

    public  List<ModelStations> getStations() {
    
        HttpWrapper httpRequest = new HttpWrapper();
            
        
        httpRequest.setURL(STATIONS_URL + "HR/100/0");
        httpRequest.setMethod(HTTP_METHOD_GET);
        httpRequest.run();
        
        
        java.lang.reflect.Type tip = new TypeToken<ModelStations>(){
        }.getType();
       
        ModelStations odgovor = new Gson()
                .fromJson(httpRequest.mResponseBody, tip);
      
  
        for (ModelStations item : odgovor.getContent()) {
              mods = new ModelStations();
              mods.setId(item.getId());
              mods.setCreated_at(item.getCreated_at());
              mods.setUpdated_at(item.getUpdated_at());
              mods.setSlug(item.getSlug());
              mods.setName(item.getName());
              mods.setFavorite(item.isFavorite());
              mods.setDescription(item.getDescription());
              mods.setCountry(item.getCountry());
              mods.setWebsite(item.getWebsite());
              mods.setTwitter_url(item.getTwitter_url());
              mods.setFacebook_url(item.getFacebook_url());
              mods.setImage_url(item.getImage_url());
              mods.setThumb_url(item.getThumb_url());
              mods.setStream_url(item.getStream_url());
              mods.setStream_bitrate(item.getStream_bitrate());
              mods.setCategories(item.getCategories());
              mods.setRating(item.getRating());
              mods.setFavorite_count(item.getFavorite_count());
            stations.add(mods);
        }
    return stations;
    }


}
