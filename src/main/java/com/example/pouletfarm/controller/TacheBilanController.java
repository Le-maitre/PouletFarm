package com.example.pouletfarm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.pouletfarm.model.BilanPrevision;
import com.example.pouletfarm.model.TacheBilan;
import com.example.pouletfarm.service.TacheBilanService;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/tachebilans")
public class TacheBilanController {

    @Autowired
    private TacheBilanService tacheBilanService;

    @PostMapping("/create/bilanprevisions/{bilanPrevisionId}")
    public ResponseEntity<TacheBilan> createTacheBilan(
            @PathVariable Long bilanPrevisionId,
            @RequestBody TacheBilan tacheBilan
    ) {
        BilanPrevision bilanPrevision = new BilanPrevision();
        bilanPrevision.setId(bilanPrevisionId);

        tacheBilan.setBilanPrevision(bilanPrevision);
        TacheBilan newTacheBilan = tacheBilanService.createTacheBilan(tacheBilan);
        return new ResponseEntity<>(newTacheBilan, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TacheBilan>> getAllTacheBilans() {
        List<TacheBilan> tacheBilans = tacheBilanService.getAllTacheBilans();
        return new ResponseEntity<>(tacheBilans, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TacheBilan> getTacheBilanById(@PathVariable Long id) {
        TacheBilan tacheBilan = tacheBilanService.getTacheBilanById(id);

        if (tacheBilan != null) {
            return new ResponseEntity<>(tacheBilan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TacheBilan> updateTacheBilan(@PathVariable Long id, @RequestBody TacheBilan tacheBilan) {
        TacheBilan updatedTacheBilan = tacheBilanService.updateTacheBilan(id, tacheBilan);

        if (updatedTacheBilan != null) {
            return new ResponseEntity<>(updatedTacheBilan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTacheBilan(@PathVariable Long id) {
        boolean isDeleted = tacheBilanService.deleteTacheBilan(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/bilanprevisions/{bilanPrevisionId}")
public ResponseEntity<List<TacheBilan>> getTacheBilansByBilanPrevisionId(@PathVariable Long bilanPrevisionId) {
    List<TacheBilan> tacheBilans = tacheBilanService.getTacheBilansByBilanPrevisionId(bilanPrevisionId);
    
    if (!tacheBilans.isEmpty()) {
        return new ResponseEntity<>(tacheBilans, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

}
