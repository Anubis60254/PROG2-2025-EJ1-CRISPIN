package PruebaConcurrente;

import dto.Cuenta;

import java.util.concurrent.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureCuenta {
    ArrayList<Cuenta> cuentas;
    public CompletableFutureCuenta(ArrayList<Cuenta> cuentas){
        this.cuentas = cuentas;
    }

    public void probar10000Iteraciones(){
        int totalOperaciones = 10000;
        ExecutorService executor = Executors.newFixedThreadPool(10); // Pool de 10 hilos


        CompletableFuture<Void>[] tareas = new CompletableFuture[totalOperaciones];

        for (int i = 0; i < totalOperaciones; i++) {
            tareas[i] = CompletableFuture.runAsync(() -> {
                // Seleccionar aleatoriamente una cuenta de la lista
                Cuenta cuentaSeleccionada = cuentas.get(ThreadLocalRandom.current().nextInt(0, cuentas.size()));

                // Generar una operación aleatoria
                double monto = ThreadLocalRandom.current().nextDouble(1.0, 200.0);
                boolean esAgregar = ThreadLocalRandom.current().nextBoolean();

                // Realizar la operación
                if (esAgregar) {
                    cuentaSeleccionada.agregarSaldo(monto);
                } else {
                    cuentaSeleccionada.quitarSaldo(monto);
                }
            }, executor);
        }

        // Esperar a que todas las operaciones terminen
        CompletableFuture.allOf(tareas).join();
        executor.shutdown();
        for (int i = 0; i < cuentas.size(); i++) {
            System.out.println("Cuenta " + (i + 1) + " - Saldo final: " + cuentas.get(i).getSaldo() +
                    " | Operaciones realizadas: " + cuentas.get(i).getOperaciones());
        }


    }
}
