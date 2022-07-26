package craftjakob.morecrossbows.core.util;

import net.minecraft.world.item.crafting.Ingredient;

public interface CrossbowTier {
	   int getUses(); //Yes

	   float getAttackDamageBonus(); //No

	   int getEnchantmentValue(); //I don't no

	   Ingredient getRepairIngredient(); //Yes
}
