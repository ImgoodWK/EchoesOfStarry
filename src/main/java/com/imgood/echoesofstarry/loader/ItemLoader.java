package com.imgood.echoesofstarry.loader;

import com.imgood.echoesofstarry.EchoesOfStarry;
import com.imgood.echoesofstarry.item.LevelInfoDisplayDebugTool;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = "EchoesOfStarry", bus = Bus.MOD)
public class ItemLoader {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EchoesOfStarry.MODID);

    public static final RegistryObject<Item> LEVEL_INFO_DISPLAY_DEBUG_TOOL = ITEMS.register("levelinfodisplaydebugtool",
            () -> new LevelInfoDisplayDebugTool(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
