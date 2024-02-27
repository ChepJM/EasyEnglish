package prom.it.entity;

import jakarta.persistence.*;
import prom.it.entity.security.User;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vocabularies")
public class Vocabulary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "vocabulary")
    private Set<Word> words = new HashSet<>();

}
