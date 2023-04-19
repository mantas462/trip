package trip.controller.trip;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trip.dto.trip.api.PlanTripRequestDto;
import trip.dto.trip.api.PlanTripResponseDto;
import trip.dto.trip.internal.TripDto;
import trip.service.trip.TripService;
import trip.util.api.MediaType;
import trip.util.api.RestUrl;
import trip.util.mapper.trip.TripMapper;

@RestController
@AllArgsConstructor
@RequestMapping(RestUrl.API_V1)
public class TripController {

    private TripService tripService;

    @PostMapping(
            value = RestUrl.TRIP,
            consumes = MediaType.PLAN_TRIP_REQUEST
    )
    public PlanTripResponseDto plan(@RequestBody @Validated PlanTripRequestDto planTripRequestDto) {

        TripDto tripDto = TripMapper.toDto(planTripRequestDto);
        TripDto savedTrip = tripService.plan(tripDto);

        return TripMapper.toPlanTripResponseDto(savedTrip);
    }
}
