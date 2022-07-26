package craftjakob.morecrossbows;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import craftjakob.morecrossbows.common.item.CrossbowModItem;
import craftjakob.morecrossbows.core.init.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod("morecrossbows")
public class MoreCrossbows
{
	public static final String MODID = "morecrossbows";
	private static final IEventBus MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();
	private static final IEventBus EVENT_BUS = MinecraftForge.EVENT_BUS;

    public MoreCrossbows()
    {
    	MOD_EVENT_BUS.addListener(this::setup);
        ModItems.CROWSSBOWS.register(MOD_EVENT_BUS);
        
        EVENT_BUS.register(this);
    }
    
    private void setup(final FMLClientSetupEvent event)
    {
    	//ItemProperties
        event.enqueueWork(() -> {
    	ModItems.CROWSSBOWS.getEntries().forEach(item -> {
    	      ItemProperties.register(item.get(), new ResourceLocation("pull"), (ItemStack, ClientLevel, LivingEntity, p_174623_) -> {
    	          if (LivingEntity == null) {
    	             return 0.0F;
    	          } else {
    	             return CrossbowModItem.isCharged(ItemStack) ? 0.0F : (float)(ItemStack.getUseDuration() - LivingEntity.getUseItemRemainingTicks()) / (float)CrossbowModItem.getChargeDuration(ItemStack);
    	          }
    	       });
    	       ItemProperties.register(item.get(), new ResourceLocation("pulling"), (ItemStack, ClientLevel, LivingEntity, p_174618_) -> {
    	          return LivingEntity != null && LivingEntity.isUsingItem() && LivingEntity.getUseItem() == ItemStack && !CrossbowModItem.isCharged(ItemStack) ? 1.0F : 0.0F;
    	       });
    	       ItemProperties.register(item.get(), new ResourceLocation("charged"), (ItemStack, ClientLevel, LivingEntity, p_174613_) -> {
    	          return LivingEntity != null && CrossbowModItem.isCharged(ItemStack) ? 1.0F : 0.0F;
    	       });
    	       ItemProperties.register(item.get(), new ResourceLocation("firework"), (ItemStack, ClientLevel, LivingEntity, p_174608_) -> {
    	          return LivingEntity != null && CrossbowModItem.isCharged(ItemStack) && CrossbowModItem.containsChargedProjectile(ItemStack, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
    	       });
    	});
      });
    }
    @SubscribeEvent
    public void onFOVUpdate(ComputeFovModifierEvent event)
    {
    	LivingEntity player = event.getPlayer();
    	Item item = player.getUseItem().getItem();
        if(item instanceof CrossbowModItem) {
        	float FOVModifier = player.getTicksUsingItem() / (float)CrossbowModItem.DEFAULT_RANGE;
        	if (FOVModifier > 1.0f) {
        		FOVModifier = 1.0f;
        	}
        	else {
        		FOVModifier *= FOVModifier;
        	}
        	event.setNewFovModifier(event.getNewFovModifier() * (1.0f - FOVModifier * 0.15f));
        }
    }
}
