package builders

import attributes.types.Player
import config.GameConfig
import config.GameConfig.LOG_AREA_HEIGHT
import config.GameConfig.SIDEBAR_WIDTH
import config.GameConfig.WINDOW_HEIGHT
import config.GameConfig.WINDOW_WIDTH
import config.GameConfig.WORLD_SIZE
import extensions.GameEntity
import org.hexworks.zircon.api.data.Position3D
import org.hexworks.zircon.api.data.Size3D
import world.Game

class GameBuilder(val worldSize: Size3D) {
    private val visibleSize = Size3D.create(
        xLength = WINDOW_WIDTH - SIDEBAR_WIDTH,
        yLength = WINDOW_HEIGHT - LOG_AREA_HEIGHT,
        zLength = 1
    )

    private val world = WorldBuilder(worldSize)
        .makeRooms()
        .build(visibleSize = visibleSize)

    fun buildGame(): Game {
        prepareWorld()

        val player = addPlayer()

        return Game.create(
            player = player,
            world = world
        )
    }

    private fun addPlayer(): GameEntity<Player> {
        val player = EntityFactory.newPlayer()
        world.addAtEmptyOPosition(
            player,
            offset = Position3D.create(0, 0, GameConfig.Z_LEVELS - 1),
            size = world.visibleSize.copy(zLength = 0)
        )

        return player
    }

    private fun prepareWorld() = also {
        world.scrollUpBy(world.actualSize.zLength)
    }

    companion object {
        fun create() = GameBuilder(
            worldSize = WORLD_SIZE
        ).buildGame()
    }
}