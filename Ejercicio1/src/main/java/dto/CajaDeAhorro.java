package dto;

public class CajaDeAhorro extends Cuenta implements IGestionSaldo{

    public CajaDeAhorro(double montoInicial) {
        Saldo = montoInicial;
    }

    @java.lang.Override
    public synchronized Boolean agregarSaldo(double monto) {
        Operaciones++;
        Saldo +=monto;
        return true;
    }

    @java.lang.Override
    public synchronized Boolean quitarSaldo(double monto) {
        Operaciones++;
        if (Saldo < monto){
            return false;
        }
        Saldo -= monto;
        return true;
    }

}
