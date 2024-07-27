package com.example.Empregados;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Empregado {
    @Id
    @SequenceGenerator(
            name = "empregado_sequence",
            sequenceName = "empregado_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "empregado_sequence"
    )

    private Long id;
    private String nome;
    private String email;
    private float salario;
    private LocalDate dob;



    public Empregado(){}


    public Empregado(Long id, String nome, String email, float salario, LocalDate dob) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.salario = salario;
        this.dob = dob;
    }

    public Empregado(String nome, String email, float salario, LocalDate dob) {
        this.nome = nome;
        this.email = email;
        this.salario = salario;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public float getSalario() {
        return salario;
    }
    public void setSalario(float salario) {
        this.salario = salario;
    }
    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getAge(){
        return Period.between(dob, LocalDate.now()).getYears();
    }
}
