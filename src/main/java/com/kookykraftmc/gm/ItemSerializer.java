package com.kookykraftmc.gm;

import com.google.common.reflect.TypeToken;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;
import ninja.leaping.configurate.objectmapping.serialize.TypeSerializer;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;

/**
 * Created by TimeTheCat on 11/6/2016.
 */
public class ItemSerializer implements TypeSerializer<ItemStack> {
    @Override
    public ItemStack deserialize(TypeToken<?> type, ConfigurationNode value) throws ObjectMappingException {
        ItemType iType = value.getNode("item-type").getValue(TypeToken.of(ItemType.class));
        int quantity = value.getNode("item-quantity").getInt();

        return ItemStack.builder().itemType(iType).quantity(quantity).build();
    }

    @Override
    public void serialize(TypeToken<?> type, ItemStack obj, ConfigurationNode value) throws ObjectMappingException {

    }
}
