package draylar.wolveswitharmor.item;

import draylar.wolveswitharmor.WolvesWithArmor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.List;

public class WolfArmorItem extends Item {

    private final String type;
    private final int bonus;
    private final Identifier entityTexture;

    public WolfArmorItem(String type, int bonus) {
        super(new Item.Settings().maxCount(1));
        this.type = type;
        this.bonus = bonus;
        this.entityTexture = WolvesWithArmor.id("textures/entity/wolf/armor/wolf_armor_" + type + ".png");
    }

    public WolfArmorItem(String type, int bonus, boolean fireproof) {
        super(new Item.Settings().maxCount(1).fireproof());
        this.type = type;
        this.bonus = bonus;
        this.entityTexture = WolvesWithArmor.id("textures/entity/wolf/armor/wolf_armor_" + type + ".png");
    }

    @Environment(EnvType.CLIENT)
    public Identifier getEntityTexture() {
        return this.entityTexture;
    }

    public int getBonus(ItemStack stack) {
        int protectionLevel = EnchantmentHelper.getLevel(Enchantments.PROTECTION, stack) * 2;
        return this.bonus + protectionLevel;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        tooltip.add(Text.of(""));
        tooltip.add(Text.translatable("wolveswitharmor.tooltip.when_equipped").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("wolveswitharmor.tooltip.bonus", getBonus(stack)).formatted(Formatting.BLUE));

        if(stack.hasEnchantments()) {
            tooltip.add(Text.of(""));
        }
    }

    public String getType() {
        return type;
    }

    public int getBonus() {
        return bonus;
    }
}
