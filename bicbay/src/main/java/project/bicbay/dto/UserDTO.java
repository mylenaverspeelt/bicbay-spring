package project.bicbay.dto;

public class UserDTO {
    private String name;
    private String email;
    private String password;
    private float balance;
    private String cpf;
    private String cnpj;

    public UserDTO(String name, String email, String password, float balance, String cpf, String cnpj) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.cpf = cpf;
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
