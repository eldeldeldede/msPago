package cl.duoc.mspago.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.mspago.model.Pago;
@Repository
public interface PagoRepository extends JpaRepository<Pago,Integer >{



}
