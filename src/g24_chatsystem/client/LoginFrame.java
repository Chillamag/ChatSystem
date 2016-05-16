/*
 *  Chat System
 *  Lavet af Gruppe 24 - DTU 2016
 *  --------------------
 *  Magnus Andrias Nielsen, s141899
 *  --------------------
 */
package g24_chatsystem.client;

import brugerautorisation.data.Bruger;
import brugerautorisation.transport.rmi.Brugeradmin;
import java.net.*;
import java.io.*;
import java.rmi.Naming;
import java.util.*;

/**
 *
 * @author Magnus A. Nielsen
 */
public class LoginFrame extends javax.swing.JFrame {

    static String username, password, address = "52.24.17.151";
    static ArrayList<String> users = new ArrayList();
    int port = 1108;
    Boolean isConnected = false;
    private String firstName = "";
    private String lastName = "";
    
    Socket sock;
    static BufferedReader reader;
    static PrintWriter writer;
    
    public void ListenThread(){
        Thread IncomingReader = new Thread(new IncomingReader());
        IncomingReader.start();
    }
    
    public static void error(int number){
        txtErrorWindow.setVisible(true);
        txtErrorWindow.setSize(400, 30);
        txtError.setVisible(true);
        switch (number) {
            case 1:
                txtError.setText("Wrong Username or Password..");
                break;
            case 2:
                txtError.setText("Cannot Connect! Try Again.");
                break;
            case 3:
                txtError.setText("Server down.. Try again later..");
                btnLogin.setEnabled(false);
                break;
            default:
                error(2);
                break;
        }
    }
    
    public void enter(){
        txtError.setVisible(false);
        txtErrorWindow.setVisible(false);
        txtErrorWindow.setSize(400, 1);
        
        btnLogin.setEnabled(false);
        btnCancel.setEnabled(false);
        txtUsername.setEditable(false);
        txtPassword.setEditable(false);
        txtUsername.setEnabled(false);
        txtPassword.setEnabled(false);
    }
    
    public void reset(){
        btnLogin.setEnabled(true);
        btnCancel.setEnabled(true);
        txtUsername.setEditable(true);
        txtPassword.setEditable(true);
        txtUsername.setEnabled(true);
        txtPassword.setEnabled(true);
        
    }
    
    public void resetError(){
        txtError.setVisible(false);
        txtErrorWindow.setVisible(false);
        txtErrorWindow.setSize(400, 1);
        
    }
    
    public LoginFrame() {
        initComponents();
        txtError.setVisible(false);
        txtErrorWindow.setVisible(false);
        txtErrorWindow.setSize(400, 1);
        txtError.setVisible(false);
        
        try{
            sock = new Socket(address, port);
            InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamreader);
            writer = new PrintWriter(sock.getOutputStream());
        }catch(Exception ex){
            error(3);
        }
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtPassword = new javax.swing.JPasswordField();
        txtErrorWindow = new javax.swing.JPanel();
        txtError = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Green Chat - Login");
        setBackground(new java.awt.Color(51, 105, 30));
        setForeground(new java.awt.Color(51, 105, 30));
        setPreferredSize(new java.awt.Dimension(400, 300));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        jPanel2.setBackground(new java.awt.Color(241, 248, 233));
        jPanel2.setAlignmentX(0.0F);
        jPanel2.setAlignmentY(0.0F);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Username:");

