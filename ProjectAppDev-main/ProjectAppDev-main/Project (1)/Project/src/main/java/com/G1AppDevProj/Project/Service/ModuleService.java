package com.G1AppDevProj.Project.Service;



import com.G1AppDevProj.Project.Entity.Module;
import com.G1AppDevProj.Project.Repository.ModuleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {

    private final ModuleRepo moduleRepository;

    @Autowired
    public ModuleService(ModuleRepo moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    // Create
    public Module createModule(Module module) {
        return moduleRepository.save(module);
    }

    // Find by ID
    public Optional<Module> findModuleById(int id) {
        return moduleRepository.findById(id);
    }

    // Find All
    public List<Module> findAllModules() {
        return moduleRepository.findAll();
    }

    // Update
    public Module updateModule(int id, Module updatedModule) {
        Optional<Module> existingModule = moduleRepository.findById(id);
        if (existingModule.isPresent()) {
            Module module = existingModule.get();
            module.setModuleName(updatedModule.getModuleName());
            return moduleRepository.save(module);
        }
        return null;
    }

    // Delete
    public boolean deleteModule(int id) {
        if (moduleRepository.existsById(id)) {
            moduleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}