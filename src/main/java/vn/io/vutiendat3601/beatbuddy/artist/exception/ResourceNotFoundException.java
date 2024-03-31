package vn.io.vutiendat3601.beatbuddy.artist.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(
            String resourceType,
            String param,
            String paramValue

    ) {
        super("%s not found with param: %s=%s"
                .formatted(resourceType, param, paramValue)

        );
    }
}
