package org.dav.tacocloud.repository;

import org.dav.tacocloud.domain.TacoOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends CrudRepository<TacoOrder, UUID> {
    List<TacoOrder> findByDeliveryZip(String deliveryZip);
}
