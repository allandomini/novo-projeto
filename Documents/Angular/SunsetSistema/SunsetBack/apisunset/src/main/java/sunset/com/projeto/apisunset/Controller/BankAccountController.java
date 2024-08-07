package sunset.com.projeto.apisunset.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sunset.com.projeto.apisunset.model.BankAccount;
import sunset.com.projeto.apisunset.repository.BankAccountRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/BankAccount")
public class BankAccountController {

    @Autowired
    private BankAccountRepository repository;

    @PostMapping
    public BankAccount create(@RequestBody BankAccount entity) {
        return repository.save(entity);
    }

    @GetMapping
    public List<BankAccount> getAll() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public BankAccount update(@PathVariable Integer id, @RequestBody BankAccount entity) {
        entity.setBankAccountID(id);
        return repository.save(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}