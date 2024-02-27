package prom.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prom.it.entity.Word;

public interface WordRepository extends JpaRepository<Word, Long> {
}
