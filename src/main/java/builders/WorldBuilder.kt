package builders

import blocks.GameBlock
import extensions.sameLevelNeighborsShuffled
import org.hexworks.zircon.api.data.Position3D
import org.hexworks.zircon.api.data.Size3D
import world.World

class WorldBuilder(private val worldSize: Size3D) {
    private val width = worldSize.xLength
    private val height = worldSize.yLength
    private var blocks: MutableMap<Position3D, GameBlock> = mutableMapOf()

    fun makeRooms(): WorldBuilder {
        return randomizeTiles()
            .smooth(8)
    }

    fun build(visibleSize: Size3D): World = World(blocks, visibleSize, worldSize)

    private fun smooth(iterations: Int): WorldBuilder {
        val newBlocks = mutableMapOf<Position3D, GameBlock>()
        repeat(iterations) {
            forAllPositions { pos ->
                val (x, y, z) = pos
                var floors = 0
                var walls = 0

                pos.sameLevelNeighborsShuffled().plus(pos).forEach { neighbor ->
                    blocks.whenPresent(neighbor) { block ->
                        if (block.isFloor) {
                            floors++
                        } else walls++
                    }
                }
                newBlocks[Position3D.create(x, y, z)] =
                    if (floors >= walls) GameBlockFactory.floor() else GameBlockFactory.wall()
            }

            blocks = newBlocks
        }
        return this
    }

    private fun forAllPositions(fn: (Position3D) -> Unit) {
        worldSize.fetchPositions().forEach(fn)
    }

    private fun randomizeTiles(): WorldBuilder {
        forAllPositions { pos ->
            blocks[pos] = if (Math.random() < 0.55) {
                GameBlockFactory.floor()
            } else GameBlockFactory.wall()
        }
        return this
    }

    private fun MutableMap<Position3D, GameBlock>.whenPresent(pos: Position3D, fn: (GameBlock) -> Unit) {
        this[pos]?.let(fn)
    }
}