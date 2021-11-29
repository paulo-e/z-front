package world

import builders.WorldBuilder
import config.GameConfig.GAME_AREA_SIZE
import config.GameConfig.WORLD_SIZE
import org.hexworks.zircon.api.data.Size3D

class Game(val world: World) {
    companion object {
        fun create(
            worldSize: Size3D = WORLD_SIZE,
            visibleSize: Size3D = GAME_AREA_SIZE
        ) = Game(
            WorldBuilder(worldSize)
                .makeRooms()
                .build(visibleSize)
        )
    }
}