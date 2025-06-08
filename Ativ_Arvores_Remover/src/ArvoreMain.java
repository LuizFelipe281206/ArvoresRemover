public class ArvoreMain {
    public static void main(String[] args) {
        Arvore arvore = new Arvore(59);
        arvore.inserirConteudoOtimizado(90);
        arvore.inserirConteudoOtimizado(10);
        arvore.inserirConteudoOtimizado(58);
        arvore.inserirConteudoOtimizado(-10);
        arvore.visualizar();

        arvore.remover(10);

        arvore.visualizar();
    }
}
