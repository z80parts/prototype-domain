package jp.prototype.domain.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    Page<QuarterResult> results = repository.findAll(Example.of(qr, matcher),
            PageRequest.of(page, size));
    ResultDTO<QuarterResult> dto = new ResultDTO<QuarterResult>();
    dto.setCount(results.getTotalElements());
    dto.setTotalPages(results.getTotalPages());
    dto.setContent(results.getContent());

    return dto;
  }

  public Page<QuarterResult> find(QuarterResult searchCondition, Pageable page) {

    // for individual properties
    ExampleMatcher matcher = ExampleMatcher.matching()
            .withMatcher("code", ExampleMatcher.GenericPropertyMatchers.contains()) // あいまいにしないと、空文字で検索結果0
            .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
    Example<QuarterResult> exapmple = Example.of(searchCondition, matcher);

    return repository.findAll(exapmple,
            PageRequest.of(page.getPageNumber(), page.getPageSize(),
                    Sort.by(Sort.Direction.ASC, "code")
                            .and(Sort.by(Sort.Direction.ASC, "term"))
                            .and(Sort.by(Sort.Direction.DESC, "quarter"))));
  }
}