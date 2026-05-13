package cl.duoc.mspago.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.duoc.mspago.dto.ArriendoDTO;

@FeignClient(name = "msArriendo", url = "http://localhost:8084")
public interface ArriendoClient {

    @GetMapping("api/v1/arriendos/dto/{id}")
    ArriendoDTO buscarDTO(@PathVariable("id") Integer id);

}
