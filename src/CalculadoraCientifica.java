public class CalculadoraCientifica extends Calculadora {

    public CalculadoraCientifica(double numero1, double numero2) {
        super(numero1, numero2); // llama al constructor de la clase padre
    }

    // Método nuevo: potenciación
    public double potenciar(double base, double exponente) {
        return Math.pow(base, exponente);
    }

    // Polimorfismo: sobrescribimos mostrarTipo()
    @Override
    public String mostrarTipo() {
        return "Calculadora científica";
    }
}
