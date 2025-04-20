package service;

import dto.ConstructorCuenta;
import dto.Cuenta;

import java.util.ArrayList;

public class LogicaCuenta {
    public ArrayList<Cuenta> cuentas;
    private static LogicaCuenta instance;
    private LogicaCuenta() {
        cuentas = new ArrayList<Cuenta>();
    }

    public synchronized static LogicaCuenta getInstance() {
        if(instance == null){
            instance = new LogicaCuenta();
        }
        return instance;
    }

    public synchronized void agregarSaldo(int cuenta, double monto){
        if (cuenta > cuentas.size() || cuenta < 0){
            return;
        }
        cuentas.get(cuenta - 1).agregarSaldo(monto);

    }


    public synchronized void quitarSaldo(int cuenta, double monto){
        if (cuenta > cuentas.size() || cuenta < 0){
            return;
        }
        cuentas.get(cuenta - 1).quitarSaldo(monto);
    }


    public synchronized double consultarSaldo(int cuenta){
        if (cuenta > cuentas.size() || cuenta < 0){
            return 0;
        }
        return cuentas.get(cuenta - 1).getSaldo();
    }

    public synchronized int consultarOperaciones(int cuenta){
        if (cuenta > cuentas.size() || cuenta < 0){
            return 0;
        }
        return cuentas.get(cuenta - 1).getOperaciones();
    }

    public synchronized void añadirCuentaAhorro(double monto){
        ConstructorCuenta constructor = ConstructorCuenta.getInstance();
        constructor.setSaldoInicial(monto);
        cuentas.add(constructor.build());
    }
    public synchronized void añadirCuentaAhorro(double monto, double giroDescubierto){
        ConstructorCuenta constructor = ConstructorCuenta.getInstance();
        constructor.setSaldoInicial(monto);
        constructor.setCuentaCorriente(giroDescubierto);
        cuentas.add(constructor.build());
    }
}
