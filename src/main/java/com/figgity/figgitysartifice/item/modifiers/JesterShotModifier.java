package com.figgity.figgitysartifice.item.modifiers;

import io.redspace.irons_artifice.data.PlayableSound;
import io.redspace.irons_artifice.data.ShotComponentMap;
import io.redspace.irons_artifice.data.ShotComponents;
import io.redspace.irons_artifice.data.ValueModifier;
import io.redspace.irons_artifice.modifier.ValueStackModifier;
import io.redspace.irons_artifice.registry.SoundRegistry;

import java.util.Map;

public class JesterShotModifier extends ValueStackModifier {
    public JesterShotModifier() {
        super(Map.of(
                ShotComponents.RICOCHET, new ValueModifier(2, ValueModifier.Operation.ADD, ValueModifier.Type.BENEFICIAL),
                ShotComponents.PROJECTILE_COUNT, new ValueModifier(1, ValueModifier.Operation.ADD, ValueModifier.Type.BENEFICIAL),
                ShotComponents.KNOCKBACK, new ValueModifier(0.35, ValueModifier.Operation.ADD, ValueModifier.Type.BENEFICIAL),
                ShotComponents.DAMAGE, new ValueModifier(-0.05, ValueModifier.Operation.MULTIPLY_TOTAL, ValueModifier.Type.BENEFICIAL)
        ));
    }

    @Override
    public void apply(ShotComponentMap components) {
        super.apply(components);
        components.getOrCreate(ShotComponents.IMPACT_SOUND).addBlockAccent(PlayableSound.of(SoundRegistry.BULLET_IMPACT_RICOCHET, 2f, 29.3f, 30.3f));
    }
}
