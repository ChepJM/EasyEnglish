package prom.it.service;

import prom.it.entity.Word;

import java.util.List;

public interface WordService {

    Word addWord(Word word);
    Boolean deleteWord(Long id);
    Word getById(Long id);
    Word updateWord(Word word);
    List<Word> getAll();

}
