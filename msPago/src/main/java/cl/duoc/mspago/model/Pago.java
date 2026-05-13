package cl.duoc.mspago.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
    @OneToMany
    @JoinColumn(name = "metodo_id",nullable = false)
    private Metodo_pago metodoPago;
    @OneToOne
    @JoinColumn(name = "comprobante_id",nullable = false)
    private Comprobante comprobante;

}
