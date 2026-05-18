package cl.duoc.mspago.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.mspago.client.ArriendoClient;
import cl.duoc.mspago.client.ClienteClient;

import cl.duoc.mspago.model.Pago;
import cl.duoc.mspago.repository.PagoRepository;

@Service
public class PagoService {

    @Autowired
    private PagoRepository repo;

    @Autowired
    private ClienteClient clienteCliente;

    @Autowired
    private ArriendoClient arriendoClient;

    public List<Pago> listar(){
        return repo.findAll();
    }

    public Pago guardar(Pago pago){
        if(pago.getMetodoPago() != null){
            pago.getMetodoPago().setPago(pago);
        }
        
        if(pago.getComprobante() != null){
            pago.getComprobante().setPago(pago);
        }

        
        return repo.save(pago);
    }

    public Pago buscarPorId(Integer id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException("pago no encontrado"));
    }

    public void eliminar(Integer id){
        if(repo.existsById(id)){
            repo.deleteById(id);
        }else{
            throw new RuntimeException("pago no encontrado");
        }
    }

    public Pago actualizar(Integer id, Pago pagoActualizar){
        Pago pago = repo.findById(id).orElseThrow(() -> new RuntimeException("pago no encontrado"));
        pago.setMonto(pagoActualizar.getMonto());    
        pago.setEstado(pagoActualizar.getEstado());
        
        if(pagoActualizar.getMetodoPago()!= null){
            pago.getMetodoPago().setPago(pago);
            pago.setMetodoPago(pagoActualizar.getMetodoPago());
        }

        if(pagoActualizar.getComprobante() != null){
            pago.getComprobante().setPago(pago);
            pago.setComprobante(pagoActualizar.getComprobante());
        }

        return repo.save(pago);
    }

    //public PagoDTO obtenerDetallePago(Integer id){
    //    Pago pago = repo.findById(id).orElseThrow(() -> new RuntimeException("pago no encontrado"));
        
    //    ClienteDTO cliente = cliente.buscarDTO(id);

    //    if(cliente.isEmpty != null){
            
    
    //}

}
