package com.kookykraftmc.gm;

import com.google.common.reflect.TypeToken;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;
import ninja.leaping.configurate.objectmapping.serialize.TypeSerializer;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;

import java.util.List;

public class ItemSerializer implements TypeSerializer<ItemStackSnapshot>{

    public static final ItemSerializer INSTANCE = new ItemSerializer();
    private static final TypeToken<ItemStackSnapshot> typeToken = TypeToken.of(ItemStackSnapshot.class);

    @Override
    public void serialize(TypeToken<?> type, ItemStackSnapshot obj, ConfigurationNode value) throws ObjectMappingException {

    }

    @Override
    public ItemStackSnapshot deserialize(TypeToken<?> type, ConfigurationNode value) throws ObjectMappingException {
        return null;
    }

}
