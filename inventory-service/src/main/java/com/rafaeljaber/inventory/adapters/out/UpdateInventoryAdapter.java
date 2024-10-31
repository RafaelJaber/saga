package com.rafaeljaber.inventory.adapters.out;

import com.rafaeljaber.inventory.adapters.out.repository.InventoryRepository;
import com.rafaeljaber.inventory.adapters.out.repository.entity.InventoryEntity;
import com.rafaeljaber.inventory.adapters.out.repository.mapper.InventoryEntityMapper;
import com.rafaeljaber.inventory.application.core.domain.Inventory;
import com.rafaeljaber.inventory.application.ports.out.UpdateInventoryOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateInventoryAdapter implements UpdateInventoryOutputPort {

    private final InventoryRepository inventoryRepository;
    private final InventoryEntityMapper inventoryEntityMapper;

    @Override
    public void update(Inventory inventory) {
        InventoryEntity inventoryEntity = inventoryEntityMapper.toInventoryEntity(inventory);
        inventoryRepository.save(inventoryEntity);
    }

}
