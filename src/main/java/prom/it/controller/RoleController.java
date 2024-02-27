package prom.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import prom.it.entity.Vocabulary;
import prom.it.service.VocabularyService;

import java.util.List;

@RestController
@RequestMapping("/api/vocabulary")
public class RoleController {

    @Autowired
    private VocabularyService vocabularyService;

    /**
     * Returns list of all vocabularies
     *
     * @return List<Vocabulary>
     */
    @GetMapping
    public List<Vocabulary> getVocabularies() {
        return vocabularyService.getAll();
    }

    /**
     * Add new vocabulary
     *
     * @param vocabulary new object
     * @return Vocabulary
     */
    @PostMapping
    public Vocabulary addVocabulary(@RequestBody Vocabulary vocabulary) {
        return vocabularyService.addVocabulary(vocabulary);
    }

    /**
     * Returns specified vocabulary
     *
     * @param id unique identifier of vocabulary
     * @return Vocabulary
     */
    @GetMapping(params = "id")
    public Vocabulary getVocabulary(@RequestParam String id) {
        return vocabularyService.getById(Long.valueOf(id));
    }

    /**
     * Update specified Vocabulary
     *
     * @param vocabulary object with edited values
     * @return
     */
    @PatchMapping
    public Vocabulary updateVocabulary(@RequestBody Vocabulary vocabulary) {
        return vocabularyService.updateVocabulary(vocabulary);
    }

    /**
     * Delete specified vocabulary
     *
     * @param id unique identifier of vocabulary
     * @return true in case of success, otherwise false
     */
    @DeleteMapping
    public Boolean deleteVocabulary(@RequestParam String id) {
        return vocabularyService.deleteVocabulary(Long.valueOf(id));
    }
}
