    package project.bicbay.models;

    import jakarta.persistence.Column;
    import jakarta.persistence.DiscriminatorValue;
    import jakarta.persistence.Entity;

    @Entity
    @DiscriminatorValue("CLIENT")
    public class Client  extends User{
        @Column(name = "cpf", nullable = false, unique = true)
        private String cpf;

        public Client() {
            super();
        }

        public Client(String name, String email, String password, float balance, String cpf) {
            super(name, email, password, balance);
            this.cpf = cpf;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public String transfer(User user, float value) {
            if (super.getBalance() < value) {
                return "Saldo insuficiente. Operação cancelada.";
            } else {
                super.setBalance(super.getBalance() + value);
                user.setBalance(user.getBalance() + value);
                return "Transferencia realizada com sucesso";
            }
        }
    }
