package com.rpjossamod.item;

import com.rpjossamod.RPJossaMod;
import com.rpjossamod.item.custom.FireFlowerMarioItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RPJossaMod.MODID);

    public static final RegistryObject<Item> COIN_MARIO_ITEM = ITEMS.register("coin_mario_item",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FIRE_FLOWER_MARIO_ITEM = ITEMS.register("fire_flower_mario_item",
            () -> new FireFlowerMarioItem(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
