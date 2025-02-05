package aula03fevereiro;

import java.util.ArrayList;
import java.util.Objects;

public class BlocoDeNotas {
    private ArrayList<Anotacao> blocoDeNotas;
    private ArrayList<Anotacao> notasRecuperadasPorTexto;
    private ArrayList<Anotacao> blocoDeNotasNaoDeletadas;

    public BlocoDeNotas() {
        this.blocoDeNotas = new ArrayList<Anotacao>();
        this.notasRecuperadasPorTexto = new ArrayList<Anotacao>();
        this.blocoDeNotasNaoDeletadas = new ArrayList<Anotacao>();
    }

    public Anotacao adicionarAnotacao(Anotacao nota) {
        blocoDeNotas.add(nota);
        return nota;
    }

    public Anotacao editarAnotacao(int ID, String texto) {
        Anotacao nota = blocoDeNotas.get(ID);
        nota.setTexto(texto);
        return nota;
    }

    public ArrayList recuperarPorTexto(String buscaStr) {
        for (int i = 0; i < blocoDeNotas.size(); i++) {
            Anotacao texto = blocoDeNotas.get(i);
            if (texto.contemTexto(buscaStr)) {
                notasRecuperadasPorTexto.add(texto);
            }
        }
        return notasRecuperadasPorTexto;
    }

    public ArrayList<Anotacao> listar() {
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
                ", notasRecuperadasPorTexto=" + notasRecuperadasPorTexto +
                ", blocoDeNotasNaoDeletadas=" + blocoDeNotasNaoDeletadas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BlocoDeNotas that = (BlocoDeNotas) o;
        return Objects.equals(blocoDeNotas, that.blocoDeNotas) && Objects.equals(notasRecuperadasPorTexto, that.notasRecuperadasPorTexto) && Objects.equals(blocoDeNotasNaoDeletadas, that.blocoDeNotasNaoDeletadas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blocoDeNotas, notasRecuperadasPorTexto, blocoDeNotasNaoDeletadas);
    }
}
