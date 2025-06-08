public class Arvore{
    private No raiz;

    public Arvore(int conteudo){
        raiz = new No(conteudo);
    }

    public boolean estaVazia(){
        if(raiz == null){
            return true;
        }else {
            return false;
        }
    }
    public void inserirConteudoOtimizado(int conteudo){
        No novoNo = new No(conteudo);
        this.raiz = inserirRecursivoOtimizado(this.raiz, novoNo);
    }
    public No inserirRecursivoOtimizado(No aux, No novoNo){
        if(aux == null){
            return novoNo;
        } else if (novoNo.getConteudo()>aux.getConteudo()) {
            aux.setDireita(inserirRecursivoOtimizado(aux.getDireita(),novoNo));
        }else{
            aux.setEsquerda(inserirRecursivoOtimizado(aux.getEsquerda(),novoNo));
        }
        return aux;
    }
    public void visualizar(){
        System.out.println("Pre Ordem");
        preOrdem(this.raiz);
        System.out.println("Em Ordem");
        emOrdem(this.raiz);
        System.out.println("Pós Ordem");
        posOrdem(this.raiz);
    }
    public void preOrdem(No no){
        if(no == null){
            return;
        }
        System.out.println(no.getConteudo());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }
    public void emOrdem(No no){
        if(no == null){
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getDireita());
    }
    public void posOrdem(No no) {
        if (no == null) {
        return;
        }
            posOrdem(no.getEsquerda());
            posOrdem(no.getDireita());
            System.out.println(no.getConteudo());
    }

    public void remover(int conteudo){
        this.raiz = removerRecursivoOtimizado(this.raiz, conteudo);
    }

    private No removerRecursivoOtimizado(No no, int conteudo){
        if (no == null){
            return null;
        }

        if (conteudo<no.getConteudo()){
            no.setEsquerda(removerRecursivoOtimizado(no.getEsquerda(), conteudo));
        }//menor

        else if (conteudo>no.getConteudo()){
            no.setDireita(removerRecursivoOtimizado(no.getDireita(), conteudo));
        }//maior

        else{
            if (no.getEsquerda() == null && no.getDireita() == null){
                return null;
            }//se não tiver filhos

            else if (no.getEsquerda() == null){
                return no.getDireita();
            }//se não tiver filho à esquerda

            else if (no.getDireita() == null){
                return no.getEsquerda();
            }

            else {
                No sucessor = encontrarMenor(no.getDireita());

                no.setConteudo(sucessor.getConteudo());

                no.setDireita(removerRecursivoOtimizado(no.getDireita(), sucessor.getConteudo()));
            }
        }
        return no;
    }

    public No encontrarMenor(No no) {

        while (no.getEsquerda() != null) {
            no = no.getEsquerda();
        }
        return no;

    }
}

