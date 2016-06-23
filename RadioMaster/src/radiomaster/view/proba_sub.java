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

package radiomaster.view;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import radiomaster.model.model_subcategories;
import radiomaster.restful.Response;

/**
 *
 * @author Ema
 */



public class proba_sub {
    ArrayList<String> subcategories;
    public proba_sub(){
    
     URL radiomaster;
     subcategories = new ArrayList<>();
    
    
             try {
            radiomaster = new URL("http://radiomaster.gaussx.com/web/app_dev.php/api/categories/list/sub/1");

            HttpURLConnection yc = (HttpURLConnection) radiomaster.openConnection();
            //provjeriti kasnije ima li header
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;
            StringBuffer sBuffer = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                sBuffer.append(inputLine);
            }

            in.close();

            //System.out.println(sBuffer);
            java.lang.reflect.Type tip = new TypeToken<Response<model_subcategories>>() {
            }.getType();

            Response<model_subcategories> odgovor = new Gson().fromJson(sBuffer.toString(), tip);
            
            
             for (model_subcategories item : odgovor.getContent()) {
                System.out.println("title: " + item.getTitle()/*+ ", created at:" + item.getCreated_at() + ", updated at:" + item.getUpdated_at()*/);
                  subcategories.add(item.getTitle());
                 
             }
//             for (int i =0; i<categories.size(); i++)
//             {
//             jsubmenu = new JMenuItem();
//             jsubmenu.setText(categories.get(i));
//             jmenu1.add(jsubmenu);
//             }
  
        }
        catch (MalformedURLException ex) {
            Logger.getLogger(view_categories.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(view_categories.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}

public static void main(String[] args) {
//    
    }
}

