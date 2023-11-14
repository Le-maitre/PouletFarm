package com.example.pouletfarm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pouletfarm.model.TacheBilan;
import com.example.pouletfarm.repository.TacheBilanRepository;

import java.util.List;

@Service
public class TacheBilanService {

    @Autowired
    private TacheBilanRepository tacheBilanRepository;

    public TacheBilan createTacheBilan(TacheBilan tacheBilan) {
        return tacheBilanRepository.save(tacheBilan);
    }

    public List<TacheBilan> getAllTacheBilans() {
        return tacheBilanRepository.findAll();
    }

    public TacheBilan getTacheBilanById(Long id) {
        return tacheBilanRepository.findById(id).orElse(null);
    }

    public TacheBilan updateTacheBilan(Long id, TacheBilan tacheBilan) {
        TacheBilan existingTacheBilan = tacheBilanRepository.findById(id).orElse(null);

        if (existingTacheBilan != null) {
            existingTacheBilan.setNom(tacheBilan.getNom());
            existingTacheBilan.setPrix(tacheBilan.getPrix());
            existingTacheBilan.setDescription(tacheBilan.getDescription());
            existingTacheBilan.setBilanPrevision(tacheBilan.getBilanPrevision());

            return tacheBilanRepository.save(existingTacheBilan);
        }

        return null;
    }

    public boolean deleteTacheBilan(Long id) {
        if (tacheBilanRepository.existsById(id)) {
            tacheBilanRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public List<TacheBilan> getTacheBilansByBilanPrevisionId(Long bilanPrevisionId) {
        return tacheBilanRepository.findAllByBilanPrevisionId(bilanPrevisionId);
    }
}
