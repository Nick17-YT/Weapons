package jdt.nick17_yt.evento;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class balas implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {

        if (e.getAction() != Action.RIGHT_CLICK_AIR) {
            return;
        }
        if (e.getItem().getType() != Material.BLAZE_ROD) {
            return;
        }
        Snowball s = (Snowball) e.getPlayer().launchProjectile(Snowball.class);
        s.getWorld().playEffect(e.getPlayer().getLocation(), Effect.SMOKE, 10);
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {

        Projectile p = e.getEntity();
        if (!(p instanceof Snowball)) {
            return;
        }
        Snowball s = (Snowball) p;
        s.getWorld().createExplosion(s.getLocation(), 5.0F);
        for (Entity en : s.getNearbyEntities(5.0D, 30.0D, 5.0D)) {
            if ((en instanceof Player)) {
                Player pl = (Player)en;
                if (pl != e.getEntity().getShooter()) {
                    pl.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 100, 0));
                }
            }
        }

        Egg g = (Egg) g;
        s.getWorld().createExplosion(g.getLocation(), 5.0f);
        for (Entity en : g.getNearbyEntities(5.0D, 10.0D, 3.0D)){
            if ((en instanceof Player)){
                Player pl = (Player)en;
                if (pl != e.getEntity().getShooter()) {
                    pl.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 50, 0));
                }
            }
        }
    }
}