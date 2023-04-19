package trip.dto.item.api;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
public class CreateItemResponseDto {

    @NotNull
    private List<UUID> uuidList;
}
