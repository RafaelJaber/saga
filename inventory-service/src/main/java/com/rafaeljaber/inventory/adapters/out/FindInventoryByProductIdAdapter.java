package com.rafaeljaber.inventory.adapters.out;

import com.rafaeljaber.inventory.adapters.out.repository.InventoryRepository;
import com.rafaeljaber.inventory.adapters.out.repository.entity.InventoryEntity;
import com.rafaeljaber.inventory.adapters.out.repository.mapper.InventoryEntityMapper;
import com.rafaeljaber.inventory.application.core.domain.Inventory;
import com.rafaeljaber.inventory.application.ports.out.FindInventoryByProductIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindInventoryByProductIdAdapter implements FindInventoryByProductIdOutputPort {

    private final InventoryRepository inventoryRepository;
    private final InventoryEntityMapper inventoryEntityMapper;

    @Override
    public Optional<Inventory> find(Integer productId) {
        Optional<InventoryEntity> inventoryEntity = inventoryRepository.findByProductId(productId);
        return inventoryEntity.map(inventoryEntityMapper::toInventory);
    }

}
