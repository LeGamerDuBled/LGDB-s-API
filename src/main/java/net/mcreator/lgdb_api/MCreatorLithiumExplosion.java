package net.mcreator.lgdb_api;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import java.util.Iterator;

@Elementslgdb_api.ModElement.Tag
public class MCreatorLithiumExplosion extends Elementslgdb_api.ModElement {
	public MCreatorLithiumExplosion(Elementslgdb_api instance) {
		super(instance, 71);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorLithiumExplosion!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorLithiumExplosion!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorLithiumExplosion!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorLithiumExplosion!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure MCreatorLithiumExplosion!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorLithiumExplosion!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		World world = (World) dependencies.get("world");
		double localX = 0;
		double localY = 0;
		double localZ = 0;
		boolean Found = false;
		localX = (double) -3;
		Found = (boolean) (false);
		for (int index0 = 0; index0 < (int) (6); index0++) {
			localX = (double) -3;
			for (int index1 = 0; index1 < (int) (6); index1++) {
				localX = (double) -3;
				for (int index2 = 0; index2 < (int) (6); index2++) {
					if ((((world.getBlockState(new BlockPos((int) (x + (localX)), (int) (y + (localX)), (int) (z + (localX))))).getBlock() == Blocks.WATER
							.getDefaultState().getBlock()) || (((world.getBlockState(new BlockPos((int) (x + (localX)), (int) (y + (localX)),
							(int) (z + (localX))))).getBlock() == Blocks.WATER.getDefaultState().getBlock()) || ((world.getBlockState(new BlockPos(
							(int) (x + (localX)), (int) (y + (localX)), (int) (z + (localX))))).getBlock() == Blocks.BUBBLE_COLUMN.getDefaultState()
							.getBlock())))) {
						Found = (boolean) (true);
					}
					localX = (double) ((localX) + 1);
				}
				localX = (double) ((localX) + 1);
			}
			localX = (double) ((localX) + 1);
		}
		if ((((itemstack).getItem() == new ItemStack(MCreatorLithiumShard.block, (int) (1)).getItem()) && ((Found) == (true)))) {
			if (!world.isRemote) {
				world.createExplosion(null, (int) x, (int) y, (int) z, (float) 8, Explosion.Mode.BREAK);
			}
			if ((!(((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld)) ? ((ServerPlayerEntity) entity)
					.getAdvancements()
					.getProgress(
							((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager().getAdvancement(
									new ResourceLocation("lgdb_api:boom"))).isDone() : false))) {
				if (entity instanceof ServerPlayerEntity) {
					Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager().getAdvancement(
							new ResourceLocation("lgdb_api:boom"));
					AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
					if (!_ap.isDone()) {
						Iterator _iterator = _ap.getRemaningCriteria().iterator();
						while (_iterator.hasNext()) {
							String _criterion = (String) _iterator.next();
							((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onGemDropped(ItemTossEvent event) {
		PlayerEntity entity = event.getPlayer();
		int i = (int) entity.posX;
		int j = (int) entity.posY;
		int k = (int) entity.posZ;
		World world = entity.world;
		ItemStack itemstack = event.getEntityItem().getItem();
		java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("itemstack", itemstack);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
