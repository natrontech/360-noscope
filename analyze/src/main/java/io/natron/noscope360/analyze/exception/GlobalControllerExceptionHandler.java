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
     * Handles exceptions thrown when a survey is not found.
     * This method logs the error and sends back a structured response to the client.
     *
     * @param exception The exception that was thrown.
     * @return A structured ProblemDetail indicating the status and error message.
     */
    @ExceptionHandler(SurveyNotFoundException.class)
    public ProblemDetail handleSurveyNotFound(SurveyNotFoundException exception) {
        log.error("Survey not found with error message: " + exception.getMessage(), exception);
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    /**
     * Handles exceptions thrown when a seat is not found.
     * This method logs the error and sends back a structured response to the client.
     *
     * @param exception The exception that was thrown.
     * @return A structured ProblemDetail indicating the status and error message.
     */
    @ExceptionHandler(InvalidInputException.class)
    public ProblemDetail handleInvalidInput(InvalidInputException exception) {
        log.error("There was an invalid input with error message: " + exception.getMessage(), exception);
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

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
