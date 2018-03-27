package io.github.rafaelsakurai.zemeto;

import java.util.Date;

/**
 * Created by rafaelsakurai on 20/03/2018.
 */

public class Problema {
    private Long id;
    private String descricao;
    private Date data;

    public Problema(String descricao, Date data) {
        this.descricao = descricao;
        this.data = data;
    }

    public Problema(Long id, String descricao, Date data) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
