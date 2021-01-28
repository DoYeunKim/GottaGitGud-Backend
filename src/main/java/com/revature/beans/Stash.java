package com.revature.beans;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="stash")
public class Stash {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name="contents")
    private String contents;

    public Stash() {
        this.id = -1;
        this.contents = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stash stash = (Stash) o;
        return id.equals(stash.id) && contents.equals(stash.contents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contents);
    }

    @Override
    public String toString() {
        return "Stash{" +
                "id=" + id +
                ", contents='" + contents + '\'' +
                '}';
    }
}
