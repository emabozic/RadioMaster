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
import radiomaster.model.model_categories;
import static radiomaster.restful.HttpWrapper.CATEGORIES_URL;
import static radiomaster.restful.HttpWrapper.HTTP_METHOD_GET;

/**
 *
 * @author Ema
 */


public class controller_categories {
    
    List<model_categories> categories = new ArrayList<>();
    model_categories mc;
    model_categories kategorije;
    List<String> id;

   
    
    public List<model_categories> getCategories(){
        HttpWrapper wrapper = new HttpWrapper();
        id = new ArrayList<>();

        wrapper.setURL(CATEGORIES_URL)
                //                .setOnCompletionListener(this)
                .setMethod(HTTP_METHOD_GET);
        wrapper.run();

        java.lang.reflect.Type tip = new TypeToken<Response<model_categories>>() {
        }.getType();

        Response<model_categories> odgovor = new Gson().fromJson(wrapper.getmResponseBody(), tip);

        for (model_categories item : odgovor.getContent()) {
//            System.out.println("title: " + item.getTitle() /*+ ", created at:" + item.getCreated_at() + ", updated at:" + item.getUpdated_at()*/);
//            categories.add(item);
              mc = new model_categories();
              mc.setId(item.getId());
              mc.setTitle(item.getTitle());
              mc.setCreated_at(item.getCreated_at());
              mc.setUpdated_at(item.getUpdated_at());
              mc.setSlug(item.getSlug());
              categories.add(mc);
              
        }
        return categories;
       
}
    public List<String> getId(){
        HttpWrapper wrapper = new HttpWrapper();
        id = new ArrayList<>();

        wrapper.setURL(CATEGORIES_URL)
                //                .setOnCompletionListener(this)
                .setMethod(HTTP_METHOD_GET);
        wrapper.run();

        java.lang.reflect.Type tip = new TypeToken<Response<model_categories>>() {
        }.getType();

        Response<model_categories> odgovor = new Gson().fromJson(wrapper.getmResponseBody(), tip);

        for (model_categories item : odgovor.getContent()) {
            id.add(String.valueOf(item.getId()));
        }
        
        return id;
    }
    
   
    
}


