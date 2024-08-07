package sunset.com.projeto.apisunset.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sunset.com.projeto.apisunset.model.ContractType;
import sunset.com.projeto.apisunset.repository.TypeContractRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/TypeContract")
public class ContractTypeController {

    @Autowired
    private TypeContractRepository repository;

    @PostMapping
    public ContractType create(@RequestBody ContractType entity) {
        return repository.save(entity);
    }

    @GetMapping
    public List<ContractType> getAll() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public ContractType update(@PathVariable Integer id, @RequestBody ContractType entity) {
        entity.setContractType_ID(id);
        return repository.save(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}