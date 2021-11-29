import objects.entities.Player
import org.hexworks.zircon.api.*
import org.hexworks.zircon.api.application.AppConfig
import org.hexworks.zircon.api.component.ComponentAlignment
import org.hexworks.zircon.api.component.Label
import org.hexworks.zircon.api.grid.TileGrid
import org.hexworks.zircon.api.screen.Screen

fun main() {
    val player = Player()

    val config = AppConfig.newBuilder()
        .withSize(60, 30)
        .withDefaultTileset(CP437TilesetResources.rexPaint16x16())
        .build()

    val tileGrid: TileGrid = SwingApplications.startTileGrid(config)

    val screen: Screen = Screen.create(tileGrid)

    Components.label()
        .withText("Hello, World!")
        .withAlignment(ComponentAlignments.alignmentWithin(tileGrid, ComponentAlignment.CENTER))
        .build()

    val playerLabel = Components.label()
        .withText(player.getUnicode())
        .withAlignment(ComponentAlignments.alignmentWithin(tileGrid, ComponentAlignment.CENTER))
        .build()

    screen.addComponent(playerLabel)

    screen.display()

    screen.theme = ColorThemes.arc()
}