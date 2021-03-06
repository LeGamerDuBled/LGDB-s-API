package net.mcreator.lgdb_api;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

@Elementslgdb_api.ModElement.Tag
public class MCreatorCoalDustFuel extends Elementslgdb_api.ModElement {
	public MCreatorCoalDustFuel(Elementslgdb_api instance) {
		super(instance, 85);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(MCreatorCoalDust.block, (int) (1)).getItem())
			event.setBurnTime(1600);
	}
}
