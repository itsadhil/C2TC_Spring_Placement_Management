package com.tnsif.placement.controller;

import com.tnsif.placement.entity.College;
import com.tnsif.placement.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colleges")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    // CREATE
    @PostMapping
    public College addCollege(@RequestBody College college) {
        return collegeService.saveCollege(college);
    }

    // READ - Get by ID
    @GetMapping("/{id}")
    public College getCollegeById(@PathVariable Long id) {
        return collegeService.getCollegeById(id);
    }

    // READ - Get all
    @GetMapping
    public List<College> getAllColleges() {
        return collegeService.getAllColleges();
    }

    // UPDATE
    @PutMapping("/{id}")
    public College updateCollege(@PathVariable Long id, @RequestBody College college) {
        college.setId(id); // ensure correct ID is set
        return collegeService.saveCollege(college);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteCollege(@PathVariable Long id) {
        collegeService.deleteCollege(id);
    }
}
