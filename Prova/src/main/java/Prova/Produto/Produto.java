package Prova.Produto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {
    @Id
    @GeneratedValue (
            strategy = GenerationType.IDENTITY
    )
    private long id;
    private String nome;
    private double preco;

    public long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public void setPreco(final double preco) {
        this.preco = preco;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Produto)) {
            return false;
        } else {
            Produto other = (Produto)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getId() != other.getId()) {
                return false;
            } else if (Double.compare(this.getPreco(), other.getPreco()) != 0) {
                return false;
            } else {
                Object this$nome = this.getNome();
                Object other$nome = other.getNome();
                if (this$nome == null) {
                    if (other$nome == null) {
                        return true;
                    }
                } else if (this$nome.equals(other$nome)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Produto;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        long $id = this.getId();
        result = result * 59 + (int)($id >>> 32 ^ $id);
        long $preco = Double.doubleToLongBits(this.getPreco());
        result = result * 59 + (int)($preco >>> 32 ^ $preco);
        Object $nome = this.getNome();
        result = result * 59 + ($nome == null ? 43 : $nome.hashCode());
        return result;
    }

    public String toString() {
        long var10000 = this.getId();
        return "Produto(id=" + var10000 + ", nome=" + this.getNome() + ", preco=" + this.getPreco() + ")";
    }

    public Produto() {
    }

    public Produto(final long id, final String nome, final double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }
}
