package com.mycompany.projetoarquitetonico.forms;


import com.mycompany.projetoarquitetonico.Controllers.ProjectRegistrationController;
import com.mycompany.projetoarquitetonico.utils.BlinkText;
import com.mycompany.projetoarquitetonico.utils.TextMasks;
import javax.swing.table.DefaultTableModel;



public final class frmProjectRegistration extends javax.swing.JDialog {
    private final ProjectRegistrationController controller; 
    private final DefaultTableModel tableModel;
    
    
    public frmProjectRegistration(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        TextMasks.installDateMask( txtStartDate );
        
        controller = new ProjectRegistrationController(this);
        tableModel = (DefaultTableModel) tblExpenses.getModel();
        
        lblErrorMessage.setVisible( false );
        clearTable();
        setRegisterMode();
    }

    
    public void showError(String message, String errorType){
        lblErrorMessage.setText(message);
        lblErrorMessage.setVisible(true);
        BlinkText.blinkLabelRed(lblErrorMessage, 3);
        
        switch( errorType ){
            case "name" -> BlinkText.blinkTextFieldRed(txtProjectName, 3);
            case "date" -> BlinkText.blinkTextFieldRed(txtStartDate, 3);
            case "responsible" -> BlinkText.blinkTextFieldRed(txtResponsible, 3);
            case "terrain" -> BlinkText.blinkTextFieldRed(txtTerrain, 3);
            case "" -> {}
            default -> System.out.println("Unknown error type: " + errorType);
        }
    }
    
    
    public void hideErrorMessage(){
        lblErrorMessage.setVisible(false);
    }
    

    public void clearForm(){
        txtProjectName.setText("");
        txtStartDate.setText("");
        txtResponsible.setText("");
        txtTerrain.setText("");
        txt3DModelFile.setText("");
        clearTable();
        hideErrorMessage();
    }
    
    
    public void setEditMode(){
        btnRegister.setText("Salvar alterações");
    }
    
    
    public void setRegisterMode(){
        btnRegister.setText("Cadastrar");
    }
    
    
    public ProjectRegistrationController getController(){
        return this.controller;
    }
    
    
    public void setProjectName(String name){
        txtProjectName.setText(name);
    }
    
    
    public void setStartDate(String startDate){
        txtStartDate.setText(startDate);
    }
    
    
    public void setResponsibleCPF(String cpf){
        txtResponsible.setText(cpf);
    }
    
    
    public void setTerrainName(String name){
        txtTerrain.setText(name);
    }
    
    
    public void setFileName(String name){
        txt3DModelFile.setText(name);
    }
    
    
    public void setExpenseTable(String tableString){
        // add rows in the table
        for( String row : tableString.split("\n") ){
            String[] args = row.split("\t");
            String name         = args[0];
            float quantity      = Float.parseFloat(args[1]);
            float price         = Float.parseFloat(args[2]);
            String description  = args[3];
            addTableRow(name, quantity, price, description);
        }
    }
    
    
    public void clearTable(){
        while( tblExpenses.getRowCount() > 0 ){
            tableModel.removeRow(0);
        }
    }
    
    
    public void addTableRow(String name, float quantity, float price, String description){
        tableModel.addRow(new Object[]{name, quantity, price, description});
    }

    
    public void addTableRow(){
        tableModel.addRow(new Object[]{});
    }
    
    
    public String getNameText(){
        return txtProjectName.getText();
    }
    
    
    public String getStartDateText(){
        return txtStartDate.getText();
    }
    
    
    public String getTableString(){
        int width = tableModel.getColumnCount();
        int height = tableModel.getRowCount();
        String tableString = "";
        
        for(int h = 0; h < height; h++){
            for(int w = 0; w < width; w++){
                tableString += tableModel.getValueAt(h, w);
                if( h < height){
                    tableString += "\t";
                }
            }
            tableString += "\n";
        }
        
        System.out.println(tableString);
        return tableString;
    }
    
    
    public void removeSelectedRows(){
        int selectedRowCount = tblExpenses.getSelectedRowCount();
        for(int i = 0; i < selectedRowCount; i++){
            tableModel.removeRow( tblExpenses.getSelectedRow() );
        }
    }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtProjectName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        txtResponsible = new javax.swing.JTextField();
        txtTerrain = new javax.swing.JTextField();
        btnResponsibleFind = new javax.swing.JButton();
        btnTerrainFind = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExpenses = new javax.swing.JTable();
        btnAddRow = new javax.swing.JButton();
        btnRemoveRow = new javax.swing.JButton();
        lblErrorMessage = new javax.swing.JLabel();
        btn3DModelFind = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt3DModelFile = new javax.swing.JTextField();
        txtStartDate = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome do projeto");

