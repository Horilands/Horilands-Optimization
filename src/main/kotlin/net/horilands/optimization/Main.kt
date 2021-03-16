package net.horilands.optimization

import org.bukkit.Material
import org.bukkit.event.Cancellable
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.*
import org.bukkit.event.entity.EntityChangeBlockEvent
import org.bukkit.plugin.java.JavaPlugin

/**
 * @author Swiiz ( for horilands.net )
 */
class Main : JavaPlugin(), Listener {

    override fun onEnable() = server.pluginManager.registerEvents(this, this)

    fun c(e: BlockEvent) {
        (e as? Cancellable)?.isCancelled = true
    }

    @EventHandler
    fun fadeEvent(e: BlockFadeEvent) = c(e)

    @EventHandler
    fun physicsEvent(e: BlockPhysicsEvent) = c(e)

    @EventHandler
    fun liq(e: BlockFromToEvent) = c(e)

    @EventHandler
    fun cobble(e: BlockFormEvent) {
        if(
            e.block.type != Material.OAK_DOOR &&
            e.block.type != Material.SPRUCE_DOOR &&
            e.block.type != Material.ACACIA_DOOR &&
            e.block.type != Material.BIRCH_DOOR &&
            e.block.type != Material.IRON_DOOR &&
            e.block.type != Material.DARK_OAK_DOOR &&
            e.block.type != Material.JUNGLE_DOOR &&
            e.block.type != Material.WARPED_DOOR &&
            e.block.type != Material.CRIMSON_DOOR
        ) c(e)

    }

    @EventHandler
    fun sand(e: EntityChangeBlockEvent) {
        if (e.block.type.hasGravity()) {
            e.isCancelled = true
            e.block.state.update(true, false)
        }
    }
}