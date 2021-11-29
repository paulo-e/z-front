package views

import config.GameConfig
import org.hexworks.zircon.api.ComponentDecorations
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.component.ComponentAlignment
import org.hexworks.zircon.api.grid.TileGrid
import org.hexworks.zircon.api.view.base.BaseView
import kotlin.system.exitProcess

class StartView(private val grid: TileGrid) : BaseView(grid, GameConfig.THEME) {
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

        startButton.onActivated { replaceWith(PlayView(grid)) }

        screen.addComponents(header, startButton)
    }
}