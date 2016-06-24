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

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 *
 * @author Goran
 */

public class HttpWrapper extends Thread {
    
     //region CLASS PARAMETERS
    private static final String BASE_URL = "http://radiomaster.gaussx.com/web/app_dev.php/api/";

    public static final String COUNTRIES_URL = BASE_URL + "countries/list";
    public static final String CATEGORIES_URL = BASE_URL + "categories/list";
    public static final String CATEGORIES_sub_URL = BASE_URL + "categories/list/sub/";
    public static final String REGISTER_URL = BASE_URL + "user/register";
    public static final String LOGIN_URL = BASE_URL + "user/login";
    public static final String STATIONS_URL = BASE_URL + "stations/filter/country/";

    public static final String HTTP_METHOD_GET = "GET";
    public static final String HTTP_METHOD_POST = "POST";

    private HttpURLConnection httpConn;
    private BufferedOutputStream outStream;
    private byte[] mBodyContent;
    public String mResponseBody;

    public String getmResponseBody() {
        return mResponseBody;
    }

    private String mHttpMethod = null;
    private String mUrlCall = null;
    private OnCompletion mListener = null;

	//endregion
    //region CLASS CONSTRUCT
    public HttpWrapper() {
        mHttpMethod = HTTP_METHOD_GET;
    }

    /**
     *
     * @param url
     * @return
     */
    public HttpWrapper setURL(String url) {
        mUrlCall = url;
        return this;
    }

    /**
     *
     * @param method
     * @return
     */
    public HttpWrapper setMethod(String method) {
        mHttpMethod = method;
        return this;
    }

    /**
     *
     * @param onCompletionListener
     * @return
     */
    public HttpWrapper setOnCompletionListener(OnCompletion onCompletionListener) {
        mListener = onCompletionListener;
        return this;
    }

    /**
     *
     * @param bodyContent
     * @return
     */
    public HttpWrapper setBody(byte[] bodyContent) {
        mBodyContent = bodyContent;
        return this;
    }

	//endregion
    //region THREAD METHODS
    @Override
    public void run() {
//        System.out.println("OUTPUT " + "new thread http execution: " + mUrlCall);

        super.run();
        try {
            URL url = new URL(mUrlCall);
            httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setRequestMethod(mHttpMethod);
            httpConn.setDoOutput(true);

            if (mBodyContent != null && mHttpMethod == HTTP_METHOD_POST) {
                outStream = new BufferedOutputStream(httpConn.getOutputStream());
                outStream.write(mBodyContent);
                outStream.flush();
            }

            mResponseBody = streamToString(httpConn.getInputStream());

        } catch (ProtocolException e) {
            e.printStackTrace();
            if (mListener != null) {
                mListener.onError("error");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            if (mListener != null) {
                mListener.onError("error");
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (mListener != null) {
                mListener.onError("error");
            }
        } finally {
            try {
                if (outStream != null) {
                    outStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                if (mListener != null) {
                    mListener.onError("error");
                }
            }

            if (httpConn != null) {
                httpConn.disconnect();
            }
        }

        if (mResponseBody != null) {
//            System.out.println("OUTPUT" + mResponseBody);

            if (mListener != null) {
                mListener.onSuccess(mResponseBody);
            }
        } else {
            if (mListener != null) {
                mListener.onError("error");
            }
        }
    }

	//endregion
    //region CUSTOM METHODS
    /**
     * Convert input stream to a raw string format we can use to serialize later
     * on
     *
     * @param is
     * @return
     * @throws IOException
     */
    public String streamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

	//endregion
    //region INNER CLASSES
    public interface OnCompletion {

        /**
         * Neka dokumenetacija
         *
         * @param successBody
         */
        void onSuccess(String successBody);

        /**
         * neka error dokumentacija
         *
         * @param error
         */
        void onError(String error);
    }

	//endregion
    
    
}