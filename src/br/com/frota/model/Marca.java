package br.com.frota.model;

public class Marca extends GenericModel {
    private String descricao;

    public Marca(String descricao) {
        this.descricao = descricao;
    }

    public Marca(Integer id, String descricao) {
        this.descricao = descricao;
        super.setId(id);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Marca {" +
                "id='" + this.getId() + "\'" +
                "descricao='" + descricao + "\'" +
                '}';
    }
}
