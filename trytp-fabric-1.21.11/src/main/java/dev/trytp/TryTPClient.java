package dev.trytp;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.minecraft.client.MinecraftClient;

public final class TryTPClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) ->
            dispatcher.register(
                ClientCommandManager.literal("trytp")
                    .then(ClientCommandManager.argument("player", StringArgumentType.word())
                        .executes(context -> {
                            String target = StringArgumentType.getString(context, "player");
                            MinecraftClient client = MinecraftClient.getInstance();

                            if (client.player == null || client.getNetworkHandler() == null) {
                                return 0;
                            }

                            // Sends a normal /tpa request; server permissions and rules still apply.
                            client.getNetworkHandler().sendChatCommand("tpa " + target);
                            return 1;
                        })
                    )
            )
        );
    }
}
