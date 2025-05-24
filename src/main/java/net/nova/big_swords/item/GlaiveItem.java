package net.nova.big_swords.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.UseAction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.nova.big_swords.block.CreepBlock;
import net.nova.big_swords.init.BSAttributes;

import java.util.List;
import java.util.Random;

import static net.nova.big_swords.BigSwordsR.MODID;

public class GlaiveItem extends SwordItem {
    public static final Random random = new Random();
    public final float range = 5.0f; // 5 block range
    public float minChargedDamage;
    public float maxChargedDamage;
    public float attackMultiplier;

    public GlaiveItem(ToolMaterial toolMaterial, float minChargedDamage, float maxChargedDamage) {
        super(toolMaterial);
        this.maxCount = 1;
        this.setMaxDamage(toolMaterial.method_3399());
        this.attackMultiplier = 2.0F + toolMaterial.method_3401();
        this.minChargedDamage = minChargedDamage;
        this.maxChargedDamage = maxChargedDamage;
    }

    // Tilling Creep
    @Override
    public boolean method_3355(ItemStack itemStack, PlayerEntity playerEntity, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        Block block = world.getBlock(x, y, z);
        if (block instanceof CreepBlock) {
            CreepBlock creepBlock = (CreepBlock) block;
            /*if (!creepBlock.isTilled(world, x, y, z)) {
                world.playSound(x + 0.5F, y + 0.5F, z + 0.5F, "game.soul.escape", 1.0F, 1.0F);
                creepBlock.tillBlock(world, x, y, z);
                itemStack.damage(1, playerEntity);
                return true;
            }*/
        }
        return false;
    }

    @Override
    public ItemStack onStartUse(ItemStack stack, World world, PlayerEntity player) {
        if (player.abilities.creativeMode || player.inventory.containsItem(Items.ARROW))
            player.setUseItem(stack, this.getMaxUseTime(stack));
        return stack;
    }

    @Override
    public void onUseStopped(ItemStack stack, World level, PlayerEntity player, int timeLeft) {
        int chargeTime = this.getMaxUseTime(stack) - timeLeft;
        if (chargeTime < 20) return;

        if (!level.isClient) {
            player.swingHand();
        }
    }

    @Override
    public Multimap getAttributeModifierMap() {
        Multimap var1 = HashMultimap.create();
        var1.put(EntityAttributes.GENERIC_ATTACK_DAMAGE.getId(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER_UUID, "Weapon modifier", this.attackMultiplier, 0));
        var1.put(BSAttributes.MIN_CHARGED_DAMAGE.getId(), new AttributeModifier(BSAttributes.MIN_CHARGED_DAMAGE_MODIFIER_UUID, "Min charged modifier", this.minChargedDamage, 0));
        var1.put(BSAttributes.MAX_CHARGED_DAMAGE.getId(), new AttributeModifier(BSAttributes.MAX_CHARGED_DAMAGE_MODIFIER_UUID, "Max charged modifier", this.maxChargedDamage, 0));
        return var1;
    }

    // Bow-like Item Stuff
    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    // Methods
    public boolean glaiveHits(ItemStack stack, World world, PlayerEntity player, LivingEntity target) {
        float damage = minChargedDamage + random.nextFloat() * (maxChargedDamage - minChargedDamage);
        damage = Math.round(damage * 10.0f) / 10.0f;
        target.damage(DamageSource.player(player), damage);
        stack.damage(3, player);
        world.playSound(player, MODID + ":glaive_swing", 1.0F, 1.0F);
        return true;
    }

    public boolean glaiveMiss(ItemStack stack, PlayerEntity player, World world) {
        world.playSound(player, MODID + ":glaive_swing", 1.0F, 1.0F);
        return false;
    }

    public LivingEntity getEntityHitResult(Vec3d startVec, Vec3d endVec, List<LivingEntity> entities) {
        double closestDistance = Double.MAX_VALUE;
        for (LivingEntity entity : entities) {
            Box entityBoundingBox = entity.boundingBox;
            BlockHitResult hit = entityBoundingBox.method_585(startVec, endVec);
            if (hit != null) {
                double distance = startVec.distanceTo(hit.pos);
                if (distance < closestDistance) {
                    return entity;
                }
            }
        }
        return null;
    }
}