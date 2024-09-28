package org.dav.tacocloud.repository;

import org.dav.tacocloud.domain.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, String> {
}
