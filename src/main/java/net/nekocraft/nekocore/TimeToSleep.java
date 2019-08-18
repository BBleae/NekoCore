package net.nekocraft.nekocore;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

import java.util.Objects;

public final class TimeToSleep implements Listener {
    private World w;
    private int current = 0;

    TimeToSleep() {
        w = Objects.requireNonNull(Bukkit.getWorld("world"));
    }

    @EventHandler
    public void onSleep(PlayerBedEnterEvent e) {
        if (w.isDayTime() || e.getBedEnterResult() != PlayerBedEnterEvent.BedEnterResult.OK) return;
        current++;
        int all = 0;
        for (Player p : w.getPlayers()) {
            if (p.getInventory().getItemInMainHand().getType() != Material.FISHING_ROD &&
                !p.getDisplayName().startsWith("��7")) all++;
        }
        all = (int) Math.floor((float) all / 2);
        String str = e.getPlayer().getDisplayName() + " ��b����˯������! ��7(��f" + current + "��7 / ��f" + all + "��7)";
        if (all > current) {
            w.getPlayers().forEach(p -> {
                if (!p.isSleeping()) p.sendMessage(str);
            });
        } else {
            w.setTime(1000);
            current = 0;
            w.getPlayers().forEach(p -> p.sendActionBar("��e����, ˬ��!"));
        }
    }

    @EventHandler
    public void onLeave(PlayerBedLeaveEvent e) {
        if (current > 0) current--;
        String str = e.getPlayer().getDisplayName() + " ��e�������о�����!";
        w.getPlayers().forEach(p -> {
            if (p.isSleeping()) p.sendMessage(str);
        });
    }
}
