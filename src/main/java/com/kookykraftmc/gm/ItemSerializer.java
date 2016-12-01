package com.kookykraftmc.gm;

import com.google.common.reflect.TypeToken;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;
import ninja.leaping.configurate.objectmapping.serialize.TypeSerializer;
import org.spongepowered.api.item.inventory.ItemStack;

public class ItemSerializer implements TypeSerializer<ItemStack> {

    @Override
    public ItemStack deserialize(TypeToken<?> type, ConfigurationNode value) throws ObjectMappingException {
        return null;
    }

    @Override
    public void serialize(TypeToken<?> type, ItemStack obj, ConfigurationNode value) throws ObjectMappingException {

    }
}