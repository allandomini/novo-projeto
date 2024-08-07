package sunset.com.projeto.apisunset.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import sunset.com.projeto.apisunset.model.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {
}