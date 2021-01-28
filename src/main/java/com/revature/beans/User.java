package com.revature.beans;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name="username")
    private String username;
    @Column(name="psswrd")
    private String password;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="role_id")
    private Role role;
    @OneToMany(mappedBy="repository")
    private Set<Stash> stash_items;
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="user_local_branch",
        joinColumns=@JoinColumn(name="user_id"),
        inverseJoinColumns=@JoinColumn(name="local_branch_id"))
    private Set<LocalBranch> local_branches;

    public User() {
        this.id = -1;
        this.username = "";
        this.password = "";
        this.role = new Role();
        this.stash_items = new HashSet<>();
        this.local_branches = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Stash> getStash_items() {
        return stash_items;
    }

    public void setStash_items(Set<Stash> stash_items) {
        this.stash_items = stash_items;
    }

    public Set<LocalBranch> getLocal_branches() {
        return local_branches;
    }

    public void setLocal_branches(Set<LocalBranch> local_branches) {
        this.local_branches = local_branches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && username.equals(user.username) && password.equals(user.password) && role.equals(user.role) && stash_items.equals(user.stash_items) && local_branches.equals(user.local_branches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, role, stash_items, local_branches);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", stash_items=" + stash_items +
                ", local_branches=" + local_branches +
                '}';
    }
}
