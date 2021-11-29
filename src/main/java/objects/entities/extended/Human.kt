package objects.entities.extended

import lombok.*

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
open class Human : Carbon("@") {
    private var name: String = ""
}