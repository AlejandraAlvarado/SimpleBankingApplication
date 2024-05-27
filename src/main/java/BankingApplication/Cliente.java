package BankingApplication;

public class Cliente implements Transacciones{
    private int numeroCliente;
    private String nombreCliente;
    private String NIP;
    private double saldo;

    public Cliente(int numeroCliente, String nombreCliente, String NIP, double saldo) {
        this.numeroCliente = numeroCliente;
        this.nombreCliente = nombreCliente;
        this.NIP = NIP;
        this.saldo = saldo;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }



    @Override
    public void retiro(double monto) {
        this.saldo -= monto;
        System.out.println("Se realizó el retiro exitosamente!!!!");
        System.out.println("-------------------------------------");
    }

    @Override
    public void transferenciaCargo(double monto) {
        this.saldo -= monto;
    }
    @Override
    public void transferenciaAbono(double monto) {
        this.saldo += monto;
        System.out.println("Se realizó la transferencia exitosamente!!!");
        System.out.println("-------------------------------------------");
    }
    @Override
    public void consultaSaldo() {
        System.out.printf("El saldo del cliente es: $ %,.2f\n", getSaldo());
        //System.out.printf("El cuadrado de %.2f es %.2f\n", n, n*n);
        System.out.println("---------------------------------------");
    }

    @Override
    public void deposito(double monto) {
        this.saldo += monto;
        System.out.println("Se realizó del depósito exitosamente!!!");
        System.out.println("---------------------------------------");
    }
    public boolean validarSaldo(double monto){
        if(this.saldo >= monto)
        {
            return true;
        }
        else{
            return false;
        }
    }
}
