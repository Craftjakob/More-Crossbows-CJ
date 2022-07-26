package craftjakob.morecrossbows.common.item;

import java.util.List;

import craftjakob.morecrossbows.core.util.CrossbowTier;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class CrossbowModItem extends CrossbowItem {

	private CrossbowTier tier;

	public CrossbowModItem(CrossbowTier tier, Properties properties) {
		super(properties.durability(tier.getUses()));
		this.tier = tier;
	}
	@Override
	public int getEnchantmentValue() {
		return super.getEnchantmentValue();
	}
	@Override
	public boolean isValidRepairItem(ItemStack ItemStack, ItemStack p_41403_) {
		return this.tier.getRepairIngredient().test(p_41403_);
	}
	@Override
	public void appendHoverText(ItemStack ItemStack, Level Level, List<Component> p_41423_, TooltipFlag TooltipFlag) {
		p_41423_.add(Component.literal("+" + Float.toString(this.tier.getAttackDamageBonus()) + " ")
				.append(Component.translatable("item.morecrossbows.damage_tooltip")).withStyle(ChatFormatting.GREEN));
		super.appendHoverText(ItemStack, Level, p_41423_, TooltipFlag);
	}
}

