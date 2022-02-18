package com.zekademi.sms.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 15)
    @NotNull(message ="Lütfen adınızı giriniz")
    @Column(nullable = false, length = 25)
    private String firsName;

    @Size(max = 15)
    @NotNull(message ="Lütfen soyadınızı giriniz")
    @Column(nullable = false, length = 25)
    private String lastName;

    @Size(min = 4, max = 60)
    @NotNull(message ="Lütfen şifrenizi giriniz")
    @Column(nullable = false, length = 128)
    private String password;

    @Email(message = "Lütfen mail adresinizi doğru giriniz")
    @Size(min = 5, max = 150)
    @NotNull(message ="Lütfen email adresinizi giriniz")
    @Column(nullable = false, unique = true, length = 14)
    private String email;

    @Pattern(regexp = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{2}[- .]?\\d{2}$",
            message = "Please enter valid phone number")
    @Size(min = 14, max = 14)
    @NotNull(message ="Lütfen telefon numaranızı giriniz")
    @Column(nullable = false, length = 14)
    private String phoneNumber;

    @Size(max = 250)
    @NotNull(message ="Lütfen adresinizi giriniz")
    @Column(nullable = false, length = 250)
    private String address;

    @Size(max = 15)
    @NotNull(message ="Lütfen zipCode giriniz")
    @Column(nullable = false, length = 15)
    private String zipCode;

    @Column(nullable = false)
    private Boolean builtIn;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))

    private Set<Role> roles = new HashSet<>();

}
