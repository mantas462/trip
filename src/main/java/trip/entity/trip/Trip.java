package trip.entity.trip;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import trip.entity.SeasonType;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Trip {

    @Id
    private UUID uuid;

    @Column(nullable = false)
    private BigDecimal length;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeasonType seasonType;

    @ElementCollection
    @CollectionTable(name = "ItemList", joinColumns = @JoinColumn(name = "trip_id"))
    private List<String> itemList;
}
