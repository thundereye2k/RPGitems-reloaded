package think.rpgitems.power;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.CheckReturnValue;

/**
 * Triggers when player swap offhand item to main hand
 */
public interface PowerSwapToMainhand extends Power {

    /**
     * Calls when {@code player} swap offhand item to mainhand
     *
     * @param player Player
     * @param stack  Item that triggered this power
     * @param event  Event that triggered this power
     *
     * @return PowerResult with proposed event cancellation
     */
    @CheckReturnValue
    PowerResult<Boolean> swapToMainhand(Player player, ItemStack stack, PlayerSwapHandItemsEvent event);

    /**
     * Calls when {@code player} click offhand item in inventory
     *
     * @param player Player
     * @param stack  Item that triggered this power
     * @param event  Event that triggered this power
     *
     * @return PowerResult with proposed event cancellation
     */
    @CheckReturnValue
    default PowerResult<Boolean> pickupOffhand(Player player, ItemStack stack, InventoryClickEvent event) {
        return PowerResult.noop();
    }
}