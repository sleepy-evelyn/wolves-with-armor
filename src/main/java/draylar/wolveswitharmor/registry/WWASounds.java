package draylar.wolveswitharmor.registry;

import draylar.wolveswitharmor.WolvesWithArmor;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class WWASounds {

    public static final SoundEvent WOLF_ARMOR_EQUIP = register("entity.wolf.armor");

    private static SoundEvent register(String name) {
        Identifier id = WolvesWithArmor.id(name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void initialize() {}
}
