package cl.duoc.mspago.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.mspago.model.Comprobante;
@Repository
public interface ComprobanteRepository extends JpaRepository<Comprobante, Integer>{

    Optional<Comprobante> findbyPagoId(Integer id);

}
