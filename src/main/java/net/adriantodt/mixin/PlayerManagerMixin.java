package net.adriantodt.mixin;

import io.github.ladysnake.pal.VanillaAbilities;
import net.adriantodt.TotallyBalancedCreativeFlying;
import net.minecraft.network.ClientConnection;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerManager.class)
public class PlayerManagerMixin {
    @Inject(at = @At("TAIL"), method = "onPlayerConnect")
    private void playerSpawned(ClientConnection connection, ServerPlayerEntity player, CallbackInfo info) {
        TotallyBalancedCreativeFlying.abilitySource.grantTo(player, VanillaAbilities.ALLOW_FLYING);
    }
}
