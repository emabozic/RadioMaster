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
 

package radiomaster.restful;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import static jdk.nashorn.internal.runtime.Debug.id;
import radiomaster.model.ModelCountries;
import radiomaster.model.Stations;
import static radiomaster.restful.HttpWrapper.CATEGORIES_sub_URL;
import static radiomaster.restful.HttpWrapper.HTTP_METHOD_GET;
import static radiomaster.restful.HttpWrapper.STATIONS_URL;

/**
 *
 * @author Slaven Karakaš
 */


public class ControllerStations {
    List<Stations> stations = new ArrayList<>();
    Stations ms;
    CountriesController cc;
    List<String> id_c;
    public ControllerStations(){
        cc = new CountriesController();
        id_c = cc.getCountryCode();
    }
    public List<Stations> getStations(){
        HttpWrapper wrapper = new HttpWrapper();
        for (int i=0; i<stations.size();i++){
            
        wrapper.setURL(STATIONS_URL + i + "10/0")
                .setMethod(HTTP_METHOD_GET);
        wrapper.run();

        java.lang.reflect.Type tip = new TypeToken<Response<Stations>>() {
        }.getType();

        Response<Stations> odgovor = new Gson().fromJson(wrapper.getmResponseBody(), tip);
        
        for (Stations item : odgovor.getContent()) {
//            System.out.println("title: " + item.getTitle() /*+ ", created at:" + item.getCreated_at() + ", updated at:" + item.getUpdated_at()*/);
//            categories.add(item);
              ms = new Stations();
              ms.setId(item.getId());
              ms.setCreated_at(item.getCreated_at());
              ms.setUpdated_at(item.getUpdated_at());
              ms.setSlug(item.getSlug());
              ms.setName(item.getName());
              ms.setFavorite(item.getFavorite());
              ms.setDescription(item.getDescription());
              ms.setCountry(item.getCountry());
              ms.setWebsite(item.getWebsite());
              ms.setTwitter_url(item.getTwitter_url());
              ms.setFacebook_url(item.getFacebook_url());
              ms.setImage_url(item.getImage_url());
              ms.setThumb_url(item.getThumb_url());
              ms.setStream_url(item.getStream_url());
              ms.setStream_bitrate(item.getStream_bitrate());
              ms.setCategories(item.getCategories());
              ms.setRating(item.getRating());
              ms.setFavorite_count(item.getFavorite_count());
              stations.add(ms);
            
        }}
        return stations;
       
}


}
