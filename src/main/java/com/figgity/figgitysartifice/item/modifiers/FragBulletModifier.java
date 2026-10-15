package com.figgity.figgitysartifice.item.modifiers;

import com.figgity.figgitysartifice.item.modifier.ShrapnelOnHit;
import io.redspace.irons_artifice.data.ShotComponentMap;
import io.redspace.irons_artifice.data.ShotComponents;
import io.redspace.irons_artifice.data.ValueModifier;
import io.redspace.irons_artifice.modifier.GunModifier;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

public class FragBulletModifier implements GunModifier {
    @Override
    public void apply(ShotComponentMap components) {
        //components.getOrCreate(ShotComponents.PIERCING).addModifier(new ValueModifier(1.0, ValueModifier.Operation.ADD, ValueModifier.Type.BENEFICIAL));
        components.getOrCreate(ShotComponents.ON_HIT).add(new ShrapnelOnHit());
    }

    @Override
    public void getDescriptionText(Consumer<Component> builder) {
        //builder.accept(Component.translatable("figgitysartifice.modifier.frag_bullet_pierce")
        //        .withStyle(ChatFormatting.GREEN));
        builder.accept(Component.translatable("figgitysartifice.modifier.frag_bullet",
                ShrapnelOnHit.SHRAPNEL_COUNT,
                (int) (ShrapnelOnHit.DAMAGE_FRACTION * 100)).withStyle(ChatFormatting.AQUA));
    }
}
