package sunset.com.projeto.apisunset.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ContractType")
@Getter
@Setter
public class ContractType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ContractType_ID;
    private String description;

}