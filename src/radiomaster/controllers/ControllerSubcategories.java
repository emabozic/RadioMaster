/**
 * SubCategories Controller
 * 
* This controller class is used to get list of subcategories and id of 
* each categories from a URL.
 * 
* @author Ema Božić
 * @version 1.0
 * 
* Jul 8, 2016
 * 
* This code and information is provided "as is" without warranty of any kind,
 * either expressed or implied, including but not limited to the implied
 * warranties of merchantability and/or fitness for a particular purpose.
 * 
* Copyright (c) Gauss d.o.o. All rights reserved
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


public class ControllerSubcategories {
    
    //region CLASS PARAMETERS
    List<ModelSubcategories> subcategories = new ArrayList<>();
    ModelSubcategories msc;
    ControllerCategories cc;
    List<String> id_c;
    //endregion
    
    
    public ControllerSubcategories(){
        cc = new ControllerCategories();
        id_c = cc.getId();
    }
    
    
    //region CUSTOM METHODS
    /**
     * Calling this will get list of all SubCategories by id of Categories 
     * from a supplied URL.
     *
     * @return subcategories
     */
    
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
    //endregion


}
