package course.wscartoes.wscartoes.application;

import course.wscartoes.wscartoes.domain.ClienteCartao;
import course.wscartoes.wscartoes.infra.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {

    private final ClienteCartaoRepository repository;

    public List<ClienteCartao> listCartoes(String cpf){
        return repository.findByCpf(cpf);
    }
}
