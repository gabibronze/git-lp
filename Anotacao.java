package aula03fevereiro;

import java.time.LocalDate;
import java.util.Objects;

public class Anotacao {
    private String texto;
    private int ID;
    private LocalDate dataDeCriacao;
    private boolean deletado;
    private static int contador = 1;

    public Anotacao(String texto){
        this.texto = texto;
        this.ID = contador++;
        this.dataDeCriacao = LocalDate.now();
        this.deletado = false;
    }

    public boolean contemTexto(String texto) throws Exception {
        if (this.deletado){
            throw new Exception("A anotação foi deletada e não pode ser acessada");
        }
        return this.texto.contains(texto);
    }

    public int getID() throws Exception {
        if (this.deletado){
            throw new Exception("A anotação foi deletada e não pode ser acessada.");
        }
        return this.ID;
    }

    public String getTexto() throws Exception {
        if (this.deletado){
            throw new Exception("A anotação foi deletada e não pode ser acessada.");
        }
        return this.texto;
    }

    public String setTexto(String texto) throws Exception {
        if (this.deletado){
            throw new Exception("A anotação foi deletada e não pode ser acessada.");
        }
        return texto;
    }

    public LocalDate getDataDeCriacao() {
        return dataDeCriacao;
    }

    public boolean isDeletado() {
        return this.deletado;
    }

    public boolean deleta() throws Exception {
        if (this.deletado){
            throw new Exception("A anotação já foi deletada");
        }
        return this.deletado = true;
    }

    @Override
    public String toString() {
        return "Anotacao {" +
                " texto: '" + texto +
                "' | ID: " + ID +
                " | Data: " + dataDeCriacao +
                " | Deletado: " + deletado + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Anotacao anotacao = (Anotacao) o;
        return ID == anotacao.ID && deletado == anotacao.deletado && Objects.equals(texto, anotacao.texto) && Objects.equals(dataDeCriacao, anotacao.dataDeCriacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(texto, ID, dataDeCriacao, deletado);
    }
}
