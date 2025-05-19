package com.example.examen.mappers;

import com.example.examen.dtos.*;
import com.example.examen.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CreditMapperImpl {
    public ClientDTO fromClient(Client client){
        ClientDTO clientDTO=new ClientDTO();
        BeanUtils.copyProperties(client,clientDTO);
        return clientDTO;
    }
    public Client fromClientDTO(ClientDTO ClientDTO){
        Client client=new Client();
        BeanUtils.copyProperties(ClientDTO,client);
        return client;
    }
    public CreditImmobilierDTO fromCreditImmobilier(CreditImmobilier creditImmobilier){
        CreditImmobilierDTO creditImmobilierDTO=new CreditImmobilierDTO();
        BeanUtils.copyProperties(creditImmobilier,creditImmobilierDTO);
        creditImmobilierDTO.setClientDTO(fromClient(creditImmobilier.getClient()));
        creditImmobilierDTO.setType(creditImmobilier.getClass().getSimpleName());
        return creditImmobilierDTO;

    }
    public CreditImmobilier fromCreditImmobilierDTO(CreditImmobilierDTO creditImmobilierDTO){
        CreditImmobilier creditImmobilier=new CreditImmobilier();
        BeanUtils.copyProperties(creditImmobilierDTO,creditImmobilier);
        creditImmobilier.setClient(fromClientDTO(creditImmobilierDTO.getClientDTO()));
        return creditImmobilier;
    }

    public CreditProffessionnel fromCreditImmobilierDTO(CreditProffessionnelDTO creditProffessionnelDTO){
        CreditProffessionnel creditProffessionnel=new CreditProffessionnel();
        BeanUtils.copyProperties(creditProffessionnelDTO,creditProffessionnel);
        creditProffessionnel.setClient(fromClientDTO(creditProffessionnelDTO.getClientDTO()));
        return creditProffessionnel;
    }

    public CreditProffessionnelDTO fromCreditProffessionnel(CreditProffessionnel creditProffessionnel){
        CreditProffessionnelDTO creditProffessionnelDTO=new CreditProffessionnelDTO();
        BeanUtils.copyProperties(creditProffessionnel,creditProffessionnelDTO);
        creditProffessionnelDTO.setClientDTO(fromClient(creditProffessionnel.getClient()));
        creditProffessionnelDTO.setType(creditProffessionnel.getClass().getSimpleName());
        return creditProffessionnelDTO;

    }
    public CreditPersonnel fromCreditPersonnelDTO(CreditPersonnelDTO creditPersonnelDTO){
        CreditPersonnel creditPersonnel=new CreditPersonnel();
        BeanUtils.copyProperties(creditPersonnelDTO,creditPersonnel);
        creditPersonnel.setClient(fromClientDTO(creditPersonnelDTO.getClientDTO()));
        return creditPersonnel;
    }

    public CreditPersonnelDTO fromCreditPersonnel(CreditPersonnel creditPersonnel){
        CreditPersonnelDTO creditPersonnelDTO=new CreditPersonnelDTO();
        BeanUtils.copyProperties(creditPersonnel,creditPersonnelDTO);
        creditPersonnelDTO.setClientDTO(fromClient(creditPersonnel.getClient()));
        creditPersonnelDTO.setType(creditPersonnel.getClass().getSimpleName());
        return creditPersonnelDTO;

    }


    public RemboursementDTO fromARemboursement(Remboursement remboursement){
        RemboursementDTO remboursementDTO=new RemboursementDTO();
        BeanUtils.copyProperties(remboursement,remboursementDTO);
        return  remboursementDTO;
    }
}
