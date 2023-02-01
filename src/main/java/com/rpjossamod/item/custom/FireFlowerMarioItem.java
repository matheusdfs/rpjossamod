package com.rpjossamod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class FireFlowerMarioItem extends Item {

    public FireFlowerMarioItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            //player.sendSystemMessage(Component.literal("Throw fireball!"));

            spawnLargeFireball(level, player);

            player.getCooldowns().addCooldown(this, 20);
        }

        return super.use(level, player, hand);
    }

    private void spawnLargeFireball(Level level, Player player) {
        Vec3 vec3 = player.getViewVector(1.0F);

        SmallFireball smallFireball = new SmallFireball(level, player, vec3.x, vec3.y, vec3.z);
        smallFireball.setPos(player.getX() + vec3.x * 4.0D, player.getY(0.5D) + 0.5D, smallFireball.getZ() + vec3.z * 4.0D);
        level.addFreshEntity(smallFireball);
    }
}
