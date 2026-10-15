package com.figgity.figgitysartifice.item;

import com.figgity.figgitysartifice.FiggitysArtifice;
import com.figgity.figgitysartifice.item.modifiers.*;
import io.redspace.irons_artifice.modifier.ModifierItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FiggitysArtifice.MODID);

    //public static final DeferredItem<ModifierItem> DEVIL_COIN = ITEMS.registerItem(
    //        "devil_coin", properties -> new ModifierItem(properties.stacksTo(1), new DevilCoinModifier()));

    public static final DeferredItem<ModifierItem> HIGH_VELOCITY_BULLET = ITEMS.registerItem(
            "high_velocity_bullet", properties -> new ModifierItem(properties.stacksTo(1), new HighVelocityBulletModifier()));

    public static final DeferredItem<ModifierItem> JESTER_SHOT = ITEMS.registerItem(
                    "jester_shot", properties -> new ModifierItem(properties.stacksTo(1), new JesterShotModifier()));

    public static final DeferredItem<ModifierItem> FRAG_BULLET = ITEMS.registerItem(
            "frag_bullet", properties -> new ModifierItem(properties.stacksTo(1), new FragBulletModifier()));

    public static final DeferredItem<ModifierItem> RUBBER_BULLET = ITEMS.registerItem(
            "rubber_bullet", properties -> new ModifierItem(properties.stacksTo(1), new RubberBulletModifier()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
