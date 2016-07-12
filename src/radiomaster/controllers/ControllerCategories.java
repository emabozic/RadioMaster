/**
 * Categories Controller
 * 
* This controller class is used to get list of categories and id of categories
 * from a URL.
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
import radiomaster.model.ModelCategories;
import radiomaster.restful.HttpWrapper;
import static radiomaster.restful.HttpWrapper.CATEGORIES_URL;
import static radiomaster.restful.HttpWrapper.HTTP_METHOD_GET;

public class ControllerCategories {
    

    //region CLASS PARAMETERS
    List<ModelCategories> categories = new ArrayList<>();
    ModelCategories mc;
    ModelCategories kategorije;
    List<String> id;
    //endregion

    //region CUSTOM METHODS
    /**
     * Calling this will get list of all Categories from a supplied URL.
     *
     * @return categories
     */
    public List<ModelCategories> getCategories() {
        HttpWrapper wrapper = new HttpWrapper();
        id = new ArrayList<>();

        wrapper.setURL(CATEGORIES_URL)
                //                .setOnCompletionListener(this)
                .setMethod(HTTP_METHOD_GET);
        wrapper.run();

        java.lang.reflect.Type tip = new TypeToken<Response<ModelCategories>>() {
        }.getType();

        Response<ModelCategories> odgovor = new Gson().fromJson(wrapper.getmResponseBody(), tip);

        for (ModelCategories item : odgovor.getContent()) {
//            System.out.println("title: " + item.getTitle() /*+ ", created at:" + item.getCreated_at() + ", updated at:" + item.getUpdated_at()*/);
//            categories.add(item);
            mc = new ModelCategories();
            mc.setId(item.getId());
            mc.setTitle(item.getTitle());
            mc.setCreated_at(item.getCreated_at());
            mc.setUpdated_at(item.getUpdated_at());
            mc.setSlug(item.getSlug());
            categories.add(mc);

        }
        return categories;

    }

    /**
     * Calling this will get a list of id of each category from a supplied URL.
     *
     * @return id
     */
    public List<String> getId() {
        HttpWrapper wrapper = new HttpWrapper();
        id = new ArrayList<>();

        wrapper.setURL(CATEGORIES_URL)
                //                .setOnCompletionListener(this)
                .setMethod(HTTP_METHOD_GET);
        wrapper.run();

        java.lang.reflect.Type tip = new TypeToken<Response<ModelCategories>>() {
        }.getType();

        Response<ModelCategories> odgovor = new Gson().fromJson(wrapper.getmResponseBody(), tip);

        for (ModelCategories item : odgovor.getContent()) {
            id.add(String.valueOf(item.getId()));
        }

        return id;
    }

    //endregion
}
