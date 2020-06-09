package service.impl;

import model.PoorGrammar;
import org.springframework.beans.factory.annotation.Autowired;
import repository.PoorGrammarRepository;
import service.PoorGrammarService;

import java.util.List;

public class PoorGrammarServiceImpl implements PoorGrammarService {

    @Autowired
    private PoorGrammarRepository poorGrammarRepository;

    @Override
    public List<PoorGrammar> findAll() {
        return poorGrammarRepository.findAll();
    }
}
