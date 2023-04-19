package trip.repository.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import trip.entity.SeasonType;
import trip.entity.item.Item;
import trip.entity.item.ItemType;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;


public interface ItemDao extends JpaRepository<Item, UUID> {
    @Query(value = "SELECT * FROM ITEM INNER JOIN ITEM_SEASON_TYPE ON ITEM.UUID = ITEM_SEASON_TYPE.ITEM_UUID WHERE ITEM_SEASON_TYPE.SEASON_TYPE = :seasonType AND ITEM.ITEM_TYPE = :itemType LIMIT :times", nativeQuery = true)
    List<Item> findByItemTypeAndSeasonType(@Param("itemType") String itemType, @Param("seasonType") String seasonType, @Param("times") BigInteger times);
}
