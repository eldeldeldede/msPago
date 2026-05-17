package cl.duoc.mspago.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Metodo_pagoDTO {

    private Integer id;
    private String nombre; //transeferencia, tarjeta o efectivo
    

}
