package messages

import extensions.GameMessage
import org.hexworks.amethyst.api.entity.Entity
import org.hexworks.amethyst.api.entity.EntityType
import org.hexworks.zircon.api.data.Position3D
import world.GameContext

data class MoveTo(
    override val source: Entity<EntityType, GameContext>,
    override val context: GameContext,
    val position: Position3D
) : GameMessage
