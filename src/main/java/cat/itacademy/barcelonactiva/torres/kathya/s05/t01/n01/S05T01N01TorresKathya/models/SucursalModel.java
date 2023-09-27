package cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n01.S05T01N01TorresKathya.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

 @Entity
 @Getter
 @Setter
 @Table(name = "sucursal")
public class SucursalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk_SucursalID;
    private String nameSucursal;
    private String paisSucursal;
    private String TipoSucursal;

}
