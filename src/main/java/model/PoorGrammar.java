package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "poor_grammar", schema = "image", catalog = "")
public class PoorGrammar {
    private int id;
    private String word;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "word", nullable = false, length = 100)
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PoorGrammar that = (PoorGrammar) o;
        return id == that.id &&
                Objects.equals(word, that.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, word);
    }

}
