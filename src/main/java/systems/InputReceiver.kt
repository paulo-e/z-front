package systems

import extensions.position
import messages.MoveTo
import org.hexworks.amethyst.api.base.BaseBehavior
import org.hexworks.amethyst.api.entity.Entity
import org.hexworks.amethyst.api.entity.EntityType
import org.hexworks.zircon.api.data.Position3D
import org.hexworks.zircon.api.uievent.KeyCode
import org.hexworks.zircon.api.uievent.KeyboardEvent
import world.GameContext

object InputReceiver : BaseBehavior<GameContext>() {
    override suspend fun update(entity: Entity<EntityType, GameContext>, context: GameContext): Boolean {
        val (_, _, uiEvent, player) = context
        val currentPos: Position3D = player.position

        if (uiEvent is KeyboardEvent) {
            val newPosition = when (uiEvent.code) {
                KeyCode.UP -> currentPos.withRelativeY(-1)
                KeyCode.LEFT -> currentPos.withRelativeX(-1)
                KeyCode.DOWN -> currentPos.withRelativeY(1)
                KeyCode.RIGHT -> currentPos.withRelativeX(1)
                else -> {
                    currentPos
                }
            }
            player.receiveMessage(MoveTo(player, context, newPosition))
        }
        return true
    }
}