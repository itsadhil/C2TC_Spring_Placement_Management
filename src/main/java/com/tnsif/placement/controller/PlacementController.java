package com.tnsif.placement.controller;

import com.tnsif.placement.entity.Placement;
import com.tnsif.placement.service.PlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/placements")
public class PlacementController {

    @Autowired
    private PlacementService placementService;

    // CREATE
    @PostMapping
    public Placement addPlacement(@RequestBody Placement placement) {
        return placementService.savePlacement(placement);
    }

    // READ - Get by ID
    @GetMapping("/{id}")
    public Placement getPlacementById(@PathVariable Long id) {
        return placementService.getPlacementById(id);
    }

    // READ - Get all
    @GetMapping
    public List<Placement> getAllPlacements() {
        return placementService.getAllPlacements();
    }

    // UPDATE
    @PutMapping("/{id}")
    public Placement updatePlacement(@PathVariable Long id, @RequestBody Placement placement) {
        placement.setId(id); // Ensure correct ID
        return placementService.savePlacement(placement);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deletePlacement(@PathVariable Long id) {
        placementService.deletePlacement(id);
    }
}
