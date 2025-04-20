package dto;

public class CuentaCorriente extends Cuenta implements IGestionSaldo{
    public CuentaCorriente(double montoInicial,double giroDescubierto) {
        this.Saldo = montoInicial;
        this.giroDescubierto = giroDescubierto;
    }

    protected double giroDescubierto;
    public synchronized Boolean agregarSaldo(double monto) {
        Operaciones++;
        Saldo +=monto;
        return true;
    }

    public synchronized Boolean quitarSaldo(double monto) {
        Operaciones++;
        if (Saldo - monto < -giroDescubierto){
            return false;
        }
        Saldo -= monto;
        return true;
    }

}
