package com.example.examen.services;

import com.example.examen.dtos.ClientDTO;
import com.example.examen.dtos.CreditDTO;
import com.example.examen.dtos.RemboursementDTO;

import java.util.List;

public interface CreditService {
    List<ClientDTO> getAllClients();
    ClientDTO getClientById(Long id);
    ClientDTO saveClient(ClientDTO dto);
    void deleteClient(Long id);
    List<CreditDTO> getCreditsByClient(Long clientId);
    List<RemboursementDTO> getRemboursementsByCredit(Long creditId);
}
