package trip.controller.item;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trip.dto.item.api.CreateItemRequestDto;
import trip.dto.item.api.CreateItemResponseDto;
import trip.dto.item.internal.ItemDto;
import trip.service.item.ItemService;
import trip.util.api.MediaType;
import trip.util.api.RestUrl;
import trip.util.mapper.item.ItemMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(RestUrl.API_V1)
public class ItemController {

    private ItemService itemService;

    @PostMapping(
            value = RestUrl.ITEM,
            consumes = MediaType.CREATE_ITEM_REQUEST
    )
    public CreateItemResponseDto create(@RequestBody @Validated CreateItemRequestDto createItemRequestDto) {

        List<ItemDto> itemDtoList = createItemRequestDto.getItemList().stream().map(item -> ItemMapper.toDto(item)).collect(Collectors.toList());
        List<ItemDto> savedDtoList = itemService.saveList(itemDtoList);

        return CreateItemResponseDto.builder()
                .uuidList(savedDtoList.stream().map(ItemDto::getUuid).collect(Collectors.toList()))
                .build();
    }
}
