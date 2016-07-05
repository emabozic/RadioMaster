/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiomaster.view;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileVisitResult;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import radiomaster.restful.Response;
import radiomaster.restful.HttpWrapper;
import radiomaster.utility.Utility;
import static radiomaster.restful.HttpWrapper.LOGIN_URL;

/**
 *
 * @author Gauss Developer
 */
public class Login extends javax.swing.JFrame implements HttpWrapper.OnCompletion {

    HttpWrapper wrapper;
    /**
     * Creates new form login
     */
    public Login() {
        initComponents();
        setTitle(Utility.APP_NAME);
        Utility.center(this);
        setResizable(false);
        getContentPane().setBackground(Color.white);

        lblRegister.setForeground(Color.BLUE);
        lblForget.setForeground(Color.RED);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin = new javax.swing.JPanel();
        txtEmail = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        lblEmail = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblForget = new javax.swing.JLabel();
        lblRegister = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelLogin.setBackground(new java.awt.Color(255, 255, 255));
        panelLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 204)));

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblEmail.setText("Email:");

        lblPassword.setText("Password: ");

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPassword)
                            .addComponent(lblEmail))
                        .addGap(18, 18, 18)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addGap(18, 18, 18)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        lblForget.setText("Forget Password? ");

        lblRegister.setText("Don't have an account? Register!");
        lblRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegisterMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblForget)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblRegister)
                        .addGap(60, 60, 60))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblForget)
                    .addComponent(lblRegister))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        if (!kontrola()) {
            return;
        }
        
        wrapper = new HttpWrapper();
        String postdata = "email=" + txtEmail.getText() + "&" + "password=" + String.valueOf(txtPassword.getPassword());
        byte[] bodyContent = postdata.getBytes();

        wrapper.setURL(LOGIN_URL)
                .setMethod("POST")
                .setOnCompletionListener(this)
                .setBody(bodyContent);
                

        wrapper.run();
//        InputStream error = wrapper.getHttpConn().getErrorStream();
//        System.out.println(error);

//        try {
//            int code = wrapper.getHttpConn().getResponseCode();
//            System.out.println("code " + code);
//            if(code!=200){
//                JOptionPane.showMessageDialog(
//                    getRootPane(), //prozor koji ga zove
//                    "Invalid email or password", //prikazani tekst
//                    "Error",//naslov
//                    JOptionPane.ERROR_MESSAGE //vrsta poruke
//                        );
//                
//            
//            }else{
//                new Categories().setVisible(true);
//                this.dispose();
//            }
//            
//        } catch (IOException ex) {
//            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
//           
//     
//        }

    }//GEN-LAST:event_btnLoginActionPerformed

    private void lblRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegisterMouseClicked
        new Register().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_lblRegisterMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblForget;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRegister;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables

    private boolean kontrola() {

        if (txtEmail.getText().trim().length() == 0) {
            Utility.error(this, "Insert your email in format example@example.com");
            txtEmail.requestFocus();
            return false;
        }
        if (new String(txtPassword.getPassword()).length() == 0) {
            Utility.error(this, "Insert password");
            txtPassword.requestFocus();
            return false;
        }

        return true;

    }

    @Override
    public void onSuccess(String successBody) {
        
        new Menu().setVisible(true);
        this.dispose();
        
        System.out.println("Successful login");

    }

    @Override
    public void onError(String error) {
        
//       error = String.valueOf(wrapper.getHttpConn().getErrorStream());
//        System.out.println(error);
//        
//        System.setProperty("keep alive", error);

        System.out.println("Invalid username or password");
        
//        try {
//                int code = wrapper.getHttpConn().getResponseCode();
//                if (code>200){
//                   
//                }
//                //InputStream es = wrapper.getHttpConn().getErrorStream();
//                        
//             System.out.println("bla bla "+ es);
//                // close the errorstrem
//                es.close();
//        } catch(IOException ex) {
//                // deal with the exception
//        }

        JOptionPane.showMessageDialog(
                    getRootPane(), //prozor koji ga zove
                    "Invalid email or password", //prikazani tekst
                    "Error",//naslov
                    JOptionPane.ERROR_MESSAGE //vrsta poruke
                        );
        
        
    }

}
