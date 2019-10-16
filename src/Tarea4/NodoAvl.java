package Tarea4;

public class NodoAvl {

    public NodoAvl izquierda;
    public NodoAvl derecha;
    public int index;
    public Object contenido;
    public int altura;

    public NodoAvl(int indice){
        index = indice;
        derecha = null;
        izquierda = null;
        altura = 0;
    }
}
