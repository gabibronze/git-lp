package aula03fevereiro;

import java.util.ArrayList;

public class BlocoDeNotas {
    private ArrayList<Anotacao> blocoDeNotas;

    public BlocoDeNotas() {
        this.blocoDeNotas = new ArrayList<Anotacao>();
    }

    public Anotacao adicionarAnotacao(Anotacao nota) {
        blocoDeNotas.add(nota);
        return nota;
    }

    public Anotacao adicionarAnotacao(String texto){
        Anotacao anotacaoParaAdicionar = new Anotacao(texto);
        blocoDeNotas.add(anotacaoParaAdicionar);
        return anotacaoParaAdicionar;
    }

    public Anotacao editarAnotacao(int ID, String texto) throws Exception{
        if (ID < 1) {
            throw new Exception("A anotação " + ID + " não existe. Insira um número maior que 0.");
        }
        else if (ID > blocoDeNotas.size()) {
            throw new Exception("A anotação " + ID + " não existe. Insira um número menor ou igual ao número de anotações criadas.");
        }
        Anotacao nota = blocoDeNotas.get(ID);
        nota.setTexto(texto);
        return nota;
    }

    public ArrayList recuperarPorTexto(String buscaStr) throws Exception {
        ArrayList<Anotacao> notasRecuperadasPorTexto = new ArrayList<>();
        for (int i = 0; i < blocoDeNotas.size(); i++) {
            Anotacao texto = blocoDeNotas.get(i);
            if (texto.contemTexto(buscaStr)) {
                notasRecuperadasPorTexto.add(texto);
            }
        }

        return notasRecuperadasPorTexto;
    }

    public Anotacao recuperarPorID(int ID) throws Exception {
        if (ID < 1) {
            throw new Exception("ID inválido. O ID deve ser maior que 0.");
        }

        for (Anotacao nota : blocoDeNotas) {
            if (nota.getID() == ID) {
                return nota; // Retorna a anotação se o ID corresponder
            }
        }

        throw new Exception("Anotação com ID " + ID + " não encontrada.");
    }

    public ArrayList<Anotacao> listar() {
        ArrayList<Anotacao> blocoDeNotasNaoDeletadas = new ArrayList<Anotacao>();
        for (int i = 0; i < blocoDeNotas.size(); i++) {
            Anotacao nota = blocoDeNotas.get(i);
            if (!nota.isDeletado()) {
                blocoDeNotasNaoDeletadas.add(nota);
            }
        }
        return blocoDeNotasNaoDeletadas;
    }

    public void deletarAnotacao(int ID) throws Exception {
        if (ID < 1) {
            throw new Exception("ID inválido. O ID deve ser maior que 0.");
        }
        for (int i = 0; i < blocoDeNotas.size(); i++) {
            Anotacao nota = blocoDeNotas.get(i); //Obtém a anotação na posição i
            if (nota.getID() == ID) {
                nota.deleta(); //Marca a anotação como deletada
                System.out.println("A anotação com ID " + ID + " foi deletada.");
                return;
            }
        }
        throw new Exception("Anotação com ID " + ID + " não encontrada.");
    }

    @Override
    public String toString() {
        return "BlocoDeNotas{" +
                "blocoDeNotas=" + blocoDeNotas +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
