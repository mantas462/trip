package trip.entity.item;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import trip.entity.SeasonType;

import java.util.Collection;
import java.util.UUID;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    private UUID uuid;

    @Column(nullable = false, unique = true)
    private String name;

    @ElementCollection(targetClass = SeasonType.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "item_season_type")
    @Column(nullable = false)
    private Collection<SeasonType> seasonType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ItemType itemType;
}
