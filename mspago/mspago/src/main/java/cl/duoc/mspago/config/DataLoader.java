package cl.duoc.mspago.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cl.duoc.mspago.model.Comprobante;
import cl.duoc.mspago.model.Metodo_pago;
import cl.duoc.mspago.model.Pago;
import cl.duoc.mspago.repository.ComprobanteRepository;
import cl.duoc.mspago.repository.MetodoPagoRepository;
import cl.duoc.mspago.repository.PagoRepository;

@Configuration
public class DataLoader {


    @Bean
    CommandLineRunner initDataBase(PagoRepository pagoRepository, ComprobanteRepository comprobanteRepository,
                                    MetodoPagoRepository metodoPagoRepository
    ){

    return args -> {
        if(pagoRepository.count() > 0 && comprobanteRepository.count() > 0 && metodoPagoRepository.count() > 0){
            System.out.println("Datos ya cargador");
        }else{


                Metodo_pago metodo1 = new Metodo_pago(null,"Tarjeta de Crédito");

                Metodo_pago metodo2 = new Metodo_pago(null,"Transferencia");

                Metodo_pago metodo3 = new Metodo_pago(null,"Efectivo");

                metodoPagoRepository.save(metodo1);
                metodoPagoRepository.save(metodo2);
                metodoPagoRepository.save(metodo3);

                Pago pago1 = new Pago(null,150000,"Pagado",1,1,metodo1,null);

                Pago pago2 = new Pago(null,90000,"Pendiente",2,2,metodo2,null);

                Pago pago3 = new Pago(null,200000,"Pagado",3,3,metodo3,null);

                pagoRepository.save(pago1);
                pagoRepository.save(pago2);
                pagoRepository.save(pago3);

                Comprobante comprobante1 = new Comprobante(null,"Pago realizado correctamente",new java.util.Date(),150000,1001,pago1);

                Comprobante comprobante2 = new Comprobante(null,"Pago pendiente de confirmación",new java.util.Date(),90000,1002,pago2);

                Comprobante comprobante3 = new Comprobante(null,"Pago recibido en efectivo",new java.util.Date(),200000,1003,pago3);

                comprobanteRepository.save(comprobante1);
                comprobanteRepository.save(comprobante2);
                comprobanteRepository.save(comprobante3);

                System.out.println("Datos cargados correctamente");
            }
        };
    }
}
