package views

import config.UserConfig
import org.hexworks.zircon.api.ComponentDecorations
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.component.ComponentAlignment
import org.hexworks.zircon.api.grid.TileGrid
import org.hexworks.zircon.api.view.base.BaseView

class StartView(grid: TileGrid) : BaseView(grid, UserConfig.THEME) {
    init {
        val msg = "Hello to Z!"
        val header = Components.textBox(contentWidth = msg.length)
            .addHeader(msg)
            .addNewLine()
            .withAlignmentWithin(screen, ComponentAlignment.CENTER)
            .build()

        val startButton = Components.button()
            .withAlignmentAround(header, ComponentAlignment.BOTTOM_CENTER)
            .withText("Start!")
            .withDecorations(ComponentDecorations.box(), ComponentDecorations.shadow())
            .build()

        val quitButton = Components.button()
            .withAlignmentAround(startButton, ComponentAlignment.BOTTOM_CENTER)
            .withText("Quit!")
            .withDecorations(ComponentDecorations.box(), ComponentDecorations.shadow())
            .build()

        startButton.onActivated {
            PlayView(grid)
        }

        quitButton.onActivated { screen.close() }

        screen.addComponents(header, startButton)
    }
}