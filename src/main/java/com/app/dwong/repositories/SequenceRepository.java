package com.app.dwong.repositories;

import com.app.dwong.model.Sequence;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by dwong on 2/28/17.
 */
@RepositoryRestResource(collectionResourceRel = "sequences", path = "sequences")
public interface SequenceRepository extends PagingAndSortingRepository<Sequence, String> {
}
