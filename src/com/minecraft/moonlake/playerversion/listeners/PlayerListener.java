/*
 * Copyright (C) 2016 The MoonLake Authors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


package com.minecraft.moonlake.playerversion.listeners;

import com.minecraft.moonlake.api.event.MoonLakeListener;
import com.minecraft.moonlake.api.event.player.MoonLakePlayerJoinEvent;
import com.minecraft.moonlake.api.player.MoonLakePlayer;
import com.minecraft.moonlake.playerversion.PlayerVersionPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

public class PlayerListener implements MoonLakeListener {

    private final PlayerVersionPlugin main;

    public PlayerListener(PlayerVersionPlugin main) {
        this.main = main;
    }

    public PlayerVersionPlugin getMain() {
        return main;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(MoonLakePlayerJoinEvent event) {

        MoonLakePlayer player = event.getPlayer();
        MoonLakePlayerJoinEvent.ProtocolVersion version = event.getProtocolVersion();

        if(!version.newerThan(MoonLakePlayerJoinEvent.ProtocolVersion.v1_9)) {

            player.onKick("您的客户端版本太旧, 请使用 (1.9+) 或更高.");
        }
    }
}
