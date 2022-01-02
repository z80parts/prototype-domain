package jp.prototype.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "quarter_result")
@IdClass(value=QuarterResultKey.class)
public class QuarterResult {

  @Id
  private String code;

  private String name;

  private String standards;

  private String resultType;

  @Id
  private String term;

  @Id
  private String quarter;

  private LocalDate startDate;

  private LocalDate endDate;

  private String title;

  private long sales;

  private long operationIncome;

  private long ordinaryIncome;

  private long netIncome;

  private BigDecimal eps;

}

