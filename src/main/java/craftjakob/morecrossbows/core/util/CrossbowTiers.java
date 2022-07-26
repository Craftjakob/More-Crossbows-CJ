package craftjakob.morecrossbows.core.util;

import java.util.function.Supplier;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

@SuppressWarnings("deprecation")
public enum CrossbowTiers implements CrossbowTier {

	   COPPER(484, 0.5f, 1, () -> {
	      return Ingredient.of(Items.COPPER_INGOT);
	   }),
	   IRON(715, 1.0f, 1, () -> {
		  return Ingredient.of(Items.IRON_INGOT);
	   }),
	   GOLDEN(747, 1.5f, 5, () -> {
		  return Ingredient.of(Items.GOLD_INGOT);
	   }),
	   EMERALD(1254, 2.0f, 3, () -> {
		  return Ingredient.of(Items.EMERALD);
	   }),
	   DIAMOND(2026, 3.0f, 3, () -> {
	      return Ingredient.of(Items.DIAMOND);
	   }),
	   NETHERITE(2496, 25.0f, 20, () -> {
	      return Ingredient.of(Items.NETHERITE_INGOT);
	   });

	   private final int uses;
	   private final float damage;
	   private final int enchantmentValue;
	   private final LazyLoadedValue<Ingredient> repairIngredient;

	   private CrossbowTiers(int uses, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
	      this.uses = uses;
	      this.damage = damage;
	      this.enchantmentValue = enchantmentValue;
	      this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
	   }

	   public int getUses() {
	      return this.uses;
	   }

	   public float getAttackDamageBonus() {
	      return this.damage;
	   }

	   public int getEnchantmentValue() {
	      return this.enchantmentValue;
	   }

	   public Ingredient getRepairIngredient() {
	      return this.repairIngredient.get();
	   }
}