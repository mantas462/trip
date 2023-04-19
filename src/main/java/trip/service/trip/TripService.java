package trip.service.trip;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import trip.dto.item.internal.ItemDto;
import trip.dto.trip.internal.TripDto;
import trip.entity.trip.Trip;
import trip.repository.trip.TripDao;
import trip.service.item.ItemService;
import trip.util.mapper.trip.TripMapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

@Service
@AllArgsConstructor
public class TripService {

    private TripDao tripDao;

    private ItemService itemService;

    private static final BigDecimal AVERAGE_LENGTH_PER_DAY = BigDecimal.valueOf(20);

    public TripDto plan(TripDto tripDto) {

        ItemDto itemDto = createItemDto(tripDto);
        List<ItemDto> itemList = itemService.planItems(itemDto);

        Trip trip = TripMapper.createTrip(tripDto, itemList);
        Trip savedTrip = tripDao.save(trip);

        return TripMapper.toDto(savedTrip);
    }

    private ItemDto createItemDto(TripDto tripDto) {

        BigInteger itemTripDuration = getTripDurationInDays(tripDto.getTripLength());

        return ItemDto.builder()
                .seasonType(tripDto.getSeasonType())
                .tripDurationInDays(itemTripDuration)
                .build();
    }

    private BigInteger getTripDurationInDays(BigDecimal tripLength) {

        if (tripLength.compareTo(AVERAGE_LENGTH_PER_DAY) < 0) {
            return BigInteger.valueOf(1);
        }
        return tripLength.divide(AVERAGE_LENGTH_PER_DAY).setScale(0, RoundingMode.UP).toBigInteger();
    }
}