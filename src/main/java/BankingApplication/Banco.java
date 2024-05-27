package BankingApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1,"Alejandra Alvarado Gardea","1234", 1000);
            Cliente cliente2 = new Cliente(2,"Jesus Rodriguez","1234", 1000);
        Cliente cliente3 = new Cliente(3,"Monica Torres","1234", 1000);
        Cliente cliente4 = new Cliente(4,"Aldo Mata","1234", 1000);
        Cliente cliente5 = new Cliente(5,"Ana Borruel","1234", 1000);
        Cliente cliente6 = new Cliente(6,"Jorge Soto","1234", 1000);
        Cliente cliente7 = new Cliente(7,"Karina Almazan","1234", 1000);
        Cliente cliente8 = new Cliente(8,"Mario Venegas","1234", 1000);
        Cliente cliente9 = new Cliente(9,"Gabriel Sotelo","1234", 1000);
        Cliente cliente10 = new Cliente(10,"Jaime Garcia","1234", 1000);
        List<Cliente> listaClientes = new ArrayList<>();
        Collections.addAll(listaClientes,cliente1, cliente2, cliente3, cliente4, cliente5, cliente6, cliente7, cliente8, cliente9, cliente10);
        Cliente cliente = null;
        double monto;
        int opcion;
        Scanner sc = new Scanner(System.in);
        do {
            menu();
            System.out.println("Escribe la opción deseada: ");
            opcion = Integer.valueOf(sc.nextLine());
            switch (opcion) {
                case 1 :{
                    cliente = autenticar(listaClientes);
                    if(cliente != null) {
                        System.out.println("Capture el monto a retirar: ");
                        monto = Double.valueOf(sc.nextLine());
                        if (!cliente.validarSaldo(monto)) {
                            System.out.println("Saldo insuficiente");
                        } else {
                            cliente.retiro(monto);
                        }
                    }
                    break;
                }
                case 2 :{
                    Cliente clientedestino = null;
                    cliente = autenticar(listaClientes);
                    clientedestino = clienteDestino(listaClientes);
                    if(cliente != null && clientedestino != null) {
                        System.out.println("Capture el monto a transferir: ");
                        monto = Double.valueOf(sc.nextLine());
                        if (!cliente.validarSaldo(monto)) {
                            System.out.println("Saldo insuficiente");
                        } else {
                            cliente.transferenciaCargo(monto);
                            clientedestino.transferenciaAbono(monto);
                        }
                    }
                    break;
                }
                case 3 :{
                    cliente = autenticar(listaClientes);
                    if(cliente != null) {
                       cliente.consultaSaldo();
                    }
                    break;
                }
                case 4: {
                    cliente = autenticar(listaClientes);
                    if(cliente != null) {
                        System.out.println("Capture el monto a depositar: ");
                        monto = Double.valueOf(sc.nextLine());
                        cliente.deposito(monto);
                    }
                    break;
                }
                case 5: {
                    System.exit(0);
                }
            }
        } while (opcion != 5);
    }
    public static boolean evaluarNip(Cliente cliente, String nip){
        if(cliente.getNIP().equals(nip) ) {
            System.out.println("Bienvenido(a) " + cliente.getNombreCliente());
            return true;
        }
        else
        {
            System.out.println("NIP incorrecto");
            return false;
        }
    }
    public static void menu(){
        System.out.println("Banco Digital");
        System.out.println("Menú de opciones");
        System.out.println("1. Retiro");
        System.out.println("2. Transferencia");
        System.out.println("3. Consulta de Saldo");
        System.out.println("4. Depósito");
        System.out.println("5. Salir");
    }
    public static Cliente identificar(List<Cliente> listaClientes){
        int encontrado = 0;
        Cliente cliente = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Capture el número de cliente: ");
        int numeroCliente = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getNumeroCliente() == numeroCliente) {
                cliente = listaClientes.get(i);
                encontrado = 1;
                break;
            }
        }
        if (encontrado == 1) {
                return cliente;
        } else {
            System.out.println("No existe el cliente");
            return null;
        }
    }
    public static Cliente autenticar(List<Cliente> listaClientes){
        int encontrado = 0;
        Cliente cliente = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Capture el número de cliente: ");
        int numeroCliente = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getNumeroCliente() == numeroCliente) {
                cliente = listaClientes.get(i);
                encontrado = 1;
                break;
            }
        }
        if (encontrado == 1) {
            System.out.println("Teclea el NIP: ");
            String nip = sc.nextLine();
            if (evaluarNip(cliente, nip)) {
               return cliente;
            } else {
                System.out.println("No existe el cliente");
                return null;
            }

        } else {
            System.out.println("No existe el cliente");
            return null;
        }
    }
    public static Cliente clienteDestino(List<Cliente> listaClientes){
        int encontrado = 0;
        Cliente cliente = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Capture el número de cliente al que se le va a transferir: ");
        int numeroCliente = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getNumeroCliente() == numeroCliente) {
                cliente = listaClientes.get(i);
                encontrado = 1;
                break;
            }
        }
        if (encontrado == 1) {
                return cliente;
           } else {
            System.out.println("No existe el cliente destino");
            return null;
        }
    }
}
