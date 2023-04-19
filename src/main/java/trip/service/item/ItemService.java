package trip.service.item;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import trip.dto.item.internal.ItemDto;
import trip.entity.SeasonType;
import trip.entity.item.Item;
import trip.entity.item.ItemType;
import trip.repository.item.ItemDao;
import trip.util.mapper.item.ItemMapper;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class ItemService {

    private ItemDao itemDao;

    private static final BigInteger FOOD_TIMES_PER_DAY = BigInteger.valueOf(3);
    private static final BigInteger WEAR_TIMES_PER_DAY = BigInteger.valueOf(2);

    public List<ItemDto> saveList(List<ItemDto> itemDtoList) {

        List<Item> itemList = itemDtoList.stream().map(item -> ItemMapper.createEntity(item)).collect(Collectors.toList());
        List<Item> savedItemList = itemDao.saveAll(itemList);

        return savedItemList.stream()
                .map(item -> ItemMapper.toDto(item))
                .collect(Collectors.toList());
    }

    public List<ItemDto> planItems(ItemDto itemDto) {

        SeasonType seasonType = SeasonType.valueOf(itemDto.getSeasonType().toString());

        List<Item> foodList = findByTypeSeasonAndDays(itemDto, seasonType, FOOD_TIMES_PER_DAY, ItemType.FOOD);
        List<Item> wearList = findByTypeSeasonAndDays(itemDto, seasonType, WEAR_TIMES_PER_DAY, ItemType.WEAR);
        List<Item> gearList = findGear(seasonType);

        return Stream.of(foodList, wearList, gearList)
                .flatMap(Collection::stream)
                .map(ItemMapper::toDto)
                .collect(Collectors.toList());
    }

    private List<Item> findByTypeSeasonAndDays(ItemDto itemDto, SeasonType seasonType, BigInteger times, ItemType itemType) {

        BigInteger totalTimes = itemDto.getTripDurationInDays().multiply(times);
        return itemDao.findByItemTypeAndSeasonType(itemType.toString(), seasonType.toString(), totalTimes);
    }

    private List<Item> findGear(SeasonType seasonType) {

        return itemDao.findByItemTypeAndSeasonType(ItemType.GEAR.toString(), seasonType.toString(), BigInteger.valueOf(1));
    }
}