        txtProjectName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProjectNameActionPerformed(evt);
            }
        });

        jLabel2.setText("Data de início");

        jLabel3.setText("Responsável (CPF)");

        jLabel4.setText("Terreno");

        btnRegister.setText("Cadastrar");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        txtResponsible.setEditable(false);

        txtTerrain.setEditable(false);

        btnResponsibleFind.setText("Procurar");
        btnResponsibleFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResponsibleFindActionPerformed(evt);
            }
        });

        btnTerrainFind.setText("Procurar");
        btnTerrainFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerrainFindActionPerformed(evt);
            }
        });

        jLabel5.setText("Gastos");

        tblExpenses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Quantidade", "Preço", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblExpenses);

        btnAddRow.setText("[+] Adicionar linha");
        btnAddRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRowActionPerformed(evt);
            }
        });

        btnRemoveRow.setText("[-] Remover linhas selecionadas");
        btnRemoveRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveRowActionPerformed(evt);
            }
        });

        lblErrorMessage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErrorMessage.setText("ERROR_MESSAGE");

        btn3DModelFind.setText("Procurar");
        btn3DModelFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3DModelFindActionPerformed(evt);
            }
        });

        jLabel6.setText("Modelo 3D");

        txt3DModelFile.setEditable(false);
        txt3DModelFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt3DModelFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblErrorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txt3DModelFile))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn3DModelFind))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegister, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnRemoveRow)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddRow))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtStartDate, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProjectName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTerrain, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtResponsible))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnResponsibleFind)
                            .addComponent(btnTerrainFind))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtResponsible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResponsibleFind))
                .addGap(11, 11, 11)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTerrain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTerrainFind))
                .addGap(10, 10, 10)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt3DModelFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3DModelFind))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRemoveRow)
                    .addComponent(btnAddRow))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnRegister)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void txtProjectNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProjectNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProjectNameActionPerformed

    
    
    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        controller.handleSubmit();
    }//GEN-LAST:event_btnRegisterActionPerformed

    
    private void btnResponsibleFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResponsibleFindActionPerformed
        controller.handleResponsibleFind();
    }//GEN-LAST:event_btnResponsibleFindActionPerformed

    
    private void btnTerrainFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerrainFindActionPerformed
        controller.handleTerrainFind();
    }//GEN-LAST:event_btnTerrainFindActionPerformed
   
    
    private void btnAddRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRowActionPerformed
        addTableRow();
    }//GEN-LAST:event_btnAddRowActionPerformed

    
    private void btnRemoveRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveRowActionPerformed
        removeSelectedRows();
    }//GEN-LAST:event_btnRemoveRowActionPerformed

    private void btn3DModelFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3DModelFindActionPerformed
        controller.handle3DModelFind();
    }//GEN-LAST:event_btn3DModelFindActionPerformed

    private void txt3DModelFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt3DModelFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt3DModelFileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn3DModelFind;
    private javax.swing.JButton btnAddRow;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnRemoveRow;
    private javax.swing.JButton btnResponsibleFind;
    private javax.swing.JButton btnTerrainFind;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblErrorMessage;
    private javax.swing.JTable tblExpenses;
    private javax.swing.JTextField txt3DModelFile;
    private javax.swing.JTextField txtProjectName;
    private javax.swing.JTextField txtResponsible;
    private javax.swing.JFormattedTextField txtStartDate;
    private javax.swing.JTextField txtTerrain;
    // End of variables declaration//GEN-END:variables
}
