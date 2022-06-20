package br.com.frota.model;

public class MarcaPneu extends GenericModel {
    private String descricao;

    public MarcaPneu(String descricao) {
        this.descricao = descricao;
    }

    public MarcaPneu(Integer id, String descricao) {
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
