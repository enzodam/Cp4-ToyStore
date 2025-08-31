package com.fiap.lojaDeBrinquedos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table
@Entity
public class Brinquedo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String tipo;
    private String classificacao;
    private Float tamanho;
    private Float preco;

    public void alterar(Brinquedo brinquedo) {
        this.nome = brinquedo.getNome();
        this.tipo = brinquedo.getTipo();
        this.classificacao = brinquedo.getClassificacao();
        this.tamanho = brinquedo.getTamanho();
        this.preco = brinquedo.getPreco();
    }
}
