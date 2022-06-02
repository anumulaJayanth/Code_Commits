package com.simplilearn.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.model.PurchaseOrder;

@Repository
public interface PurchaseOrderRepo extends CrudRepository<PurchaseOrder, Integer> {


}
