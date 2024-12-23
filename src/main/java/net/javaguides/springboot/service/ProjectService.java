package net.javaguides.springboot.service;


import net.javaguides.springboot.model.Project;
import net.javaguides.springboot.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;


    public Project createProject(Project project){
        return projectRepository.save(project);
    }

    public Project getProjectById(Long id){
        return projectRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Project not Found"));
    }
}
