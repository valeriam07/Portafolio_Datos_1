package Tarea3;

public class FactoryProvider {
    public static AbstractFactory getFactory(FactoryType factoryType){
        if(FactoryType.PRIMARY_COLOR_FACTORY == factoryType){
            return new PrimaryColorFactory();
        }else if(FactoryType.SECONDARY_COLOR_FACTORY == factoryType){
            return new SecondaryColorFactory();
        }
        return null;
    }
}
