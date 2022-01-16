package jp.prototype.domain.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jp.prototype.domain.dto.ResultDTO;
import jp.prototype.domain.model.QuarterResult;
import jp.prototype.domain.repository.QuarterResultRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class QuarterResultService {

  private QuarterResultRepository repository;

  public Page<QuarterResult> findAll(int page, int size) {
    return repository.findAll(PageRequest.of(page, size));
  }

  public ResultDTO<QuarterResult> find(String code, String name, String term, int page,
          int size) {

    QuarterResult qr = QuarterResult.builder().name(name).code(code).term(term).build();

    // all values
    ExampleMatcher matcher = ExampleMatcher.matching()
            .withStringMatcher(StringMatcher.CONTAINING);
    // for individual properties
//    ExampleMatcher matcher = ExampleMatcher.matching()
//            .withMatcher("name", match -> match.contains());
    Page<QuarterResult> results = repository.findAll(Example.of(qr, matcher),
            PageRequest.of(page, size));
    ResultDTO<QuarterResult> dto = new ResultDTO<QuarterResult>();
    dto.setCount(results.getTotalElements());
    dto.setTotalPages(results.getTotalPages());
    dto.setContent(results.getContent());

    return dto;
  }

  public List<QuarterResult> find(String code, String name) {
    return repository.findByNameJpql(name);
  }

}