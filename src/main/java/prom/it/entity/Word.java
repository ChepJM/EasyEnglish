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
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Vocabulary> vocabularies = new HashSet<>();
}
