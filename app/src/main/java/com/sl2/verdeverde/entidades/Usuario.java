package com.sl2.verdeverde.entidades;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;

@Entity
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
    private int tempContadorDeUso; // not persisted

    // getters and setters for id and user ...
}
