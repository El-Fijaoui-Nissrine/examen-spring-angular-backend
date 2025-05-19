package com.example.examen.services;

import com.example.examen.dtos.ClientDTO;
import com.example.examen.dtos.CreditDTO;
import com.example.examen.dtos.RemboursementDTO;
import com.example.examen.entities.*;
import com.example.examen.mappers.CreditMapperImpl;
import com.example.examen.repositories.ClientRepository;
import com.example.examen.repositories.CreditRepository;
import com.example.examen.repositories.RemboursementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CreditServiceImpl implements  CreditService{
    private ClientRepository clientRepository;
    private CreditRepository creditRepository;
    private RemboursementRepository remboursementRepository;
    private CreditMapperImpl creditMapper;


    @Override
    public List<ClientDTO> getAllClients() {
        List<Client> clientList= clientRepository.findAll();
        List<ClientDTO> clientDTO=clientList.stream()
                .map(c -> creditMapper.fromClient(c))
                .collect(Collectors.toList());
        return clientDTO;
    }

    @Override
    public ClientDTO getClientById(Long id) {
        Client client =clientRepository.findById(id).orElse(null);
        return creditMapper.fromClient(client);
    }

    @Override
    public ClientDTO saveClient(ClientDTO dto) {
        Client client=creditMapper.fromClientDTO(dto);
        Client saveClient=clientRepository.save(client);
        return  creditMapper.fromClient(saveClient) ;
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<CreditDTO> getCreditsByClient(Long clientId) {
        List<Credit> credits=creditRepository.findAll();
        List<CreditDTO> creditDTOS= credits.stream().map(cred -> {
            if (cred instanceof CreditImmobilier){
                CreditImmobilier creditImmobilier=(CreditImmobilier) cred;
                return creditMapper.fromCreditImmobilier(creditImmobilier);
            }else if (cred instanceof CreditPersonnel) {
                CreditPersonnel creditPersonnel=(CreditPersonnel) cred;
                return creditMapper.fromCreditPersonnel(creditPersonnel);
            }else {
                CreditProffessionnel creditPfes=(CreditProffessionnel) cred;
                return creditMapper.fromCreditProffessionnel(creditPfes);


            }
        }).collect(Collectors.toList());
        return creditDTOS;
    }



    @Override
    public List<RemboursementDTO> getRemboursementsByCredit(Long creditId) {
        List<Remboursement>  remboursements=remboursementRepository.findByCreditId(creditId);
        List<RemboursementDTO> remboursementDTOS=remboursements.stream().map(rem ->
                creditMapper.fromARemboursement(rem)).collect(Collectors.toList());
        return  remboursementDTOS;
    }

}
