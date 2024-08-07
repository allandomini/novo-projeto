package sunset.com.projeto.apisunset.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import sunset.com.projeto.apisunset.model.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {
}