package builders

import attributes.types.Player
import attributes.types.attributes.EntityPosition
import attributes.types.attributes.EntityTile
import builders.GameTileRepository.PLAYER
import org.hexworks.amethyst.api.builder.EntityBuilder
import org.hexworks.amethyst.api.entity.EntityType
import org.hexworks.amethyst.api.newEntityOfType
import world.GameContext

fun <T : EntityType> newGameEntityOfType(
    type: T,
    init: EntityBuilder<T, GameContext>.() -> Unit
) = newEntityOfType(type, init)

object EntityFactory {
    fun newPlayer() = newGameEntityOfType(Player) {
        attributes(EntityPosition(), EntityTile(PLAYER))
        behaviors()
        facets()
    }
}