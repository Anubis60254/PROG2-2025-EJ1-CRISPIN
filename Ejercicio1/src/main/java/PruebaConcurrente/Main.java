package PruebaConcurrente;

import dto.ConstructorCuenta;
import dto.Cuenta;
import service.LogicaCuenta;
import java.util.Random;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        CompletableFutureCuenta completableFuture = new CompletableFutureCuenta(crearCuentas());

        completableFuture.probar10000Iteraciones();
    }
    public static ArrayList<Cuenta> crearCuentas(){
        Random random = new Random();
        ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
        ConstructorCuenta constructor = ConstructorCuenta.getInstance();

        for (int i = 0; i < 5; i++) {
            constructor.reset();
            constructor.setSaldoInicial(100 + (5000 - 100) * random.nextDouble());
            cuentas.add(constructor.build());
        }
        for (int i = 0; i < 5; i++) {
            constructor.reset();
            constructor.setSaldoInicial(100 + (5000 - 100) * random.nextDouble());
            constructor.setCuentaCorriente(100 + (5000 - 100) * random.nextDouble());
            cuentas.add(constructor.build());
        }

        return cuentas;
    }


}