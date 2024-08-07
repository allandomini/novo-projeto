package sunset.com.projeto.apisunset.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import sunset.com.projeto.apisunset.model.ContractType;

public interface TypeContractRepository extends JpaRepository<ContractType, Integer> {
}