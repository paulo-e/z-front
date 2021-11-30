package systems

import attributes.types.Player
import extensions.position
import messages.MoveCamera
import messages.MoveTo
import org.hexworks.amethyst.api.Consumed
import org.hexworks.amethyst.api.MessageResponse
import org.hexworks.amethyst.api.Pass
import org.hexworks.amethyst.api.Response
import org.hexworks.amethyst.api.base.BaseFacet
import world.GameContext

object Movable : BaseFacet<GameContext, MoveTo>(MoveTo::class) {
    override suspend fun receive(message: MoveTo): Response {
        val (entity, context, position) = message
        val world = context.world
        val previousPosition = entity.position
        var result: Response = Pass

        if (world.moveEntity(entity, position)) {
            result = if (entity.type == Player) {
                MessageResponse(MoveCamera(
                    source = entity,
                    context = context,
                    previousPosition = previousPosition
                ))
            } else Consumed
        }

        return result
    }
}