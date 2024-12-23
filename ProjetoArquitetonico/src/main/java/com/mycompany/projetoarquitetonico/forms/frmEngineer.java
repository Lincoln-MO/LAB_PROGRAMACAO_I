/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projetoarquitetonico.forms;

import com.mycompany.projetoarquitetonico.Controllers.EngineerController;

/**
 *
 * @author yurit e lincoln
 */


public class frmEngineer extends javax.swing.JFrame {

    /**
     * Creates new form frmEngineer
     */
    public frmEngineer(java.awt.Frame parent, boolean modal) {
        initComponents();
        
    }
    public javax.swing.JButton getBtnRegisterProject() {
        return btnRegisterProject;
    }

    public javax.swing.JButton getBtnRegisterClient() {
        return btnRegisterClient;
    }

    public javax.swing.JButton getBtnRegisterTerrain() {
        return btnRegisterTerrain;
    }

    public javax.swing.JButton getBtn3DView() {
        return btn3DView;
    }

    public javax.swing.JButton getBtnProjectHistory() {
        return btnProjectHistory;
    }

    public javax.swing.JButton getBtnLogout() {
        return btnLogout;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegisterProject = new javax.swing.JButton();
        btnRegisterClient = new javax.swing.JButton();
        btnRegisterTerrain = new javax.swing.JButton();
        btn3DView = new javax.swing.JButton();
        btnProjectHistory = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        txtLoginName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRegisterProject.setText("Cadastro de projetos");
        btnRegisterProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterProjectActionPerformed(evt);
            }
        });

        btnRegisterClient.setText("Cadastro de clientes");
        btnRegisterClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterClientActionPerformed(evt);
            }
        });

        btnRegisterTerrain.setText("Cadastro de terrenos");
        btnRegisterTerrain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterTerrainActionPerformed(evt);
            }
        });

        btn3DView.setText("Visualização 3D");
        btn3DView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3DViewActionPerformed(evt);
            }
        });

        btnProjectHistory.setText("Histórico de projetos");
        btnProjectHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProjectHistoryActionPerformed(evt);
            }
        });

        btnLogout.setText("Sair");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        txtLoginName.setText("Logado como: XXX.XXX.XXX-XX");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnProjectHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn3DView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegisterTerrain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegisterClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegisterProject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtLoginName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogout)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegisterProject)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegisterClient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegisterTerrain)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn3DView)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProjectHistory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogout)
                    .addComponent(txtLoginName))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProjectHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProjectHistoryActionPerformed
        frmProjectHistory form = new frmProjectHistory(this, true);
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnProjectHistoryActionPerformed

    private void btn3DViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3DViewActionPerformed
        frmProject3DView form = new frmProject3DView(this, true);
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn3DViewActionPerformed

    private void btnRegisterTerrainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterTerrainActionPerformed
        frmTerrainRegistration form = new frmTerrainRegistration(this, true);
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegisterTerrainActionPerformed

    private void btnRegisterClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterClientActionPerformed
        frmClientRegistration form = new frmClientRegistration(this, true);
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegisterClientActionPerformed

    private void btnRegisterProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterProjectActionPerformed
        frmProjectRegistration form = new frmProjectRegistration(this, true);
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegisterProjectActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn3DView;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnProjectHistory;
    private javax.swing.JButton btnRegisterClient;
    private javax.swing.JButton btnRegisterProject;
    private javax.swing.JButton btnRegisterTerrain;
    private javax.swing.JLabel txtLoginName;
    // End of variables declaration//GEN-END:variables
}
