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

    public boolean contemTexto(String texto){
        return this.texto.contains(texto);
    }

    public int getID(int ID){
        return ID;
    }

    public String getTexto(String texto){
        return texto;
    }

    public String setTexto(String texto){
        return texto;
    }

    public LocalDate getDataDeCriacao() {
        return dataDeCriacao;
    }

    public boolean isDeletado() {
        return this.deletado;
    }

    public boolean deleta(){
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
