package sunset.com.projeto.apisunset.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sunset.com.projeto.apisunset.model.Employee;
import sunset.com.projeto.apisunset.repository.EmployeeRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @PostMapping
    public Employee create(@RequestBody Employee entity) {
        return repository.save(entity);
    }

    @GetMapping
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Integer id, @RequestBody Employee entity) {
        entity.setId(id);
        return repository.save(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}