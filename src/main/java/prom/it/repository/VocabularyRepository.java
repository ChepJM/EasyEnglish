package prom.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prom.it.entity.Vocabulary;

public interface VocabularyRepository extends JpaRepository<Vocabulary, Long> {
}
