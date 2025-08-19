package com.examplecom.miu.teo.book.cloudnativespring.authserver.domain;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

@Entity(name = "users")
@Data
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Integer id;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false)
  String password;

  boolean enabled;

  @OneToMany(
      cascade = {CascadeType.ALL},
      fetch = FetchType.LAZY)
  @JoinColumn(name = "username_id")
  List<Authorities> authorities;
}
