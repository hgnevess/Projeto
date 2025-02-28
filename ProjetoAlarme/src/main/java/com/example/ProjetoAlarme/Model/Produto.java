package com.example.ProjetoAlarme.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Produto")
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "Descricao")
    private String descricao;

    @Column(name = "Preco")
    private double preco;
}
