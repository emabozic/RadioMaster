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
import radiomaster.model.ModelCountries;
import static radiomaster.restful.HttpWrapper.COUNTRIES_URL;
import static radiomaster.restful.HttpWrapper.HTTP_METHOD_GET;


/**
 *
 * @author Goran
 */


public class CountriesController {
       
    List<ModelCountries> countries = new ArrayList<>();
    ModelCountries modc;
    List<String> cc;


    public  List<ModelCountries> getCountries() {
        HttpWrapper httpreq = new HttpWrapper();
        HttpWrapper httpreq1 = new HttpWrapper();

        httpreq1.setURL(COUNTRIES_URL);
        httpreq1.setMethod(HTTP_METHOD_GET);
   //     httpreq1.setOnCompletionListener(this);
        httpreq1.run();
    
    
              java.lang.reflect.Type tip1 = new TypeToken<Response<ModelCountries>>() {
        }.getType();
        Response<ModelCountries> odgovor1 = new Gson().fromJson(httpreq1.mResponseBody, tip1);

        for (ModelCountries item : odgovor1.getContent()) {
       //     System.out.println("title: " + item.getRegion());
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
    
    
        public List<String> getCountryCode(){
        HttpWrapper wrapper = new HttpWrapper();
        cc = new ArrayList<>();

        wrapper.setURL(COUNTRIES_URL)
                //                .setOnCompletionListener(this)
                .setMethod(HTTP_METHOD_GET);
        wrapper.run();

        java.lang.reflect.Type tip = new TypeToken<Response<ModelCountries>>() {
        }.getType();

        Response<ModelCountries> odgovor = new Gson().fromJson(wrapper.getmResponseBody(), tip);

        for (ModelCountries item : odgovor.getContent()) {
            cc.add(String.valueOf(item.getCountry_code()));
        }
        
        return cc;
    }
    
    
    
}
