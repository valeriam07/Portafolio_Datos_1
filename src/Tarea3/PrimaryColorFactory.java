package Tarea3;

public class PrimaryColorFactory extends AbstractFactory {
    @Override
    Color getColor(ColorType name) {
        if(ColorType.RED == name){
            return new Red();
        }else if(ColorType.YELLOW == name){
            return new Yellow();
        }
        return null;
    }
}
