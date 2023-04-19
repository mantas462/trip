package trip.repository.trip;

import org.springframework.data.jpa.repository.JpaRepository;
import trip.entity.trip.Trip;

import java.util.UUID;

public interface TripDao extends JpaRepository<Trip, UUID> {
}

