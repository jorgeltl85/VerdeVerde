package com.sl2.verdeverde.entidades;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "Entidad")
public class Entidad {
    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "NOMBRE")
    @NotNull
    private String nombre;

    @Property(nameInDb = "DESCRIPCION")
    private String descripcion;

    @Property(nameInDb = "RUC")
    private String ruc;

    @Transient
    private int contadorDeUsoEntidades; // not persisted

    @Property(nameInDb = "CREACION")
    private String creacion;

    @Property(nameInDb = "ACTUALIZACION")
    private String actualizacion;

    @Generated(hash = 1779145540)
    public Entidad(Long id, @NotNull String nombre, String descripcion, String ruc,
            String creacion, String actualizacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ruc = ruc;
        this.creacion = creacion;
        this.actualizacion = actualizacion;
    }

    @Generated(hash = 1797158407)
    public Entidad() {
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

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRuc() {
        return this.ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
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
