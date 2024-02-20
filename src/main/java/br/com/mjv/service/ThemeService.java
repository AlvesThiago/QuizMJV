package br.com.mjv.service;

import br.com.mjv.model.Theme;
import br.com.mjv.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeService {

    @Autowired
    private ThemeRepository temaRepository;

    public Theme onSalvar(Theme theme){
        return temaRepository.save(theme);
    }

    public void onDeletar(Theme theme){
        temaRepository.delete(theme);
    }

    public List<Theme> onListTema(){
        return temaRepository.findAll();
    }

    public Optional<Theme> buscarTema(Long id){
        return temaRepository.findById(id);
    }
}
