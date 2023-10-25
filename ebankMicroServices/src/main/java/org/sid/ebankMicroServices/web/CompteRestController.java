package org.sid.ebankMicroServices.web;


import org.sid.ebankMicroServices.entities.Compte;
import org.sid.ebankMicroServices.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.context.support.UiApplicationContextUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CompteRestController {
    @Autowired
    private CompteRepository compteRepository;

    @GetMapping("/comptes")
    public List<Compte> compteList(){
        return compteRepository.findAll();

    }
    @GetMapping("/comptes/{id}")
    public Compte compte(@PathVariable String id){
        return compteRepository.findById(id).orElseThrow(()->
                new RuntimeException(String.format("compte n'existe pas",id)));

    }
    @PostMapping("/comptes")
    public Compte save(@RequestBody Compte compte){
        if ( compte.getId()==null)
        compte.setId(UUID.randomUUID().toString());
        return compteRepository.save(compte);

    }
    @PutMapping("/comptes/{id}")
    public Compte edite(@PathVariable String id,@RequestBody Compte compte){
        Compte compteTrouve=compteRepository.findById(id).orElseThrow();
       if(compte.getMontantCmpt()!=0)compteTrouve.setMontantCmpt(compte.getMontantCmpt());
        if(compte.getDateCreation()!=null)compteTrouve.setDateCreation(new Date());
        if(compte.getType()!=null)compteTrouve.setType(compte.getType());
        if(compte.getDevise()!=null)compteTrouve.setDevise(compte.getDevise());

        return compteRepository.save(compteTrouve);
    }
    @DeleteMapping("/comptes/{id}")
    public void delete(@PathVariable String id){
        compteRepository.deleteById(id);

    }

}
