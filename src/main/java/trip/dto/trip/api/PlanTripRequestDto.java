package trip.dto.trip.api;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import trip.dto.common.SeasonTypeDto;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@Builder
public class PlanTripRequestDto {

    @NotNull
    private BigDecimal tripLength;

    @NotNull
    private SeasonTypeDto seasonTypeDto;
}
