/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.Controllers;

import com.mycompany.projetoarquitetonico.forms.frmClientRegistration;
import com.mycompany.projetoarquitetonico.models.Client;
import com.mycompany.projetoarquitetonico.services.ClientService;
import javax.swing.JOptionPane;

/**
 *
 * @author lincoln
 */


public class ClientRegistrationController {
    private final frmClientRegistration view;
    private final ClientService clientService;

    public ClientRegistrationController(frmClientRegistration view) {
        this.view = view;
        this.clientService = new ClientService();
        initController();
    }

    private void initController() {
        view.getBtnSubmit().addActionListener(e -> registerClient());
    }

    private void registerClient() {
        try {
            String name = view.getTxtName().getText();
            String cpf = view.getTxtCPF().getText();
            String birthDate = view.getTxtBirthDate().getText();
            String sex = view.getSexButtonGroup().getSelection().getActionCommand();

            if (name.isEmpty() || cpf.isEmpty() || birthDate.isEmpty() || sex == null) {
                JOptionPane.showMessageDialog(view, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Client client = new Client(name, cpf, birthDate, sex);
            clientService.save(client);

            JOptionPane.showMessageDialog(view, "Cliente cadastrado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            clearForm();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erro ao cadastrar cliente: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        view.getTxtName().setText("");
        view.getTxtCPF().setText("");
        view.getTxtBirthDate().setText("");
        view.getSexButtonGroup().clearSelection();
    }
}
