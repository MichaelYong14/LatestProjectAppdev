package com.G1AppDevProj.Project.Controller;

import com.G1AppDevProj.Project.Entity.Module;
import com.G1AppDevProj.Project.Service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {

    private final ModuleService moduleService;

    @Autowired
    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    // Create Module
    @PostMapping
    public ResponseEntity<Module> createModule(@RequestBody Module module) {
        Module createdModule = moduleService.createModule(module);
        return new ResponseEntity<>(createdModule, HttpStatus.CREATED);
    }

    // Get Module by ID
    @GetMapping("/{id}")
    public ResponseEntity<Module> getModuleById(@PathVariable int id) {
        Optional<Module> module = moduleService.findModuleById(id);
        return module.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Get All Modules
    @GetMapping
    public ResponseEntity<List<Module>> getAllModules() {
        List<Module> modules = moduleService.findAllModules();
        return ResponseEntity.ok(modules);
    }

    // Update Module
    @PutMapping("/{id}")
    public ResponseEntity<Module> updateModule(@PathVariable int id, @RequestBody Module updatedModule) {
        Module module = moduleService.updateModule(id, updatedModule);
        if (module != null) {
            return ResponseEntity.ok(module);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete Module
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable int id) {
        boolean isDeleted = moduleService.deleteModule(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
