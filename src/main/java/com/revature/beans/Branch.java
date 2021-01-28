package com.revature.beans;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="branch")
public class Branch {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name="contents")
    private String contents;
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="commit_history",
        joinColumns=@JoinColumn(name="branch_id"),
        inverseJoinColumns=@JoinColumn(name="commit_id"))
    private Set<Commit> commits;

    public Branch() {
        this.id = -1;
        this.contents = "";
        this.commits = new HashSet<Commit>();
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

    public Set<Commit> getCommits() {
        return commits;
    }

    public void setCommits(Set<Commit> commits) {
        this.commits = commits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return id.equals(branch.id) && contents.equals(branch.contents) && commits.equals(branch.commits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contents, commits);
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", contents='" + contents + '\'' +
                ", commits=" + commits +
                '}';
    }
}
