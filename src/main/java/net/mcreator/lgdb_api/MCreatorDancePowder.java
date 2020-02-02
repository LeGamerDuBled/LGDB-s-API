package net.mcreator.lgdb_api;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
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
public class MCreatorDancePowder extends Elementslgdb_api.ModElement {
	public MCreatorDancePowder(Elementslgdb_api instance) {
		super(instance, 115);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorDancePowder!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorDancePowder!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorDancePowder!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorDancePowder!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure MCreatorDancePowder!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorDancePowder!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		World world = (World) dependencies.get("world");
		if ((((itemstack).getItem() == new ItemStack(MCreatorBlackIronDust.block, (int) (1)).getItem()) && (((((world.getBlockState(new BlockPos(
				(int) x, (int) y, (int) z))).getBlock() == Blocks.LAVA.getDefaultState().getBlock()) || (((world.getBlockState(new BlockPos((int) x,
				(int) y, (int) z))).getBlock() == Blocks.LAVA.getDefaultState().getBlock()) || ((world.getBlockState(new BlockPos((int) x, (int) y,
				(int) z))).getBlock() == Blocks.FIRE.getDefaultState().getBlock()))) || (((world.getBlockState(new BlockPos((int) x, (int) (y + 1),
				(int) z))).getBlock() == Blocks.LAVA.getDefaultState().getBlock()) || (((world.getBlockState(new BlockPos((int) x, (int) (y + 1),
				(int) z))).getBlock() == Blocks.LAVA.getDefaultState().getBlock()) || ((world.getBlockState(new BlockPos((int) x, (int) (y + 1),
				(int) z))).getBlock() == Blocks.FIRE.getDefaultState().getBlock())))) && (world
				.canBlockSeeSky(new BlockPos((int) x, (int) y, (int) z)))))) {
			world.getWorldInfo().setRaining((true));
			if ((!(((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld)) ? ((ServerPlayerEntity) entity)
					.getAdvancements()
					.getProgress(
							((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager().getAdvancement(
									new ResourceLocation("lgdb_api:dancepowderadvancements"))).isDone() : false))) {
				if (entity instanceof ServerPlayerEntity) {
					Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager().getAdvancement(
							new ResourceLocation("lgdb_api:dancepowderadvancements"));
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
