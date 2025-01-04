package com.mycompany.projetoarquitetonico.forms;


import com.mycompany.projetoarquitetonico.Controllers.ClientRegistrationController;
import com.mycompany.projetoarquitetonico.utils.BlinkText;
import com.mycompany.projetoarquitetonico.utils.TextMasks;


/**
 *
 * @author yurit
 */
public class frmClientRegistration extends javax.swing.JDialog {
    ClientRegistrationController controller;
    
    
    public frmClientRegistration(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        controller = new ClientRegistrationController(this);
        lblErrorMessage.setVisible( false );
        TextMasks.installCPFMask( txtCPF );
        TextMasks.installDateMask( txtBirthDate );
    }
    
    
    public void showError(String message, String errorType){
        lblErrorMessage.setText(message);
        lblErrorMessage.setVisible(true);
        BlinkText.blinkLabelRed(lblErrorMessage, 3);
        
        switch( errorType ){
            case "name" -> BlinkText.blinkTextFieldRed(txtName, 3);
            case "startDate" -> BlinkText.blinkTextFieldRed(txtCPF, 3);
            case "birthDate" -> BlinkText.blinkTextFieldRed(txtBirthDate, 3);
            case "password" -> BlinkText.blinkTextFieldRed(txtPassword, 3);
            case "sex" -> {}
            case "" -> {}
            default -> System.out.println("Unknown error type: " + errorType);
        }
    }
    
    
    public void clearForm(){
        txtName.setText("");
        txtCPF.setText("");
        txtBirthDate.setText("");
        txtPassword.setText("");
        radioFeminine.setSelected(false);
        radioMasculine.setSelected(false);
        hideErrorMessage();
    }
    
    public void hideErrorMessage(){
        lblErrorMessage.setVisible(false);
    }
    
    
    public String getNameText(){
        return txtName.getText();
    }
    
    
    public String getCPFText(){
        return txtCPF.getText();
    }
    
    
    public String getBirthDateText(){
        return txtBirthDate.getText();
    }
    
    
    public String getPasswordText(){
        return txtPassword.getText();
    }
    
    
    public boolean isMasculineSelected(){
        return radioMasculine.isSelected();
    }
    
    
    public boolean isFeminineSelected(){
        return radioFeminine.isSelected();
    }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sexButtonGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        radioMasculine = new javax.swing.JRadioButton();
        radioFeminine = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblErrorMessage = new javax.swing.JLabel();
        txtCPF = new javax.swing.JFormattedTextField();
        txtBirthDate = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome");

        btnSubmit.setText("Cadastrar");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jLabel2.setText("CPF");

        jLabel3.setText("Data de nascimento");

        jLabel4.setText("Sexo");

        sexButtonGroup.add(radioMasculine);
        radioMasculine.setText("Masculino");
        radioMasculine.setName(""); // NOI18N
        radioMasculine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMasculineActionPerformed(evt);
            }
        });

        sexButtonGroup.add(radioFeminine);
        radioFeminine.setText("Feminino");
        radioFeminine.setName(""); // NOI18N
        radioFeminine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFeminineActionPerformed(evt);
            }
        });

        jLabel5.setText("Senha");

        lblErrorMessage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErrorMessage.setText("ERROR_MESSAGE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSubmit))
                    .addComponent(txtName)
                    .addComponent(lblErrorMessage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtBirthDate, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                    .addComponent(txtCPF))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(radioMasculine)
                                    .addComponent(radioFeminine))))
                        .addGap(0, 131, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioMasculine)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioFeminine)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(lblErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSubmit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    
    
    
    private void radioMasculineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMasculineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioMasculineActionPerformed

    
    private void radioFeminineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFeminineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioFeminineActionPerformed

    
    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        controller.handleSubmit();
    }//GEN-LAST:event_btnSubmitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblErrorMessage;
    private javax.swing.JRadioButton radioFeminine;
    private javax.swing.JRadioButton radioMasculine;
    private javax.swing.ButtonGroup sexButtonGroup;
    private javax.swing.JFormattedTextField txtBirthDate;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
