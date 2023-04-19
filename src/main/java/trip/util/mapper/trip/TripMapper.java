package trip.util.mapper.trip;

import trip.dto.item.internal.ItemDto;
import trip.dto.trip.api.PlanTripRequestDto;
import trip.dto.trip.api.PlanTripResponseDto;
import trip.dto.trip.internal.TripDto;
import trip.entity.SeasonType;
import trip.entity.trip.Trip;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public final class TripMapper {

    public static Trip createTrip(TripDto tripDto, List<ItemDto> itemDtoList) {

        List<String> itemNameList = itemDtoList.stream().map(ItemDto::getName).collect(Collectors.toList());

        return Trip.builder()
                .uuid(UUID.randomUUID())
                .length(tripDto.getTripLength())
                .seasonType(SeasonType.valueOf(tripDto.getSeasonType().toString()))
                .itemList(itemNameList)
                .build();
    }

    public static TripDto toDto(PlanTripRequestDto planTripRequestDto) {

        return TripDto.builder()
                .tripLength(planTripRequestDto.getTripLength())
                .seasonType(planTripRequestDto.getSeasonTypeDto())
                .build();
    }

    public static TripDto toDto(Trip trip) {

        return TripDto.builder()
                .itemNameList(trip.getItemList())
                .build();
    }

    public static PlanTripResponseDto toPlanTripResponseDto(TripDto tripDto) {

        return PlanTripResponseDto.builder()
                .itemNameList(tripDto.getItemNameList())
                .build();
    }
}
