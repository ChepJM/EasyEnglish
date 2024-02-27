package prom.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import prom.it.service.impl.WordServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/profession")
public class WordController {

    @Autowired
    private WordServiceImpl professionService;

    /**
     * Returns list of all professions
     *
     * @return List<Profession>
     */
    @GetMapping
    public List<Profession> getProfessions() {
        return professionService.getAll();
    }

    /**
     * Add new profession
     *
     * @param profession new object
     * @return Profession
     */
    @PostMapping
    public Profession addProfession(@RequestBody Profession profession) {
        return professionService.addProfession(profession);
    }

    /**
     * Returns specified profession
     *
     * @param id unique identifier of profession
     * @return Profession
     */
    @GetMapping(params = "id")
    public Profession getProfession(@RequestParam String id) {
        return professionService.getById(Long.valueOf(id));
    }

    /**
     * Update specified profession
     *
     * @param profession object with edited values
     * @return Profession
     */
    @PatchMapping
    public Profession updateProfession(@RequestBody Profession profession) {
        return professionService.updateProfession(profession);
    }

    /**
     * Delete specified profession
     *
     * @param id unique identifier of profession
     * @return true in case of success, otherwise false
     */
    @DeleteMapping
    public Boolean deleteProfession(@RequestParam String id) {
        return professionService.deleteProfession(Long.valueOf(id));
    }
}
