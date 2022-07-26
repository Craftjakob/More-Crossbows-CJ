package craftjakob.morecrossbows.core.init;

import craftjakob.morecrossbows.MoreCrossbows;
import craftjakob.morecrossbows.common.item.CrossbowModItem;
import craftjakob.morecrossbows.core.util.CrossbowTiers;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
	public static final DeferredRegister<Item> CROWSSBOWS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreCrossbows.MODID);

	public static final RegistryObject<Item> IRON_CROSSBOW = CROWSSBOWS.register("iron_crossbow", () -> new CrossbowItem((new Item.Properties().stacksTo(1)).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> GOLDEN_CROSSBOW = CROWSSBOWS.register("golden_crossbow", () -> new CrossbowItem((new Item.Properties().stacksTo(1)).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> EMERALD_CROSSBOW = CROWSSBOWS.register("emerald_crossbow", () -> new CrossbowItem((new Item.Properties().stacksTo(1)).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> DIAMOND_CROSSBOW = CROWSSBOWS.register("diamond_crossbow", () -> new CrossbowItem((new Item.Properties().stacksTo(1)).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> NETHERITE_CROSSBOW = CROWSSBOWS.register("netherite_crossbow", () -> new CrossbowItem((new Item.Properties().stacksTo(1)).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	
    public static final RegistryObject<Item> COPPER_CROSSBOW = CROWSSBOWS.register("copper_crossbow",
            () -> new CrossbowModItem(CrossbowTiers.NETHERITE, (new Item.Properties().stacksTo(1)).tab(CreativeModeTab.TAB_COMBAT)));
    
    public static void register(IEventBus eventBus) {
    CROWSSBOWS.register(eventBus);
	}
}



