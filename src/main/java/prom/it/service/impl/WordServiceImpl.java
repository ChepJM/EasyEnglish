package prom.it.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prom.it.entity.Word;
import prom.it.repository.WordRepository;
import prom.it.service.WordService;

import java.util.List;
import java.util.Optional;

@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private WordRepository wordRepository;

    @Override
    public Word addWord(Word word) {
        return wordRepository.saveAndFlush(word);
    }

    @Override
    public Boolean deleteWord(Long id) {
        try {
            wordRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Word getById(Long id) {
        Optional<Word> word = wordRepository.findById(id);
        return word.orElseGet(Word::new);
    }

    @Override
    public Word updateWord(Word word) {
        return wordRepository.saveAndFlush(word);
    }

    @Override
    public List<Word> getAll() {
        return wordRepository.findAll();
    }
}
