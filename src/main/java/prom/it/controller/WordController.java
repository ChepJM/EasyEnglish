package prom.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import prom.it.entity.Word;
import prom.it.service.impl.WordServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/word")
public class WordController {

    @Autowired
    private WordServiceImpl wordService;

    /**
     * Returns list of all words
     *
     * @return List<Word>
     */
    @GetMapping
    public List<Word> getWords() {
        return wordService.getAll();
    }

    /**
     * Add new word
     *
     * @param word new object
     * @return Word
     */
    @PostMapping
    public Word addWord(@RequestBody Word word) {
        return wordService.addWord(word);
    }

    /**
     * Returns specified word
     *
     * @param id unique identifier of word
     * @return Word
     */
    @GetMapping(params = "id")
    public Word getWord(@RequestParam String id) {
        return wordService.getById(Long.valueOf(id));
    }

    /**
     * Update specified word
     *
     * @param word object with edited values
     * @return Word
     */
    @PatchMapping
    public Word updateWord(@RequestBody Word word) {
        return wordService.updateWord(word);
    }

    /**
     * Delete specified word
     *
     * @param id unique identifier of word
     * @return true in case of success, otherwise false
     */
    @DeleteMapping
    public Boolean deleteWord(@RequestParam String id) {
        return wordService.deleteWord(Long.valueOf(id));
    }
}
