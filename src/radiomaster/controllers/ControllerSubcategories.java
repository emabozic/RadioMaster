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
import static jdk.nashorn.internal.runtime.Debug.id;
import radiomaster.model.ModelSubcategories;
import radiomaster.restful.HttpWrapper;
import static radiomaster.restful.HttpWrapper.CATEGORIES_sub_URL;
import static radiomaster.restful.HttpWrapper.HTTP_METHOD_GET;

/**
 *
 * @author Ema
 */


public class ControllerSubcategories {
    List<ModelSubcategories> subcategories = new ArrayList<>();
    ModelSubcategories msc;
    ControllerCategories cc;
    List<String> id_c;
    public ControllerSubcategories(){
        cc = new ControllerCategories();
        id_c = cc.getId();
    }
    public List<ModelSubcategories> getSubcategories(){
        HttpWrapper wrapper = new HttpWrapper();
        for (int i=1; i<16; i++){
            
        wrapper.setURL(CATEGORIES_sub_URL + i)
                .setMethod(HTTP_METHOD_GET);
        wrapper.run();

        java.lang.reflect.Type tip = new TypeToken<Response<ModelSubcategories>>() {
        }.getType();

        Response<ModelSubcategories> odgovor = new Gson().fromJson(wrapper.getmResponseBody(), tip);
        
        for (ModelSubcategories item : odgovor.getContent()) {
//            System.out.println("title: " + item.getTitle() /*+ ", created at:" + item.getCreated_at() + ", updated at:" + item.getUpdated_at()*/);
//            categories.add(item);
              msc = new ModelSubcategories();
              msc.setId(item.getId());
              msc.setParent_id(item.getParent_id());
              msc.setTitle(item.getTitle());
              msc.setCreated_at(item.getCreated_at());
              msc.setUpdated_at(item.getUpdated_at());
              msc.setSlug(item.getSlug());
              subcategories.add(msc);
            
        }}
        return subcategories;
       
}


}
