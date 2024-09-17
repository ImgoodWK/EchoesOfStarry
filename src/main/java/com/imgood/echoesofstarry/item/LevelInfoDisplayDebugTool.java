package com.imgood.echoesofstarry.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class LevelInfoDisplayDebugTool extends Item {

    public LevelInfoDisplayDebugTool(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        // 仅在客户端执行
        if (world.isClientSide) {
            // 获取玩家信息
            String playerName = player.getName().getString();
            String playerUUID = player.getUUID().toString();
            String message = "玩家: " + playerName + " UUID: " + playerUUID;

            // 设置要显示的消息
            ClientEventSubscriber.setMessage(message);

            System.out.println("玩家信息: " + playerName + " UUID: " + playerUUID);
        }

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}