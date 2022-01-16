package jp.prototype.domain.dto;

import java.util.List;

import lombok.Data;

@Data
public class ResultDTO<T> {

  public long totalPages = 0;

  public long count = 0;

  public List<T> content;

}
