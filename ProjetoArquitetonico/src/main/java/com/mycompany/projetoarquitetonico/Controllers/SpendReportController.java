/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.Controllers;

import com.mycompany.projetoarquitetonico.forms.frmSpendReport;
import javax.swing.JOptionPane;

/**
 *
 * @author lincoln
 */
public class SpendReportController {
    private final frmSpendReport spendReportView;

    public SpendReportController(frmSpendReport spendReportView) {
        this.spendReportView = spendReportView;
        initializeActions();
    }

    // Inicializa os listeners da interface
    private void initializeActions() {
        spendReportView.getBtnSave().addActionListener(e -> handleSave());
        spendReportView.getBtnClose().addActionListener(e -> handleClose());
        spendReportView.getComboTerrain().addActionListener(e -> handleTerrainSelection());
    }

    // Lida com a ação de salvar
    public void handleSave() {
        // Lógica para salvar os gastos do terreno
        String selectedTerrain = spendReportView.getComboTerrain().getSelectedItem().toString();
        String spendDetails = spendReportView.getTxtSpend().getText();
        String totalAmount = spendReportView.getTxtTotal().getText();

        // Aqui, sera implementado a lógica para salvar ou atualizar os dados (como gravar no banco ou em um arquivo)
        
        
        JOptionPane.showMessageDialog(spendReportView, "Gastos salvos com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        
        spendReportView.dispose();  // Fecha a janela após salvar
    }

    // Lida com a ação de fechar
    public void handleClose() {
        spendReportView.dispose();  // Fecha a janela sem salvar
    }

    // Lida com a seleção do terreno no combo
    public void handleTerrainSelection() {
        String selectedTerrain = spendReportView.getComboTerrain().getSelectedItem().toString();
        // Aqui podemos adicionar a lógica para lidar com a seleção do terreno, como calcular valores
        // ou atualizar outros campos dependendo do terreno selecionado.
    }  
}