        btnLogin.setBackground(new java.awt.Color(241, 248, 233));
        btnLogin.setForeground(new java.awt.Color(0, 0, 0));
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(241, 248, 233));
        btnCancel.setForeground(new java.awt.Color(0, 0, 0));
        btnCancel.setText("Exit");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Password:");

        txtUsername.setBackground(new java.awt.Color(241, 248, 233));
        txtUsername.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(0, 0, 0));
        txtUsername.setText("Username");
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(51, 105, 30));

        title.setBackground(new java.awt.Color(0, 0, 0));
        title.setForeground(new java.awt.Color(241, 248, 233));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("g24 - Green Chat");

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\ChillaMag\\Documents\\4. semester - SWT\\Dist Systemer\\Chat System\\NetBeansProjekt\\g24_ChatSystem\\src\\img\\logo1.png")); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\ChillaMag\\Documents\\4. semester - SWT\\Dist Systemer\\Chat System\\NetBeansProjekt\\g24_ChatSystem\\src\\img\\logo1.png")); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(51, 105, 30));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        txtPassword.setBackground(new java.awt.Color(241, 248, 233));
        txtPassword.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(0, 0, 0));
        txtPassword.setText("Password");
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        txtErrorWindow.setBackground(new java.awt.Color(255, 0, 0));
        txtErrorWindow.setAlignmentX(0.0F);
        txtErrorWindow.setAlignmentY(0.0F);

        txtError.setForeground(new java.awt.Color(0, 0, 0));
        txtError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtError.setText("Cannot connect.. Try Again");

        javax.swing.GroupLayout txtErrorWindowLayout = new javax.swing.GroupLayout(txtErrorWindow);
        txtErrorWindow.setLayout(txtErrorWindowLayout);
        txtErrorWindowLayout.setHorizontalGroup(
            txtErrorWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtErrorWindowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        txtErrorWindowLayout.setVerticalGroup(
            txtErrorWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtErrorWindowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtError)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(117, 117, 117)
                            .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))))
                .addContainerGap(117, Short.MAX_VALUE))
            .addComponent(txtErrorWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtErrorWindow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancel)
                    .addComponent(btnLogin))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        username = txtUsername.getText();
        password = txtPassword.getText();
        enter();
        txtError.setText("");
        resetError();

        try{
            Brugeradmin ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");
            
            try{
                        Bruger b = ba.hentBruger(username, password);
                                
                        System.out.println("\nLogged in as: " + b.fornavn + " " + b.efternavn + ".\n");
                        //loggedIn = true;
                        Client.clientFirstName = b.fornavn;
                        Client.clientUsername = username;
                        lastName = b.efternavn;
                        Client.clientPassword = password;
                        
                        Thread clientStart = new Thread(new Client());
                        clientStart.start();
                        dispose();
                                  
                    }catch(IllegalArgumentException e){
                        System.out.println("\nWrong username or password..\n");
                        error(1);
                        reset();
                        try{
                            Thread.sleep(4000);
                            //resetError();
                        }catch(InterruptedException ie){}
                        
                        
                    }
            
        }catch(Exception e){
            error(2);
            reset();
            try{
                Thread.sleep(4000);
            }catch(InterruptedException ie){}
        }
        

        /*
        
        try{
            reset();
            sock = new Socket(address, port);
            InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamreader);
            writer = new PrintWriter(sock.getOutputStream());
            
            //Connect to Jacno Server for Username & Password
                
            try{
                writer.println(username + ":" + password + ":Login");
                writer.flush(); 
                   
            }catch(Exception ex){
            }
            
        }catch(Exception ex){
            error(2);
            txtErrorWindow.setVisible(true);

        }
        
        ListenThread();
        
        */
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        String nothingU = "Username";
        if ((txtUsername.getText()).equals(nothingU)) {
            txtUsername.setText("");
        }
    }//GEN-LAST:event_txtUsernameFocusGained

    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusLost
        String nothing = "";
        if ((txtUsername.getText()).equals(nothing)) {
            txtUsername.setText("Username");
        }
    }//GEN-LAST:event_txtUsernameFocusLost

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        String nothingP = "Password";
        if ((txtPassword.getText()).equals(nothingP)) {
            txtPassword.setText("");
        }
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        String nothing = "";
        if ((txtPassword.getText()).equals(nothing)) {
            txtPassword.setText("Password");
        }
    }//GEN-LAST:event_txtPasswordFocusLost

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        txtPassword.getRootPane().setDefaultButton(btnLogin);
    }//GEN-LAST:event_txtPasswordActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private static javax.swing.JButton btnLogin;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel title;
    public static javax.swing.JLabel txtError;
    public static javax.swing.JPanel txtErrorWindow;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
