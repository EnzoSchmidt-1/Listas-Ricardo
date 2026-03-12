public class ListaDinamica implements ListaOperacoes{
    private No inicio;
    private int tamanho;

    public ListaDinamica() {
        inicio = null;
        tamanho = 0;
    }


    public void exibirElementos() {
        No atual = inicio;
        int i = 0;

        while (atual != null){
            System.out.println("[" + i + "]" + atual.valor);
            atual = atual.prox;
            i++;
        }
        if (tamanho == 0){
            System.out.println("A lista está vazia ");
        }
    }

    public boolean removerElemento(String elemento) {
        No atual = inicio;
        No anterior = null;

        while (atual != null){
            if (atual.valor.equals(elemento)){
                if (anterior == null){
                    inicio = atual.prox;
                } else {
                    anterior.prox = atual.prox;
                }
                tamanho--;
                return true;
            }
            anterior = atual;
            atual = atual.prox;
        }
        return false;
    }

    public boolean adicionarElemento(String elemento) {
        No novo = new No(elemento);

        if (inicio == null){
            inicio = novo;
        } else {
            No atual = inicio;

            while (atual.prox != null){
                atual = atual.prox;
            }
            atual.prox = novo;
        }
        tamanho++;
        return true;
    }
    
    @Override
    public int removerTodas(String elemento){
        int removidos = 0;

        No atual = inicio;
        No anterior = null;

        while (atual != null){
            if (atual.valor.equals(elemento)){
                if (anterior == null){
                    inicio = atual.prox;
                    
                }else anterior.prox = atual.prox;

                tamanho--;
                removidos++;
            } else {
                anterior = atual;
            }
            atual = atual.prox;
        }

        return removidos;
    }
    
    @Override
    public int contar(){
        return tamanho;

    }
    
    @Override
    public void limpar(){
        inicio = null;
        tamanho = 0;
    }
    
    @Override
    public String removerPorIndice(int indice){
        if (indice < 0 || indice >= tamanho){
            return null;
        }

        No removido;

        if (indice == 0 ){
            removido = inicio;
            inicio = inicio.prox;
        } else {
            No atual = inicio;

            for (int i=0; i < indice - 1; i++){
                atual = atual.prox;
            }
            removido = atual.prox;
            atual.prox = removido.prox;
        }
        tamanho--;
        return removido.valor;
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        int adicionados = 0;

        for (String e : elementos){
            adicionarElemento(e);
            adicionados++;
        }
        return adicionados;
    }

    @Override
    public String obter(int indice) {
        if (indice < 0 || indice >= tamanho){
            return null;
        }
        No atual = inicio;

        for (int i=0; i<indice;i++){
            atual = atual.prox;
        }

        return atual.valor;
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        if (indice < 0 || indice > tamanho){
            return false;
        }
        No novo = new No(elemento);
        if (indice == 0){
            novo.prox = inicio;
            inicio = novo;
        } else {
            No atual = inicio;
            for (int i=0; i<indice - 1; i++){
                atual = atual.prox;
            }
            novo.prox = atual.prox;
            atual.prox = novo;
        }
        tamanho++;
        return true;
    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        int indice = 0;
        int ultimo = -1;

        No atual = inicio;

        while (atual != null){
            if (atual.valor.equals(elemento)) {
                ultimo = indice;
            }
            atual = atual.prox;
            indice++;
        }
        return ultimo;
    }

    @Override
    public int contarOcorrencias(String elemento) {
        int cont = 0;

        No atual= inicio;

        while (atual != null){
            if (atual.valor.equals(elemento)){
                cont++;
            }
            atual = atual.prox;
        }
        return cont;
    }

    @Override
    public int substituir(String antigo, String novo) {
        int cont = 0;

        No atual = inicio;

        while (atual != null){
            if (atual.valor.equals(antigo)){
                atual.valor = novo;
                cont++;
            }
            atual = atual.prox;
        }
        return cont;
    }
}
