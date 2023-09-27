package cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n01.S05T01N01TorresKathya.DTO;


import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class SucursalDTO {
    private long pk_SucursalID;
    private String nameSucursal;
    private String paisSucursal;
    private String TipoSucursal;

    private static final List<String> paisesUE = Arrays.asList(
            "Alemania", "Austria", "Bélgica", "Bulgaria", "Chipre", "Croacia", "Dinamarca",
            "Eslovaquia", "Eslovenia", "España", "Estonia", "Finlandia", "Francia", "Grecia",
            "Hungría", "Irlanda", "Italia", "Letonia", "Lituania", "Luxemburgo", "Malta",
            "Países Bajos", "Polonia", "Portugal", "República Checa", "Rumanía", "Suecia"
    );

    public void determinarTipusSucursal() {
        this.TipoSucursal = paisesUE.contains(this.paisSucursal) ? "UE" : "Fuera UE";
    }
}
