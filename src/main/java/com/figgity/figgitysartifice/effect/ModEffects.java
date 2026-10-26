package com.figgity.figgitysartifice.effect;

import com.figgity.figgitysartifice.FiggitysArtifice;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, FiggitysArtifice.MODID);

    public static final Holder<MobEffect> ECHOING_EFFECT = MOB_EFFECTS.register("echoing",
            () -> new EchoingEffect(MobEffectCategory.HARMFUL, 0x29DEEA));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
