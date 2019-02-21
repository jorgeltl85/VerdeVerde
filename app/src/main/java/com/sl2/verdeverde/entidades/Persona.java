package com.sl2.verdeverde.entidades;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "Persona")
public class Persona {
    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "NOMBRE")
    @NotNull
    private String nombre;

    @Property(nameInDb = "APELLIDO")
    private String apellido;

    @Property(nameInDb = "DIRECCION")
    private String direccion;

    @Transient
    private int contadorDeUsoPersonas; // not persisted

    @Property(nameInDb = "CREACION")
    private String creacion;

    @Property(nameInDb = "ACTUALIZACION")
    private String actualizacion;

    @Generated(hash = 1936356546)
    public Persona(Long id, @NotNull String nombre, String apellido,
            String direccion, String creacion, String actualizacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.creacion = creacion;
        this.actualizacion = actualizacion;
    }

    @Generated(hash = 1270265349)
    public Persona() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCreacion() {
        return this.creacion;
    }

    public void setCreacion(String creacion) {
        this.creacion = creacion;
    }

    public String getActualizacion() {
        return this.actualizacion;
    }

    public void setActualizacion(String actualizacion) {
        this.actualizacion = actualizacion;
    }
}
