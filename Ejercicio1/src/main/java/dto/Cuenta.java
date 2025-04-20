package dto;

public abstract class Cuenta implements IGestionSaldo{
    protected double Saldo;
    protected int Operaciones = 0;

    public int getOperaciones() {
        return Operaciones;
    }

    public double getSaldo() {
        return Saldo;
    }
    public abstract Boolean agregarSaldo(double monto);
    public abstract Boolean quitarSaldo(double monto);
}
