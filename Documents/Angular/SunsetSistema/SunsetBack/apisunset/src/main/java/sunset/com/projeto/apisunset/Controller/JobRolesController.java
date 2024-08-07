package sunset.com.projeto.apisunset.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sunset.com.projeto.apisunset.model.JobRoles;
import sunset.com.projeto.apisunset.repository.JobRolesRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/JobRoles")
public class JobRolesController {

    @Autowired
    private JobRolesRepository repository;

    @PostMapping
    public JobRoles create(@RequestBody JobRoles entity) {
        return repository.save(entity);
    }

    @GetMapping
    public List<JobRoles> getAll() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public JobRoles update(@PathVariable Integer id, @RequestBody JobRoles entity) {
        JobRoles existingJobRole = repository.findById(id).orElseThrow();
        existingJobRole.setJobName(entity.getJobName());
        // Update other fields as needed
        return repository.save(existingJobRole);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}