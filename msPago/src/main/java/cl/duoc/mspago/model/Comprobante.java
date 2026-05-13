package cl.duoc.mspago.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comprobante")
public class Comprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String informacion;

    @Column(nullable = false)
    private Date fecha_emision;

    @Column(nullable = false)
    private Integer total;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer numero_boleta;

    @OneToOne
    private Pago pago;

}
