/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp1;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Random;

/**
 *
 * @author parth
 */
public class ForgetPassword extends javax.swing.JFrame {
    public static String strFP;
    
   static boolean OTP_flag=false;
    public void SendOTP(String user){
        int otp;
        String User= user;
        Random ran = new Random();
        otp=ran.nextInt(1000000000);
        ForgetPassword f=new ForgetPassword();
        Scanner sc = new Scanner(System.in);
		final String username = "vectorparker0047@gmail.com"; // enter your mail id
                System.out.print("Enter Admin Password : ");
                String pwd=sc.nextLine();
		final String password = pwd;// enter ur password

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
                props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
                props.put("mail.smtp.ssl.trust", "*");



		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
                        @Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("vectorparker0047@gmail.com")); // same email id
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(User));// whome u have to send mails that person id
			message.setSubject("MTBS");
			message.setText("Dear User,"
				+ "\n\n OTP is : " +otp+ " !!!");
                        System.out.println("Otp : "+otp);
                        
			Transport.send(message);

			String res= JOptionPane.showInputDialog(f,"Email has been sent.\nEnter OTP....");
                        int i=Integer.parseInt(res);
                        /*SubmitFPEmail.setVisible(false);
                        FPLOtp.setVisible(true);
                        FPOtp.setVisible(true);
                        SubmitFPOtp.setVisible(true);*/
                       if(i==otp){
                           System.out.println("Done man!! \n"+strFP);
                           NewPass n= new NewPass();
                            n.setVisible(true);
                       }
                       else{
                           System.out.println("Wrong OTP!!!!");
                       }

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
        
    }

    /**
     * Creates new form ForgetPassword
     */
    public ForgetPassword() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        FPLEmail = new javax.swing.JLabel();
        SubmitFPEmail = new javax.swing.JButton();
        FPEmail = new javax.swing.JTextField();
        BackToL = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Forget Password");

        FPLEmail.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        FPLEmail.setForeground(new java.awt.Color(0, 102, 102));
        FPLEmail.setText("Enter recovery E-mail : ");

        SubmitFPEmail.setBackground(new java.awt.Color(0, 255, 0));
        SubmitFPEmail.setText("Submit");
        SubmitFPEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitFPEmailActionPerformed(evt);
            }
        });

        FPEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FPEmailActionPerformed(evt);
            }
        });
        FPEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FPEmailKeyPressed(evt);
            }
        });

        BackToL.setBackground(new java.awt.Color(255, 51, 51));
        BackToL.setText("Back");
        BackToL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToLActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mp1/images/Kiticket.png"))); // NOI18N
        jLabel4.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackToL)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SubmitFPEmail)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(FPLEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FPEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackToL)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FPLEmail)
                    .addComponent(FPEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(SubmitFPEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("Forget Password");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitFPEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitFPEmailActionPerformed
        // TODO add your handling code here:
        
       /* String tstr1=""; 
        try{
            FileWriter fwFP= new FileWriter("Data.txt",true);
            int i=0;
            while(i != strFP.length()){
                fwFP.write(strFP.charAt(i));
                i++;
        }
            fwFP.write("\r\n");
            FileReader frFP= new FileReader("Data.txt");
            BufferedReader brFP=new BufferedReader(frFP);
                    int count1=0;
                    while((i=frFP.read())!= -1){
                        tstr1+=(char)i;
                        i++;
                    }
                    String temp1="";
                    int location=0;
                    String str1[]=tstr1.split(" ",0);
                    String newPass;
                    for(i=0;i<str1.length;i+=2){
                            temp1=str1[i].trim();
                            location+=str1[i].length();
                            if(temp1.equals(strFP)){
                                System.out.print("Valid Username\nEnter new Password : ");
                                Scanner sc=new Scanner(System.in);
                                newPass=sc.nextLine();
                                int newLocation=location+newPass.length();
                                String str2=brFP.readLine();
                                String update=str2.substring(0,location)+newPass+str2.substring(newLocation);
                                fwFP.write(update);
                            }
                            else
                                count1++;
                    }
                    if(count1==(str1.length/2)+1)
                        System.out.println("User doesn't exist");
            brFP.close();
            frFP.close();
            fwFP.close();
            ForgetPassword fp=new ForgetPassword();
            fp.setVisible(false);
        }catch(Exception e){
                
        }*/
       strFP= FPEmail.getText();
       String host = "jdbc:derby://localhost:1527/Users";
String uName = "username";
String uPass= "password";
    int flag = 0;
    
    ForgetPassword f = new ForgetPassword();
     try {
            Connection con;
      con = DriverManager.getConnection( host,uName,uPass);
      Statement stmt = con.createStatement();
      String SQL = "SELECT * FROM Data";
      ResultSet rs=stmt.executeQuery(SQL);
      while(rs.next())
      {
      String user=rs.getString("Contact");
      if(strFP.equals(user)){
          flag=1;
          SendOTP(user);
         //JOptionPane.showMessageDialog(f,"Email has been sent....");
         //dispose();
         OTP_flag=true;
         break;
     }
      else if(strFP.equals("")){
          flag=1;
          JOptionPane.showMessageDialog(f,"Please fill the field....");
          break;
      }
    
    }//GEN-LAST:event_SubmitFPEmailActionPerformed
      if(flag==0){
         JOptionPane.showMessageDialog(f,"Email is not registered!!!");
     }
     }catch(Exception e){}
    }
    
    private void FPEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FPEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FPEmailActionPerformed

    private void BackToLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToLActionPerformed
        // TODO add your handling code here:
        dispose();
        //new Login().setVisible(true);
    }//GEN-LAST:event_BackToLActionPerformed

    private void FPEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FPEmailKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
             java.awt.event.ActionEvent e = null;
             SubmitFPEmailActionPerformed(e);
         }
    }//GEN-LAST:event_FPEmailKeyPressed

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
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                ForgetPassword fp= new ForgetPassword();
                fp.setVisible(true);
                fp.setResizable(false);
                fp.setSize(new Dimension(517,454));
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackToL;
    public javax.swing.JTextField FPEmail;
    private javax.swing.JLabel FPLEmail;
    private javax.swing.JButton SubmitFPEmail;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
