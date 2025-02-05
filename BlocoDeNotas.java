package aula03fevereiro;

import java.util.ArrayList;
import java.util.Objects;

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

    public Anotacao editarAnotacao(int ID, String texto) {
        Anotacao nota = blocoDeNotas.get(ID);
        nota.setTexto(texto);
        return nota;
    }

    public ArrayList recuperarPorTexto(String buscaStr) {
        ArrayList<Anotacao> notasRecuperadasPorTexto = new ArrayList<>();
        for (int i = 0; i < blocoDeNotas.size(); i++) {
            Anotacao texto = blocoDeNotas.get(i);
            if (texto.contemTexto(buscaStr)) {
                notasRecuperadasPorTexto.add(texto);
            }
        }
        return notasRecuperadasPorTexto;
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
