package trip.dto.trip.internal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import trip.dto.common.SeasonTypeDto;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class TripDto {

    private BigDecimal tripLength;

    private SeasonTypeDto seasonType;

    private List<String> itemNameList;
}
