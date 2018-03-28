package io.github.rafaelsakurai.zemeto;

import java.util.Date;

/**
 * Created by rafaelsakurai on 20/03/2018.
 */

public class Problema {
    private Long id;
    private String descricao;
    private Date data;
    private boolean arrumado;

    public Problema(String descricao, Date data) {
        this.descricao = descricao;
        this.data = data;
        this.arrumado = false;
    }

    public Problema(Long id, String descricao, Date data) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.arrumado = false;
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

    public boolean isArrumado() {
        return arrumado;
    }

    public void setArrumado(boolean arrumado) {
        this.arrumado = arrumado;
    }

    @Override
    public String toString() {
        return "Problema{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                ", arrumado=" + arrumado +
                '}';
    }
}
