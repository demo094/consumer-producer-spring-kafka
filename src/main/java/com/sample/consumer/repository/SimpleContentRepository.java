package com.sample.consumer.repository;

import com.sample.consumer.domain.SimpleContent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by demo094 on 2019-04-02.
 */
@Repository
public interface SimpleContentRepository  extends CrudRepository<SimpleContent, Long> {
}
