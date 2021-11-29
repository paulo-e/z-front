package views

import config.UserConfig
import org.hexworks.zircon.api.ColorThemes
import org.hexworks.zircon.api.ComponentDecorations.box
import org.hexworks.zircon.api.ComponentDecorations.shadow
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.component.ComponentAlignment.LEFT_CENTER
import org.hexworks.zircon.api.grid.TileGrid
import org.hexworks.zircon.api.view.base.BaseView

class PlayView(grid: TileGrid) : BaseView(grid, UserConfig.THEME) {
    init {
        val loseButton = Components.button()
            .withAlignmentWithin(screen, LEFT_CENTER)
            .withText("Lost!")
            .withDecorations(box(), shadow())
            .build()

        val winButton = Components.button()
            .withAlignmentWithin(screen, LEFT_CENTER)
            .withText("Won!")
            .withDecorations(box(), shadow())
            .build()

        screen.addComponents(loseButton, winButton)
    }
}