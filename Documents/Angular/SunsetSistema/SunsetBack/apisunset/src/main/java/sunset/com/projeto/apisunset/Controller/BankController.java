package sunset.com.projeto.apisunset.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sunset.com.projeto.apisunset.model.Bank;
import sunset.com.projeto.apisunset.repository.BankRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankRepository repository;

    @PostMapping
    public Bank create(@RequestBody Bank entity) {
        return repository.save(entity);
    }

    @GetMapping
    public List<Bank> getAll() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Bank update(@PathVariable Integer id, @RequestBody Bank entity) {
        entity.setBank_ID(id);
        return repository.save(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}