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
       // HttpWrapper httpreq = new HttpWrapper();
        HttpWrapper httpRequest = new HttpWrapper();
        httpRequest.setURL(STATIONS_URL + "HR/100/0");
        httpRequest.setMethod(HTTP_METHOD_GET);
        httpRequest.run();
        java.lang.reflect.Type tip = new TypeToken<Response<ModelStations>>(){
        }.getType();
        Response<ModelStations> odgovor = new Gson()
                .fromJson(httpRequest.mResponseBody, tip);
        for (ModelStations item : odgovor.getContent()) {
            mods = new ModelStations();
            mods.setName(item.getName());

            stations.add(mods);
        }
    return stations;
    }


}
