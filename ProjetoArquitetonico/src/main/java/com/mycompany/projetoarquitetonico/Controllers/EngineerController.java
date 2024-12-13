/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.Controllers;

import com.mycompany.projetoarquitetonico.forms.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author lincoln
 */


public class EngineerController {
    private final frmEngineer view;

    public EngineerController(frmEngineer view) {
        this.view = view;

        // Adiciona os ActionListeners aos botões
        this.view.getBtnRegisterProject().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openProjectRegistration();
            }
        });

        this.view.getBtnRegisterClient().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openClientRegistration();
            }
        });

        this.view.getBtnRegisterTerrain().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openTerrainRegistration();
            }
        });

        this.view.getBtn3DView().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                open3DView();
            }
        });

        this.view.getBtnProjectHistory().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openProjectHistory();
            }
        });

        this.view.getBtnLogout().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });
    }

    private void openProjectRegistration() {
        frmProjectRegistration projectView = new frmProjectRegistration(view, true);
        projectView.setVisible(true);
    }

    private void openClientRegistration() {
        frmClientRegistration clientView = new frmClientRegistration(view, true);
        clientView.setVisible(true);
    }

    private void openTerrainRegistration() {
        frmTerrainRegistration terrainView = new frmTerrainRegistration(view, true);
        terrainView.setVisible(true);
    }

    private void open3DView() {
        frmProject3DView view3D = new frmProject3DView(view, true);
        view3D.setVisible(true);
    }

    private void openProjectHistory() {
        frmProjectHistory historyView = new frmProjectHistory(view, true);
        historyView.setVisible(true);
    }

    private void logout() {
        // Fecha a tela atual e volta para a tela de login (se existir)
        view.dispose();
        // Aqui podemos abrir a tela de login, se necessário:
        frmLogin loginView = new frmLogin();
        loginView.setVisible(true);
    }
}
