package BankingApplication;

public interface Transacciones {


    void retiro(double monto);

    void transferenciaCargo(double monto);

    void transferenciaAbono(double monto);

    void consultaSaldo();

    void deposito(double monto);
}
