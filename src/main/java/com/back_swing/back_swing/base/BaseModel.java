package com.back_swing.back_swing.base;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public abstract class BaseModel {

  @Id
  private Long id;

  private boolean active = true;

  @CreatedDate
  @Column("created_at")
  private Instant createdAt;

  @LastModifiedDate
  @Column("updated_at")
  private Instant updatedAt;
}
