package sunset.com.projeto.apisunset.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sunset.com.projeto.apisunset.model.DepartamentSec;
import sunset.com.projeto.apisunset.repository.DepartmentSecRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/DepartamentSec")
public class DepartmentSecController {

    @Autowired
    private DepartmentSecRepository repository;

    @PostMapping
    public DepartamentSec create(@RequestBody DepartamentSec entity) {
        return repository.save(entity);
    }

    @GetMapping
    public List<DepartamentSec> getAll() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public DepartamentSec update(@PathVariable Integer id, @RequestBody DepartamentSec entity) {
        entity.setDepartament_ID(id);
        return repository.save(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}