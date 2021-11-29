import org.hexworks.zircon.api.*
import org.hexworks.zircon.api.application.AppConfig
import org.hexworks.zircon.api.component.ComponentAlignment
import org.hexworks.zircon.api.component.Label
import org.hexworks.zircon.api.grid.TileGrid
import org.hexworks.zircon.api.screen.Screen

fun main() {
    val tileGrid: TileGrid = SwingApplications.startTileGrid(
        AppConfig.newBuilder()
            .withSize(60, 30)
            .withDefaultTileset(CP437TilesetResources.rexPaint16x16())
            .build()
    )

    val screen: Screen = Screen.create(tileGrid)

    val label: Label = Components.label()
        .withText("Hello, World!")
        .withAlignment(ComponentAlignments.alignmentWithin(tileGrid, ComponentAlignment.CENTER))
        .build()

    screen.addComponent(label)

    screen.display()

    screen.theme = ColorThemes.arc()
}