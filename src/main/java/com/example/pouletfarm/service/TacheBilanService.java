package com.example.pouletfarm.service;

import com.example.pouletfarm.model.TacheBilan;
import com.example.pouletfarm.repository.TacheBilanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<TacheBilan> existingTacheBilan = tacheBilanRepository.findById(id);
        if (existingTacheBilan.isPresent()) {
            tacheBilan.setId(id);
            return tacheBilanRepository.save(tacheBilan);
        }
        return null;
    }

    public boolean deleteTacheBilan(Long id) {
        Optional<TacheBilan> existingTacheBilan = tacheBilanRepository.findById(id);
        if (existingTacheBilan.isPresent()) {
            tacheBilanRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
