package com.revature.beans;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="staged_commit")
public class Commit {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name="contents")
    private String contents;

    public Commit() {
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
        Commit commit = (Commit) o;
        return id.equals(commit.id) && contents.equals(commit.contents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contents);
    }

    @Override
    public String toString() {
        return "Commit{" +
                "id=" + id +
                ", contents='" + contents + '\'' +
                '}';
    }
}
