package com.example.examen.web;

import com.example.examen.dtos.ClientDTO;
import com.example.examen.services.CreditService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin( "*")
@RestController
@AllArgsConstructor
public class ClientRestController {
    private CreditService creditService;
    @GetMapping("/clients")

    public List<ClientDTO> clients(){
        return creditService.getAllClients();
    }

    @GetMapping("/customers/{id}")

    public ClientDTO getClient( @PathVariable(name = "id") Long Id) {
        return  creditService.getClientById(Id);
    }

    @PostMapping("/customers")


    public ClientDTO saveClient(@RequestBody ClientDTO clientDTO )  {
        return  creditService.saveClient(clientDTO);
    }
    @DeleteMapping ("/customers/{customerId}")

    public void deletClient(@PathVariable Long Id){
        creditService.deleteClient(Id);
    }
}
