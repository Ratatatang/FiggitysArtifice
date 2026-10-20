package com.figgity.figgitysartifice;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.minecraft.resources.ResourceLocation;

import com.figgity.figgitysartifice.item.ModItems;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(FiggitysArtifice.MODID)
public class FiggitysArtifice {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "figgitysartifice";

    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public FiggitysArtifice(IEventBus modEventBus, ModContainer modContainer) {
        NeoForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);

        //Add to arms n artifice creative tab
        modEventBus.addListener(this::buildCreativeTab);

        //modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.LOG_DIRT_BLOCK.getAsBoolean()) {
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
        }

        LOGGER.info("{}{}", Config.MAGIC_NUMBER_INTRODUCTION.get(), Config.MAGIC_NUMBER.getAsInt());

        Config.ITEM_STRINGS.get().forEach((item) -> LOGGER.info("ITEM >> {}", item));
    }

    private void buildCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().location().equals(ResourceLocation.fromNamespaceAndPath("irons_artifice", "main"))) {
            ModItems.ITEMS.getEntries().forEach(item -> event.accept(item.get()));
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
}
