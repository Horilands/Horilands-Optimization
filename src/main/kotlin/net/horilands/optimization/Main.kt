package net.horilands.optimization

import org.bukkit.event.Cancellable
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockEvent
import org.bukkit.event.block.BlockFormEvent
import org.bukkit.event.block.BlockFromToEvent
import org.bukkit.event.block.BlockPhysicsEvent
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
    fun physicsEvent(e: BlockPhysicsEvent) = c(e)

    @EventHandler
    fun liq(e: BlockFromToEvent) = c(e)

    @EventHandler
    fun cobble(e: BlockFormEvent) = c(e)

    @EventHandler
    fun sand(e: EntityChangeBlockEvent) {
        if (e.block.type.hasGravity()) {
            e.isCancelled = true
            e.block.state.update(true, false)
        }
    }
}