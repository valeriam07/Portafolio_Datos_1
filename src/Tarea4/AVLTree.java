package Tarea4;

import java.util.Comparator;

public class AVLTree {
    private NodoAvl raiz;            // Nodo raiz del arbol
    private Comparator cmp = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            if((int)o1 < (int)o2){
                return -1;
            }else if (o1 == o2){
                return 0;
            }else {
                return 1;
            }
        }
    };          // Comparador
    private int nNodos;              //numero de nodos

    public AVLTree() {
        raiz = null;
        nNodos = 0;
    }

    public void vaciar() {
        raiz = null;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public int size() {
        return nNodos;
    }

    public void print() {
        if(estaVacio())
            System.out.println("Arbol vacio");
        else
            imprimir(raiz);
        System.out.println();

    }

    private void imprimir(NodoAvl nodo) {
        if(nodo != null) {
            imprimir(nodo.izquierda);
            System.out.print(nodo.contenido +":"+nodo.altura+"\t");
            imprimir(nodo.derecha);
        }
    }

    public void agregar(Object dato) {
        raiz = agregar(dato, raiz);
        System.out.println(raiz.contenido);
    }

    private NodoAvl agregar(Object dato, NodoAvl n) {
        if(n == null) {
            n = new NodoAvl((Integer) dato);
            n.contenido = dato;
            nNodos ++;
        }
        else if(cmp.compare(dato, n.contenido) < 0) {
            n.izquierda = agregar(dato, n.izquierda);
            if(altura(n.izquierda) - altura(n.derecha) == 2)
                if(cmp.compare(dato, n.izquierda.contenido) < 0)
                    n = rotarIzq(n);
                else {
                    n.izquierda = rotarDer(n.izquierda);
                    n = rotarIzq(n);
                }
        } else if(cmp.compare(dato, n.contenido) > 0) {
            n.derecha = agregar(dato, n.derecha);
            if(altura(n.derecha) - altura(n.izquierda) == 2)
                if(cmp.compare(dato, n.derecha.contenido) > 0)
                    n = rotarDer(n);
                else {
                    n.derecha = rotarIzq(n.derecha);
                    n = rotarDer(n);
                }
        }  else ;  // Encontro un duplicado y no hace nada.

        n.altura = max(altura(n.izquierda), altura(n.derecha)) + 1;
        System.out.println(n.altura);
        return n;

    }

    private int max(int alturaIZQ, int alturaDER) {     //verfica cual altura es mayor
        if (alturaDER > alturaIZQ) {
            return alturaDER;
        } else {
            return alturaIZQ;
        }
    }


    private int altura(NodoAvl n) {
        return (n == null) ? -1 : n.altura;
    }


    private NodoAvl rotarIzq(NodoAvl n) {
        NodoAvl nraiz = n.izquierda;
        n.izquierda = nraiz.derecha;
        nraiz.derecha = n;
        n.altura = max(altura(n.izquierda), altura(n.derecha)) + 1;
        nraiz.altura = max(altura(nraiz.izquierda), n.altura) + 1;
        return nraiz;
    }

    private NodoAvl rotarDer(NodoAvl n) {
        NodoAvl nraiz = n.derecha;
        n.derecha = nraiz.izquierda;
        nraiz.izquierda = n;
        n.altura = max(altura(n.izquierda), altura(n.derecha)) + 1;
        nraiz.altura = max(altura(nraiz.derecha), n.altura) + 1;
        return nraiz;
    }

    public NodoAvl encuentraMin(NodoAvl n) {
        if(n == null)
            return null;
        else if(n.izquierda == null)
            return n;
        return encuentraMin(n.izquierda);
    }

    public boolean contiene(Object dato) {      //encontrar un dato
        return encontrar(dato, raiz) != null;
    }


    private NodoAvl encontrar(Object dato, NodoAvl n) {
        while(n != null)
            if(cmp.compare(dato, n.contenido) < 0)
                n = n.izquierda;
            else if(cmp.compare(dato, n.contenido) > 0)
                n = n.derecha;
            else
                return n;    // Lo encontro

        return null;   // No lo encontro.
    }
}

















