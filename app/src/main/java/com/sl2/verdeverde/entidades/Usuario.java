package com.sl2.verdeverde.entidades;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "Usuario")
public class Usuario {
    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "NOMBRE")
    private String nombre;

    @Property(nameInDb = "DESCRIPCION")
    private String descripcion;

    @NotNull
    private String email;

    @Property(nameInDb = "USUARIO")
    @Index(unique = true)
    private String usuario;

    @Property(nameInDb = "CLAVE")
    private String clave;

    @Transient
    private int contadorDeUsoUsuarios; // not persisted

    @Property(nameInDb = "CREACION")
    private String creacion;

    @Property(nameInDb = "ACTUALIZACION")
    private String actualizacion;

    @Generated(hash = 662341584)
    public Usuario(Long id, String nombre, String descripcion,
            @NotNull String email, String usuario, String clave, String creacion,
            String actualizacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.email = email;
        this.usuario = usuario;
        this.clave = clave;
        this.creacion = creacion;
        this.actualizacion = actualizacion;
    }

    @Generated(hash = 562950751)
    public Usuario() {
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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
