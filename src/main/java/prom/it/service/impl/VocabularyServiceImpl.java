package prom.it.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prom.it.entity.Vocabulary;
import prom.it.repository.VocabularyRepository;
import prom.it.repository.WordRepository;
import prom.it.service.VocabularyService;

import java.util.List;
import java.util.Optional;

@Service
public class VocabularyServiceImpl implements VocabularyService {

    @Autowired
    private VocabularyRepository vocabularyRepository;

    @Override
    public Vocabulary addVocabulary(Vocabulary vocabulary) {
        return vocabularyRepository.saveAndFlush(vocabulary);
    }

    @Override
    public Boolean deleteVocabulary(Long id) {
        try {
            vocabularyRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Vocabulary getById(Long id) {
        Optional<Vocabulary> employee = vocabularyRepository.findById(id);
        return employee.orElseGet(Vocabulary::new);
    }

    @Override
    public Vocabulary updateVocabulary(Vocabulary vocabulary) {
        return vocabularyRepository.saveAndFlush(vocabulary);
    }

    @Override
    public List<Vocabulary> getAll() {
        return vocabularyRepository.findAll();
    }
}
