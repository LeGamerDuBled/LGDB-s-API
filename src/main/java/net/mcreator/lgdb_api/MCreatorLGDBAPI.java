package net.mcreator.lgdb_api;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@Elementslgdb_api.ModElement.Tag
public class MCreatorLGDBAPI extends Elementslgdb_api.ModElement {
	public MCreatorLGDBAPI(Elementslgdb_api instance) {
		super(instance, 42);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tablgdbapi") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(MCreatorCraftingBook.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
