package com.revature.beans;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="local_branch")
public class LocalBranch {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name="current_contents")
    private String contents;
    @OneToOne()
    @JoinColumn(name="commit_id")
    private Commit current_commit;

    public LocalBranch() {
        this.id = -1;
        this.contents = "";
        this.current_commit = null;
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

    public Commit getCurrent_commit() {
        return current_commit;
    }

    public void setCurrent_commit(Commit current_commit) {
        this.current_commit = current_commit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalBranch that = (LocalBranch) o;
        return id.equals(that.id) && contents.equals(that.contents) && Objects.equals(current_commit, that.current_commit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contents, current_commit);
    }

    @Override
    public String toString() {
        return "LocalBranch{" +
                "id=" + id +
                ", contents='" + contents + '\'' +
                ", current_commit=" + current_commit +
                '}';
    }
}
