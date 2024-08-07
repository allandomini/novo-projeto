package sunset.com.projeto.apisunset.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sunset.com.projeto.apisunset.model.User;
import sunset.com.projeto.apisunset.repository.UserRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserRepository UserRepository;

    @PostMapping
    public User create(@RequestBody User User) {
        return UserRepository.save(User);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable int userId) {
        Optional<User> User = UserRepository.findById(userId);
        return User.orElse(null);
    }

    @GetMapping("/name/{nameUser}")
    public List<User> getUserByName(@PathVariable String nameUser) {
        return UserRepository.findByNameUser(nameUser);
    }

    @GetMapping("/tipo/{tipo}")
    public List<User> getUserByTipo(@PathVariable String tipo) {
        return UserRepository.findByType(tipo);
    }
    @GetMapping
    public Iterable<User> getAllUsers() {
        return UserRepository.findAll();
    }
    @PutMapping("/{userId}")
    public User update(@PathVariable int userId, @RequestBody User User) {
        User.setUserId(userId);
        return UserRepository.save(User);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable int userId) {
        UserRepository.deleteById(userId);
    }

    @PostMapping("/authenticate")
    public boolean authenticateUser(@RequestBody Map<String, String> payload) {
        String nameUser = payload.get("nameUser");
        String password = payload.get("password");
        
        List<User> Users = UserRepository.findByNameUser(nameUser);
        if (Users.isEmpty()) {
            return false; 
        }
        for (User User : Users) {
            if (User.getPassword().equals(password)) {
                return true;
            }
        }
        return false; 
    }
    
    
    @PutMapping("/password/{userId}")
    public void changeUserPassword(@PathVariable int userId, @RequestParam String newPassword) {
        Optional<User> UserOpt = UserRepository.findById(userId);
        if (UserOpt.isPresent()) {
            User User = UserOpt.get();
            User.setPassword(newPassword);
            UserRepository.save(User);
        }
    }
}