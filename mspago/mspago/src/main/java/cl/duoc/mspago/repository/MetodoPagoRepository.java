package cl.duoc.mspago.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.mspago.model.Metodo_pago;
@Repository
public interface MetodoPagoRepository extends JpaRepository<Metodo_pago, Integer>{


}
