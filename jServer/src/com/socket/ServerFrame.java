package com.socket;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

public class ServerFrame extends javax.swing.JFrame {

    public SocketServer server;
    public Thread serverThread;
    public String filePath = "C:\\Users\\shreejal\\Downloads\\Article_sr\\Data.xml";
    public JFileChooser fileChooser;
    
    public ServerFrame() {
        initComponents();
        tf_FilePath.setEditable(false);
        tf_FilePath.setBackground(Color.WHITE);
        
        fileChooser = new JFileChooser();
        ta_Server.setEditable(false);
    }
    
    public boolean isWin32(){
        return System.getProperty("os.name").startsWith("Windows");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b_StartServer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_Server = new javax.swing.JTextArea();
        lb_DBFile = new javax.swing.JLabel();
        tf_FilePath = new javax.swing.JTextField();
        b_BrowseDataFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("jServer");

        b_StartServer.setText("Start Server");
        b_StartServer.setEnabled(false);
        b_StartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_StartServerActionPerformed(evt);
            }
        });

        ta_Server.setColumns(20);
        ta_Server.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        ta_Server.setRows(5);
        jScrollPane1.setViewportView(ta_Server);

        lb_DBFile.setText("Database File : ");

        b_BrowseDataFile.setText("Browse...");
        b_BrowseDataFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_BrowseDataFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lb_DBFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_FilePath, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_BrowseDataFile, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_StartServer)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_FilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_DBFile)
                    .addComponent(b_BrowseDataFile)
                    .addComponent(b_StartServer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                .addContainerGap())
        );

        b_StartServer.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_StartServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_StartServerActionPerformed
        server = new SocketServer(this);
        b_StartServer.setEnabled(false); b_BrowseDataFile.setEnabled(false);
    }//GEN-LAST:event_b_StartServerActionPerformed

    public void RetryStart(int port){
        if(server != null){ server.stop(); }
        server = new SocketServer(this, port);
    }
    
    private void b_BrowseDataFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_BrowseDataFileActionPerformed
        fileChooser.showDialog(this, "Select");
        File file = fileChooser.getSelectedFile();
        
        if(file != null){
            filePath = file.getPath();
            if(this.isWin32()){ filePath = filePath.replace("\\", "/"); }
            tf_FilePath.setText(filePath);
            b_StartServer.setEnabled(true);
        }
    }//GEN-LAST:event_b_BrowseDataFileActionPerformed

    public static void main(String args[]) {

        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception ex){
            System.out.println("Look & Feel Exception");
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_BrowseDataFile;
    private javax.swing.JButton b_StartServer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_DBFile;
    public javax.swing.JTextArea ta_Server;
    private javax.swing.JTextField tf_FilePath;
    // End of variables declaration//GEN-END:variables
}
