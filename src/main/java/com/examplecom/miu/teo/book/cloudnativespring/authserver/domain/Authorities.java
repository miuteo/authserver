package com.examplecom.miu.teo.book.cloudnativespring.authserver.domain;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Data
public class Authorities implements GrantedAuthority {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  Integer id;

  @Column String authority;
}
