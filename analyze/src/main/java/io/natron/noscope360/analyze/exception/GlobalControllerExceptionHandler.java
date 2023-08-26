package io.natron.noscope360.analyze.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler that captures exceptions across all controllers.
 * This class ensures that whenever an exception occurs in any of the application's
 * controllers, a uniform response is sent to the client.
 */
@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

    /**
     * Handles general exceptions thrown from any controller methods.
     * This method logs the error and sends back a structured response to the client.
     *
     * @param exception The exception that was thrown.
     * @return A structured ProblemDetail indicating the status and error message.
     */
    @ExceptionHandler(Exception.class)
    public ProblemDetail handleGeneralException(Exception exception) {
        log.error("An unexpected error occurred with error message: " + exception.getMessage(), exception);
        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred.");
    }
}
