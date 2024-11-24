/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.services;

/**
 *
 * @author linco
 */

import com.mycompany.projetoarquitetonico.models.Client;

public class ClientService {
    public void save(Client client) {
        // adicionaremos posteriormente a Lógica para salvar cliente no banco de dados
        System.out.println("Cliente salvo: " + client.getName());
    }
}

