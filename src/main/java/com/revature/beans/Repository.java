package com.revature.beans;

import javafx.scene.text.Text;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="repository")
public class Repository {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name="url")
    private String url;
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="repository_branch",
        joinColumns=@JoinColumn(name="repository_id"),
        inverseJoinColumns=@JoinColumn(name="branch_id"))
    private Set<Branch> branches;

    public Repository() {
        this.id = -1;
        this.url = "";
        this.branches = new HashSet<Branch>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Branch> getBranches() {
        return branches;
    }

    public void setBranches(Set<Branch> branches) {
        this.branches = branches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repository that = (Repository) o;
        return id.equals(that.id) && url.equals(that.url) && branches.equals(that.branches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url, branches);
    }

    @Override
    public String toString() {
        return "Repository{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", branches=" + branches +
                '}';
    }
}
