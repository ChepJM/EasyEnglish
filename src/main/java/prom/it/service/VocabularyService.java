package prom.it.service;

import prom.it.entity.Vocabulary;

import java.util.List;

public interface VocabularyService {

    Vocabulary addVocabulary(Vocabulary vocabulary);
    Boolean deleteVocabulary(Long id);
    Vocabulary getById(Long id);
    Vocabulary updateVocabulary(Vocabulary vocabulary);
    List<Vocabulary> getAll();

}
