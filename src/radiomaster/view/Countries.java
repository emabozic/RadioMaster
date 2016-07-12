/**
* \brief 
* \details 
* @author Goran
* @version 1.0
* \date Jul 8, 2016
* \copyright
* This code and information is provided "as is" without warranty of
* any kind, either expressed or implied, including but not limited to
* the implied warranties of merchantability and/or fitness for a
* particular purpose.
* \par
* Copyright (c) Gauss d.o.o. All rights reserved
*/


package radiomaster.view;

import java.awt.Color;
import radiomaster.restful.HttpWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import radiomaster.model.ModelCountries;
import radiomaster.controllers.ControllerCountries;
import radiomaster.controllers.ControllerStations;
import radiomaster.controllers.ControllerStream;
import radiomaster.model.ModelStations;
import radiomaster.utility.Utility;


public class Countries extends javax.swing.JFrame implements HttpWrapper.OnCompletion {

    ArrayList<String>                countries;
    ArrayList<String>                stations;
    DefaultListModel<ModelCountries> defaultListModelCountries;
    DefaultListModel<ModelStations>  defaultListModelStations;
    List<ModelCountries>             modelCountries;
    List<ModelStations>              modelStations;
    ControllerCountries              cc;
    ControllerStations               cs;
    ModelCountries                   mc;
    ModelStations                    ms;
    ControllerStream                 initControllerStreamInsance = new ControllerStream();

    /**
     * Creates new form ViewGoran
     */
    public Countries() throws IOException {
        initComponents();
        setTitle(Utility.APP_NAME);
        Utility.center(this);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        
        jLbVol.setText(Integer.toString(jSldVol.getValue()) + "%");
        initControllerStreamInsance.setGain((float) 0.8);
        jLBRadio.setVisible(false);
        jLbImageEQ.setVisible(false);
        
        countries = new ArrayList<>();
        cc = new ControllerCountries();
        napuniCountries();
        defaultListModelCountries = new DefaultListModel<>();
        for (ModelCountries mc : modelCountries) {
            defaultListModelCountries.addElement(mc);
        }
        jLcountries.setModel(defaultListModelCountries);
        this.modelCountries = cc.getCountries();
        
        
        
        stations = new ArrayList<>();
        cs = new ControllerStations();
        napuniStations();
        defaultListModelStations = new DefaultListModel<>();
        for (ModelStations ms : modelStations) {
            defaultListModelStations.addElement(ms);
        }
        jLstations.setModel(defaultListModelStations);
        this.modelStations = cs.getStations();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLbVolumeStatic = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLbPlay = new javax.swing.JLabel();
        jSldVol = new javax.swing.JSlider();
        jLbStop = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLbVol = new javax.swing.JLabel();
        jLbYVolStatic = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLbImageEQ = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLcountries = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLstations = new javax.swing.JList();
        jLBRadio = new javax.swing.JLabel();
        jTxtTemp = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel.setBackground(new java.awt.Color(255, 255, 255));
        jPanel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("SubRegion:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Station Count:");

        jLbVolumeStatic.setText("Volume:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Country Code: ");

        jLbPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/radiomaster/images/1467907386_InterfaceExpendet-07.png"))); // NOI18N
        jLbPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLbPlayMousePressed(evt);
            }
        });

        jSldVol.setBackground(new java.awt.Color(255, 255, 255));
        jSldVol.setValue(80);
        jSldVol.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSldVolStateChanged(evt);
            }
        });

        jLbStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/radiomaster/images/1467907404_free-09.png"))); // NOI18N
        jLbStop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLbStopMousePressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Prazno");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Region:");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Prazno");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Prazno");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Prazno");

        jLbVol.setText("100%");

        jLbYVolStatic.setText("Your volume is: ");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Prazno");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("ID:");

        jLbImageEQ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/radiomaster/images/equalizer.gif~original2.gif"))); // NOI18N

        jLcountries.setBackground(new java.awt.Color(255, 255, 255));
        jLcountries.setForeground(new java.awt.Color(0, 0, 0));
        jLcountries.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jLcountriesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jLcountries);

        jLstations.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(jLstations);

        jLBRadio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/radiomaster/images/radio.gif"))); // NOI18N

        jTxtTemp.setText("http://grt.streamradio.com.hr:9062");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(26, 26, 26)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelLayout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jLbImageEQ))
                                    .addGroup(jPanelLayout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addComponent(jLBRadio)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelLayout.createSequentialGroup()
                                        .addComponent(jLbPlay)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLbStop))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelLayout.createSequentialGroup()
                                        .addComponent(jLbVolumeStatic)
                                        .addGap(112, 112, 112)
                                        .addComponent(jLbYVolStatic)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLbVol)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jSldVol, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanelLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jTxtTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(2155, 2155, 2155))))))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10)
                            .addComponent(jTxtTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLbPlay)
                                    .addComponent(jLbStop))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLbVolumeStatic)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLbYVolStatic)
                                        .addComponent(jLbVol)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSldVol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLbImageEQ)
                                .addGap(18, 18, 18)
                                .addComponent(jLBRadio)
                                .addGap(0, 36, Short.MAX_VALUE))
                            .addComponent(jScrollPane3)))
                    .addComponent(jScrollPane1)))
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 865, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLcountriesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jLcountriesValueChanged
        mc = (ModelCountries) jLcountries.getSelectedValue();
        jLabel6.setText(String.valueOf(mc.getId()));
        jLabel7.setText(String.valueOf(mc.getStations_count()));
        jLabel8.setText(mc.getCountry_code());
        jLabel9.setText(mc.getRegion());
        jLabel10.setText(mc.getSubregion());
    }//GEN-LAST:event_jLcountriesValueChanged

    private void jSldVolStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSldVolStateChanged
        float setvolume = (float) (jSldVol.getValue() / (float) 100);
        System.out.println(jSldVol.getValue() + "%   " + setvolume);
        initControllerStreamInsance.setGain(setvolume);
        jLbVol.setText(Integer.toString(jSldVol.getValue()) + "%");
    }//GEN-LAST:event_jSldVolStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
      initControllerStreamInsance.StopPlayingAudioStream();
    }//GEN-LAST:event_formWindowClosing

    private void jLbPlayMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbPlayMousePressed
                try {
            if(jLbPlay.isEnabled()) {
                initControllerStreamInsance.StartPlayingAudioStream(jTxtTemp.getText());
                jLbImageEQ.setVisible(true);
                jLBRadio.setVisible(true);
                jLbPlay.setEnabled(false);
            }
        } catch (Exception e) {
          }
    }//GEN-LAST:event_jLbPlayMousePressed

    private void jLbStopMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbStopMousePressed
               try {
            initControllerStreamInsance.StopPlayingAudioStream();
            jLbImageEQ.setVisible(false);
             jLBRadio.setVisible(false);
            jLbPlay.setEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
          }
    }//GEN-LAST:event_jLbStopMousePressed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLBRadio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLbImageEQ;
    private javax.swing.JLabel jLbPlay;
    private javax.swing.JLabel jLbStop;
    private javax.swing.JLabel jLbVol;
    private javax.swing.JLabel jLbVolumeStatic;
    private javax.swing.JLabel jLbYVolStatic;
    private javax.swing.JList jLcountries;
    private javax.swing.JList jLstations;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSlider jSldVol;
    private javax.swing.JTextField jTxtTemp;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onError(String error) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onSuccess(String successBody) {

    }

    private void napuniCountries() {
        this.modelCountries = cc.getCountries();

    }
    
    private void napuniStations() {
        this.modelStations = cs.getStations();

    }
}
