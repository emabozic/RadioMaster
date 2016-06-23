package radiomaster.restful;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * \brief   RESTFUL API content provider
 * \details This class contains all methods and inner classes
 * required to execute HTTP requests towards specific server. Both 
 * for getting data and manipulating data on the service.
 * 
 * @author Slaven Karakaš
 * @version 1.0
 * 
 * \license The MIT License

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
public class ContentProvider {
    private static final String myUrl = "http://radiomaster.gaussx.com/web/app_dev.php/api/";
    public static final String mStations = myUrl + "stations/favorites/list";
    public static final String mCategories = myUrl + "categories/list";
    public static final String mComments = myUrl + "stations/comments/lists";
    public static final String mLogin = myUrl + "user/login";
    public static final String mCountries = myUrl + "countries/list";
    /**
     * get data from the server with internally declared route to the server
     * @param string constant used from which the http request is being executed.
     */
    public static void getData(String string){
        if (string.contains("http")) {
            // TODO: call normal http request execution
            
            executeHTTPRequest(String);
            }
            else if (string.contains("https")) {
                    // TODO: call https secure protocol request
                                            } 
            else {
                    // TODO: handle unused exception
                    }
                }
    /**
     * Execute HTTP request to a specified domain
     * @param myURL URL of the request 
     * @return      String response of the request
     */
    
    private static String executeHTTPRequest(String myURL) {
                System.out.println("Requested URL:" + myURL);

                StringBuilder sb = new StringBuilder();
                HttpURLConnection urlConn = null;
                InputStreamReader in = null;
                try {
                    URL url = new URL(myURL);
                    urlConn = (HttpURLConnection) url.openConnection();
                    if (urlConn != null) {
                        urlConn.setReadTimeout(60 * 1000);
                    }
                    if (urlConn != null && urlConn.getInputStream() != null) {
                        in = new InputStreamReader(urlConn.getInputStream(),
                                Charset.defaultCharset());
                        try (BufferedReader bufferedReader = new BufferedReader(in)) {
                            int cp;
                            while ((cp = bufferedReader.read()) != -1) {
                                sb.append((char) cp);
                            }
                        }

                        in.close();
                    }
                    } catch (Exception e) {
                    throw new RuntimeException("Exception while calling URL:" + myURL, e);
                    }

                         return sb.toString();
                        }
                    } 

    public interface getDataAsync{
        // asynchronous
         public void execute (final getDataAsync keys, Callback callback);

        interface Callback{
            void onResult(String result);
        }
    public class AsynchronousData implements getDataAsync{
       public void execute (final getDataAsync keys, Callback callback){
           //data
           callback.onResult(result.get()); 
       }
    }

    public class mCallback implements Callback{
        public void onResult(String result){
            //results
        }
    }
}
    

