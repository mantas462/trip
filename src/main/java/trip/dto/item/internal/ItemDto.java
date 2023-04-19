package trip.dto.item.internal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import trip.dto.common.SeasonTypeDto;

import java.math.BigInteger;
import java.util.Collection;
import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
public class ItemDto {

    private UUID uuid;

    private String name;

    private SeasonTypeDto seasonType;

    private ItemTypeDto itemType;

    private BigInteger tripDurationInDays;

    private Collection<SeasonTypeDto> seasonTypeList;
}
