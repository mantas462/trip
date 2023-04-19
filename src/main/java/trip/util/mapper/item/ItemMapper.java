package trip.util.mapper.item;

import trip.dto.item.api.ItemRequestDto;
import trip.dto.item.internal.ItemDto;
import trip.entity.SeasonType;
import trip.entity.item.Item;
import trip.entity.item.ItemType;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

public final class ItemMapper {

    public static ItemDto toDto(ItemRequestDto itemRequestDto) {

        return ItemDto.builder()
                .name(itemRequestDto.getName())
                .seasonTypeList(itemRequestDto.getSeasonTypeList())
                .itemType(itemRequestDto.getItemType())
                .build();
    }

    public static ItemDto toDto(Item item) {

        return ItemDto.builder()
                .uuid(item.getUuid())
                .name(item.getName())
                .build();
    }

    public static Item createEntity(ItemDto item) {

        Collection<SeasonType> seasonTypeList = item.getSeasonTypeList().stream().map(seasonType -> SeasonType.valueOf(seasonType.toString())).collect(Collectors.toList());

        return Item.builder()
                .uuid(UUID.randomUUID())
                .name(item.getName())
                .itemType(ItemType.valueOf(item.getItemType().toString()))
                .seasonType(seasonTypeList)
                .build();
    }
}
