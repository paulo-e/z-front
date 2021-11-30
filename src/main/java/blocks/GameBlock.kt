package blocks

import builders.GameTileRepository.EMPTY
import builders.GameTileRepository.FLOOR
import builders.GameTileRepository.PLAYER
import builders.GameTileRepository.WALL
import extensions.GameEntity
import extensions.tile
import kotlinx.collections.immutable.persistentMapOf
import org.hexworks.amethyst.api.entity.EntityType
import org.hexworks.zircon.api.data.BlockTileType
import org.hexworks.zircon.api.data.Tile
import org.hexworks.zircon.api.data.base.BaseBlock

class GameBlock(
    private var defaultTile: Tile = FLOOR,
    private val currentEntities: MutableList<GameEntity<EntityType>> = mutableListOf()
) : BaseBlock<Tile>(
    emptyTile = EMPTY,
    tiles = persistentMapOf(BlockTileType.CONTENT to defaultTile)
) {
    val isFloor: Boolean
        get() = content == FLOOR

    val isWall: Boolean
        get() = content == WALL

    val isEmptyFloor: Boolean
        get() = currentEntities.isEmpty()

    val entities: Iterable<GameEntity<EntityType>>
        get() = currentEntities.toList()

    fun addEntity(entity: GameEntity<EntityType>) {
        currentEntities.add(entity)
        updateContent()
    }

    fun removeEntity(entity: GameEntity<EntityType>) {
        currentEntities.remove(entity)
        updateContent()
    }

    private fun updateContent() {
        val entityTiles = currentEntities.map { it.tile }
        content = when {
            entityTiles.contains(PLAYER) -> PLAYER
            entityTiles.isNotEmpty() -> entityTiles.first()
            else -> defaultTile
        }
    }
}