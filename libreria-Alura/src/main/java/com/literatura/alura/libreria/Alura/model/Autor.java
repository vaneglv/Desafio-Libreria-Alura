package com.literatura.alura.libreria.Alura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long autorId;
    private String nombre;
    private Integer fechaNacimiento;
    private Integer fechaFallecimiento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    private List<Libro> libros;

    public Autor() {
    }

    public Autor(DatosAutor datosAutor){
        this.nombre = datosAutor.nombre();
        this.fechaNacimiento = datosAutor.nacimiento();
        this.fechaFallecimiento = datosAutor.muerte();
    }

    public Long getAutor_id() {
        return autorId;
    }

    public void setAutor_id(Long autor_id) {
        this.autorId = autor_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFecha_Nacimiento() {
        return fechaNacimiento;
    }

    public void setFecha_Nacimiento(Integer fecha_Nacimiento) {
        this.fechaNacimiento = fecha_Nacimiento;
    }

    public Integer getFecha_Fallecimiento() {
        return fechaFallecimiento;
    }

    public void setFecha_Fallecimiento(Integer fecha_Fallecimiento) {
        this.fechaFallecimiento = fecha_Fallecimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        libros.forEach(l-> l.setAutor(this));
        this.libros = libros;
    }

    @Override
    public String toString() {
        return " \n"+
                "----- Autor -----\n" +
                "Nombre: " + nombre + "\n" +
                "Fecha de nacimiento: " + fechaNacimiento + "\n" +
                "Fecha de fallecimiento: " + fechaFallecimiento + "\n" +
                "libros: " + libros.stream().map(Libro::getTitulo).collect(Collectors.toList()) + "\n" +
                "--------------------";
    }
}