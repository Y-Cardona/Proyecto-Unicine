package co.edu.uniquindio.unicine.entidades;

import co.edu.uniquindio.unicine.enums.Estado;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Entidad que representa los clientes del sistema
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false, unique = true, length = 10)
    private String cedula;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String correo;

    @Type(type="text")
    private String imgPerfil;

    @Column(nullable = false)
    private Estado estado;

    @OneToOne
    @ToString.Exclude
    private Usuario usuario;

    @OneToMany(mappedBy = "cliente")
    @ToString.Exclude
    private List<Telefono> telefono;

    @ManyToMany(mappedBy = "clientes")
    @ToString.Exclude
    private List<Cupon> cupones;

    @OneToMany(mappedBy = "cliente")
    @ToString.Exclude
    private List<Venta> ventas;

    @Builder
    public Cliente(String cedula, String nombre, String correo, String imgPerfil, Estado estado, Usuario usuario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.imgPerfil = imgPerfil;
        this.estado = estado;
        this.usuario = usuario;
    }
}
