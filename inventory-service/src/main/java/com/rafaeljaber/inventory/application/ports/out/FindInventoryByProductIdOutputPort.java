package com.rafaeljaber.inventory.application.ports.out;

import com.rafaeljaber.inventory.application.core.domain.Inventory;

import java.util.Optional;

public interface FindInventoryByProductIdOutputPort {

    Optional<Inventory> find(Integer productId);

}
