package views

import builders.GameBuilder
import builders.GameTileRepository
import config.GameConfig
import config.GameConfig.LOG_AREA_HEIGHT
import config.GameConfig.SIDEBAR_WIDTH
import config.GameConfig.WINDOW_HEIGHT
import config.GameConfig.WINDOW_WIDTH
import org.hexworks.cobalt.databinding.api.extension.toProperty
import org.hexworks.zircon.api.ComponentDecorations.box
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.component.ColorTheme
import org.hexworks.zircon.api.component.ComponentAlignment.BOTTOM_RIGHT
import org.hexworks.zircon.api.component.ComponentAlignment.TOP_RIGHT
import org.hexworks.zircon.api.game.ProjectionMode
import org.hexworks.zircon.api.grid.TileGrid
import org.hexworks.zircon.api.view.base.BaseView
import org.hexworks.zircon.internal.game.impl.GameAreaComponentRenderer
import world.Game

class PlayView(
    grid: TileGrid,
    game: Game = GameBuilder.create(),
    theme: ColorTheme = GameConfig.THEME
) : BaseView(grid, theme) {
    init {
        val sidebar = Components.panel()
            .withName("Sidebar")
            .withPreferredSize(SIDEBAR_WIDTH, WINDOW_HEIGHT)
            .withDecorations(box())
            .build()

        val logArea = Components.logArea()
            .withDecorations(box(title = "Logs"))
            .withPreferredSize(WINDOW_WIDTH - SIDEBAR_WIDTH, LOG_AREA_HEIGHT)
            .withAlignmentWithin(screen, BOTTOM_RIGHT)
            .build()

        val gameComponent = Components.panel()
            .withName("Game")
            .withPreferredSize(game.world.visibleSize.to2DSize())
            .withComponentRenderer(
                GameAreaComponentRenderer(
                    gameArea = game.world,
                    projectionMode = ProjectionMode.TOP_DOWN.toProperty(),
                    fillerTile = GameTileRepository.FLOOR
                )
            )
            .withAlignmentWithin(screen, TOP_RIGHT)
            .build()

        screen.addComponents(sidebar, logArea, gameComponent)
    }
}