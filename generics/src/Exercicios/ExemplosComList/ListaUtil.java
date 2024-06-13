package Exercicios.ExemplosComList;

import java.util.List;

public class ListaUtil {
    // Colocar <?> é a mesma coisa que <Object>, pois Object é o tipo mais genérico em Java.
    public static Object getUltimo(List<?> lista) {
        return lista.get(lista.size() - 1);
    }

    // Já nessa versão está explicito que o retorno será um elemento <T> T.
    public static <T> T getPenultimo(List<T> lista) {
        return lista.get(lista.size() - 2);
    }

}
