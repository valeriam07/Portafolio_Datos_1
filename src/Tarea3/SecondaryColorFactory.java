package Tarea3;

public class SecondaryColorFactory extends AbstractFactory{
    @Override
    Color getColor(ColorType name) {
        if(ColorType.PURPLE == name){
            return new Purple();
        }
        return null;
    }
}
