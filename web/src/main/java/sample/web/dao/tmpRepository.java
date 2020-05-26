package sample.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import sample.web.entity.tmp;

import java.io.Serializable;

@Repository
public interface tmpRepository extends JpaRepository<tmp, Integer>, JpaSpecificationExecutor<tmp>, Serializable {
}
