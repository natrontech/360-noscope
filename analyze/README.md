# NoScope360 Analyze Service

The NoScope360 Analyze Service is a robust Spring Boot application designed to handle operations related to
municipalities and surveys, offering capabilities such as fetching detailed municipality insights, computing average
ratings, managing and processing survey data, and more.

### Features

* **Municipality Operations:** Get a comprehensive overview of municipalities, detailed information on specific
  municipalities based on ID, and compute statistics for all municipalities.
* **Survey Management:** Access a broad overview of all available surveys, fetch specific surveys by ID, view statistics
  related to surveys, and process answers for given surveys.
* **Exception Handling:** Custom exception handling to handle scenarios such as invalid inputs and not-found resources.

### Dependencies

* **Spring Boot:** The backbone of our service, facilitating quick and efficient development.
* **SLF4J:** Logging framework integrated to provide insights into operations and assist with debugging.
* **Repositories:** Interaction with the database is facilitated using various repositories like
  QuantitativeDataRepository, QualitativeDataRepository, MunicipalityRepository, and more.
* **SurveyClient:** An external client used for interactions related to survey operations.

### Quick Start

1. Clone the repository:

```bash
git clone [repository_url]
```

2. Navigate to the project directory:

```bash
cd noscope360-analyze-service
```

3. Build the project:

```bash
mvn clean install
```

4. Run the application:

```bash
mvn spring-boot:run
```

### Future Enhancements

* Implement the outstanding `TODO` features in the `SurveyService`.
* Extend the application to incorporate more granular insights related to municipalities and surveys.
* Integrate with more data sources to enhance the comprehensiveness of our analysis.