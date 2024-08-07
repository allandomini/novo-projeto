package sunset.com.projeto.apisunset.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fullName;
    private String fullAddress;
    private String maritalStatus;
    private String birthDate;
    private String gender;
    private String identityCard;
    private String email;

    @ManyToOne
    @JoinColumn(name = "jobid")
    private JobRoles jobRoles;

    @ManyToOne
    @JoinColumn(name = "departmentid")
    private DepartamentSec departmentSec;

    @OneToOne
    @JoinColumn(name = "phoneid")
    private Phone phone;

    @ManyToOne
    @JoinColumn(name = "bankid")
    private Bank bank;

    @ManyToOne
    @JoinColumn(name = "bank_accountid")
    private BankAccount bankAccount;

    @ManyToOne
    @JoinColumn(name = "contract_typeid")
    private ContractType contractType;
}