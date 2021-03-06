package max_sk.MyWork.services;

import lombok.RequiredArgsConstructor;
import max_sk.MyWork.model.TovarModel;
import max_sk.MyWork.repositories.TovarRepository;
import max_sk.MyWork.soap.tovars.Tovar;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TovarService {

    private final TovarRepository tovarRepository;

    public static final Function<TovarModel, Tovar> functionEntityToSoap = te -> {
        Tovar g = new Tovar();
        g.setId(te.getId());
        g.setName(te.getName());
        g.getCost(te.getCost());
        return g;
    };

    public List<Tovar> getAllTovar(){
        return tovarRepository.findAll().stream().map(functionEntityToSoap).collect(Collectors.toList());
    }


}
