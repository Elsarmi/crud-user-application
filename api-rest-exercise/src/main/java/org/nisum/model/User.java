package org.nisum.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    private String name;
    @Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    private String email;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Pattern(regexp = "^(tu-expresión-regular-aquí)$")
    private String password;
    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime lastLogin;
    private String token;
    private boolean isActive;//

    @OneToMany(cascade = CascadeType.ALL)
    private List<Phone> phones;

    public void setId(UUID id) {
        this.id = id;
    }
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return this.password;
    }
}
