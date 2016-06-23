/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiomaster.view;

import radiomaster.restful.HttpWrapper;
import static radiomaster.restful.HttpWrapper.CATEGORIES_URL;
import static radiomaster.restful.HttpWrapper.CATEGORIES_sub_URL;
import static radiomaster.restful.HttpWrapper.HTTP_METHOD_GET;
import radiomaster.utility.Utility;

/**
 *
 * @author Gauss Developer
 */
public class Categories extends javax.swing.JFrame {

    /**
     * Creates new form Categories
     */
    public Categories() {
        initComponents();
        Utility.center(this);
        
        HttpWrapper wrapper = new HttpWrapper();
        
        wrapper.setURL(CATEGORIES_URL)
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

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmCountries = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmCategories = new javax.swing.JMenu();
        jmSubCategories = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Countries");

        jmCountries.setText("Države");
        jMenu1.add(jmCountries);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Categories");

        jmCategories.setText("Kategorije");
        jmCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCategoriesActionPerformed(evt);
            }
        });

        jmSubCategories.setText("Podkategorije");
        jmSubCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSubCategoriesActionPerformed(evt);
            }
        });
        jmCategories.add(jmSubCategories);

        jMenu2.add(jmCategories);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCategoriesActionPerformed
        
    }//GEN-LAST:event_jmCategoriesActionPerformed

    private void jmSubCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSubCategoriesActionPerformed

    }//GEN-LAST:event_jmSubCategoriesActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmCategories;
    private javax.swing.JMenuItem jmCountries;
    private javax.swing.JMenuItem jmSubCategories;
    // End of variables declaration//GEN-END:variables
}
