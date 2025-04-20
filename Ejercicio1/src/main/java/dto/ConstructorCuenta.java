package dto;

public class ConstructorCuenta {
    private double saldoInicial;
    private double giroDescubierto;
    private boolean esCuentaCorriente;
    private static ConstructorCuenta instance;
    private ConstructorCuenta(){
        esCuentaCorriente = false;
    }

    public static ConstructorCuenta getInstance() {
        if(instance == null){
            instance = new ConstructorCuenta();
        }
        instance.reset();
        return instance;
    }

    public void setSaldoInicial(double monto) {
        saldoInicial = monto;
    }
    public void setCuentaCorriente(double giroEnDescubierto){
        giroDescubierto = giroEnDescubierto;
        esCuentaCorriente = true;
    }
    public Cuenta build(){
        if(esCuentaCorriente){
            return new CuentaCorriente(saldoInicial,giroDescubierto);
        } else {
            return new CajaDeAhorro(saldoInicial);
        }

    }

    public void reset(){
        esCuentaCorriente = false;
        saldoInicial = 0;
        giroDescubierto = 0;
    }


}
