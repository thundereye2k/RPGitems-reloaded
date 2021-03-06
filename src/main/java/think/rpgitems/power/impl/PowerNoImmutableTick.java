package think.rpgitems.power.impl;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import think.rpgitems.I18n;
import think.rpgitems.RPGItems;
import think.rpgitems.power.PowerHit;
import think.rpgitems.power.PowerMeta;
import think.rpgitems.power.PowerResult;

/**
 * Power noimmutabletick.
 * <p>
 * Cancel the damage delay (no-damage-tick)
 * </p>
 */
@PowerMeta(immutableTrigger = true)
public class PowerNoImmutableTick extends BasePower implements PowerHit {

    @Override
    public String getName() {
        return "noimmutabletick";
    }

    @Override
    public String displayText() {
        return I18n.format("power.noimmutabletick");
    }

    @Override
    public PowerResult<Double> hit(Player player, ItemStack stack, LivingEntity entity, double damage, EntityDamageByEntityEvent event) {
        Bukkit.getScheduler().runTaskLater(RPGItems.plugin, ()-> entity.setNoDamageTicks(0), 0);
        Bukkit.getScheduler().runTaskLater(RPGItems.plugin, ()-> entity.setNoDamageTicks(0), 1);
        return PowerResult.ok(damage);
    }
}
