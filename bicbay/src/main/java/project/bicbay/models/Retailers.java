package project.bicbay.models;

import jakarta.persistence.Entity;

@Entity
public class Retailers extends User {
    private String cnpj;

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
