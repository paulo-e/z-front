package config

import org.hexworks.zircon.api.CP437TilesetResources
import org.hexworks.zircon.api.ColorThemes
import org.hexworks.zircon.api.application.AppConfig
import org.hexworks.zircon.api.data.Size3D

object GameConfig {
    var THEME = ColorThemes.discord()
    var TILESET = CP437TilesetResources.rogueYun16x16()

    const val SIDEBAR_WIDTH = 14
    const val LOG_AREA_HEIGHT = 8

    const val WINDOW_WIDTH = 60
    const val WINDOW_HEIGHT = 40
    const val Z_LEVELS = 2

    val WORLD_SIZE = Size3D.create(WINDOW_WIDTH * 2, WINDOW_HEIGHT * 2, Z_LEVELS)
    val GAME_AREA_SIZE = Size3D.create(
        xLength = WINDOW_WIDTH - SIDEBAR_WIDTH,
        yLength = WINDOW_HEIGHT - LOG_AREA_HEIGHT,
        zLength = Z_LEVELS
    )

    fun buildAppConfig() = AppConfig.newBuilder()
        .withDefaultTileset(TILESET)
        .withSize(WINDOW_WIDTH, WINDOW_HEIGHT)
        .withFullScreen(IS_FULLSCREEN)
        .build()

    var IS_FULLSCREEN = false
}