package sunset.com.projeto.apisunset.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="phone")
@Getter
@Setter
public class Phone {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long phoneID;
    private String number;
    private String type;
    private String countryCode;
    private String areaCode;
    private String extension;
    
}
