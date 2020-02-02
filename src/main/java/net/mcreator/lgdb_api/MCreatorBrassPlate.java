package net.mcreator.lgdb_api;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@Elementslgdb_api.ModElement.Tag
public class MCreatorBrassPlate extends Elementslgdb_api.ModElement {
	@ObjectHolder("lgdb_api:brassplate")
	public static final Item block = null;

	public MCreatorBrassPlate(Elementslgdb_api instance) {
		super(instance, 11);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(MCreatorLGDBAPI.tab).maxStackSize(64));
			setRegistryName("brassplate");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
