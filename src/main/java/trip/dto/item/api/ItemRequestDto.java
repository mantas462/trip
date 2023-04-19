package trip.dto.item.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import trip.dto.common.SeasonTypeDto;
import trip.dto.item.internal.ItemTypeDto;

import java.util.Collection;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class ItemRequestDto {

    @NotBlank
    private String name;

    @NotNull
    private ItemTypeDto itemType;

    @NotNull
    private Collection<SeasonTypeDto> seasonTypeList;
}
