package net.nekocraft.nekocore;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

import java.util.Objects;
import java.util.Random;

final class TimeToSleep implements Listener {
    private final World w;
    private int current = 0;
    private final Main plugin;

    TimeToSleep(Main plugin) {
        this.plugin = plugin;
        w = Objects.requireNonNull(plugin.getServer().getWorld("world"));
    }

    private String getDisplayName(String name) {
        switch (name) {
            case "lulu_fengling": return "¶¶";
            case "bbleae": return "BB";
            default: return null;
        }
    }

    @EventHandler
    public void onSleep(PlayerBedEnterEvent e) {
        if (w.isDayTime() || e.getBedEnterResult() != PlayerBedEnterEvent.BedEnterResult.OK) return;
        current++;
        int all = getAll();
        Player p = e.getPlayer();
        String displayName = getDisplayName(p.getName().toLowerCase());
        String str = (displayName == null ? "��e¶¶" + p.getDisplayName() : "��a" + displayName) +
            " ��b����˯������! ��7(��f" + current + "��7 / ��f" + all + "��7)";
        w.getPlayers().forEach(pl -> pl.sendMessage(str));
        if (all <= current) {
            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                w.setTime(new Random().nextInt(2000));
                current = 0;
                w.getPlayers().forEach(pl -> p.sendActionBar("��e����, ˬ��!"));
            }, 20 * 8);
        }
    }

    @EventHandler
    public void onLeave(PlayerBedLeaveEvent e) {
        if (w.isDayTime()) return;
        if (current > 0) current--;
        String str = e.getPlayer().getDisplayName() + " ��e�������о�����! ��7(��f" + current + "��7 / ��f" + getAll() + "��7)";
        w.getPlayers().forEach(p -> p.sendMessage(str));
    }

    private int getAll() {
        int all = 0;
        for (Player p : w.getPlayers()) {
            if (p.getInventory().getItemInMainHand().getType() != Material.FISHING_ROD &&
                !p.getPlayerListName().startsWith("��7") && p.getGameMode() == GameMode.SURVIVAL) all++;
        }
        return (int) Math.floor((float) all / 2);
    }
}
