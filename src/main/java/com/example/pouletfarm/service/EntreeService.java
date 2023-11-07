package com.example.pouletfarm.service;

import com.example.pouletfarm.model.Entree;
import com.example.pouletfarm.model.User;
import com.example.pouletfarm.repository.EntreeRepository;
import com.example.pouletfarm.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntreeService {

    @Autowired
    private EntreeRepository entreeRepository;
     @Autowired
    private UserRepository userRepository;

    public Entree createEntree(Entree entree, Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            entree.setUser(user);
            return entreeRepository.save(entree);
        }
        return null; 
    }
    
    
    

    public List<Entree> getAllEntrees(Long userId) {
        return entreeRepository.findByUserId(userId);
    }

    public Entree getEntreeById(Long id, Long userId) {
        return entreeRepository.findByIdAndUserId(id, userId).orElse(null);
    }

    public Entree updateEntree(Long id, Entree entree, Long userId) {
        Optional<Entree> existingEntree = entreeRepository.findByIdAndUserId(id, userId);
        if (existingEntree.isPresent()) {
            Entree updatedEntree = existingEntree.get();
            updatedEntree.setDateEntree(entree.getDateEntree());
            updatedEntree.setNombrePoussins(entree.getNombrePoussins());
            return entreeRepository.save(updatedEntree);
        }
        return null;
    }

    public boolean deleteEntree(Long id, Long userId) {
        Optional<Entree> existingEntree = entreeRepository.findByIdAndUserId(id, userId);
        if (existingEntree.isPresent()) {
            entreeRepository.delete(existingEntree.get());
            return true;
        }
        return false;
    }
}