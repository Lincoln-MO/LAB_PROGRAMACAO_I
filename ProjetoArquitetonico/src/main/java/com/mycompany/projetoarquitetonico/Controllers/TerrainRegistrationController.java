/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.Controllers;

import com.mycompany.projetoarquitetonico.forms.frmTerrainRegistration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author lincoln
 */
public class TerrainRegistrationController {
    private frmTerrainRegistration view;

    public TerrainRegistrationController(frmTerrainRegistration view) {
        this.view = view;
        addListeners();
    }

    private void addListeners() {
        view.getBtnRegister().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerTerrain();
            }
        });
        
        view.getBtnClose().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeForm();
            }
        });
    }

    private void registerTerrain() {
        // Lógica para cadastrar o terreno
        String terrainName = view.getTxtTerrainName().getText();
        String ownerCPF = view.getTxtOwnerCPF().getText();
        String terrainArea = view.getTxtTerrainArea().getText();
        String terrainLocation = view.getTxtTerrainLocation().getText();
        
        // Aqui depois vamos adicionar validações e persistência de dados, 
        // como verificar se os campos não estão vazios e se o CPF é válido.
        
        if (terrainName.isEmpty() || ownerCPF.isEmpty() || terrainArea.isEmpty() || terrainLocation.isEmpty()) {
            // Exibe uma mensagem de erro se algum campo estiver vazio
            System.out.println("Por favor, preencha todos os campos.");
        } else {
            // Aqui vamos fazer a persistência (salvar no banco de dados, por exemplo).
            // Por enquanto, apenas exibimos uma mensagem de sucesso.
            System.out.println("Terreno cadastrado com sucesso!");
            // Fechar a janela após o cadastro
            view.dispose();
        }
    }

    private void closeForm() {
        // Fechar o formulário sem realizar nenhuma ação
        view.dispose();
    }
}
