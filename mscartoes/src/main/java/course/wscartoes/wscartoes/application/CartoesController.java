package course.wscartoes.wscartoes.application;

import course.wscartoes.wscartoes.application.dto.CartaoSaveRequest;
import course.wscartoes.wscartoes.application.dto.CartoesPorClienteResponse;
import course.wscartoes.wscartoes.domain.Cartao;
import course.wscartoes.wscartoes.domain.ClienteCartao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cartoes")
@RequiredArgsConstructor
public class CartoesController {

    private final CartaoService cartaoService;
    private final ClienteCartaoService clienteCartaoService;


    @GetMapping
    public String status(){
        return "okk";
    }

    @PostMapping
    public ResponseEntity cadastrar( @RequestBody CartaoSaveRequest request ){
        Cartao cartao = request.toModel();
        cartaoService.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartoesRendaAteh(@RequestParam("renda") Long renda){
        List<Cartao> list = cartaoService.getcartoesRendaMenorOuIguals(renda);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesPorClienteResponse>> getCartoesByCliente(@RequestParam("cpf") String cpf){
        List<ClienteCartao> lista = clienteCartaoService.listCartoes(cpf);
        List<CartoesPorClienteResponse> resultList = lista.stream().
                map(CartoesPorClienteResponse::fromModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resultList);
    }
}
