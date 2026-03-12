public class ListaSimples implements ListaOperacoes{
    private String[] lista;

    public ListaSimples(int tamanho) {
        this.lista = new String[tamanho];
    }

    public void exibirElementos() {
        for (int i = 0; i < this.lista.length; i++) {
            System.out.println("Lista[" + i + "] = " + this.lista[i]);
        }
    }

    public void adicionarElemento(String elemento) {
        if (!estaCheia()) {
            this.lista[encontrarPosicaoVazia()] = elemento;
            System.out.println("Elemento " + elemento + " adicionado com sucesso!");
        }
    }


    private boolean estaCheia() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                return false;
            }
        }
        System.out.println("A lista está cheia!");
        return true;
    }

    private boolean estaVazio() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null) {
                return false;
            }
        }
        System.out.println("A lista está vazia!");
        return true;
    }

    private int encontrarPosicaoVazia() {
        int i;
        for (i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                return i;
            }
        }
        return i;
    }

    public void removerElemento(String elemento) {
        if (!estaVazio()) {
            if (this.buscarElemento(elemento) >= 0) {
                this.lista[this.buscarElemento(elemento)] = null;
                System.out.println("Elemento " + elemento + " removido com sucesso!");
            }
        }
    }

    public int buscarElemento(String elemento){
        int i;
        if (!estaVazio()) {
            for (i = 0; i < this.lista.length; i++) {
                if (this.lista[i].equals(elemento)) {
                    return i;
                }
            }
        }
        System.out.println("Elemento não encontrado na lista.");
        return -1;
    }

    public void alterarElemento(String elementoASerAlterado, String alteracao) {
        if(buscarElemento(elementoASerAlterado) >= 0) {
            this.lista[buscarElemento(elementoASerAlterado)] = alteracao;
            System.out.println("Elemento " + elementoASerAlterado + " alterado com sucesso para " + alteracao);
        }
    }

    public void quantidadeElementos() {
        int cont = 0;
        if(!estaVazio()) {
            for (int i = 0; i < this.lista.length; i++) {
                if(this.lista[i] != null) {
                    cont++;
                }
            }
        }
        System.out.println("A lista possui " + cont + " elementos!");
    }

    @Override
    public int removerTodas(String elemento) {
        int quantidadeRemovida = 0;
        if (!estaVazio()) {
                for (int i = 0; i < this.lista.length; i++) {
                    if (this.lista[i] == elemento) {
                        this.lista[i] = null;
                        quantidadeRemovida++;
                    }
                }System.out.println(quantidadeRemovida + " intancias do elemento: "+ elemento + " removidos com sucesso!");
            }
        return quantidadeRemovida;
    }

    @Override
    public int contar() {
        int contagem = 0; 
        if (!estaVazio()) {
            for (int i = 0; i < this.lista.length; i++) {
                if (this.lista[i] != null) {
                    contagem++;
                }
            } return contagem;
        } return 0; 
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        int quantidadeAdicionados = 0;
        if (!estaCheia()) {
            for (int i = 0; i < elementos.length; i++) {
                this.lista[encontrarPosicaoVazia()] = elementos[i]; 
                quantidadeAdicionados++;
                if (this.lista.length == contar()) {
                    return quantidadeAdicionados;
                }

            
            }
        
        }return quantidadeAdicionados; 
    }

    @Override
    public String obter(int indice) {
        if (indice >= 0 && indice < this.lista.length) {
            for (int i = 0; i < this.lista.length; i++) {
                if (this.lista[i] == this.lista[indice]) {
                    return this.lista[indice];
                }
            }   
        }return "O indice: " + indice +" não foi encontrado";
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        int tamanho = contar();
        if (indice >= 0 && indice < this.lista.length) {

            for (int i = tamanho-1; i >= indice; i--) {
                this.lista[i + 1] = this.lista[i];
            }
            this.lista[indice] = elemento;
            return true;
        }return false;
    }

    @Override
    public String removerPorIndice(int indice) {
        if (indice >= 0 && indice < this.lista.length) {
            String lembrarIndice = this.lista[indice];
            this.lista[indice] = null;
            for (int i = indice; i < this.lista.length -1; i++) {
                this.lista[i] = this.lista[i+1];
            }
            this.lista[this.lista.length-1] = null;
            return "Indice " + indice + " removido, ele contia: " + lembrarIndice + " e foi substituido por: " + this.lista[indice];
        
        }else return null;
    }

    @Override
    public void limpar() {
        if (!estaVazio()) {
            for (int i = 0; i < this.lista.length; i++) {
                if (this.lista[i] != null) {
                    this.lista[i] = null;
                }
            }
        }
    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        if (!estaVazio()) {
            for (int i = this.lista.length-1; i > 0; i--) {
                if (this.lista[i] == elemento) {
                    return i;
                }
            }
        }return -1;
    }

    @Override
    public int contarOcorrencias(String elemento) {
        int contagem = 0; 
        if (!estaVazio()) {
            for (int i = 0; i < this.lista.length; i++) {
                if (this.lista[i] == elemento) {
                    contagem++;
                }
            } return contagem;
        } return 0; 
    }

    @Override
    public int substituir(String antigo, String novo) {
        int quantidadeSubst = 0;
        if(!estaVazio()){
            for(int i = 0; i < lista.length; i++){
                if(this.lista[i] == antigo){
                    this.lista[i] = novo;
                    quantidadeSubst++;
                }
            }
        }return quantidadeSubst;
    }

}
