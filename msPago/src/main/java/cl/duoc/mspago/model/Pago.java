package cl.duoc.mspago.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pago")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer monto;

    @Column(nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "metodo_id",nullable = false)
    @JsonBackReference
    private Metodo_pago metodoPago;

    @ManyToOne
    @JoinColumn(name = "comprobante_id",nullable = false)
    @JsonBackReference
    private Comprobante comprobante;

}
