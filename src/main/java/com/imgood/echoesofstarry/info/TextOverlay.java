package com.imgood.echoesofstarry.info;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "mymod", value = Dist.CLIENT)
public class TextOverlay {

    @SubscribeEvent
    public static void onRenderGameOverlay(RenderGameOverlayEvent.Text event) {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;

        if (player != null) {
            PoseStack poseStack = event.getPoseStack();
            Font fontRenderer = mc.font;
            String textToDisplay = "这是一个示例文本"; // 你想要显示的文本

            // 设置渲染位置（例如屏幕左上角）
            int x = 10;
            int y = 10;

            poseStack.pushPose();
            RenderSystem.enableBlend();
            fontRenderer.draw(poseStack, Component.literal(textToDisplay), x, y, 0xFFFFFF); // 0xFFFFFF 是文本的颜色
            RenderSystem.disableBlend();
            poseStack.popPose();
        }
    }
}