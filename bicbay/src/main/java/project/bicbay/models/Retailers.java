package project.bicbay.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("RETAILER")
public class Retailers extends User {
    @Column(name = "cnpj", nullable = false, unique = true)
    private String cnpj;

    public Retailers() {
        super();
    }

    public Retailers(String name, String email, String password, float balance, String cnpj) {
        super(name, email, password, balance);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
