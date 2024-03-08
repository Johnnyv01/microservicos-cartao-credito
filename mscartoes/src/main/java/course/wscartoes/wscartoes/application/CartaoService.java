package course.wscartoes.wscartoes.application;

import course.wscartoes.wscartoes.domain.Cartao;
import course.wscartoes.wscartoes.infra.repository.CartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartaoService {

    private final CartaoRepository repository;

    @Transactional

    public Cartao save(Cartao cartao){
        return repository.save(cartao);
    }

    public List<Cartao> getcartoesRendaMenorOuIguals(Long renda){
        var rendas = BigDecimal.valueOf(renda);
        return repository.findByRendaLessThanEqual(rendas);
    }
}
