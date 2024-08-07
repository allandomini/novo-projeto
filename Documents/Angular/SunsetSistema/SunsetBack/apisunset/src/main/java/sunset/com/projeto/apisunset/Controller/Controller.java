package sunset.com.projeto.apisunset.Controller;

import org.springframework.web.bind.annotation.RestController;

import sunset.com.projeto.apisunset.model.Phone;
import sunset.com.projeto.apisunset.repository.PhoneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin(origins = "*")
public class Controller {
    
    @Autowired
    private PhoneRepository phone;

    @PostMapping("/phone")
    public Phone cadastrar(@RequestBody Phone t) {

        return phone.save(t);
        }

    @GetMapping("/phone")
    public Iterable<Phone> selecionar() {
        return phone.findAll();
        }
        @PutMapping("/phone")
        public Phone editar(@RequestBody Phone t) {
            return phone.save(t);
        }
        @DeleteMapping("/phone/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (phone.existsById(id)) {
            phone.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
   
    

}
