package Tarea3;

public class Main {
    public static void main(String[] args) {

        //Nueva fabrica para colores primarios, sirve para rojo y amarillo
        AbstractFactory F1 = FactoryProvider.getFactory(FactoryType.PRIMARY_COLOR_FACTORY);
        Color C1 = F1.getColor(ColorType.RED);
        C1.paint();

        Color C2 = F1.getColor(ColorType.YELLOW);
        C2.paint();


        //Nueva fabrica para colores secundarios, sirve para morado
        AbstractFactory F2 = FactoryProvider.getFactory(FactoryType.SECONDARY_COLOR_FACTORY);
        Color C3 = F2.getColor(ColorType.PURPLE);
        C3.paint();

    }
}
