package net.mcreator.lgdb_api;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@Elementslgdb_api.ModElement.Tag
public class MCreatorLithiumShard extends Elementslgdb_api.ModElement {
	@ObjectHolder("lgdb_api:lithiumshard")
	public static final Item block = null;

	public MCreatorLithiumShard(Elementslgdb_api instance) {
		super(instance, 18);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(MCreatorLGDBAPI.tab).maxStackSize(64));
			setRegistryName("lithiumshard");
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