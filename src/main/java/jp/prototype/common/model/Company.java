package jp.prototype.common.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * test
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "nikkei")
public class Company {

  @Id
  private String code;

  private String name;

  private String category;

}
