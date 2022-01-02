package jp.prototype.domain.model;

import java.io.Serializable;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuarterResultKey implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private String code;

  @Id
  private String term;

  @Id
  private String quarter;

}
