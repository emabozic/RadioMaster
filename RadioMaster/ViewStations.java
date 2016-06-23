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
import java.util.ArrayList;
import javax.swing.JMenuItem;
import radiomaster.restful.Response;    
import radiomaster.restful.HttpWrapper;
import static radiomaster.restful.HttpWrapper.STATIONS_URL;
import static radiomaster.restful.HttpWrapper.HTTP_METHOD_GET;
import radiomaster.model.Stations;
import radiomaster.restful.Response2;
import java.io.FileReader;
import java.util.ArrayList;
import com.google.gson.Gson;
import java.util.List;
import radiomaster.model.StationResponseModel;

/**
 *
 * @author Slaven Karakaš
 * app for data harvesting
 */


public class ViewStations extends javax.swing.JFrame implements HttpWrapper.OnCompletion {
    
    ArrayList<String> stations;
    JMenuItem jsubmenu;
    private Object jmenu2;
//    JTextArea output;
//    JScrollPane scrollPane;
//    JMenuBar menuBar;
//    JMenu menu, submenu;
//    JMenuItem menuItem;
    /**
     * Creates new form view_categories
     */
     
    
    
    
    public ViewStations(){
        initComponents();
 
        stations = new ArrayList<>();
        //subcategories = new ArrayList<>();
        jmenu.setText("Stations");
        jmenu1.setText("Categories");
        HttpWrapper wrapper = new HttpWrapper();
       
        wrapper.setURL(STATIONS_URL + "HR/5/0")
                .setOnCompletionListener(this)
                .setMethod(HTTP_METHOD_GET);
        wrapper.run();  
    }
   


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jmenubar = new javax.swing.JMenuBar();
        jmenu = new javax.swing.JMenu();
        jmenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jmenubar.add(jmenu);

        jmenu1.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jmenu1MenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        jmenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenu1ActionPerformed(evt);
            }
        });
        jmenubar.add(jmenu1);

        setJMenuBar(jmenubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 887, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 576, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenu1ActionPerformed
                
     
    }//GEN-LAST:event_jmenu1ActionPerformed

    private void jmenu1MenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jmenu1MenuKeyPressed
             

    }//GEN-LAST:event_jmenu1MenuKeyPressed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jmenu;
    private javax.swing.JMenu jmenu1;
    public static javax.swing.JMenuBar jmenubar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onSuccess(String successBody) {   
            Response2 odgovor= new Gson().fromJson(successBody,Response2.class);

            for (Stations item : odgovor.getContent().getStations()) {
                System.out.println("Item: " + item.getName());
            }   
    }

    @Override
    public void onError(String error) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
