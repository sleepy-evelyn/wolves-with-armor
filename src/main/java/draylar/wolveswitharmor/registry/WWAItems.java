package draylar.wolveswitharmor.registry;

import draylar.wolveswitharmor.WolvesWithArmor;
import draylar.wolveswitharmor.item.DyeableWolfArmorItem;
import draylar.wolveswitharmor.item.WolfArmorDispenserBehavior;
import draylar.wolveswitharmor.item.WolfArmorItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class WWAItems {

    public static final WolfArmorItem LEATHER_WOLF_ARMOR, IRON_WOLF_ARMOR, GOLDEN_WOLF_ARMOR,
            DIAMOND_WOLF_ARMOR, NETHERITE_WOLF_ARMOR;

    public static void initialize() {}

    private static WolfArmorItem register(WolfArmorItem item) {
        Registry.register(Registries.ITEM, WolvesWithArmor.id(item.getType() + "_wolf_armor"), item);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((entries) -> entries.add(item));
        DispenserBlock.registerBehavior(item, new WolfArmorDispenserBehavior());
        return item;
    }

    static {
        LEATHER_WOLF_ARMOR = register(new DyeableWolfArmorItem("leather", 3));
        IRON_WOLF_ARMOR = register(new WolfArmorItem("iron", 5));
        GOLDEN_WOLF_ARMOR = register(new WolfArmorItem("golden", 7));
        DIAMOND_WOLF_ARMOR = register(new WolfArmorItem("diamond", 11));
        NETHERITE_WOLF_ARMOR = register(new WolfArmorItem("netherite", 15, true));
    }
}
