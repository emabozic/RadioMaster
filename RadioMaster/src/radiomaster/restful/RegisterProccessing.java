/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiomaster.restful;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Gauss Developer
 */
public class RegisterProccessing {
    
     public static void main(String[] args) throws IOException {

         sendPostRequest(null, null);
        System.out.println("POST DONE");
    }
    
    String requestURL = "http://radiomaster.gaussx.com/web/app_dev.php/api/user/register"; 
 String data = "email=temail@mail.com&password=123password";


 public static String sendPostRequest(String data, String requestURL) {

         String result="";
        try {

            // Send the request
            URL url = new URL(requestURL);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

            //write parameters
            writer.write(data);
            writer.flush();

            // Get the response
            StringBuffer answer = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                answer.append(line);
            }
            writer.close();
            reader.close();

            //Output the response
            System.out.println(answer.toString());
            result = answer.toString();

        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         return result;
    }
    
}
