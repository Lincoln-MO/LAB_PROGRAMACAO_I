/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projetoarquitetonico.forms;

import com.mycompany.projetoarquitetonico.Controllers.ClientController;
import com.mycompany.projetoarquitetonico.Controllers.LoginController;

/**
 *
 * @author yurit e lincoln
 */
public class frmClient extends javax.swing.JFrame {
    private ClientController controller;
    
    public frmClient() {
        initComponents();
        controller = new ClientController(this);
    }
    
    
    public javax.swing.JLabel getTxtLoginName() {
        return txtLoginName;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSendFeedback = new javax.swing.JButton();
        btn3DView = new javax.swing.JButton();
        txtLoginName = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        btnProjects = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSendFeedback.setText("Enviar feedback");
        btnSendFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendFeedbackActionPerformed(evt);
            }
        });

        btn3DView.setText("Visualização 3D");
        btn3DView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3DViewActionPerformed(evt);
            }
        });

        txtLoginName.setText("Logado como: XXX.XXX.XXX-XX");

        btnLogout.setText("Sair");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnProjects.setText("Histórico de projetos");
        btnProjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProjectsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtLoginName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogout))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSendFeedback, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn3DView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnProjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnSendFeedback)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn3DView)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProjects)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogout)
                    .addComponent(txtLoginName))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnSendFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendFeedbackActionPerformed
        controller.openFeedbackForm();
    }//GEN-LAST:event_btnSendFeedbackActionPerformed

    
    private void btn3DViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3DViewActionPerformed
        controller.open3DViewForm();
    }//GEN-LAST:event_btn3DViewActionPerformed

    
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        controller.logout();
    }//GEN-LAST:event_btnLogoutActionPerformed

    
    private void btnProjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProjectsActionPerformed
        controller.openProjectHistoryForm();
    }//GEN-LAST:event_btnProjectsActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn3DView;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnProjects;
    private javax.swing.JButton btnSendFeedback;
    private javax.swing.JLabel txtLoginName;
    // End of variables declaration//GEN-END:variables
}
