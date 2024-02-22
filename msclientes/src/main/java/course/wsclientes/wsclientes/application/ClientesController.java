package course.wsclientes.wsclientes.application;

import course.wsclientes.wsclientes.application.representation.ClienteSaveRequest;
import course.wsclientes.wsclientes.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.logging.Logger;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
@Slf4j
public class ClientesController {

    private final ClienteService service;
    @GetMapping
    public String status(){
        log.info("Obtendo o status do microservice de cliente");
        return "ok";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ClienteSaveRequest request){
        Cliente clientes = request.toModel();
        service.save(clientes);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(clientes.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity dadosCliente(@RequestParam("cpf") String cpf){
        var clientes = service.getByCPF(cpf);
        System.out.println(clientes);
        if (clientes.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientes);
    }

}
