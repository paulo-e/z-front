import config.GameConfig
import org.hexworks.zircon.api.SwingApplications
import org.hexworks.zircon.api.grid.TileGrid
import views.PlayView

fun main() {
    val grid: TileGrid = SwingApplications.startTileGrid(GameConfig.buildAppConfig())

    PlayView(grid).dock()
}