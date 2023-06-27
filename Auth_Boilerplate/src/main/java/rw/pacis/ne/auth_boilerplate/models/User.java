package rw.pacis.ne.auth_boilerplate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import rw.pacis.ne.auth_boilerplate.enums.EGender;
import rw.pacis.ne.auth_boilerplate.enums.ERole;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "customers", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"}), @UniqueConstraint(columnNames = {"phone_number"})})
@OnDelete(action = OnDeleteAction.CASCADE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "national_id")
    private String nationalId;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private EGender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private ERole role = ERole.STANDARD;

    @JsonIgnore
    @NotBlank
    @Column(name = "password")
    private String password;

    public User(String name, String phoneNumber, String email, EGender gender) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
    }

    public User(String name, String phoneNumber, String email, EGender gender, ERole role) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.role = role;
    }

    public User(String name, String phoneNumber, String email, EGender gender, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.password = password;
    }

    public User(String name, String phoneNumber, String email, EGender gender, String password, ERole role) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.role = role;
    }

    public String getFullName() {
        return this.name;
    }
}
