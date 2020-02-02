package net.mcreator.lgdb_api;

import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import io.netty.buffer.Unpooled;

@Elementslgdb_api.ModElement.Tag
public class MCreatorAlloyFurnaceOnBlockRightClicked extends Elementslgdb_api.ModElement {
	public MCreatorAlloyFurnaceOnBlockRightClicked(Elementslgdb_api instance) {
		super(instance, 45);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorAlloyFurnaceOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorAlloyFurnaceOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorAlloyFurnaceOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorAlloyFurnaceOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorAlloyFurnaceOnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (entity instanceof ServerPlayerEntity)
			NetworkHooks.openGui((ServerPlayerEntity) entity, new INamedContainerProvider() {
				@Override
				public ITextComponent getDisplayName() {
					return new StringTextComponent("AlloyFurnaceGUI");
				}

				@Override
				public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
					return new MCreatorAlloyFurnaceGUI.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(new BlockPos(
							x, y, z)));
				}
			}, new BlockPos(x, y, z));
	}
}
