package prom.it.entity;

import jakarta.persistence.*;
import prom.it.entity.security.Role;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "words")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "complexity")
    private String complexity;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "word_vocabulary",
            joinColumns = @JoinColumn(name = "word_id"),
            inverseJoinColumns = @JoinColumn(name = "vocabulary_id"))
    private Set<Vocabulary> vocabularies = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComplexity() {
        return complexity;
    }

    public void setComplexity(String complexity) {
        this.complexity = complexity;
    }

    public Set<Vocabulary> getVocabularies() {
        return vocabularies;
    }

    public void setVocabularies(Set<Vocabulary> vocabularies) {
        this.vocabularies = vocabularies;
    }
}
