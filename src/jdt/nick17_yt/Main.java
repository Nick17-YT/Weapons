package jdt.nick17_yt;

import jdt.nick17_yt.evento.balas;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(new balas(), this);
    }
}
