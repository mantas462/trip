package trip.dto.trip.api;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class PlanTripResponseDto {

    @NotNull
    private List<String> itemNameList;
}
