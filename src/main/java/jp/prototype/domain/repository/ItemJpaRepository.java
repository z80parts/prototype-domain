package jp.prototype.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.prototype.domain.model.Item;

@Repository
public interface ItemJpaRepository extends JpaRepository<Item, String> {
}
