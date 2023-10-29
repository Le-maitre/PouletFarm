package com.example.pouletfarm.service;

import com.example.pouletfarm.model.Vitamine;
import com.example.pouletfarm.repository.VitamineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VitamineService {

    @Autowired
    private VitamineRepository vitamineRepository;

    public List<Vitamine> getAllVitamines() {
        return vitamineRepository.findAll();
    }

    public Optional<Vitamine> getVitamineById(Long id) {
        return vitamineRepository.findById(id);
    }

    public Vitamine saveVitamine(Vitamine vitamine) {
        return vitamineRepository.save(vitamine);
    }

    public void deleteVitamine(Long id) {
        vitamineRepository.deleteById(id);
    }
}
