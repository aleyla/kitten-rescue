package com.leyla.kittenrescue.service;

import com.leyla.kittenrescue.enums.Direction;
import com.leyla.kittenrescue.enums.ErrorCodeEnum;
import com.leyla.kittenrescue.enums.Facing;
import com.leyla.kittenrescue.exception.KittenRescueApiException;
import com.leyla.kittenrescue.model.Location;
import com.leyla.kittenrescue.model.WomanInfo;
import com.leyla.kittenrescue.model.request.EmailRequest;
import com.leyla.kittenrescue.model.request.GuessLocationRequest;
import com.leyla.kittenrescue.model.response.LocationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KittenRescueServiceImpl implements KittenRescueService {

    private final LocationApiService locationApiService;

    public KittenRescueServiceImpl(LocationApiService locationApiService) {
        this.locationApiService = locationApiService;
    }

    @Override
    public List<Direction> getDirections(EmailRequest request) {
        validateRequest(request);
        return locationApiService.getDirections(request.getEmail());
    }

    @Override
    public LocationResponse findWomanLocation(EmailRequest request) {
        validateRequest(request);
        WomanInfo womanInfo = getWomanInfo(getDirections(request));
        return locationApiService.getLocation(request.getEmail(), womanInfo.getLocation());
    }

    @Override
    public Location getCoordinateClue(EmailRequest email) {
        WomanInfo womanInfo = getWomanInfo(getDirections(email));
        return womanInfo.getLocation();
    }

    private void validateRequest(EmailRequest request) {
        if (request == null) {
            throw new KittenRescueApiException(ErrorCodeEnum.BAD_REQUEST_ERROR);
        }
    }

    @Override
    public LocationResponse guessLocation(GuessLocationRequest request) {
        return locationApiService.getLocation(request.getEmail(), new Location(request.getX(), request.getY()));
    }

    public WomanInfo getWomanInfo(List<Direction> directions) {
        WomanInfo womanInfo = new WomanInfo();
        directions.forEach(direction -> {
            Facing newFacing = Facing.getDirectionToFacing().get(womanInfo.getFacing())[direction.getFacingIndex()];
            womanInfo.setFacing(newFacing);
            if (Direction.FORWARD.equals(direction)) {
                womanInfo.setLocation(womanInfo.updateLocation(newFacing.getX(), newFacing.getY()));
            }
        });
        return womanInfo;
    }

}
